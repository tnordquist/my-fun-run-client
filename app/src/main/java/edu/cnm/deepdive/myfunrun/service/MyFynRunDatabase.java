package edu.cnm.deepdive.myfunrun.service;

import android.annotation.SuppressLint;
import android.app.Application;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import edu.cnm.deepdive.MyFunRuns.R;
import edu.cnm.deepdive.MyFunRuns.model.dao.MyFunRunDao;
import edu.cnm.deepdive.MyFunRuns.model.dao.SourceDao;
import edu.cnm.deepdive.MyFunRuns.model.entity.MyFunRun;
import edu.cnm.deepdive.MyFunRuns.model.entity.Source;
import edu.cnm.deepdive.myfunrun.model.dao.HistoryDao;
import edu.cnm.deepdive.myfunrun.model.dao.RaceDao;
import edu.cnm.deepdive.myfunrun.model.dao.UserDao;
import edu.cnm.deepdive.myfunrun.model.entity.History;
import edu.cnm.deepdive.myfunrun.model.entity.Race;
import edu.cnm.deepdive.myfunrun.model.entity.User;
import io.reactivex.schedulers.Schedulers;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

@Database(
    entities = {Race.class, User.class, History.class},
    version = 1,
    exportSchema = true
)
public abstract class MyFunRunsDatabase extends RoomDatabase {

  private static final String DB_NAME = "MyFunRuns_db";

  private static Application context;

  public static void setContext(Application context) {
    MyFunRunsDatabase.context = context;
  }

  public abstract UserDao getUserDao();

  public abstract RaceDao getRaceDao();

  public abstract HistoryDao getHistoryDao();

  public static MyFunRunsDatabase getInstance() {
    return InstanceHolder.INSTANCE;
  }

  private static class InstanceHolder {

    private static final MyFunRunsDatabase INSTANCE =
        Room.databaseBuilder(context, MyFunRunsDatabase.class, DB_NAME)
            .addCallback(new MyFunRunsCallback())
            .build();
  }

  private static class MyFunRunsCallback extends Callback {

    @Override
    public void onCreate(@NonNull SupportSQLiteDatabase db) {
      super.onCreate(db);
      try {
        Map<History, List<MyFunRun>> map = parseFile(R.raw.MyFunRuns);
        persist(map);
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }

    private Map<Source, List<MyFunRun>> parseFile(int resourceId) throws IOException {
      try (
          InputStream input = MyFunRunsDatabase.context.getResources().openRawResource(resourceId);
          Reader reader = new InputStreamReader(input);
          CSVParser parser = CSVParser.parse(
              reader, CSVFormat.EXCEL.withIgnoreSurroundingSpaces().withIgnoreEmptyLines());
      ) {
        Map<User, List<MyFunRun>> map = new HashMap<>();
        for (CSVRecord record : parser) {
          Source source = null;
          String sourceName = record.get(0).trim();
          if (!sourceName.isEmpty()) {
            source = new Source();
            source.setName(sourceName);
          }
          List<MyFunRun> MyFunRuns = map.computeIfAbsent(source, (s) -> new LinkedList<>());
          MyFunRun MyFunRun = new MyFunRun();
          MyFunRun.setText(record.get(1).trim());
          MyFunRuns.add(MyFunRun);
        }
        Log.d(getClass().getName(), map.toString());
        return map;
      }
    }

    @SuppressLint("CheckResult")
    private void persist(Map<Source, List<MyFunRun>> map) {
      MyFunRunsDatabase database = MyFunRunsDatabase.getInstance();
      SourceDao sourceDao = database.getSourceDao();
      MyFunRunDao MyFunRunDao = database.getMyFunRunDao();
      List<Source> sources = new LinkedList<>(map.keySet());
      List<MyFunRun> unattributed = map.getOrDefault(null, Collections.emptyList());
      sources.remove(null);
      sourceDao.insert(sources)
          .subscribeOn(Schedulers.io())
          .flatMap((sourceIds) -> {
            List<MyFunRun> MyFunRuns = new LinkedList<>();
            Iterator<Long> idIterator = sourceIds.iterator();
            Iterator<Source> sourceIterator = sources.iterator();
            while (idIterator.hasNext()) {
              long sourceId = idIterator.next();
              for (MyFunRun MyFunRun : map.getOrDefault(sourceIterator.next(), Collections.emptyList())) {
                MyFunRun.setSourceId(sourceId);
                MyFunRuns.add(MyFunRun);
              }
            }
            MyFunRuns.addAll(unattributed);
            return MyFunRunDao.insert(MyFunRuns);
          })
          .subscribe(
              (MyFunRunIds) -> {
              },
              (throwable) -> {
                throw new RuntimeException(throwable);
              }
          );
    }
  }

  public static class Converters {

    @TypeConverter
    public static Long dateToLong(Date value) {
      return (value != null) ? value.getTime() : null;
    }

    @TypeConverter
    public static Date longToDate(Long value) {
      return (value != null) ? new Date(value) : null;
    }

  }
}


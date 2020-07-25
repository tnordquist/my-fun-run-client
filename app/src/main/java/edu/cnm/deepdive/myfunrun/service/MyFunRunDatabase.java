package edu.cnm.deepdive.myfunrun.service;

import android.app.Application;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;
import edu.cnm.deepdive.myfunrun.model.dao.HistoryDao;
import edu.cnm.deepdive.myfunrun.model.dao.UserDao;
import edu.cnm.deepdive.myfunrun.model.dao.RaceDao;
import edu.cnm.deepdive.myfunrun.model.entity.History;
import edu.cnm.deepdive.myfunrun.model.entity.Race;
import edu.cnm.deepdive.myfunrun.model.entity.User;
import edu.cnm.deepdive.myfunrun.service.MyFunRunDatabase.Converters;
import io.reactivex.schedulers.Schedulers;
import java.util.Date;

@Database(
    entities = {Race.class, User.class, History.class},
    version = 1,
    exportSchema = true
)
@TypeConverters({Converters.class})
public abstract class MyFunRunDatabase extends RoomDatabase {

  private static final String DB_NAME = "MyFunRuns_db";

  private static Application context;

  public static void setContext(Application context) {
    MyFunRunDatabase.context = context;
  }

  public abstract UserDao getUserDao();

  public abstract RaceDao getRaceDao();

  public abstract HistoryDao getHistoryDao();

  public static MyFunRunDatabase getInstance() {
    return InstanceHolder.INSTANCE;
  }

  private static class InstanceHolder {

    private static final MyFunRunDatabase INSTANCE =
        Room.databaseBuilder(context, MyFunRunDatabase.class, DB_NAME)
            .addCallback(new Callback(context))
            .build();

  }

  private static class Callback extends RoomDatabase.Callback {

    private final Context context;

    private Callback(Context context) {
      this.context = context;
    }

    @Override
    public void onCreate(@NonNull SupportSQLiteDatabase db) {
      super.onCreate(db);
      MyFunRunDatabase database = MyFunRunDatabase.getInstance();
      RaceDao raceDao = database.getRaceDao();
      Race race1 = new Race();
      race1.setName("Spartan");
      Race race2 = new Race();
      race2.setName("Zombie");
      raceDao.insert(race1, race2)
          .subscribeOn(Schedulers.io())
          .subscribe();
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


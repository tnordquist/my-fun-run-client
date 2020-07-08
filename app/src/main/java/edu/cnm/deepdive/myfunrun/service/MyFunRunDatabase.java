package edu.cnm.deepdive.myfunrun.service;

import android.app.Application;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import edu.cnm.deepdive.myfunrun.model.dao.HistoryDao;
import edu.cnm.deepdive.myfunrun.model.dao.UserDao;
import edu.cnm.deepdive.myfunrun.model.dao.RaceDao;
import edu.cnm.deepdive.myfunrun.model.entity.History;
import edu.cnm.deepdive.myfunrun.model.entity.Race;
import edu.cnm.deepdive.myfunrun.model.entity.User;

@Database(
    entities = {Race.class, User.class, History.class},
    version = 1,
    exportSchema = true
)
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
            .build();
  }



}


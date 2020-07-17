package edu.cnm.deepdive.myfunrun.service;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import edu.cnm.deepdive.myfunrun.model.dao.RaceDao;
import edu.cnm.deepdive.myfunrun.model.entity.Race;
import java.util.List;

public interface RaceRepository {


  private final Context context;
  private final MyFunRunDatabase database;
  private final RaceDao raceDao;

  public RaceRepository(Context context) {
    this.context = context;
    database = MyFunRunDatabase.getInstance();
    raceDao = database.getRaceDao();
  }

  public LiveData<List<Race>> getAll() {
    return raceDao.selectAll();
  }
}

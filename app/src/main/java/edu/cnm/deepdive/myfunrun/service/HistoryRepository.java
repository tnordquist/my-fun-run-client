package edu.cnm.deepdive.myfunrun.service;

import android.content.Context;
import androidx.lifecycle.LiveData;
import edu.cnm.deepdive.myfunrun.model.dao.HistoryDao;
import edu.cnm.deepdive.myfunrun.model.dao.RaceDao;
import edu.cnm.deepdive.myfunrun.model.dao.UserDao;
import edu.cnm.deepdive.myfunrun.model.entity.History;
import edu.cnm.deepdive.myfunrun.model.entity.Race;
import edu.cnm.deepdive.myfunrun.model.pojo.HistoryWithRace;
import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import java.util.List;

public class HistoryRepository {

  private final Context context;
  private final MyFunRunDatabase database;
  private final HistoryDao HistoryDao;
  private final UserDao userDao;
  private final RaceDao raceDao;
  public HistoryRepository(Context context, UserDao userDao) {
    this.context = context;
    this.userDao = userDao;
    database = MyFunRunDatabase.getInstance();
    HistoryDao = database.getHistoryDao();
    raceDao = database.getRaceDao();
  }

  public LiveData<List<HistoryWithRace>> getAll() {
    return raceDao.selectAll();
  }

  public Single<HistoryWithRace> get(long id) {
    return raceDao.selectById(id)
        .subscribeOn(Schedulers.io());
  }

  public Completable save(History history) {
    if (history.getId() == 0) {
      return Completable.fromSingle(raceDao.insert(history))
          .subscribeOn(Schedulers.io());
    } else {
      return Completable.fromSingle(raceDao.update(history))
          .subscribeOn(Schedulers.io());
    }
  }

  public Completable delete( Race race) {
    if (userDao.getId() == 0) {
      return Completable.fromAction(() -> {})
          .subscribeOn(Schedulers.io());
    } else {
      return Completable.fromSingle(userDao.delete())
          .subscribeOn(Schedulers.io());
    }
  }

}

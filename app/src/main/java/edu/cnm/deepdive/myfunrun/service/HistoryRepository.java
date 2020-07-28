package edu.cnm.deepdive.myfunrun.service;

import android.content.Context;
import androidx.lifecycle.LiveData;
import edu.cnm.deepdive.myfunrun.model.dao.HistoryDao;
import edu.cnm.deepdive.myfunrun.model.dao.RaceDao;
import edu.cnm.deepdive.myfunrun.model.dao.UserDao;
import edu.cnm.deepdive.myfunrun.model.entity.History;
import edu.cnm.deepdive.myfunrun.model.pojo.HistoryWithDetails;
import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import java.util.List;

public class HistoryRepository {

  private final Context context;
  private final MyFunRunDatabase database;
  private final HistoryDao historyDao;
  private final UserDao userDao;
  private final RaceDao raceDao;

  public HistoryRepository(Context context) {
    this.context = context;
    database = MyFunRunDatabase.getInstance();
    userDao = database.getUserDao();
    historyDao = database.getHistoryDao();
    raceDao = database.getRaceDao();
  }

  public LiveData<List<HistoryWithDetails>> getAll() {
    return historyDao.selectAll();
  }

  public Single<HistoryWithDetails> get(long id) {
    return historyDao.selectById(id)
        .subscribeOn(Schedulers.io());
  }

  public Completable save(History history) {
    if (history.getId() == 0) {
      return Completable.fromSingle(historyDao.insert(history))
          .subscribeOn(Schedulers.io());
    } else {
      return Completable.fromSingle(historyDao.update(history))
          .subscribeOn(Schedulers.io());
    }
  }

  public Completable delete(History history) {
    if (history.getId() == 0) {
      return Completable.fromAction(() -> {})
          .subscribeOn(Schedulers.io());
    } else {
      return Completable.fromSingle(historyDao.delete(history))
          .subscribeOn(Schedulers.io());
    }
  }



}

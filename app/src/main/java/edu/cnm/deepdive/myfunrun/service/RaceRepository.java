package edu.cnm.deepdive.myfunrun.service;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import edu.cnm.deepdive.myfunrun.model.dao.RaceDao;
import edu.cnm.deepdive.myfunrun.model.entity.Race;
import edu.cnm.deepdive.myfunrun.model.pojo.RaceWithHistory;
import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import java.util.List;

/**
 * The type Race repository.
 */
public class RaceRepository {


  private final Context context;
  private final MyFunRunDatabase database;
  private final RaceDao raceDao;

  /**
   * Instantiates a new Race repository.
   *
   * @param context the context
   */
  public RaceRepository(Context context) {
    this.context = context;
    database = MyFunRunDatabase.getInstance();
    raceDao = database.getRaceDao();
  }

  /**
   * Gets all.
   *
   * @return the all
   */
  public LiveData<List<Race>> getAll() {
    return raceDao.selectAll();
  }

  /**
   * Get single.
   *
   * @param id the id
   * @return the single
   */
  public Single<RaceWithHistory> get(long id) {
    return raceDao.selectById(id)
        .subscribeOn(Schedulers.io());
  }

  /**
   * Save completable.
   *
   * @param race the race
   * @return the completable
   */
  public Completable save(Race race) {
    if (race.getId() == 0) {
      return Completable.fromSingle(raceDao.insert(race))
          .subscribeOn(Schedulers.io());
    } else {
      return Completable.fromSingle(raceDao.update(race))
          .subscribeOn(Schedulers.io());
    }
  }

  /**
   * Delete completable.
   *
   * @param race the race
   * @return the completable
   */
  public Completable delete(Race race) {
    if (race.getId() == 0) {
      return Completable.fromAction(() -> {})
          .subscribeOn(Schedulers.io());
    } else {
      return Completable.fromSingle(raceDao.delete(race))
          .subscribeOn(Schedulers.io());
    }
  }
}

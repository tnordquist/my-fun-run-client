package edu.cnm.deepdive.myfunrun.service;

import android.content.Context;
import androidx.lifecycle.LiveData;
import edu.cnm.deepdive.myfunrun.model.dao.UserDao;
import edu.cnm.deepdive.myfunrun.model.entity.User;
import edu.cnm.deepdive.myfunrun.model.pojo.UserWithHistory;
import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import java.util.List;

/**
 * The type User repository.
 */
public class UserRepository {

  private final Context context;
  private final MyFunRunDatabase database;
  private final UserDao userDao;

  /**
   * Instantiates a new User repository.
   *
   * @param context the context
   */
  public UserRepository(Context context) {
    this.context = context;
    database = MyFunRunDatabase.getInstance();
    userDao = database.getUserDao();
  }

  /**
   * Gets all.
   *
   * @return the all
   */
  public LiveData<List<User>> getAll() {
    return userDao.selectAll();
  }

  /**
   * Get single.
   *
   * @param id the id
   * @return the single
   */
  public Single<UserWithHistory> get(long id) {
    return userDao.selectById(id)
        .subscribeOn(Schedulers.io());
  }

  /**
   * Save completable.
   *
   * @param user the user
   * @return the completable
   */
  public Completable save(User user) {
    if (user.getId() == 0) {
      return Completable.fromSingle(userDao.insert(user))
          .subscribeOn(Schedulers.io());
    } else {
      return Completable.fromSingle(userDao.update(user))
          .subscribeOn(Schedulers.io());
    }
  }

  /**
   * Delete completable.
   *
   * @param user the user
   * @return the completable
   */
  public Completable delete(User user) {
    if (user.getId() == 0) {
      return Completable.fromAction(() -> {})
          .subscribeOn(Schedulers.io());
    } else {
      return Completable.fromSingle(userDao.delete(user))
          .subscribeOn(Schedulers.io());
    }
  }

}

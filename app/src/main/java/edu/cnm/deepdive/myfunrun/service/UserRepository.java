package edu.cnm.deepdive.myfunrun.service;

import android.content.Context;
import androidx.lifecycle.LiveData;
import edu.cnm.deepdive.myfunrun.model.dao.UserDao;
import edu.cnm.deepdive.myfunrun.model.entity.User;
import java.util.List;

public class UserRepository {

  private final Context context;
  private final MyFunRunDatabase database;
  private final UserDao userDao;

  public UserRepository(Context context) {
    this.context = context;
    database = MyFunRunDatabase.getInstance();
    userDao = database.getUserDao();
  }

  public LiveData<List<User>> getAll() {
    return userDao.selectAll();
  }

}

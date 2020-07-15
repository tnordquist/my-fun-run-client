package edu.cnm.deepdive.myfunrun.model.pojo;

import androidx.room.Relation;
import edu.cnm.deepdive.myfunrun.model.entity.History;
import edu.cnm.deepdive.myfunrun.model.entity.User;

public class HistoryWithUser extends History {

  @Relation(entity = User.class, entityColumn = "user_id", parentColumn = "user_id")
  private User user;

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

}

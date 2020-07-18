package edu.cnm.deepdive.myfunrun.model.pojo;

import androidx.room.Relation;
import edu.cnm.deepdive.myfunrun.model.entity.History;
import edu.cnm.deepdive.myfunrun.model.entity.User;
import java.util.List;

public class UserWithHistory extends User {

  @Relation(entity = History.class, entityColumn = "user_id", parentColumn = "user_id")
  private List<History> histories;

  public List<History> getHistories() {
    return histories;
  }

  public void setHistories(List<History> histories) {
    this.histories = histories;
  }
}

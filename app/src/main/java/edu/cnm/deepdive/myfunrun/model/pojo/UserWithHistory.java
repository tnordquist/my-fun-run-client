package edu.cnm.deepdive.myfunrun.model.pojo;

import androidx.room.Relation;
import edu.cnm.deepdive.myfunrun.model.entity.History;
import edu.cnm.deepdive.myfunrun.model.entity.User;
import java.util.List;

/**
 * The class connects list of Histories within User allowing data to be shared.
 */
public class UserWithHistory extends User {

  @Relation(entity = History.class, entityColumn = "user_id", parentColumn = "user_id")
  private List<History> histories;

  /**
   * Gets histories.
   *
   * @return the histories
   */
  public List<History> getHistories() {
    return histories;
  }

  /**
   * Sets histories.
   *
   * @param histories the histories
   */
  public void setHistories(List<History> histories) {
    this.histories = histories;
  }
}

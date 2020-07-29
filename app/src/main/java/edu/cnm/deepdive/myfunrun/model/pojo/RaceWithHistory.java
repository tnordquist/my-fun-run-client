package edu.cnm.deepdive.myfunrun.model.pojo;

import androidx.room.Relation;
import edu.cnm.deepdive.myfunrun.model.entity.History;
import edu.cnm.deepdive.myfunrun.model.entity.Race;
import java.util.List;

/**
 * The type Race with history.
 */
public class RaceWithHistory extends Race {

  @Relation(entity = History.class, entityColumn = "race_id", parentColumn = "race_id")
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

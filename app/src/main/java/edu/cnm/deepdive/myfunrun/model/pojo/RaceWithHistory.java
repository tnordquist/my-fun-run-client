package edu.cnm.deepdive.myfunrun.model.pojo;

import androidx.room.Relation;
import edu.cnm.deepdive.myfunrun.model.entity.History;
import edu.cnm.deepdive.myfunrun.model.entity.Race;
import java.util.List;

public class RaceWithHistory extends Race {

  @Relation(entity = History.class, entityColumn = "race_id", parentColumn = "race_id")
  private List<History> histories;

  public List<History> getHistories() {
    return histories;
  }

  public void setHistories(List<History> histories) {
    this.histories = histories;
  }
}

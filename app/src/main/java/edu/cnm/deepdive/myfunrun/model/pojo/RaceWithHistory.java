package edu.cnm.deepdive.myfunrun.model.pojo;

import androidx.room.Relation;
import edu.cnm.deepdive.myfunrun.model.entity.History;
import edu.cnm.deepdive.myfunrun.model.entity.Race;

public class RaceWithHistory extends Race {

  @Relation(entity = History.class, entityColumn = "history_id", parentColumn = "history_id")
  private History history;

  public History getHistory() {
    return history;
  }

  public void setHistory(History history) {
    this.history = history;
  }
}

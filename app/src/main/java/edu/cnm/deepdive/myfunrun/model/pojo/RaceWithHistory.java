package edu.cnm.deepdive.myfunrun.model.pojo;

import androidx.room.Relation;
import edu.cnm.deepdive.myfunrun.model.entity.History;
import edu.cnm.deepdive.myfunrun.model.entity.Race;

public class RaceWithHistory extends Race {

  @Relation(entity = Race.class, entityColumn = "race_id", parentColumn = "race_id")
  private Race race;

  public Race getRace() {
    return race;
  }

  public void setHistory(Race race) {
    this.race = race;
  }
}

package edu.cnm.deepdive.myfunrun.model.pojo;

import androidx.annotation.NonNull;
import androidx.room.Relation;
import edu.cnm.deepdive.myfunrun.model.entity.History;
import edu.cnm.deepdive.myfunrun.model.entity.Race;
import edu.cnm.deepdive.myfunrun.model.entity.User;

/**
 * The type History with details.
 */
public class HistoryWithDetails extends History {


  @Relation(entity = Race.class, entityColumn = "race_id", parentColumn = "race_id")
  private Race race;

  @Relation(entity = User.class, entityColumn = "user_id", parentColumn = "user_id")
  private User user;

  /**
   * Gets user.
   *
   * @return the user
   */
  public User getUser() {
    return user;
  }

  /**
   * Sets user.
   *
   * @param user the user
   */
  public void setUser(User user) {
    this.user = user;
  }

  /**
   * Gets race.
   *
   * @return the race
   */
  public Race getRace() {
    return race;
  }

  /**
   * Sets race.
   *
   * @param race the race
   */
  public void setRace(Race race) {
    this.race = race;
  }


}

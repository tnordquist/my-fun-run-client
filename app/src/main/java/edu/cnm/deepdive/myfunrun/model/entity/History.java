package edu.cnm.deepdive.myfunrun.model.entity;




import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import java.util.Date;
import javax.annotation.Nonnull;


/**
 * The type History.
 */
@Entity(
    foreignKeys = {
        @ForeignKey(
            entity = Race.class,
            parentColumns = "race_id",
            childColumns = "race_id",
            onDelete = ForeignKey.SET_NULL),
        @ForeignKey(
            entity = User.class,
            parentColumns = "user_id",
            childColumns = "user_id",
            onDelete = ForeignKey.CASCADE)
    } )

public class History {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "history_id")
  private long id;

@ColumnInfo(name = "user_id", index = true)
  private long userId;

@ColumnInfo(name = "race_id", index = true)
private Long raceId;

  @ColumnInfo(name = "distance", index = true)
  private int distance;

  @Nonnull
  private Date start;

  @Nonnull
  private Date end;

  /**
   * Gets id.
   *
   * @return the id
   */
  public long getId() {
    return id;
  }

  /**
   * Sets id.
   *
   * @param id the id
   */
  public void setId(long id) {
    this.id = id;
  }

  /**
   * Gets user id.
   *
   * @return the user id
   */
  public long getUserId() {
    return userId;
  }

  /**
   * Sets user id.
   *
   * @param userId the user id
   */
  public void setUserId(long userId) {
    this.userId = userId;
  }

  /**
   * Gets race id.
   *
   * @return the race id
   */
  public Long getRaceId() {
    return raceId;
  }

  /**
   * Sets race id.
   *
   * @param raceId the race id
   */
  public void setRaceId(Long raceId) {
    this.raceId = raceId;
  }

  /**
   * Gets distance.
   *
   * @return the distance
   */
  public int getDistance() {
    return distance;
  }

  /**
   * Sets distance.
   *
   * @param distance the distance
   */
  public void setDistance(int distance) {
    this.distance = distance;
  }

  /**
   * Gets start.
   *
   * @return the start
   */
  @Nonnull
  public Date getStart() {
    return start;
  }

  /**
   * Sets start.
   *
   * @param start the start
   */
  public void setStart(@Nonnull Date start) {
    this.start = start;
  }

  /**
   * Gets end.
   *
   * @return the end
   */
  @Nonnull
  public Date getEnd() {
    return end;
  }

  /**
   * Sets end.
   *
   * @param end the end
   */
  public void setEnd(@Nonnull Date end) {
    this.end = end;
  }

  /**
   * Gets pace.
   *
   * @return the pace
   */
  public double getPace() {
    return distance * 3600.0 / (end.getTime() - start.getTime());
}
}

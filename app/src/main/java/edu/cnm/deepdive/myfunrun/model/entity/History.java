package edu.cnm.deepdive.myfunrun.model.entity;




import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import java.util.Date;
import javax.annotation.Nonnull;


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

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }

  public Long getRaceId() {
    return raceId;
  }

  public void setRaceId(Long raceId) {
    this.raceId = raceId;
  }

  public int getDistance() {
    return distance;
  }

  public void setDistance(int distance) {
    this.distance = distance;
  }

  @Nonnull
  public Date getStart() {
    return start;
  }

  public void setStart(@Nonnull Date start) {
    this.start = start;
  }

  @Nonnull
  public Date getEnd() {
    return end;
  }

  public void setEnd(@Nonnull Date end) {
    this.end = end;
  }

public double getPace() {
    return distance * 3600.0 / (end.getTime() - start.getTime());
}
}

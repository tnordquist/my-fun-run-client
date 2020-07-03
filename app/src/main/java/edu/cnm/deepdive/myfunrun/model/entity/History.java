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
            parentColumns = "history_id",
            childColumns = "race_id",
            onDelete = ForeignKey.SET_NULL),
        @ForeignKey(
            entity = User.class,
            parentColumns = "history_id",
            childColumns = "user_id",
            onDelete = ForeignKey.SET_NULL)
    } )

public class History {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "history_id")
  private long id;

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
}

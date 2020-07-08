package edu.cnm.deepdive.myfunrun.model.entity;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(
    indices = @Index(value = "race_name", unique = true)
)
public class Race {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "race_id")
  private long id;

  @ColumnInfo(name = "race_id")
  private String raceName;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getRaceName() {
    return raceName;
  }

  public void setRaceName(String raceName) {
    this.raceName = raceName;
  }
}

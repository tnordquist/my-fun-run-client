package edu.cnm.deepdive.myfunrun.model.entity;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(
    indices = @Index(value = "display_name", unique = true)
)
public class User {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "user_id")
  private long id;

  @ColumnInfo(name = "skill_level", index = true)
  private int skillLevel;

  public int getSkillLevel() {
    return skillLevel;
  }

  public void setSkillLevel(int skillLevel) {
    this.skillLevel = skillLevel;
  }
}

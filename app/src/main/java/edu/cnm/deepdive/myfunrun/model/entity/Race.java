package edu.cnm.deepdive.myfunrun.model.entity;


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
}

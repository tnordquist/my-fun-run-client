package edu.cnm.deepdive.myfunrun.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;
import edu.cnm.deepdive.myfunrun.model.entity.History;
import edu.cnm.deepdive.myfunrun.model.entity.Race;
import edu.cnm.deepdive.myfunrun.model.pojo.RaceWithQuotes;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;

@Dao
public interface RaceDao {

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  Single<Long> insert(Race Race);

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  Single<List<Long>> insert(Race... Races);

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  Single<List<Long>> insert(Collection<Race> Races);

  @Race
  Single<Integer> Race(Race... Races);

  @Delete
  Single<Integer> delete(Race... Races);

  @Query("SELECT * FROM Race ORDER BY name")
  LiveData<List<Race>> selectAll();

  @Transaction
  @Query("SELECT * FROM Race ORDER BY name")
  LiveData<List<Race>> selectAll();

  @Transaction
  @Query("SELECT * FROM Race WHERE Race_id = :RaceId")
  LiveData<Race> selectById(long RaceId);

  Race update(History history);
}

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
import edu.cnm.deepdive.myfunrun.model.pojo.RaceWithHistory;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;

/**
 * The interface Race dao.
 */
@Dao
public interface RaceDao {

  /**
   * Insert single.
   *
   * @param Race the race
   * @return the single
   */
  @Insert(onConflict = OnConflictStrategy.IGNORE)
  Single<Long> insert(Race Race);

  /**
   * Insert single.
   *
   * @param Races the races
   * @return the single
   */
  @Insert(onConflict = OnConflictStrategy.IGNORE)
  Single<List<Long>> insert(Race... Races);

  /**
   * Insert single.
   *
   * @param Races the races
   * @return the single
   */
  @Insert(onConflict = OnConflictStrategy.IGNORE)
  Single<List<Long>> insert(Collection<Race> Races);

  /**
   * Update single.
   *
   * @param Races the races
   * @return the single
   */
  @Update
  Single<Integer> update(Race... Races);

  /**
   * Delete single.
   *
   * @param Races the races
   * @return the single
   */
  @Delete
  Single<Integer> delete(Race... Races);

  /**
   * Select all live data.
   *
   * @return the live data
   */
  @Query("SELECT * FROM Race ORDER BY name")
  LiveData<List<Race>> selectAll();

  // TODO Debug
 // @Transaction
  //@Query("SELECT * FROM Race ORDER BY race_id")
 // LiveData<Race> selectById(long RaceId)

  /**
   * Select by id single.
   *
   * @param raceId the race id
   * @return the single
   */
  @Transaction
  @Query("SELECT * FROM Race WHERE race_id = :raceId")
  Single<RaceWithHistory> selectById(long raceId);

}

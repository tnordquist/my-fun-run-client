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
import edu.cnm.deepdive.myfunrun.model.pojo.HistoryWithRace;
import edu.cnm.deepdive.myfunrun.model.pojo.RaceWithHistory;
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

  @Insert
  Single<Integer> Race(Race... Races);

  @Delete
  Single<Integer> delete(Race... Races);

  @Query("SELECT * FROM Race ORDER BY race_id")
  LiveData<List<Race>> selectAll();

  // TODO Debug
 // @Transaction
  //@Query("SELECT * FROM Race ORDER BY race_id")
 // LiveData<Race> selectById(long RaceId)

 // @Transaction
  //@Query("SELECT * FROM History WHERE Race_id = :RaceId")
  //LiveData<HistoryWithRace> selectById(long Race);

  Race update(History history);
}

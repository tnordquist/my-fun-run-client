package edu.cnm.deepdive.myfunrun.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.TypeConverters;
import androidx.room.Update;
import edu.cnm.deepdive.myfunrun.model.entity.History;
import edu.cnm.deepdive.myfunrun.model.pojo.HistoryWithDetails;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;

@Dao
public interface HistoryDao {

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  Single<Long> insert(History history);

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  Single<List<Long>> insert(History... histories);

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  Single<List<Long>> insert(Collection<History> histories);

  @Update
  Single<Integer> update(History... histories);

  @Delete
  Single<Integer> delete(History... histories);

  @Transaction
  @Query("SELECT * FROM History ORDER BY distance")
  LiveData<List<HistoryWithDetails>> selectAll();

 // @Transaction
 // @Query("SELECT * FROM History ORDER BY ")
 // LiveData<List<History>> selectById;

  @Transaction
  @Query("SELECT * FROM History WHERE History_id = :historyId")
  Single<HistoryWithDetails> selectById(long historyId);



}

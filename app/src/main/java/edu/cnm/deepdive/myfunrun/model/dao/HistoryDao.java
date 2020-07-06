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
import edu.cnm.deepdive.myfunrun.model.pojo.HistoryWithQuotes;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;

@Dao
public interface HistoryDao {

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  Single<Long> insert(History History);

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  Single<List<Long>> insert(History... Historys);

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  Single<List<Long>> insert(Collection<History> Historys);

  @Update
  Single<Integer> update(History... Historys);

  @Delete
  Single<Integer> delete(History... Historys);

  @Query("SELECT * FROM History ORDER BY name")
  LiveData<List<History>> selectAll();

  @Transaction
  @Query("SELECT * FROM History ORDER BY name")
  LiveData<List<HistoryWithQuotes>> selectAllWithQuotes();

  @Transaction
  @Query("SELECT * FROM History WHERE History_id = :HistoryId")
  LiveData<HistoryWithQuotes> selectById(long HistoryId);

}

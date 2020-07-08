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
import edu.cnm.deepdive.myfunrun.model.entity.History;
import edu.cnm.deepdive.myfunrun.model.entity.User;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;

@Dao
public interface UserDao {

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  Single<Long> insert(History History);

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  Single<List<Long>> insert(History... histories);

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  Single<List<Long>> insert(Collection<History> histories);

  @Update
  Single<Integer> update(History... histories);

  @Delete
  Single<Integer> delete(History... histories);
// TODO correct errors
 // @Query("SELECT * FROM History ORDER BY name")
 // LiveData<List<History>> selectAll();

 // @Transaction
  //@Query("SELECT * FROM History ORDER BY name")
  //LiveData<List<User>> selectAll();

  @Transaction
  @Query("SELECT * FROM History WHERE History_id = :HistoryId")
  LiveData<User> selectById(long HistoryId);

}

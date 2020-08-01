package edu.cnm.deepdive.myfunrun.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;
import edu.cnm.deepdive.myfunrun.model.entity.Comment;
import io.reactivex.Single;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Dao
public interface CommentDao {

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  Single<Long> insert(Comment comment);

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  Single<List<Long>> insert(Comment... comments);

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  Single<List<Long>> insert(Collection<Comment> comments);

  @Update
  Single<Integer> update(Comment... comments);

  @Delete
  Single<Integer> delete(Comment... comments);

  @Query("SELECT * FROM Comment WHERE history_id = :historyId ORDER BY date ASC")
  LiveData<List<Comment>> getAllByHistoryId(long historyId);
}

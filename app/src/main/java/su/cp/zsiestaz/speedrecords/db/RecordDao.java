package su.cp.zsiestaz.speedrecords.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import su.cp.zsiestaz.speedrecords.model.Record;

@Dao
public interface RecordDao {

  @Query("SELECT * FROM users")
  User[] getAllUsers();

  @Query("SELECT * FROM users WHERE id = :id")
  User getUserById(int id);

  @Insert
  void addUser(User... users);

  @Delete
  void deleteUser(User user);
}

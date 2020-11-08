package su.cp.zsiestaz.speedrecords.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;



@Entity(tableName = "records")
public class Record {

  @PrimaryKey(autoGenerate = true)
  public final int id;

  @ColumnInfo(name = "distances")
  public final String distances;

  @ColumnInfo(name = "times")
  public final String times;

  public final boolean fastspeed;

  public Record(int id, String distances, String times,boolean fastspeed) {
    this.id = id;
    this.distances = distances;
    this.times = times;
    this.fastspeed = fastspeed;
  }
}

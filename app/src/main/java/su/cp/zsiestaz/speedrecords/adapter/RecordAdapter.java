package su.cp.zsiestaz.speedrecords.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import su.cp.zsiestaz.speedrecords.R;
import su.cp.zsiestaz.speedrecords.model.Record;

public class RecordAdapter extends RecyclerView.Adapter<RecordAdapter.MyViewHolder> {

  private Context mContext;
  private Record[] mRecords;

  public RecordAdapter(Context context, Record[] records) {
    this.mContext = context;
    this.mRecords = records;
  }

  @NonNull
  @Override
  public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View v = LayoutInflater.from(parent.getContext())
        .inflate( R.layout.item_record, parent, false);
    return new MyViewHolder(v);
  }

  @Override
  public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
    Record record = mRecords[position];



    holder.cowImageView.setImageResource(
        record.fastspeed == true? R.drawable.red_cow : R.drawable.female
    );
  }

  @Override
  public int getItemCount() {
    return mRecords.length;
  }

  static class MyViewHolder extends RecyclerView.ViewHolder {
    TextView averageTextView;
    TextView distanceTextView;
    TextView timeTextView;
    ImageView cowImageView;
    boolean fastspeedTextView;

    public MyViewHolder(@NonNull View itemView) {
      super(itemView);

      this.averageTextView = itemView.findViewById(R.id.average_speed_text_view);
      this.distanceTextView = itemView.findViewById(R.id.distance_text_view);
      this.timeTextView = itemView.findViewById(R.id.time_text_view);
      this.cowImageView = itemView.findViewById(R.id.cow_image_view);
      double Cov = Double.parseDouble(averageTextView.getText().toString());
      if(Cov > 80){
        this.fastspeedTextView = true;
      }

    }
  }
}

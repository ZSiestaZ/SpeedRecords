package su.cp.zsiestaz.speedrecords.util;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import su.cp.zsiestaz.speedrecords.db.AppDatabase;

import java.util.Calendar;
import java.util.Date;

import su.cp.zsiestaz.speedrecords.R;
import su.cp.zsiestaz.speedrecords.model.Record;

public class AddRecordActivity extends AppCompatActivity {

    private EditText DistanceEditText, TimeEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_record);
        final Button cal = findViewById(R.id.calculae_buttom);
        final EditText dis = findViewById(R.id.numtext1);
        final EditText tim = findViewById(R.id.numtext2);


        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cal.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(dis.length() == 0 || tim.length() == 0){
                            Toast t = Toast.makeText(AddRecordActivity.this,getResources().getString(R.string.Toast1),Toast.LENGTH_LONG);
                            t.show();
                        }else{
                            double distance = Double.parseDouble(dis.getText().toString());
                            double time = Double.parseDouble(tim.getText().toString());
                            if(time <= 0){
                                Toast t = Toast.makeText(AddRecordActivity.this,getResources().getString(R.string.Toast2),Toast.LENGTH_LONG);
                                t.show();
                            }else{
                                double result = ((distance/time)*60*60)/1000;
                                String strDouble = String.format("%.2f", result);
                                AlertDialog.Builder dialog = new AlertDialog.Builder(AddRecordActivity.this);
                            }
                        }

                    }
        });

            }
        });

        Button saveButton = findViewById(R.id.add_button);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String distance;
                String time;
                boolean fastspeed;

                final Record record = new Record(0, "xx", "yy",true);

                AppExecutors executors = new AppExecutors();
                executors.diskIO().execute(new Runnable() {
                    @Override
                    public void run() { // worker thread
                        AppDatabase db = AppDatabase.getInstance(AddRecordActivity.this);
                        db.RecordDao().addUser(record);
                        finish();
                    }
                });
            }
        });
    }
}


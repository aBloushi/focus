package com.example.focus;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView timer;
    Button start, pause, reset;
    long MillisecondTime, StartTime, TimeBuff, UpdateTime = 0L;
    Handler handler;
    int Seconds, Minutes, MilliSeconds;
    int counter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timer = (TextView) findViewById(R.id.tvTimer);
        start = (Button) findViewById(R.id.btStart);
        pause = (Button) findViewById(R.id.btPause);
        reset = (Button) findViewById(R.id.btReset);

        handler = new Handler();

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                StartTime = SystemClock.uptimeMillis();
                handler.postDelayed(runnable, 0);

                reset.setEnabled(false);

            }
        });

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TimeBuff += MillisecondTime;

                handler.removeCallbacks(runnable);

                reset.setEnabled(true);

                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                final EditText edittext = new EditText(MainActivity.this);

                //dialoge
                alert.setMessage("What where you doing?");
                alert.setTitle("Done");

                alert.setView(edittext);

                alert.setPositiveButton("Save", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        //What ever you want to do with the value
                       // Editable YouEditTextValue = edittext.getText();
                        //OR

                        int min = Minutes;
                        int sec = Seconds;

                        String activity = edittext.getText().toString();

                        counter ++;






                        Intent intent = new Intent(MainActivity.this ,ActivRe.class);

                        intent.putExtra("co", counter);
                        intent.putExtra("act", activity);
                        intent.putExtra("min",min);
                        intent.putExtra("sec",sec );





                        startActivity(intent);

                    }
                });

                alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        // what ever you want to do with No option.
                    }
                });

                alert.show();

            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MillisecondTime = 0L;
                StartTime = 0L;
                TimeBuff = 0L;
                UpdateTime = 0L;
                Seconds = 0;
                Minutes = 0;
                MilliSeconds = 0;

                timer.setText("00:00:00");

            }
        });

    }

    public Runnable runnable = new Runnable() {

        public void run() {

            MillisecondTime = SystemClock.uptimeMillis() - StartTime;

            UpdateTime = TimeBuff + MillisecondTime;

            Seconds = (int) (UpdateTime / 1000);

            Minutes = Seconds / 60;

            Seconds = Seconds % 60;

            MilliSeconds = (int) (UpdateTime % 1000);

            timer.setText("" + Minutes + ":"
                    + String.format("%02d", Seconds) + ":"
                    + String.format("%03d", MilliSeconds));

            handler.postDelayed(this, 0);
        }

    };



}
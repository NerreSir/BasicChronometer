package com.liontertainment.runnable_handler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textViewtime;
    int numbertime;
    Runnable runnabletime;
    Handler handlertime;
    Button buttonstart;
    Button buttonstop;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewtime = findViewById(R.id.textView2);
        buttonstart = findViewById(R.id.buttonA);
        numbertime = 0;
    }

    public void starttime (View view) {
        handlertime = new Handler();

        runnabletime = new Runnable() {
            @Override
            public void run() {
                numbertime++;
                textViewtime.setText("Time: " + numbertime);
                handlertime.postDelayed(runnabletime, 1000);
            }
        };

        handlertime.post(runnabletime);
        buttonstart.setEnabled(false);

    }
/*  WHİLE DÖNGÜSÜ ÇALIŞMADI ÇÜNKÜ THREAD.SLEEP PROGRAMI HATA VERİYOR

        while (numbertime < 100) {
            //textViewtime.setText("Time: " + numbertime);
            numbertime++;
            textViewtime.setText("Time: " + numbertime);
          Thread.sleep(1000);
        }
*/

    public void stoptime (View view){
        handlertime.removeCallbacks(runnabletime);
        //numbertime=0; Gerek yokki en son kalınan zamanı gösteriyor bu olmazsa
        textViewtime.setText("Time resetted at:       " + numbertime + ". second");
        buttonstart.setEnabled(true);
    }



}
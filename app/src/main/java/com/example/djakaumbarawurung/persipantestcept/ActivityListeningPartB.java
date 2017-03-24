package com.example.djakaumbarawurung.persipantestcept;


import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class ActivityListeningPartB extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    TextView time;
    Button FinishLb,BstartB;
    ArrayList<String> UserLog = new ArrayList<>();
    EditText ET1,ET2,ET3,ET4,ET5;




    private double starttime = 0;
    private double finaltime = 0;
    private Handler myHandler = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_listening_part_b);


        time = (TextView) findViewById(R.id.time);
        FinishLb = ( Button )findViewById(R.id.FinishLB);
        ET1 = (EditText) findViewById(R.id.ET1);
        ET2 = (EditText) findViewById(R.id.ET2);
        ET3 = (EditText) findViewById(R.id.ET3);
        ET4 = (EditText) findViewById(R.id.ET4);
        ET5 = (EditText) findViewById(R.id.ET5);
        BstartB = ( Button ) findViewById(R.id.BstartB);


        int songId = this.getRawResIdByName("soallisteningb");


        this.mediaPlayer = MediaPlayer.create(this, songId);
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                FinishLb.setVisibility(View.VISIBLE);

            }
        });

    }




    public int getRawResIdByName(String resName) {
        String pkgName = this.getPackageName();

        int resID = this.getResources().getIdentifier(resName, "raw", pkgName);
        return resID;
    }





    @Override
    public void onDestroy() {
        if (mediaPlayer.isPlaying())
            mediaPlayer.stop();
        super.onDestroy();

    }

    public void StartListeningB(View view) {
        this.mediaPlayer.start();

        finaltime = mediaPlayer.getDuration();
        starttime = mediaPlayer.getCurrentPosition();

        time.setText(String.format("%d min, %d sec",
                TimeUnit.MILLISECONDS.toMinutes((long) starttime),
                TimeUnit.MILLISECONDS.toSeconds((long) starttime) -
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long)
                                starttime)))
        );
        myHandler.postDelayed(UpdateSongTime, 100);

BstartB.setEnabled(false);
    }


    public void cekJawabanListeningPartb ( View view ){
        String jawabanUser1 = ET1.getText().toString();
        String jawabanUser2 = ET2.getText().toString();
        String jawabanUser3 = ET3.getText().toString();
        String jawabanUser4 = ET4.getText().toString();
        String jawabanUser5 = ET5.getText().toString();

        UserLog.add(jawabanUser1);
        UserLog.add(jawabanUser2);
        UserLog.add(jawabanUser3);
        UserLog.add(jawabanUser4);
        UserLog.add(jawabanUser5);

        Intent intent = new Intent(ActivityListeningPartB.this, ActivityCekJawabanListeningB.class );
        intent.putStringArrayListExtra("userLog",UserLog);
        startActivity(intent);
    }



    private Runnable UpdateSongTime = new Runnable() {
        @Override
        public void run() {
            starttime = mediaPlayer.getCurrentPosition();
            double timeRemaining = finaltime - starttime;
            time.setText(String.format("%d min, %d sec",
                    TimeUnit.MILLISECONDS.toMinutes((long) timeRemaining),
                    TimeUnit.MILLISECONDS.toSeconds((long) timeRemaining) -
                            TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long) timeRemaining)))
            );
            myHandler.postDelayed(this, 100);
        }
    };
}




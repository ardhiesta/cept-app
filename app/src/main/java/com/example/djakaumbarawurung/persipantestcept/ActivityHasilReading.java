package com.example.djakaumbarawurung.persipantestcept;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ActivityHasilReading extends AppCompatActivity {
    TextView tvBenar, tvSalah;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil_reading);
        this.setTitle("Persiapan Tes CEPT");

        tvBenar = (TextView) findViewById(R.id.tvJmlBenarReading);
        tvSalah = (TextView) findViewById(R.id.tvJmlSalahReading);

        int jmlBenar = getIntent().getExtras().getInt("benar");
        int jmlsalah = getIntent().getExtras().getInt("salah");
        tvBenar.setText(String.valueOf(jmlBenar));
        tvSalah.setText(String.valueOf(jmlsalah));


    }
    public void exitApp( View view){
        this.finishAffinity();
    }
    public void goToHome ( View view){
        Intent intent = new Intent (ActivityHasilReading.this , ActivityHome.class);
        startActivity(intent);
    }
}

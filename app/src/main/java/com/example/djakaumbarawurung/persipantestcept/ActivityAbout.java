package com.example.djakaumbarawurung.persipantestcept;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ActivityAbout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        this.setTitle("Persiapan Tes CEPT");
    }
//    public void About (View view) {
//        Intent intent = new Intent(ActivityAbout.this, ActivityQuiz.class);
//        startActivity(intent);
//    }

}

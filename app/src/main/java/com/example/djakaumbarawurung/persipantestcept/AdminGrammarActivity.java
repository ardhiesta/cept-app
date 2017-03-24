package com.example.djakaumbarawurung.persipantestcept;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.djakaumbarawurung.persipantestcept.database.DataSource_PenghubungTabel;

public class AdminGrammarActivity extends AppCompatActivity {
    DataSource_PenghubungTabel dataSource_penghubungTabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_grammar);

        dataSource_penghubungTabel = new DataSource_PenghubungTabel(this);
    }
}

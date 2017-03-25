package com.example.djakaumbarawurung.persipantestcept;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.djakaumbarawurung.persipantestcept.Model_Set_get.Grammar;
import com.example.djakaumbarawurung.persipantestcept.database.DataSource_PenghubungTabel;
import com.example.djakaumbarawurung.persipantestcept.utils.GrammarAdapter;

import java.util.ArrayList;
import java.util.List;

public class AdminGrammarActivity extends AppCompatActivity {
    DataSource_PenghubungTabel dataSource_penghubungTabel;

    // ambil data soal grammar
    ArrayList<Grammar> grammarArrayList = new ArrayList<>();

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_grammar);

        dataSource_penghubungTabel = new DataSource_PenghubungTabel(this);
        dataSource_penghubungTabel.open();

        recyclerView = (RecyclerView) findViewById(R.id.rv_gramar);

        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        getDataGrammar();

        GrammarAdapter grammarAdapter = new GrammarAdapter(grammarArrayList);
        recyclerView.setAdapter(grammarAdapter);
    }

    private void getDataGrammar(){
        grammarArrayList = dataSource_penghubungTabel.ambilDataSoalGrammar();
    }

    @Override
    protected void onResume() {
        dataSource_penghubungTabel.open();
        super.onResume();
    }

    @Override
    protected void onPause() {
        dataSource_penghubungTabel.close();
        super.onPause();
    }


}

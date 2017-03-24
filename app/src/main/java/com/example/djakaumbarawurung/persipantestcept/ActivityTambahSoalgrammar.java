package com.example.djakaumbarawurung.persipantestcept;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.djakaumbarawurung.persipantestcept.database.DataSource_PenghubungTabel;

public class ActivityTambahSoalgrammar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitytambahsoalgrammar);
    }

    public void simpanPertanyaanBARU(View view) {
//        String pertanyaan = etQuestion.getText().toString();
//        String Jawaban = etAnswer.getText().toString();
//        String Penjelasann = etExplanation.getText().toString();
//        String opsi1 = etOpsi1.getText().toString();
//        String opsi2 = etOpsi1.getText().toString();
//        String opsi3 = etOpsi1.getText().toString();
//        String opsi4 = etOpsi1.getText().toString();
//
//        long new GrammarId = 0;
//
//        if ((!pertanyaan.equalsIgnoreCase("") && !jawaban.equalsIgnoreCase("") && !penjelasan.equalsIgnoreCase(""))) {
//            newGrammarId = DataSource_PenghubungTabel.insertDataKeGrammarTanpaId(pertanyaan, jawaban, penjelasan);
//            if (newGrammarId > 0) {
//                DataSource_PenghubungTabel.insertOpsiGrammar(opsi1, newGrammarId);
//                DataSource_PenghubungTabel.insertOpsiGrammar(opsi1, newGrammarId);
//                DataSource_PenghubungTabel.insertOpsiGrammar(opsi1, newGrammarId);
//                DataSource_PenghubungTabel.insertOpsiGrammar(opsi1, newGrammarId);
//            }
//        }

    }
}

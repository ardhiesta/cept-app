package com.example.djakaumbarawurung.persipantestcept;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.djakaumbarawurung.persipantestcept.database.DataSource_PenghubungTabel;
import com.example.djakaumbarawurung.persipantestcept.Model_Set_get.Grammar;

import java.util.ArrayList;

public class ActivityHasil extends AppCompatActivity {
        TextView tvBenar,tvSalah;
    TextView tvSoalCekGrammar, tvJawabanUserCekGrammar, tvKunciCekGrammar, tvPenjelasanCekGrammar;
    Button btnBackCekGrammar, btnNextCekGrammar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil);

        tvBenar = (TextView) findViewById(R.id.tvBenar);
        tvSalah = (TextView) findViewById(R.id.tvSalah);



        tvSoalCekGrammar = (TextView) findViewById(R.id.tvSoalCekGrammar);
        tvJawabanUserCekGrammar = (TextView) findViewById(R.id.tvJawabanUserCekGrammar);
        tvKunciCekGrammar = (TextView) findViewById(R.id.tvKunciCekGrammar);
        tvPenjelasanCekGrammar = (TextView) findViewById(R.id.tvPenjelasanCekGrammar);
        btnBackCekGrammar = (Button) findViewById(R.id.btnBackCekGrammar);
        btnNextCekGrammar = (Button) findViewById(R.id.btnNextCekGrammar);






        //mengambil data jumlah jawaban benar dan jumlah jawaban salah yang dikirimkan activity sebelumnya
        int jmlBenar = getIntent().getExtras().getInt("benar");
        int jmlsalah = getIntent().getExtras().getInt("salah");

        //menampilkan jumlah jawaban benar dan jumlah jawaban salah
        tvBenar.setText(String.valueOf(jmlBenar));
        tvSalah.setText(String.valueOf(jmlsalah));
    }
    public void exitApp( View view){
        this.finishAffinity();
    }
    public void goToHome ( View view){
        Intent intent = new Intent (ActivityHasil.this , ActivityHome.class);
        startActivity(intent);
    }
}



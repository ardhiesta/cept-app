package com.example.djakaumbarawurung.persipantestcept;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.djakaumbarawurung.persipantestcept.Model_Set_get.UserLog;

import java.util.ArrayList;

public class Activity_Cek_ListeningA extends AppCompatActivity {
    int indexAktivitasUser = 0;
    ArrayList<UserLog> userLogArrayList = new ArrayList<>();
    TextView tvSoalCekListening, tvJawabanUserCekListening, tvKunciCekListening;
    Button BtnBAckLA, BtnNextLA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity__cek__listening);


        tvJawabanUserCekListening = (TextView) findViewById(R.id.tvJawabanUserCekListening);
        tvSoalCekListening = (TextView) findViewById(R.id.tvSoalCekListening);
        tvKunciCekListening = (TextView) findViewById(R.id.tvKunciCekListening);
        userLogArrayList = getIntent().getParcelableArrayListExtra("aktivitasUser");
        BtnBAckLA = (Button) findViewById(R.id.btnBackCekListening);
        BtnNextLA = (Button) findViewById(R.id.btnNextCekListening);

        showQuestion(indexAktivitasUser);
    }

    private void showQuestion(int index) {
        UserLog userLog = userLogArrayList.get(index);
        tvSoalCekListening.setText("Question " + (index + 1));
        tvJawabanUserCekListening.setText(userLog.getJawabanUser());
        tvKunciCekListening.setText(userLog.getKunci());
    }

    public void nextCekListening(View view) {
        if (BtnNextLA.getText().toString().equalsIgnoreCase("next")) {
            System.out.println("");
            if (indexAktivitasUser < userLogArrayList.size() - 1) {
                indexAktivitasUser++;
                showQuestion(indexAktivitasUser);
            } else {
                BtnNextLA.setText("SHOW RESULT");
            }
        } else {
            Intent intent =  new Intent(Activity_Cek_ListeningA.this, ActivityHasil.class);
            int jmlBenar = hitungListeningBenar();
            intent.putExtra("benar", jmlBenar);
            intent.putExtra("salah",userLogArrayList.size()-jmlBenar);
            startActivity(intent);

        }
    }

    // hitung jumlah benar

    private int hitungListeningBenar() {
        int jmlBenar = 0;
        for (int i = 0; i < userLogArrayList.size(); i++) {
            if (userLogArrayList.get(i).getJawabanUser().startsWith(userLogArrayList.get(i).getKunci())) {
                jmlBenar++;
            }
        }
        return jmlBenar;
    }



    public void backCekListening(View view){
        if (indexAktivitasUser > 0){
            indexAktivitasUser--;
            showQuestion(indexAktivitasUser);
        }
    }

    }


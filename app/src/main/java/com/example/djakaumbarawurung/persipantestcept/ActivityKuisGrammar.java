package com.example.djakaumbarawurung.persipantestcept;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.djakaumbarawurung.persipantestcept.Model_Set_get.UserLog;
import com.example.djakaumbarawurung.persipantestcept.database.DataSource_PenghubungTabel;
import com.example.djakaumbarawurung.persipantestcept.Model_Set_get.Opsi;
import com.example.djakaumbarawurung.persipantestcept.Model_Set_get.Grammar;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class ActivityKuisGrammar extends AppCompatActivity {
    TextView TvSoal, TvOpsi1, TvOpsi2, TvOpsi3, TvOpsi4, TvPenjelasan, TxtPenjelasan;
    Button Bnext;
    DataSource_PenghubungTabel dataSource_penghubungTabel;
    ArrayList<Integer> alidPertanyaan;
    int IndexGrammar = 0;
    String jawabanUser = "";
    ArrayList<UserLog> userLogArrayList = new ArrayList<>();
//    boolean sudahCekJawaban = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grammar);
        this.setTitle("Persiapan Tes CEPT");

        TvSoal = (TextView) findViewById(R.id.TVPertanyaan);
        TvOpsi1 = (TextView) findViewById(R.id.TVpilihan1);
        TvOpsi2 = (TextView) findViewById(R.id.TVpilihan2);
        TvOpsi3 = (TextView) findViewById(R.id.TVpilihan3);
        TvOpsi4 = (TextView) findViewById(R.id.TVpilihan4);
//        TvPenjelasan = (TextView) findViewById(R.id.TvPenjelasan);
        // TxtPenjelasan = (TextView) findViewById (R.id.TvPenjelasan);


        //  BCheck = (Button) findViewById(R.id.Btncek);
        Bnext = (Button) findViewById(R.id.BtnNext);
        //Bback = (Button) findViewById(R.id.BtnBack);


        dataSource_penghubungTabel = new DataSource_PenghubungTabel(this);
        dataSource_penghubungTabel.open();


        alidPertanyaan = dataSource_penghubungTabel.mengambilsemuaIdGrammar();
        acakIdPertanyaan();

//        TvPenjelasan.setText("");
//        TxtPenjelasan.setText("");
//

        Bnext.setEnabled(true);

//        Bnext.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                System.out.println("button clicked");
////                tampilkanPertanyaanSelanjutnya(view);
//            }
//        });
    }


    private void acakIdPertanyaan() {
        long seed = System.nanoTime();
        if (alidPertanyaan.size() > 0) {
            Collections.shuffle(alidPertanyaan, new Random(seed));

            int idPertanyaan = alidPertanyaan.get(0);
            bentukKuis(idPertanyaan);
        } else {
            Toast.makeText(this, "Pertanyaan Sudah Habis", Toast.LENGTH_LONG).show();
        }

    }

    private void bentukKuis(int idpertanyaan) {
        ArrayList<Opsi> opsiArrayList = dataSource_penghubungTabel.ambilOpsiSesuaiPertanyaan(idpertanyaan);

        Grammar pertanyaan = dataSource_penghubungTabel.ambilpertanyaanSesuaiId(idpertanyaan);
        TvSoal.setText(pertanyaan.getPertanyaan());
        for (int i = 0; i < opsiArrayList.size(); i++) {
            Opsi opsi = opsiArrayList.get(i);
            if (opsi.getOpsi().toLowerCase().startsWith("a")) {
                TvOpsi1.setText(opsi.getOpsi());
            } else if ((opsi.getOpsi().toLowerCase().startsWith("b"))) {
                TvOpsi2.setText(opsi.getOpsi());
            } else if (opsi.getOpsi().toLowerCase().startsWith("c")) {
                TvOpsi3.setText(opsi.getOpsi());
            } else {
                TvOpsi4.setText(opsi.getOpsi());

            }

        }
    }

    public void opsi1klik(View view) {
        //ambil Abjad Pilihan User
        jawabanUser = "a";
        setOpsi(TvOpsi1, TvOpsi2, TvOpsi3, TvOpsi4);
        Bnext.setEnabled(true);
    }

    public void opsiKlik2(View view) {
        jawabanUser = "b";
        setOpsi(TvOpsi2, TvOpsi1, TvOpsi3, TvOpsi4);
        Bnext.setEnabled(true);
    }

    public void opsiKlik3(View view) {
        jawabanUser = "c";
        setOpsi(TvOpsi3, TvOpsi1, TvOpsi2, TvOpsi4);
        Bnext.setEnabled(true);
    }

    public void opsiKlik4(View view) {
        jawabanUser = "d";
        setOpsi(TvOpsi4, TvOpsi1, TvOpsi2, TvOpsi3);
        Bnext.setEnabled(true);
    }

    private void setOpsi(TextView tvdipilih, TextView tvTdkDiplih1, TextView tvtdkDiplih2, TextView tvtdkdipilih3) {
        tvdipilih.setTypeface(null, Typeface.BOLD);
        tvTdkDiplih1.setTypeface(null, Typeface.NORMAL);
        tvtdkDiplih2.setTypeface(null, Typeface.NORMAL);
        tvtdkdipilih3.setTypeface(null, Typeface.NORMAL);
        tvdipilih.setTextColor(Color.parseColor("#303f9f"));
        tvTdkDiplih1.setTextColor(Color.parseColor("#000000"));
        tvtdkDiplih2.setTextColor((Color.parseColor("#000000")));
        tvtdkdipilih3.setTextColor(Color.parseColor("#000000"));
    }


    public void netralkanOpsi() {
        jawabanUser = "";

        TvOpsi1.setTypeface(null, Typeface.NORMAL);
        TvOpsi2.setTypeface(null, Typeface.NORMAL);
        TvOpsi3.setTypeface(null, Typeface.NORMAL);
        TvOpsi4.setTypeface(null, Typeface.NORMAL);
        TvOpsi1.setTextColor(Color.parseColor("#000000"));
        TvOpsi2.setTextColor(Color.parseColor("#000000"));
        TvOpsi3.setTextColor(Color.parseColor("#000000"));
        TvOpsi4.setTextColor((Color.parseColor("#000000")));
    }


    // METHOD UNTUK NEXT
    public void tampilkanPertanyaanSelanjutnya(View view) {
        System.out.println("");
        // if (!sudahCekJawaban) {

        // tombol Next setelah sampai pada pertanyaan terakhir untuk narasi terakhir akan menampilkan ActivityCekJawaban
        if (Bnext.getText().toString().equalsIgnoreCase("CHECK ANSWER")) {
            Intent intent = new Intent(ActivityKuisGrammar.this, ActivityCekJawabanGrammar.class);

            //mengirim data aktivitas user (soal serta jawaban yang telah dipilih user) ke activity selanjutnya
            intent.putParcelableArrayListExtra("aktivitasUser", userLogArrayList);
            startActivity(intent);


        } else {
            if (!jawabanUser.equals("")) {
                //menyimpan aktivitas user di kuis grammar ke obyek userLog
                UserLog userLog = new UserLog();
                userLog.setJawabanUser(jawabanUser);
                Grammar grammar2 = dataSource_penghubungTabel.ambilpertanyaanSesuaiId(alidPertanyaan.get(IndexGrammar));
                userLog.setKunci(grammar2.getJawaban());
                userLog.setPenjelasan(grammar2.getPenjelasan());
                userLog.setPertanyaan(grammar2.getPertanyaan());


                if (IndexGrammar < alidPertanyaan.size() - 1) {
                    //menambah (increment) index grammar untuk menuju ke soal selanjutnya
                    IndexGrammar++;
                    netralkanOpsi();

                    //mengambil id soal selanjutnya dari ArrayList yang berisi id soal
                    int idPertanyaan = alidPertanyaan.get(IndexGrammar);

                    //menampilkan soal grammar beserta opsi
                    bentukKuis(idPertanyaan);

                    //menyimpan aktivitas user ke ArrayList userLogArrayList
                    userLogArrayList.add(userLog);

                } else {
                    Bnext.setText("CHECK ANSWER");


                }
            }

            else { Toast.makeText(getApplicationContext(), "Silahkan Pilih Jawaban Terlebih Dahulu", Toast.LENGTH_LONG).show();

            }

        }
    }
}




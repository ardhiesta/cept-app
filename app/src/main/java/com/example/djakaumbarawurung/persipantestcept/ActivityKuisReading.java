package com.example.djakaumbarawurung.persipantestcept;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.djakaumbarawurung.persipantestcept.Model_Set_get.NarasiReading;
import com.example.djakaumbarawurung.persipantestcept.Model_Set_get.OpsiReading;
import com.example.djakaumbarawurung.persipantestcept.Model_Set_get.SoalReading;
import com.example.djakaumbarawurung.persipantestcept.Model_Set_get.ReadingLog;
import com.example.djakaumbarawurung.persipantestcept.database.DataSource_PenghubungTabel;

import java.util.ArrayList;

public class ActivityKuisReading extends AppCompatActivity {
    TextView TvOpsi1, TvOpsi2, TvOpsi3, TvOpsi4, TvSoal, TvNarasi, TvPenjelasan;
    DataSource_PenghubungTabel dataSource_penghubungTabel;
    ArrayList<NarasiReading> narasiReadingArrayList;
    int indexNarasi = 0;
    int indexPertanyaan = 0;
    String jawabanUser = "";
    ArrayList<ReadingLog> aktivitasUserDikuisReading = new ArrayList<>();
    Button bNextReading;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reading);
        this.setTitle("Persiapan Tes CEPT");

        dataSource_penghubungTabel = new DataSource_PenghubungTabel(this);
        dataSource_penghubungTabel.open();
        narasiReadingArrayList = dataSource_penghubungTabel.ambilNaskahReading();


        TvNarasi = (TextView) findViewById(R.id.TvNarasi);
        TvSoal = (TextView) findViewById(R.id.TVPertanyaanReading);
        TvOpsi1 = (TextView) findViewById(R.id.TvOpsiReading1);
        TvOpsi2 = (TextView) findViewById(R.id.TvOpsiReading2);
        TvOpsi3 = (TextView) findViewById(R.id.TvOpsiReading3);
        TvOpsi4 = (TextView) findViewById(R.id.TvOpsiReading4);
        TvPenjelasan = (TextView) findViewById(R.id.PenjelasanReading);

        TvPenjelasan.setText("");
        bNextReading = (Button) findViewById(R.id.bNextReading);


        // untuk menampilkan pertanyaan reading
        tampilkanPertanyaan(indexNarasi, indexPertanyaan);

    }

    public void tampilkanPertanyaan(int indexNarasi, int indexPertanyaan) {

        NarasiReading narasiReading = narasiReadingArrayList.get(indexNarasi);
        TvNarasi.setText(narasiReading.getNarasi());
        ArrayList<SoalReading> pertanyaanReadingArrayList = narasiReading.getSoalReadingArraylist();
        SoalReading pertanyaanReading = pertanyaanReadingArrayList.get(indexPertanyaan);
        TvSoal.setText(pertanyaanReading.getPetanyaan());
        ArrayList<OpsiReading> opsiReadingArrayList = pertanyaanReading.getOpsiReadingArrayList();
        for (int i = 0; i < opsiReadingArrayList.size(); i++) {
            OpsiReading opsiReading = opsiReadingArrayList.get(i);
            if (opsiReading.getOpsi().toLowerCase().startsWith("a")) {
                TvOpsi1.setText(opsiReading.getOpsi());
            } else if (opsiReading.getOpsi().toLowerCase().startsWith("b")) {
                TvOpsi2.setText(opsiReading.getOpsi());
            } else if (opsiReading.getOpsi().toLowerCase().startsWith("c")) {
                TvOpsi3.setText(opsiReading.getOpsi());
            } else {
                TvOpsi4.setText(opsiReading.getOpsi());
            }
        }

    }


    public void tampilkanPertanyaanReadingSelanjutnya2(View view) {
        // tombol Next setelah sampai pada pertanyaan terakhir untuk narasi terakhir akan menampilkan activityCekJawaban
        if (bNextReading.getText().toString().equalsIgnoreCase("CHECK ANSWER")) {
            Intent intent = new Intent(ActivityKuisReading.this, ActivityCekJawabanReading.class);
            intent.putParcelableArrayListExtra("aktivitasUser", aktivitasUserDikuisReading);
            startActivity(intent);
            finish();
        } else {
            if (!jawabanUser.equals("")) {
                ReadingLog readingLog = new ReadingLog();
                readingLog.setNarasi(TvNarasi.getText().toString());
                readingLog.setPertanyaan(TvSoal.getText().toString());
                readingLog.setJawabanUser(jawabanUser);
                NarasiReading narasiReading = narasiReadingArrayList.get(indexNarasi);
                SoalReading soalReading = narasiReading.getSoalReadingArraylist().get(indexPertanyaan);
                readingLog.setKunci(soalReading.getJawaban());
                readingLog.setPenjelasan(soalReading.getPenjelasan());


                if (indexPertanyaan < narasiReadingArrayList.get(indexNarasi).getSoalReadingArraylist().size() - 1) {
                    aktivitasUserDikuisReading.add(readingLog);
                    netralkanOpsi();
                    indexPertanyaan++;
                    tampilkanPertanyaan(indexNarasi, indexPertanyaan);

                } else {
                    if (indexNarasi < narasiReadingArrayList.size() - 1) {
                        aktivitasUserDikuisReading.add(readingLog);
                        netralkanOpsi();
                        indexNarasi++;
                        indexPertanyaan = 0;
                        tampilkanPertanyaan(indexNarasi, indexPertanyaan);
                    } else {
                        // jika sudah sampai pada narasi terakhir dan pertanyaan terakhir tombol next berubah jadi cek jawaban
                        if (indexPertanyaan == narasiReadingArrayList.get(indexNarasi).getSoalReadingArraylist().size() - 1) {
                            bNextReading.setText("CHECK ANSWER");
                            aktivitasUserDikuisReading.add(readingLog);
                        }
                    }
                }
            }
        }
    }



    public void opsi1klikR(View view) {
        //ambil Abjad Pilihan User
        setOpsi(TvOpsi1);
        jawabanUser = TvOpsi1.getText().toString();

    }

    public void opsiKlik2R(View view) {
        setOpsi(TvOpsi2);
        jawabanUser = TvOpsi2.getText().toString();

    }

    public void opsiKlik3R(View view) {
        setOpsi(TvOpsi3);
        jawabanUser = TvOpsi3.getText().toString();

    }

    public void opsiKlik4R(View view) {
        setOpsi(TvOpsi4);
        jawabanUser = TvOpsi4.getText().toString();

    }


    private void setOpsi(TextView tvdipilih) {
        netralkanOpsi();
        tvdipilih.setTypeface(null, Typeface.BOLD);
        tvdipilih.setTextColor(Color.parseColor("#303f9f"));
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
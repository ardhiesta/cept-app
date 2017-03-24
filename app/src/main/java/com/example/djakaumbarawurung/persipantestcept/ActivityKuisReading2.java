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
import com.example.djakaumbarawurung.persipantestcept.Model_Set_get.ReadingLog;
import com.example.djakaumbarawurung.persipantestcept.Model_Set_get.SoalReading;
import com.example.djakaumbarawurung.persipantestcept.database.DataSource_PenghubungTabel;

import java.util.ArrayList;

public class ActivityKuisReading2 extends AppCompatActivity {



    TextView TvOpsi1, TvOpsi2, TvOpsi3, TvOpsi4, TvSoal, TvNarasi, TvPenjelasan;
    DataSource_PenghubungTabel dataSource_penghubungTabel;
    ArrayList<NarasiReading> narasiReadingArrayList;
    int indexNarasi = 0;
    int indexPertanyaan = 0;
    String jawabanUser = "";
    ArrayList<ReadingLog> aktivitasUserDiKuisReading = new ArrayList<>();
    Button bNextReading;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kuis_reading);
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
        bNextReading = (Button) findViewById(R.id.bNextReading);

        TvPenjelasan.setText("");
        //tombol next tidak bisa diklik kecuali user telah memilih sebuah opsi untuk menjawab soal
        bNextReading.setEnabled(false);

        tampilkanPertanyaan(indexNarasi, indexPertanyaan);
    }

    // untuk menampilkan pertanyaan reading
    public void tampilkanPertanyaan(int indexNarasi, int indexPertanyaan) {
        NarasiReading narasiReading = narasiReadingArrayList.get(indexNarasi);
        TvNarasi.setText(narasiReading.getNarasi());
        ArrayList<SoalReading> soalReadingArrayList = narasiReading.getSoalReadingArraylist();
        SoalReading soalReading = soalReadingArrayList.get(indexPertanyaan);
        TvSoal.setText(soalReading.getPetanyaan());
        ArrayList<OpsiReading> opsiReadingArrayList = soalReading.getOpsiReadingArrayList();
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

    public void tampilkanPertanyaanReadingSelanjutnya(View view) {
        // tombol Next setelah sampai pada pertanyaan terakhir untuk narasi terakhir akan menampilkan activityCekJawaban
        if (bNextReading.getText().toString().equalsIgnoreCase("CHECK ANSWER")) {
            Intent intent = new Intent(ActivityKuisReading2.this, ActivityCekJawabanReading.class);
            intent.putParcelableArrayListExtra("aktivitasUser", aktivitasUserDiKuisReading);
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
                    aktivitasUserDiKuisReading.add(readingLog);
                    netralkanOpsi();
                    indexPertanyaan++;
                    tampilkanPertanyaan(indexNarasi, indexPertanyaan);

                } else {
                    if (indexNarasi < narasiReadingArrayList.size() - 1) {
                        aktivitasUserDiKuisReading.add(readingLog);
                        netralkanOpsi();
                        indexNarasi++;
                        indexPertanyaan = 0;
                        tampilkanPertanyaan(indexNarasi, indexPertanyaan);
                    } else {
                        // jika sudah sampai pada narasi terakhir dan pertanyaan terakhir tombol next berubah jadi cek jawaban
                        if (indexPertanyaan == narasiReadingArrayList.get(indexNarasi).getSoalReadingArraylist().size() - 1) {
                            bNextReading.setText("CHECK ANSWER");
                            aktivitasUserDiKuisReading.add(readingLog);
                        }
                    }
                }
            }
        }
    }

    /* opsi1KlikReading untuk mengisi variabel jawabanUser ke opsi pertama
    * kemudian tombol next diEnable
    * dan opsi yang dipilih user ditandai (bold, warna font ganti)
    *
    * demikian pula untuk opsi2KlikReading hingga opsi4KlikReading
    * */
    public void opsi1KlikReading(View view) {
        //ambil jawaban pilihan User
        setOpsi(TvOpsi1);
        jawabanUser = TvOpsi1.getText().toString();
        bNextReading.setEnabled(true);
    }

    public void opsi2KlikReading(View view) {
        setOpsi(TvOpsi2);
        jawabanUser = TvOpsi2.getText().toString();
        bNextReading.setEnabled(true);
    }

    public void opsi3KlikReading(View view) {
        setOpsi(TvOpsi3);
        jawabanUser = TvOpsi3.getText().toString();
        bNextReading.setEnabled(true);
    }

    public void opsi4KlikReading(View view) {
        setOpsi(TvOpsi4);
        jawabanUser = TvOpsi4.getText().toString();
        bNextReading.setEnabled(true);
    }

    /* jawaban user dinetralkan
     * opsiyang dipilih user diBold dan diganti warna fontnya */
    private void setOpsi(TextView tvdipilih) {
        netralkanOpsi();
        tvdipilih.setTypeface(null, Typeface.BOLD);
        tvdipilih.setTextColor(Color.parseColor("#303f9f"));
    }

    /* variabek jawbanUser dikosongkan
     * semua opsi fontnya dibuat normal (tidak bold)
     * semua opsi warna fontnya kembali jadi hitam */
    public void netralkanOpsi() {
        jawabanUser = "";
        bNextReading.setEnabled(false);

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


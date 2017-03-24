package com.example.djakaumbarawurung.persipantestcept;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.djakaumbarawurung.persipantestcept.Model_Set_get.UserLog;

import java.util.ArrayList;

public class ActivityCekJawabanGrammar extends AppCompatActivity {
    int indexAktivitasUser = 0;
    ArrayList<UserLog> userLogArrayList = new ArrayList<>();
    TextView tvSoalCekGrammar, tvJawabanUserCekGrammar, tvKunciCekGrammar, tvPenjelasanCekGrammar;
    Button btnBackCekGrammar, btnNextCekGrammar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_cek_jawaban_grammar);

        tvSoalCekGrammar = (TextView) findViewById(R.id.tvSoalCekGrammar);
        tvJawabanUserCekGrammar = (TextView) findViewById(R.id.tvJawabanUserCekGrammar);
        tvKunciCekGrammar = (TextView) findViewById(R.id.tvKunciCekGrammar);
        tvPenjelasanCekGrammar = (TextView) findViewById(R.id.tvPenjelasanCekGrammar);
        btnBackCekGrammar = (Button) findViewById(R.id.btnBackCekGrammar);
        btnNextCekGrammar = (Button) findViewById(R.id.btnNextCekGrammar);

        //mengambil data aktivitas user yang dikirim dari ActivityKuisGrammar
        userLogArrayList = getIntent().getParcelableArrayListExtra("aktivitasUser");

        //menampilkan soal, jawabanUser, kunci jawaban, serta penjelasan
        showQuestion(indexAktivitasUser);
    }

    //menampilkan soal, jawabanUser, kunci jawaban, serta penjelasan ke screen
    private void showQuestion(int index) {
        UserLog userLog = userLogArrayList.get(index);
        tvSoalCekGrammar.setText(userLog.getPertanyaan());
        tvJawabanUserCekGrammar.setText(userLog.getJawabanUser());
        tvKunciCekGrammar.setText(userLog.getKunci());
        tvPenjelasanCekGrammar.setText(userLog.getPenjelasan());
    }

    //dieksekusi ketika tombol Next diklik
    public void nextCekGrammar(View view) {
        if (btnNextCekGrammar.getText().toString().equalsIgnoreCase("next")) {
            //bila belum sampai di soal terakhir, tampilkan soal-soal selanjutnya
            if (indexAktivitasUser < userLogArrayList.size() - 1) {
                indexAktivitasUser++;
                showQuestion(indexAktivitasUser);
            } else {
                //tombol cek hasil ditampilkan ketika sampai pada soal terakhir
                btnNextCekGrammar.setText("SHOW RESULT");
            }
        } else { //dieksekusi ketika tulisan pada tombol Next berubah menjadi SHOW RESULT
            //menampilkan ActivityHasilKuis yang memuat informasi jumlah soal benar dan salah
            Intent intent = new Intent(ActivityCekJawabanGrammar.this, ActivityHasil.class);
            //menghitung jumlah soal yang dijawab benar
            int jmlBenar = hitungGrammarBenar();
            //mengirimkan data jumlah soal benar ke ActivityHasilKuis
            intent.putExtra("benar", jmlBenar);
            //menghitung dan mengirimkan data jumlah soal salah ke ActivityHasilKuis
            intent.putExtra("salah", userLogArrayList.size() - jmlBenar);
            startActivity(intent);
        }
    }

    //dieksekusi ketika tombol Back diklik
    public void backCekGrammar(View view) {
        if (indexAktivitasUser > 0) {
            indexAktivitasUser--;
            showQuestion(indexAktivitasUser);

            //kembalikan btn next utk menampilkan next
            if (btnNextCekGrammar.getText().toString().equalsIgnoreCase("show result")) {
                btnNextCekGrammar.setText("NEXT");
            }
        }
    }

    //hitung jumlah jawaban benar
    private int hitungGrammarBenar() {
        int jmlBenar = 0;
        for (int i = 0; i < userLogArrayList.size(); i++) {
            if (userLogArrayList.get(i).getJawabanUser().startsWith(userLogArrayList.get(i).getKunci().toLowerCase())) {
                jmlBenar++;
            }
        }
        return jmlBenar;
    }
}
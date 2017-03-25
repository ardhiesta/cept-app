package com.example.djakaumbarawurung.persipantestcept;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.djakaumbarawurung.persipantestcept.Model_Set_get.Grammar;
import com.example.djakaumbarawurung.persipantestcept.database.DataSource_PenghubungTabel;
import com.example.djakaumbarawurung.persipantestcept.database.SQLiteHelper;

import java.util.ArrayList;

public class ActivityHome extends AppCompatActivity {

 private DataSource_PenghubungTabel dataSource_penghubungTabel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        this.setTitle("Persiapan Tes CEPT");


        dataSource_penghubungTabel = new DataSource_PenghubungTabel(this);
        dataSource_penghubungTabel.open();

        // menghitung jumlah record //
        if(dataSource_penghubungTabel.hitungrecordGrammar()== 0) {
            dataSource_penghubungTabel.insertDataKeGrammar(1, "In 1796, French mathematician Pierre-Simon Laplace _____ a more detailed version of Kant’s theory.", "A", "");
            dataSource_penghubungTabel.insertDataKeGrammar(2, "Abdominal pain is a common problem for people in all age groups, and ................... to frequent visits to physicians and doctors.", "B", "Karena kalimat diatas kehilangan kata kerja, maka jawaban yang paling tepat adalah B.Leads ");
            dataSource_penghubungTabel.insertDataKeGrammar(3, "Treatment adherence refers to behavior in ..................................... to a prescribed treatment regimen for an illness.", "A", "Susunan paling tepat untuk ADJ CLAUSE adalah Clause Marker + Subject + Verb jadi jawaban yang paling tepat adalah A.Which individuals adhere");
            dataSource_penghubungTabel.insertDataKeGrammar(4, "Some factors .......................... to health outcomes among African Americans include descrimination, health issues, and nonaccess to medical care.", "D", "D.Contributing adalah klausa kata sifat yang berupa kalimat aktif merupakan jawaban yang tepat untuk kalimat yang membutuhkan klausa kata sifat");
            dataSource_penghubungTabel.insertDataKeGrammar(5, "Medications of Alzheimer’s disease should target specific symptoms ...................... their effects can be monitored", "B", "Kata hubung koordinatif yang paling tepat adalah B.So");
            dataSource_penghubungTabel.insertDataKeGrammar(6, "Recently, stents have been inserted into the ........................... artery to help preserve blood flow.", "B", "Susunan pilihan jawaban yang paling tepat");
        }

        if(dataSource_penghubungTabel.hitungrecordOpsi()== 0) {
            dataSource_penghubungTabel.insertDataKeOpsi(1, "A.produced", 1);
            dataSource_penghubungTabel.insertDataKeOpsi(2, "B.produce", 1);
            dataSource_penghubungTabel.insertDataKeOpsi(3, "C.is produced", 1);
            dataSource_penghubungTabel.insertDataKeOpsi(4, "D.has produce", 1);
            dataSource_penghubungTabel.insertDataKeOpsi(5, "A.is leading", 2);
            dataSource_penghubungTabel.insertDataKeOpsi(6, "B.leads", 2);
            dataSource_penghubungTabel.insertDataKeOpsi(7, "C.leaded", 2);
            dataSource_penghubungTabel.insertDataKeOpsi(8, "D.lead", 2);
            dataSource_penghubungTabel.insertDataKeOpsi(9, "A.which individuals adhere", 3);
            dataSource_penghubungTabel.insertDataKeOpsi(10, "B.which adhere individuals", 3);
            dataSource_penghubungTabel.insertDataKeOpsi(11, "C.individuals which adhere", 3);
            dataSource_penghubungTabel.insertDataKeOpsi(12, "D.adhere individual which", 3);
            dataSource_penghubungTabel.insertDataKeOpsi(13, "A.contribution", 4);
            dataSource_penghubungTabel.insertDataKeOpsi(14, "B.contributed", 4);
            dataSource_penghubungTabel.insertDataKeOpsi(15, "C.contibute", 4);
            dataSource_penghubungTabel.insertDataKeOpsi(16, "D.contributing", 4);
            dataSource_penghubungTabel.insertDataKeOpsi(17, "A.and", 5);
            dataSource_penghubungTabel.insertDataKeOpsi(18, "B.so", 5);
            dataSource_penghubungTabel.insertDataKeOpsi(19, "C.but", 5);
            dataSource_penghubungTabel.insertDataKeOpsi(20, "D.or", 5);
            dataSource_penghubungTabel.insertDataKeOpsi(21, "A.new opened", 6);
            dataSource_penghubungTabel.insertDataKeOpsi(22, "B.newly opened", 6);
            dataSource_penghubungTabel.insertDataKeOpsi(23, "C.newly open", 6);
            dataSource_penghubungTabel.insertDataKeOpsi(24, "D.new openly", 6);

        }

//----------- START OF READING PART
        //masukkan data untuk soal tipe reading
        //insert narasi reading
        if (dataSource_penghubungTabel.hitungJumlahRecordTabel(SQLiteHelper.TABLE_NARASI_READING) == 0) {
            dataSource_penghubungTabel.insertDataKenarasiReading(1, "According to a new study, it is possible that doctor’s visit one day result in a prescription for chocolate. Researchers suggest that consuming a small amount of chocolate every day may lower the risk of diabetes and heart disease. Prof. Saverio Stranges - visiting academic of the University of Warwick Medical School, United Kingdom, and scientific director of the Department of Population Health at the Luxembourg Institute of Health (LIH) - and colleagues publish their findings in the British Journal of Nutrition. ");
            dataSource_penghubungTabel.insertDataKenarasiReading(2, "Chocolate is often perceived as a treat that should only be enjoyed from time to time. Given its high fat and sugar content, this is no surprise; overconsumption can lead to health problems, such as tooth decay and obesity. However, studies are increasingly suggesting regular, moderate chocolate consumption may yield significant health benefits, particularly when it comes to dark chocolate. Dark chocolate has the highest cocoa content, which means it has the highest levels of antioxidants - specifically, flavonoids - which are molecules that can prevent some forms of cell damage.");
            dataSource_penghubungTabel.insertDataKenarasiReading(3, "Dr.Prof. Stranges and colleagues say their findings suggest that chocolate consumption may reduce the risk of developing cardiometabolic disorders by improving liver enzyme levels and protecting against insulin resistance. \"Given the growing body of evidence, including our own study, cocoa-based products may represent an additional dietary recommendation to improve cardiometabolic health; however, observational results need to be supported by robust trial evidence. Potential applications of this knowledge include recommendations by healthcare professionals to encourage individuals to consume a wide range of phytochemical-rich foods, which can include dark chocolate in moderate amounts.\" However, Prof. Stranges notes that it is important to distinguish the difference between chocolate that contains natural cocoa and processed chocolate; the latter is much higher in calories.\n" +
                    "\n" +
                    "http://www.medicalnewstoday.com/articles/309741.php ");
        }

        //insert soal reading
        if (dataSource_penghubungTabel.hitungJumlahRecordTabel(SQLiteHelper.TABLE_READING) == 0) {
            dataSource_penghubungTabel.insertDataPertanyaanReading(1, "1.The highlighted word “important” in the last paragraph means....", "a", "Important berarti penting", 1);
            dataSource_penghubungTabel.insertDataPertanyaanReading(2, "2.From the passage, it can be inferred that …", "c", "Paragraph tersebut menceritakan tentang kadar antioxidan", 1);
            dataSource_penghubungTabel.insertDataPertanyaanReading(3, "3.From the passage, it can be inferred that …", "c", "Paragraph tersebut menceritakan tentang kadar antioxidan", 1);
            dataSource_penghubungTabel.insertDataPertanyaanReading(4, "4.Chocolate may reduce the diabetes and heart disease risk. ", "a", "penjelasan 4", 2);
            dataSource_penghubungTabel.insertDataPertanyaanReading(5, "5.Processed chocolate has fewer calories than the natural cocoa chocolate", "a", "penjelasan 5", 2);
            dataSource_penghubungTabel.insertDataPertanyaanReading(6, "6.Chocolate may reduce the diabetes and heart disease risk", "a", "penjelasan 6", 2);
            dataSource_penghubungTabel.insertDataPertanyaanReading(7, "7.People who consumed chocolate were found to have reduced _____  and improved liver enzyme levels. ", "a", "penjelasan 7", 3);
            dataSource_penghubungTabel.insertDataPertanyaanReading(8, "8.It is also found that people who ate chocolate were more ______, younger, and more highly educated than those who did not eat chocolate.", "a", "penjelasan 8", 3);
            dataSource_penghubungTabel.insertDataPertanyaanReading(9, "9.People who consumed chocolate were found to have reduced _____  and improved liver enzyme levels", "a", "penjelasan 9", 3);
        }

        //insert opsi reading
        if (dataSource_penghubungTabel.hitungrecordOpsiReading() == 0) {
            //opsi untuk soal reading 1
            dataSource_penghubungTabel.insertDataKeOpsiReading("a. significant", 1);
            dataSource_penghubungTabel.insertDataKeOpsiReading("b. resistant", 1);
            dataSource_penghubungTabel.insertDataKeOpsiReading("c. potential", 1);
            dataSource_penghubungTabel.insertDataKeOpsiReading("d. beneficial", 1);

            //opsi untuk soal reading 2
            dataSource_penghubungTabel.insertDataKeOpsiReading("a. Consuming chocolate every day may increase heart disease", 2);
            dataSource_penghubungTabel.insertDataKeOpsiReading("b. People who consume chocolate were more mentally active", 2);
            dataSource_penghubungTabel.insertDataKeOpsiReading("c. Dark chocolate has the highest antioxidants than other chocolate", 2);
            dataSource_penghubungTabel.insertDataKeOpsiReading("d. Chocolate is generally beneficial to reduce the liver enzymes levels", 2);

            //opsi untuk soal reading 3
            dataSource_penghubungTabel.insertDataKeOpsiReading("a. Consuming chocolate every day may increase heart disease", 3);
            dataSource_penghubungTabel.insertDataKeOpsiReading("b. People who consume chocolate were more mentally active", 3);
            dataSource_penghubungTabel.insertDataKeOpsiReading("c. Dark chocolate has the highest antioxidants than other chocolate", 3);
            dataSource_penghubungTabel.insertDataKeOpsiReading("d. Chocolate is generally beneficial to reduce the liver enzymes levels", 3);

            //opsi untuk soal reading 4
            dataSource_penghubungTabel.insertDataKeOpsiReading("a. True", 4);
            dataSource_penghubungTabel.insertDataKeOpsiReading("b. False", 4);
            dataSource_penghubungTabel.insertDataKeOpsiReading("c. T", 4);
            dataSource_penghubungTabel.insertDataKeOpsiReading("d. F", 4);

            //opsi untuk soal reading 5
            dataSource_penghubungTabel.insertDataKeOpsiReading("a. True", 5);
            dataSource_penghubungTabel.insertDataKeOpsiReading("b. False", 5);
            dataSource_penghubungTabel.insertDataKeOpsiReading("c. T", 5);
            dataSource_penghubungTabel.insertDataKeOpsiReading("d. F", 5);

            //opsi untuk soal reading 6
            dataSource_penghubungTabel.insertDataKeOpsiReading("a. True", 6);
            dataSource_penghubungTabel.insertDataKeOpsiReading("b. False", 6);
            dataSource_penghubungTabel.insertDataKeOpsiReading("c. T", 6);
            dataSource_penghubungTabel.insertDataKeOpsiReading("d. F", 6);

            //opsi untuk soal reading 7
            dataSource_penghubungTabel.insertDataKeOpsiReading("a. obesity", 7);
            dataSource_penghubungTabel.insertDataKeOpsiReading("b. physically stronger", 7);
            dataSource_penghubungTabel.insertDataKeOpsiReading("c. healthy", 7);
            dataSource_penghubungTabel.insertDataKeOpsiReading("d. insulin resistance", 7);

            //opsi untuk soal reading 8
            dataSource_penghubungTabel.insertDataKeOpsiReading("a. obesity", 8);
            dataSource_penghubungTabel.insertDataKeOpsiReading("b. physically stronger", 8);
            dataSource_penghubungTabel.insertDataKeOpsiReading("c. healthy", 8);
            dataSource_penghubungTabel.insertDataKeOpsiReading("d. insulin resistance", 8);

            //opsi untuk soal reading 9
            dataSource_penghubungTabel.insertDataKeOpsiReading("a. obesity", 9);
            dataSource_penghubungTabel.insertDataKeOpsiReading("b. physically stronger", 9);
            dataSource_penghubungTabel.insertDataKeOpsiReading("c. healthy", 9);
            dataSource_penghubungTabel.insertDataKeOpsiReading("d. insulin resistance", 9);
        }
        //----------- END OF READING PART



    }
    public void paketSoal(View view){
        Intent intent=new Intent(ActivityHome.this,ActivityQuiz.class);
        startActivity(intent);
    }
    public void About(View view) {
        Intent intent = new Intent(ActivityHome.this, ActivityAbout.class);
        startActivity(intent);
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

    public void testHapusDataGrammar(View view){
        int testDeleteGrammar = dataSource_penghubungTabel.hapusDataGrammar(6);
        System.out.println("testDeleteGrammar: "+testDeleteGrammar);

        int testDeleteOpsiGrammar = dataSource_penghubungTabel.hapusDataOpsiGrammar(6);
        System.out.println("testDeleteOpsiGrammar: "+testDeleteOpsiGrammar);
    }

    public void testAmbilDataGrammar(View view){
        ArrayList<Grammar> grammarArrayList = dataSource_penghubungTabel.ambilDataSoalGrammar();
        System.out.println("");
    }

    public void showAdminGrammar(View view){
        Intent intent = new Intent(ActivityHome.this, AdminGrammarActivity.class);
        startActivity(intent);
    }
}

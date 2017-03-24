package com.example.djakaumbarawurung.persipantestcept;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.djakaumbarawurung.persipantestcept.R;

import java.util.ArrayList;

public class ActivityCekJawabanListeningB extends AppCompatActivity {

    TextView CompleteAnswer, UserLogListeningPartB;
    ArrayList<String> menampungJawabanUser = new ArrayList<>();
    ArrayList<String> JawabanUser;
    ArrayList<String> JawabanBenar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cek_jawaban_listening_b);

      UserLogListeningPartB = ( TextView) findViewById(R.id.UserLogListeningPartB);
         CompleteAnswer = (TextView) findViewById(R.id.CompleteAnswer);

//        JumlahJawabanBenar = ( TextView) findViewById(R.id.JumlahJawabanBenar);
//        JumlahJawabanSalah = ( TextView) findViewById(R.id.JumlahJawabanSalah);



menampungJawabanUser = getIntent().getStringArrayListExtra("userLog");

        String jawabanUser1 = menampungJawabanUser.get(0);
        String jawabanUser2 = menampungJawabanUser.get(1);
        String jawabanUser3 = menampungJawabanUser.get(2);
        String jawabanUser4 = menampungJawabanUser.get(3);
        String jawabanUser5 = menampungJawabanUser.get(4);

        String jawabanBenar1 = "Cold";
        String jawabanBenar2 = "Happy";
        String jawabanBenar3 = "PAVEMENT";
        String jawabanBenar4 = "CANNOT";
        String jawabanBenar5 = "Complicated";

        JawabanUser = new ArrayList<>();
        JawabanBenar =  new ArrayList<>();


        JawabanUser.add(jawabanUser1);
        JawabanUser.add(jawabanUser2);
        JawabanUser.add(jawabanUser3);
        JawabanUser.add(jawabanUser4);
        JawabanUser.add(jawabanUser5);


        JawabanBenar.add(jawabanBenar1);
        JawabanBenar.add(jawabanBenar2);
        JawabanBenar.add(jawabanBenar3);
        JawabanBenar.add(jawabanBenar4);
        JawabanBenar.add(jawabanBenar5);



        int JumlahJawabanNBenar = cekJawabanBenarLB(JawabanUser,JawabanBenar);
        int JumlahJawabanSAlah = JawabanUser.size()-JumlahJawabanNBenar;
//        JumlahJawabanBenar.setText(String.valueOf(JumlahJawabanNBenar));
//        JumlahJawabanSalah.setText(String.valueOf(JumlahJawabanSAlah));


        String NarasiFull = "Lithuania is very (6) cold in the winter. " +
                "The snow falls from the beginning of November to the beginning of April. " +
                "The good thing about snow is that you have white atmosphere everywhere after the miserable autumn." +
                " When people walk in snow, they are (7)____________happy." +
                "\n" + "Belgium in winter is really miserable. It’s raining all the time. " +
                "People look depressed since they can just look at (8) ___________ the pavement all the time when they are walking outside." +
                " \n" + "The temperature almost reached minus 26 in Lithuania in wintertime." +
                " It was really freezing so that people  (9)___________ cannot get out of their house." +
                " When it’s so cold, it takes a lot of money to heat the house." +
                " Aiste’s father combined three heating parts with two different kinds of wood and also natural gas from central heating system." +
                " It was really a  (10)_____________ complicated and expensive heating system. \n";

        CompleteAnswer.setText(NarasiFull);
        UserLogListeningPartB.setText(jawabanUser1+"\n"+jawabanUser2+"\n"+jawabanUser3+"\n"+jawabanUser4+"\n"+jawabanUser5);
    }

public int cekJawabanBenarLB(ArrayList<String> JawabanUser, ArrayList<String> jawabanBenar){
    int JumlahJawabanBenar=0;
    for (int i=0; i<JawabanUser.size();i++){
        if(JawabanUser.get(i).equalsIgnoreCase(jawabanBenar.get(i))){
            JumlahJawabanBenar++;
        }
    }
    return JumlahJawabanBenar;
}

    public void hasilListening (View view){
        Intent intent = new Intent(ActivityCekJawabanListeningB.this, ActivityHasilReading.class);
        int jmlBenar = cekJawabanBenarLB(JawabanUser,JawabanBenar);
        intent.putExtra("benar", jmlBenar);
        intent.putExtra("salah", JawabanUser.size()-jmlBenar);
        startActivity(intent);
    }


}







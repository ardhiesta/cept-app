package com.example.djakaumbarawurung.persipantestcept.Model_Set_get;

import android.widget.ArrayAdapter;

import java.util.ArrayList;

/**
 * Created by Djaka Umbara Wurung on 10/19/2016.
 */
public class SoalReading {
    private int id;
    private String petanyaan;
    private String jawaban;
    private String penjelasan;
    private ArrayList<OpsiReading> opsiReadingArrayList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPetanyaan() {
        return petanyaan;
    }

    public void setPertanyaan(String petanyaan) {
        this.petanyaan = petanyaan;
    }

    public String getJawaban() {
        return jawaban;
    }

    public void setJawaban(String jawaban) {
        this.jawaban = jawaban;
    }

    public String getPenjelasan() {
        return penjelasan;
    }

    public void setPenjelasan(String penjelasan) {
        this.penjelasan = penjelasan;
    }

    public ArrayList<OpsiReading> getOpsiReadingArrayList() {
        return opsiReadingArrayList;
    }

    public void setOpsiReadingArrayList(ArrayList<OpsiReading> opsiReadingArrayList) {
        this.opsiReadingArrayList = opsiReadingArrayList;
    }
}

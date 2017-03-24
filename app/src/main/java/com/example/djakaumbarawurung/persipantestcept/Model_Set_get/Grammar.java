package com.example.djakaumbarawurung.persipantestcept.Model_Set_get;

import java.util.ArrayList;

/**
 * Created by Djaka Umbara Wurung on 8/6/2016.
 */
public class Grammar {
    private int id_soal;
    private String pertanyaan;
    private String jawaban;
    private String penjelasan;
    private ArrayList<Opsi> opsiArrayList;

    public int getId_soal() {
        return id_soal;
    }

    public void setId_soal(int id_soal) {
        this.id_soal = id_soal;
    }

    public String getPertanyaan() {
        return pertanyaan;
    }

    public void setPertanyaan(String pertanyaan) {
        this.pertanyaan = pertanyaan;
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

    public ArrayList<Opsi> getOpsiArrayList() {
        return opsiArrayList;
    }

    public void setOpsiArrayList(ArrayList<Opsi> opsiArrayList) {
        this.opsiArrayList = opsiArrayList;
    }
}
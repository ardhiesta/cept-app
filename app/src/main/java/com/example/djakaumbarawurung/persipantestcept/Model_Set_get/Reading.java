package com.example.djakaumbarawurung.persipantestcept.Model_Set_get;

/**
 * Created by Djaka Umbara Wurung on 12/10/2016.
 */
public class Reading {
    private int idReading;
    private String pertanyaan;
    private String jawabanReading;
    private int idNarasi;
    private String PenjelasanReading;

    public int getIdReading() {
        return idReading;
    }

    public void setIdReading(int idReading) {
        this.idReading = idReading;
    }

    public String getPertanyaan() {
        return pertanyaan;
    }

    public void setPertanyaan(String pertanyaan) {
        this.pertanyaan = pertanyaan;
    }

    public String getJawabanReading() {
        return jawabanReading;
    }

    public void setJawabanReading(String jawabanReading) {
        this.jawabanReading = jawabanReading;
    }

    public int getIdNarasi() {
        return idNarasi;
    }

    public void setIdNarasi(int idNarasi) {
        this.idNarasi = idNarasi;
    }

    public String getPenjelasanReading() {
        return PenjelasanReading;
    }

    public void setPenjelasanReading(String penjelasanReading) {
        PenjelasanReading = penjelasanReading;
    }
}

package com.example.djakaumbarawurung.persipantestcept.Model_Set_get;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.HashMap;

/**
 * Created by Djaka Umbara Wurung on 12/10/2016.
 */
public class ReadingLog implements Parcelable {
    String narasi;
    String pertanyaan;
    String kunci;
    String jawabanUser;
    String penjelasan;

    public String getPenjelasan() {
        return penjelasan;
    }

    public void setPenjelasan(String penjelasan) {
        this.penjelasan = penjelasan;
    }

    public String getNarasi() {
        return narasi;
    }

    public void setNarasi(String narasi) {
        this.narasi = narasi;
    }

    public String getPertanyaan() {
        return pertanyaan;
    }

    public void setPertanyaan(String pertanyaan) {
        this.pertanyaan = pertanyaan;
    }

    public String getKunci() {
        return kunci;
    }

    public void setKunci(String kunci) {
        this.kunci = kunci;
    }

    public String getJawabanUser() {
        return jawabanUser;
    }

    public void setJawabanUser(String jawabanUser) {
        this.jawabanUser = jawabanUser;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(narasi);
    dest.writeString(pertanyaan);
        dest.writeString(kunci);
        dest.writeString(penjelasan);
        dest.writeString(jawabanUser);

    }

    public ReadingLog(){}

    private ReadingLog(Parcel in){
        narasi = in.readString();
        pertanyaan = in.readString();
        kunci = in.readString();
        jawabanUser = in.readString();
        penjelasan= in.readString();
    }



    public static final Parcelable.Creator<ReadingLog> CREATOR =
            new Parcelable.Creator<ReadingLog>(){
        @Override
                public ReadingLog createFromParcel(Parcel source){
            return new ReadingLog(source);
        }
        @Override
                public  ReadingLog[] newArray(int size){
            return new ReadingLog[size];
        }


    };





}

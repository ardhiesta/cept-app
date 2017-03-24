package com.example.djakaumbarawurung.persipantestcept.Model_Set_get;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Djaka Umbara Wurung on 1/8/2017.
 */
public class UserLog implements Parcelable{
    String pertanyaan;
    String kunci;
    String jawabanUser;
    String penjelasan;

    public UserLog(Parcel in) {
        pertanyaan = in.readString();
        kunci = in.readString();
        jawabanUser = in.readString();
        penjelasan = in.readString();
    }

    public static final Creator<UserLog> CREATOR = new Creator<UserLog>() {
        @Override
        public UserLog createFromParcel(Parcel in) {
            return new UserLog(in);
        }

        @Override
        public UserLog[] newArray(int size) {
            return new UserLog[size];
        }
    };

    public UserLog() {

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

    public String getPenjelasan() {
        return penjelasan;
    }

    public void setPenjelasan(String penjelasan) {
        this.penjelasan = penjelasan;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(pertanyaan);
        parcel.writeString(kunci);
        parcel.writeString(jawabanUser);
        parcel.writeString(penjelasan);
    }
}

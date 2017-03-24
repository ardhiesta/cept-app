package com.example.djakaumbarawurung.persipantestcept.Model_Set_get;

import java.util.HashMap;

/**
 * Created by Djaka Umbara Wurung on 12/24/2016.
 */
public class Listening {
    String question;
    HashMap<String, String> opsi;

    String realAnswer;
    String userAnswer;

    public String getUserAnswer() {
        return userAnswer;
    }

    public void setUserAnswer(String userAnswer) {
        this.userAnswer = userAnswer;
    }

    public String getRealAnswer() {
        return realAnswer;
    }

    public void setRealAnswer(String realAnswer) {
        this.realAnswer = realAnswer;
    }

    public HashMap<String, String> getOpsi() {
        return opsi;
    }

    public void setOpsi(HashMap<String, String> opsi) {
        this.opsi = opsi;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
package com.example.android.test2;

class Response {

    private int number;
    private String responseCode;

    Response(int number, String responseCode) {
        this.number = number;
        this.responseCode = responseCode;
    }

    int getNumber() {
        return number;
    }

    String getResponseCode() {
        return responseCode;
    }
}

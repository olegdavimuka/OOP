package com.example.android.test2;

import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.IBinder;
import android.util.Log;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;

public class MyService extends Service {

    private final static String LOG_TAG = "myLogs";

    private static final String URL = "https://www.google.com.ua/";

    public void onCreate() {
        super.onCreate();
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                RequestAsyncTask task = new RequestAsyncTask();
                task.execute(URL);
            }
        }, 0L, 5000);
        return super.onStartCommand(intent, flags, startId);
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    private class RequestAsyncTask extends AsyncTask<String, Void, String> {

        protected String doInBackground(String... urls) {
            return request(URL);
        }

        protected void onPostExecute(String result) {
            if (result == null) {
                return;
            }
            Intent intent = new Intent(MainActivity.BROADCAST_ACTION);
            intent.putExtra(MainActivity.responseCode, result);
            sendBroadcast(intent);
        }
    }

    static String request(String requestUrl) {
        URL url = createUrl(requestUrl);
        return makeHttpRequest(url);
    }

    private static URL createUrl(String stringUrl) {
        URL url = null;
        try {
            url = new URL(stringUrl);
        } catch (MalformedURLException e) {
            Log.e(LOG_TAG, "Error with creating URL ", e);
        }
        return url;
    }

    private static String makeHttpRequest(URL url) {
        String responseCode = "";
        if (url == null) {
            return responseCode;
        }
        HttpURLConnection urlConnection = null;
        try {
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setReadTimeout(10000);
            urlConnection.setConnectTimeout(15000);
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();
            if (urlConnection.getResponseCode() == 200) {
                responseCode = "200";
            } else {
                responseCode = "Something went wrong. Response code: " + urlConnection.getResponseMessage() + urlConnection.getResponseCode();
            }
        } catch (IOException e) {
            Log.e(LOG_TAG, "Error with making a request", e);
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }
        return responseCode;
    }
}
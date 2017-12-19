package com.example.android.test2;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends Activity {

    final static String responseCode = "Response Code";

    static int okCount = 0, count = 0;

    BroadcastReceiver requestReceiver;

    ResponseHelper responseHelper;

    ArrayList<Response> responses;

    ResponseAdapter responseAdapter;

    SQLiteDatabase db;

    ListView responsesListView;

    public final static String BROADCAST_ACTION = "package com.example.android.test2";

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        responseHelper = new ResponseHelper(this);
        responses = new ArrayList<>();
        responseAdapter = new ResponseAdapter(this, responses);
        responsesListView = findViewById(R.id.list);

        responsesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                startActivity(new Intent(view.getContext(), ChartActivity.class));
            }
        });

        requestReceiver = new BroadcastReceiver() {

            @Override
            public void onReceive(Context context, Intent intent) {
                String code = intent.getStringExtra(responseCode);

                count++;
                if (code.equals("200")) okCount++;

                ContentValues cv = new ContentValues();

                db = responseHelper.getWritableDatabase();

                cv.put("responseCode", code);

                db.insert("responsetable", null, cv);

                Cursor c = db.query("responsetable", null, null, null, null, null, null);

                if (c.moveToFirst()) {
                    c.moveToLast();

                    int idColIndex = c.getColumnIndex("id");
                    int responseCodeColIndex = c.getColumnIndex("responseCode");

                    responses.add(new Response(c.getInt(idColIndex), c.getString(responseCodeColIndex)));

                    responsesListView.setAdapter(responseAdapter);
                }
                c.close();
                responseHelper.close();
            }
        };

        IntentFilter intentFilter = new IntentFilter(BROADCAST_ACTION);
        registerReceiver(requestReceiver, intentFilter);

        db = responseHelper.getWritableDatabase();
        db.delete("responsetable", null, null);

        responseHelper.close();
        startService(new Intent(this, MyService.class));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(requestReceiver);
    }

    class ResponseHelper extends SQLiteOpenHelper {

        ResponseHelper(Context context) {
            super(context, "ResponseDB", null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("create table responsetable ("
                    + "id integer primary key,"
                    + "responseCode text" + ");");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }
}

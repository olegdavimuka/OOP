package com.example.android.test2;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;

public class ChartActivity extends AppCompatActivity {

    PieChart pieChart;

    ArrayList<PieEntry> yEntrys;

    PieDataSet pieDataSet;

    ArrayList<Integer> colors;

    PieData pieData;

    private float okPercentage = (float) MainActivity.okCount / MainActivity.count;

    private float[] yData = {okPercentage, 1 - okPercentage};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);

        pieChart = findViewById(R.id.chart);
        pieChart.setUsePercentValues(true);

        yEntrys = new ArrayList<>();
        colors = new ArrayList<>();

        for (int i = 0; i < yData.length; i++) {
            if (yData[i] != 0f) yEntrys.add(new PieEntry(yData[i], i));
        }

        colors.add(Color.GREEN);
        colors.add(Color.RED);

        pieDataSet = new PieDataSet(yEntrys, "Site accessibility");

        pieDataSet.setColors(colors);

        pieData = new PieData(pieDataSet);

        pieChart.setData(pieData);

        pieChart.invalidate();
    }
}

package com.pjatk.bmi.ui.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.pjatk.bmi.R;

import java.util.ArrayList;

public class ChartFragment extends Fragment {

    LineChart lineChart;
    LineData lineData;
    LineDataSet lineDataSet;
    ArrayList lineEntries;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chart, container, false);

        lineChart = view.findViewById(R.id.lineChart);
        lineChart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
        lineChart.getAxisLeft().setDrawGridLines(false);
        lineChart.getAxisRight().setDrawGridLines(false);
        lineChart.getDescription().setText("BMI / Months");

        getEntries();

        lineDataSet = new LineDataSet(lineEntries, "changes in BMI over the year");
        lineDataSet.setColor(Color.RED);
        lineDataSet.setLineWidth(1f);
        lineDataSet.setValueTextColor(Color.BLACK);

        lineData = new LineData(lineDataSet);
        lineChart.setData(lineData);
        lineChart.invalidate();
        lineDataSet.setValueTextColor(Color.BLACK);
        lineDataSet.setValueTextSize(18f);



        return view;
    }

    private void getEntries() {
        lineEntries = new ArrayList();
        lineEntries.add(new Entry(1, 18.5f));
        lineEntries.add(new Entry(2, 18.4f));
        lineEntries.add(new Entry(3, 18.0f));
        lineEntries.add(new Entry(4, 18.5f));
        lineEntries.add(new Entry(5, 19.5f));
        lineEntries.add(new Entry(6, 20.5f));
        lineEntries.add(new Entry(7, 19.5f));
        lineEntries.add(new Entry(8, 18.5f));
        lineEntries.add(new Entry(9, 18.0f));
        lineEntries.add(new Entry(10, 18.0f));
        lineEntries.add(new Entry(11, 18.0f));
        lineEntries.add(new Entry(12, 18.5f));
    }



}

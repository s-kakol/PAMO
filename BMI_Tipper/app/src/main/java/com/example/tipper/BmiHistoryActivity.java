package com.example.tipper;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GridLabelRenderer;
import com.jjoe64.graphview.LegendRenderer;
import com.jjoe64.graphview.helper.StaticLabelsFormatter;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class BmiHistoryActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_history);
        GraphView graph = findViewById(R.id.graph);
        StaticLabelsFormatter staticLabelsFormatter = new StaticLabelsFormatter(graph);
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[]{
                new DataPoint(0, 40),
                new DataPoint(1, 30),
                new DataPoint(2, 50),
                new DataPoint(3, 35),
                new DataPoint(4, 45),
        });

        graph.addSeries(series);
        staticLabelsFormatter.setHorizontalLabels(new String[]{
                "January",
                "February",
                "Marchuary",
                "Aprilary",
                "Mayary",
        });
        graph.getGridLabelRenderer().setLabelFormatter(staticLabelsFormatter);

        series.setColor(Color.rgb(255, 160, 122));
        series.setDrawDataPoints(true);
        series.setDataPointsRadius(4);
        series.setThickness(4);

        graph.addSeries(series);
        graph.setTitle("BMI changes over the course of last months");
        graph.setTitleTextSize(48);
        graph.setTitleColor(Color.rgb(102, 51, 153));
        graph.getLegendRenderer().setVisible(true);
        graph.getLegendRenderer().setAlign(LegendRenderer.LegendAlign.TOP);

        GridLabelRenderer gridLabel = graph.getGridLabelRenderer();
        gridLabel.setHorizontalAxisTitle("Months");
        gridLabel.setVerticalAxisTitle("BMI");
    }
}

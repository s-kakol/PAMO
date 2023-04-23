package com.example.tipper

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jjoe64.graphview.GraphView
import com.jjoe64.graphview.LegendRenderer
import com.jjoe64.graphview.helper.StaticLabelsFormatter
import com.jjoe64.graphview.series.DataPoint
import com.jjoe64.graphview.series.LineGraphSeries

class BmiHistoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_bmi_history)

        val graph = findViewById<GraphView>(R.id.graph)
        val staticLabelsFormatter = StaticLabelsFormatter(graph)
        val series = LineGraphSeries(arrayOf(
                DataPoint(0.0, 40.0),
                DataPoint(1.0, 30.0),
                DataPoint(2.0, 50.0),
                DataPoint(3.0, 35.0),
                DataPoint(4.0, 45.0)))
        graph.addSeries(series)

        staticLabelsFormatter.setHorizontalLabels(arrayOf(
                "January",
                "February",
                "Marchuary",
                "Aprilary",
                "Mayary"))
        graph.gridLabelRenderer.labelFormatter = staticLabelsFormatter

        series.color = Color.rgb(255, 160, 122)
        series.isDrawDataPoints = true
        series.dataPointsRadius = 4f
        series.thickness = 4

        graph.addSeries(series)
        graph.title = "BMI changes over the course of last months"
        graph.titleTextSize = 48f
        graph.titleColor = Color.rgb(102, 51, 153)
        graph.legendRenderer.isVisible = true
        graph.legendRenderer.align = LegendRenderer.LegendAlign.TOP

        val gridLabel = graph.gridLabelRenderer
        gridLabel.horizontalAxisTitle = "Months"
        gridLabel.verticalAxisTitle = "BMI"
    }
}
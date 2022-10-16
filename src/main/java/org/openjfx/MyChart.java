package org.openjfx;

import javafx.fxml.FXMLLoader;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class MyChart extends VBox {
//    @FXML
//    private LineChart lineChart;

    public MyChart() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("chart.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        getChildren().add(buildSampleLineChart());

    }

    public LineChart buildSampleLineChart() {
        XYChart.Series<Double, Double> series = new XYChart.Series<>();
        series.getData().add(new XYChart.Data<>(0.0, 0.0));
        series.getData().add(new XYChart.Data<>(0.7, 0.5));
        series.getData().add(new XYChart.Data<>(1.0, 0.632));
        series.getData().add(new XYChart.Data<>(2.0, 0.865));
        series.getData().add(new XYChart.Data<>(3.0, 0.95));
        series.getData().add(new XYChart.Data<>(4.0, 0.982));
        series.getData().add(new XYChart.Data<>(5.0, 0.993));


        LineChart lc = new LineChart(
                new NumberAxis("Time Constant", 0.0, 5.0, 1),
                new NumberAxis("Voltage (Vs)", 0.0, 1.0, 0.1)
        );

        lc.getData().add(series);
        return lc;
    }
}

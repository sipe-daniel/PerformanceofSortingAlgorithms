/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;


/**
 *
 * @author jordan
 */

public class LineChartController  extends CoreController{
    @FXML LineChart<String,Number> lineChart;
    @FXML Label label;
    final int DEFAULT_VALUEOFTHE_CHECKBOX = -50;  

    public void btnUpload(ActionEvent evt){
        List arrEachValueTest =(new controller.GroupRadioButtonController().getNumberValuetab());
        lineChart.getData().clear();
        
        XYChart.Series<String,Number> seriesTriSelection = new XYChart.Series<>();
        XYChart.Series<String,Number> seriesTriInsertion = new XYChart.Series<>();
        XYChart.Series<String,Number> seriesTriBulle = new XYChart.Series<>();
        XYChart.Series<String,Number> seriesTriFusion = new XYChart.Series<>();
        XYChart.Series<String,Number> seriesTriRapide = new XYChart.Series<>();
        
        for(int i=0; i< arrEachValueTest.size();i++){        
            if(CoreController.timeTableForEachAlgo[0][i]!=DEFAULT_VALUEOFTHE_CHECKBOX)
                seriesTriSelection.getData().add(new XYChart.Data<>(String.format("%s", arrEachValueTest.get(i)),CoreController.timeTableForEachAlgo[0][i]));
            if(CoreController.timeTableForEachAlgo[1][i]!=DEFAULT_VALUEOFTHE_CHECKBOX)
                seriesTriInsertion.getData().add(new XYChart.Data<>(String.format("%s", arrEachValueTest.get(i)),CoreController.timeTableForEachAlgo[1][i]));
            if(CoreController.timeTableForEachAlgo[2][i]!=DEFAULT_VALUEOFTHE_CHECKBOX)
                seriesTriBulle.getData().add(new XYChart.Data<>(String.format("%s", arrEachValueTest.get(i)),CoreController.timeTableForEachAlgo[2][i]));
            if(CoreController.timeTableForEachAlgo[3][i]!=DEFAULT_VALUEOFTHE_CHECKBOX)
                seriesTriFusion.getData().add(new XYChart.Data<>(String.format("%s", arrEachValueTest.get(i)),CoreController.timeTableForEachAlgo[3][i]));
            if(CoreController.timeTableForEachAlgo[4][i]!=DEFAULT_VALUEOFTHE_CHECKBOX)
                seriesTriRapide.getData().add(new XYChart.Data<>(String.format("%s", arrEachValueTest.get(i)),CoreController.timeTableForEachAlgo[4][i]));
        }
        
        if(CoreController.timeTableForEachAlgo[0][0]!=DEFAULT_VALUEOFTHE_CHECKBOX)
            seriesTriSelection.setName(String.format("%s\n O(n)", "Tri Selection"));
        if(CoreController.timeTableForEachAlgo[1][0]!=DEFAULT_VALUEOFTHE_CHECKBOX)
            seriesTriInsertion.setName(String.format("%s\n O(n)", "Tri Insertion"));
        if(CoreController.timeTableForEachAlgo[2][0]!=DEFAULT_VALUEOFTHE_CHECKBOX)
            seriesTriBulle.setName(String.format("%s\n O(n)", "Tri Bulle"));
        if(CoreController.timeTableForEachAlgo[3][0]!=DEFAULT_VALUEOFTHE_CHECKBOX)
            seriesTriFusion.setName(String.format("%s\n O(nlog(n))", "Tri Fusion"));
        if(CoreController.timeTableForEachAlgo[4][0]!=DEFAULT_VALUEOFTHE_CHECKBOX)
            seriesTriRapide.setName(String.format("%s\n O(nlog(n))", "Tri Rapide"));
        
        lineChart.getData().addAll(seriesTriSelection,seriesTriInsertion,seriesTriBulle,seriesTriFusion,seriesTriRapide);
        
        seriesTriSelection.getData().stream().forEach((XYChart.Data<String, Number> data) -> {
            data.getNode().addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent event) -> {
                label.setText("Sorting Value :"+data.getXValue()+"\nSorting Time : "+String.valueOf(data.getYValue())+" milliseconds");
            });
        });
        seriesTriInsertion.getData().stream().forEach((data) -> {
            data.getNode().addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent event) -> {
                label.setText("Sorting Value :"+data.getXValue()+"\nSorting Time : "+String.valueOf(data.getYValue())+" milliseconds");
            });
        });
        seriesTriBulle.getData().stream().forEach((data) -> {
            data.getNode().addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent event) -> {
                label.setText("Sorting Value :"+data.getXValue()+"\nSorting Time : "+String.valueOf(data.getYValue())+" milliseconds");
            });
        });
        seriesTriFusion.getData().stream().forEach((XYChart.Data<String, Number> data) -> {
            data.getNode().addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent event) -> {
                label.setText("Sorting Value :"+data.getXValue()+"\nSorting Time : "+String.valueOf(data.getYValue())+" milliseconds");
            });
        });
        seriesTriRapide.getData().stream().forEach((XYChart.Data<String, Number> data) -> {
            data.getNode().addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent event) -> {
                label.setText("Sorting Value :"+data.getXValue()+"\nSorting Time : "+String.valueOf(data.getYValue())+" milliseconds");
            });
        });
        
    }
    
}

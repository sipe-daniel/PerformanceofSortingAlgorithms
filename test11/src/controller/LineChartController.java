/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
    //array de tout les types qui va contenir les types choisie
    // et avec sa je vais pouvoir ameloirer la boucle
//    private final ArrayList<XYChart.Data<String,Number>> SeriesTriBoard;
    
    
//    public LineChartController(ArrayList arrayListTypeTri) {
//        this.SeriesTriBoard = new ArrayList<>();
//    }
//  
    public void btnUpload(ActionEvent evt){
        List boardEachValueTest =(new controller.GroupRadioButtonController().getNumberValuetab());
        lineChart.getData().clear();
        
        XYChart.Series<String,Number> seriesTriSelection = new XYChart.Series<>();
        XYChart.Series<String,Number> seriesTriInsertion = new XYChart.Series<>();
        XYChart.Series<String,Number> seriesTriBulle = new XYChart.Series<>();
        XYChart.Series<String,Number> seriesTriFusion = new XYChart.Series<>();
        XYChart.Series<String,Number> seriesTriRapide = new XYChart.Series<>();
        
        for(int i=0; i< boardEachValueTest.size();i++){        
            if(CoreController.tabTimeForEachAlgo[0][i]!=-50)
                seriesTriSelection.getData().add(new XYChart.Data<>(String.format("%s", boardEachValueTest.get(i)),CoreController.tabTimeForEachAlgo[0][i]));
            if(CoreController.tabTimeForEachAlgo[1][i]!=-50)
                seriesTriInsertion.getData().add(new XYChart.Data<>(String.format("%s", boardEachValueTest.get(i)),CoreController.tabTimeForEachAlgo[1][i]));
            if(CoreController.tabTimeForEachAlgo[2][i]!=-50)
                seriesTriBulle.getData().add(new XYChart.Data<>(String.format("%s", boardEachValueTest.get(i)),CoreController.tabTimeForEachAlgo[2][i]));
            if(CoreController.tabTimeForEachAlgo[3][i]!=-50)
                seriesTriFusion.getData().add(new XYChart.Data<>(String.format("%s", boardEachValueTest.get(i)),CoreController.tabTimeForEachAlgo[3][i]));
            if(CoreController.tabTimeForEachAlgo[4][i]!=-50)
                seriesTriRapide.getData().add(new XYChart.Data<>(String.format("%s", boardEachValueTest.get(i)),CoreController.tabTimeForEachAlgo[4][i]));
        }
        
       // ici on estime que si un des case est egale a -50 cela veut dire que le tri n'a pas ete selectionner
        if(CoreController.tabTimeForEachAlgo[0][0]!=-50)
            seriesTriSelection.setName(String.format("%s\n O(n)", "Tri Selection"));
        if(CoreController.tabTimeForEachAlgo[1][0]!=-50)
            seriesTriInsertion.setName(String.format("%s\n O(n)", "Tri Insertion"));
        if(CoreController.tabTimeForEachAlgo[2][0]!=-50)
            seriesTriBulle.setName(String.format("%s\n O(n)", "Tri Bulle"));
        if(CoreController.tabTimeForEachAlgo[3][0]!=-50)
            seriesTriFusion.setName(String.format("%s\n O(nlog(n))", "Tri Fusion"));
        if(CoreController.tabTimeForEachAlgo[4][0]!=-50)
            seriesTriRapide.setName(String.format("%s\n O(nlog(n))", "Tri Rapide"));
       

        
        lineChart.getData().addAll(seriesTriSelection,seriesTriInsertion,seriesTriBulle,seriesTriFusion,seriesTriRapide);
        
        seriesTriSelection.getData().stream().forEach((XYChart.Data<String, Number> data) -> {
            data.getNode().addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent event) -> {
                label.setText("sorting Value :"+data.getXValue()+"\n sorting Time : "+String.valueOf(data.getYValue())+" milliseconds");
            });
        });
        seriesTriInsertion.getData().stream().forEach((data) -> {
            data.getNode().addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent event) -> {
                label.setText("sorting Value :"+data.getXValue()+"\n sorting Time : "+String.valueOf(data.getYValue())+" milliseconds");
            });
        });
        seriesTriBulle.getData().stream().forEach((data) -> {
            data.getNode().addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent event) -> {
                label.setText("sorting Value :"+data.getXValue()+"\n sorting Time : "+String.valueOf(data.getYValue())+" milliseconds");
            });
        });
        seriesTriFusion.getData().stream().forEach((XYChart.Data<String, Number> data) -> {
            data.getNode().addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent event) -> {
                label.setText("sorting Value :"+data.getXValue()+"\n sorting Time : "+String.valueOf(data.getYValue())+" milliseconds");
            });
        });
        seriesTriRapide.getData().stream().forEach((XYChart.Data<String, Number> data) -> {
            data.getNode().addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent event) -> {
                label.setText("sorting Value :"+data.getXValue()+"\n sorting Time : "+String.valueOf(data.getYValue())+" milliseconds");
            });
        });
        
    }
    
}

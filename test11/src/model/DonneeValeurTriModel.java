/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author jordan
 */
public class DonneeValeurTriModel extends VBox {


    private final int nombre;
    private int NB_RADIO = 5;

    private List<Integer> result = new ArrayList<>();
    private List<ToggleGroup> toggles = new ArrayList<ToggleGroup>();

    public DonneeValeurTriModel(Integer nbre) {
        nombre = nbre;
        System.out.println("Selected value : " + nombre);
        initComponents();
    }

    private void initComponents() {
        int[] values = {10, 100, 500, 1000, 10000};
        VBox vbox = new VBox();
        VBox.setMargin(vbox, new Insets(50));
        int i;
        for (i = 0; i < nombre; i++) {
            HBox hbox = new HBox(new Label("Test "+(i+1)+" :"));
            hbox.setSpacing(20);
            HBox.setMargin(hbox, new Insets(50));
            ToggleGroup toggle = new ToggleGroup();
            for (int j = 0; j < NB_RADIO; j++) {
                RadioButton radio = new RadioButton(values[j] + "");
                radio.setUserData(values[i]);
                radio.setToggleGroup(toggle);
                hbox.getChildren().add(radio);
            }
            toggles.add(toggle);
            vbox.getChildren().add(hbox);
            vbox.setSpacing(30);
        }
        getChildren().addAll(vbox);
    }

    public List<Integer> getResult() {
        for (ToggleGroup tg : toggles) {
            RadioButton rd = (RadioButton) tg.getSelectedToggle();
            result.add(Integer.parseInt(rd.getText()));
        }
        return result;
    }
    
 
    

}

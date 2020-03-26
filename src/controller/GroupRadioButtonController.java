/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.function.Consumer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.util.Callback;
import model.DonneeValeurTriModel;


/**
 * FXML Controller class
 *
 * @author jordan
 */

public class GroupRadioButtonController implements Initializable{
    
    @FXML
    private ComboBox<Integer> comboNombre; 
    @FXML
    private Button button;
    private static List<Integer> numberValueTab;
    private static int numberOfTest;
    Boolean essai ;
    
    @FXML
    private void clickButton(ActionEvent event) {
        essai = true;
        Dialog<List<Integer>> dialog = new Dialog<>();
        ButtonType ok = new ButtonType("Valider", ButtonBar.ButtonData.OK_DONE);
        ButtonType cancel = new ButtonType("Annuler", ButtonBar.ButtonData.CANCEL_CLOSE);
        dialog.getDialogPane().getButtonTypes().addAll(ok, cancel);
        dialog.setTitle("Nombre de valeurs");
        dialog.setHeaderText("Choix du nombre de valeurs");
        System.out.println(comboNombre.getSelectionModel().getSelectedItem());
         try{
        this.setNumberOfTest(comboNombre.getSelectionModel().getSelectedItem());
        DonneeValeurTriModel meschexbox;
       
            meschexbox = new DonneeValeurTriModel(comboNombre.getSelectionModel().getSelectedItem());
            dialog.getDialogPane().setContent(meschexbox);
                dialog.setResultConverter(new Callback<ButtonType, List<Integer>>() {
            @Override
            public List<Integer> call(ButtonType param) {
                if (param.getButtonData() == ButtonBar.ButtonData.OK_DONE) {
                    return meschexbox.getResult();
                } else {
                    return null;
                }
            }
        });
         Optional<List<Integer>> result = dialog.showAndWait();
          result.ifPresent(new Consumer<List<Integer>>() {
            @Override
            public void accept(List<Integer> t) {
                System.out.println("Resultat : "  + t);
                numberValueTab = new ArrayList<>(t);
            }
        });
          essai = true;
        }catch(NullPointerException e){     
            if(!essai ||comboNombre.getSelectionModel().getSelectedItem()==null){
              
              ButtonType okay = new ButtonType("j'ai compris", ButtonBar.ButtonData.OK_DONE);
              dialog.getDialogPane().getButtonTypes().setAll(okay);
              dialog.setTitle("Ton titre");
              dialog.setHeaderText("Un header");

              dialog.getDialogPane().setContent(new Label("vous n'avez pas entrez le nombre de test a effectuer"));
              Optional<List<Integer>> result = dialog.showAndWait();
            }         
        }

    }
    
    
    /**
     * initialize le comboNombre 
     * @param url
     * @param rb 
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<Integer> data = FXCollections.observableArrayList();
        for (int i = 1; i < 6; i++) {
            data.add(i);
        }
        comboNombre.setItems(data);
    }
    
    
   /**
    * getNumberValuetab() retourne le nombre de valeur du test
    * @return numberValueTab
    */

    public List<Integer> getNumberValuetab(){
          return numberValueTab;
    }
    
    
    /**
     * setNumberOfTest() permet de modifier le nombre de test
     * @param a 
     */
    
    private void setNumberOfTest(int a){
        this.numberOfTest = a;
    }
    
    
    /**
     * getNumberOfTest() revoi le nombre de test
     * @return numberOfTest
     */
    
    public int getNumberOfTest(){
        return numberOfTest;
    }
}












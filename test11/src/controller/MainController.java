/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.GroupRadioButtonController;
import controller.CheckboxController;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import model.DonneeTimeTriModel;

/**
 *
 * @author jordan
 */
public class MainController {
//    private static final int nbTri = 5;
    public static boolean signal = false;
    List<String> tabTypeTri = new ArrayList<>();
    CheckboxController checkbox = new CheckboxController();
    /**
     * run : lance l'application
     * @param event
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     * @throws InvocationTargetException
     * @throws NoSuchMethodException
     * @throws IOException 
     */
     private boolean start = true;
  @FXML
  public void pressButtonChangeWindow(ActionEvent evt){
      if(start){
            start = false; 
        }
      Parent root1 = null;
      FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/tableViewResultTri.fxml"));
      
      try {
          root1 = (Parent) fxmlLoader.load();
      } catch (IOException ex) {
          Logger.getLogger(TableViewResultTriController.class.getName()).log(Level.SEVERE, null, ex);
      }
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));  
        stage.show();
   }
  

  @FXML
  public void lineChart(ActionEvent evt){
    
      Parent root = null;
      FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/lineChart.fxml"));
      
      try {
          root = (Parent) fxmlLoader.load();
      } catch (IOException ex) {
      }
      
        Stage stage = new Stage();
        stage.setTitle("Line Chart Tri");
        stage.setScene(new Scene(root));  
        stage.show();
   }
  
   @FXML
    public void run(ActionEvent event) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, IOException {
        CoreController c = new CoreController();
        
        checkbox.getCheckBoxUserChoice(tabTypeTri);
        GroupRadioButtonController donneeController = new GroupRadioButtonController();
        c.core(tabTypeTri, donneeController.getNumberValuetab());  
        tabTypeTri.clear();// pour que lorsque l'on reset les val le tabTypeTri soit vide
       
    }
    @FXML
    public void restAll(){
        DonneeTimeTriModel reset = new DonneeTimeTriModel();
        (new CheckboxController()).setReturnEtatCheckbox(true);
//        super.triBulle.setSelected(false);
//        super.triInsertion.setSelected(false);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;



/**
 *
 * @author jordan
 */
public class ResultTriController  {
  private boolean start = true;
  
  @FXML
  public void pressButtonChangeWindow(ActionEvent evt){
      if(start){
            start = false; 
        }
      
      FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("tableViewResultTri.fxml"));
      Parent root1 = null;
      try {
          root1 = (Parent) fxmlLoader.load();
      } catch (IOException ex) {
          Logger.getLogger(ResultTriController.class.getName()).log(Level.SEVERE, null, ex);
      }
    Stage stage = new Stage();
    stage.setScene(new Scene(root1));  
    stage.show();
   }
  


}

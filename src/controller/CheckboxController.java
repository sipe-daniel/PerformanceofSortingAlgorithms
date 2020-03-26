/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Checkbox;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javax.swing.JOptionPane;


/**
 * FXML Controller class
 *
 * @author jordan
 */
public class CheckboxController  {
 
    @FXML
      public CheckBox triSelection;
    @FXML
      public CheckBox coreTriFusion;
    @FXML
      public CheckBox coreTriRapide;
    @FXML
      public CheckBox triInsertion;
    @FXML
      public CheckBox triBulle;
    
    Label messageError = new Label("error"); 
    Stage stage =new Stage();
    private static ArrayList<String> listTri = new ArrayList<>();
   
    /**
     * recupere les types de tri coché par l'utilisateur
     * @param tab 
     */
    public void getCheckBoxUserChoice(List<String> tab){
        for(int i = 0; i<listTri.size(); i++){
            tab.add(i,listTri.get(i));
        }
        listTri.clear();// pour vider la listTri
    }
   
   private static Boolean etatOk = true;
   /**
    * bouton de validation des cases cochés ajoute a la listTri les type tri selectionné
    * @return listTri
    * @throws IOException 
    */
    @FXML
    void button() throws IOException{
      try{
        if(etatOk){
            if(triSelection.isSelected())
                listTri.add(triSelection.getId());
            if(triInsertion.isSelected())
                listTri.add(triInsertion.getId());
            if(triBulle.isSelected())
                listTri.add(triBulle.getId());
            if(coreTriFusion.isSelected())
                listTri.add(coreTriFusion.getId());
            if(coreTriRapide.isSelected())
                listTri.add(coreTriRapide.getId());
            
            //affiche le tri selectionner a la position 0
            System.out.println(listTri.get(0));
            System.out.println(listTri.size());
            etatOk = false; 
         }else{
             System.out.println("vous avez deja entré les valeurs");
             messageError.setText("vous avez deja entré les valeurs");
             this.error1(messageError);           
        }   
      }catch(Exception e){
              System.out.println("cochez les cases avant de valider");
              messageError.setText("cochez les cases avant de valider");
              this.error1(messageError);
      }
    }
    
   /**
    * clickButtonError1 lorsque l'utilisateur valide la page fenetre disaprait
    * @param evt 
    */
   @FXML
   public void clickButtonErro1(Event evt){
       this.stage.close();
   }
   /**
    * conception de l'onglet d'erreur
    * @param message
    * @throws IOException 
    */
    @FXML
    public void error1(Label message) throws IOException {
      Dialog<List<Integer>> dialog = new Dialog<>();
      ButtonType ok = new ButtonType("j'ai compris", ButtonBar.ButtonData.OK_DONE);
      dialog.getDialogPane().getButtonTypes().addAll(ok);
      dialog.setTitle("Erreur 404");
      dialog.setHeaderText("Erreur detecté");

      dialog.getDialogPane().setContent(message);
      Optional<List<Integer>> result = dialog.showAndWait();
   }
   
   public boolean getReturnEtatCheckbox() {
       return etatOk;
   }
   
   public void setReturnEtatCheckbox(boolean nouvelleEtat) {
        etatOk = nouvelleEtat;
   }
   
   public void removeEtatCheckbox(List<String> tab) {
      for(int i = 0; i<listTri.size(); i++){
            tab.set(i," ");
        }
   }
  
}

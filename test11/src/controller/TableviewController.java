/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.DonneeTimeTriModel;



/**
 * FXML Controller class
 *
 * @author jordan
 */
public class TableviewController extends CoreController implements Initializable {
    @FXML private TableView<DonneeTimeTriModel> tableView;
    @FXML private TableColumn<DonneeTimeTriModel,String> tableColumnIndexTest;
    @FXML private TableColumn<DonneeTimeTriModel,String> tableColumnTriSelection;
    @FXML private TableColumn<DonneeTimeTriModel,String> tableColumnTriInsertion;
    @FXML private TableColumn<DonneeTimeTriModel,String> tableColumnTriBulle;
    @FXML private TableColumn<DonneeTimeTriModel,String> tableColumnTriFusion;
    @FXML private TableColumn<DonneeTimeTriModel,String> tableColumnTriRapide;
   
    private static List<DonneeTimeTriModel> listTri= new ArrayList<>();
    private ObservableList<DonneeTimeTriModel> observableListDonneeTimeTri;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {    
        createTableViewTri();

    }
     /**
     * createTableView: permet d'affecter chaque valeur correspondante a sa column
     * dans le tableview
     */
    //il faudrai que le nom dans propertyValueFactory soit identique a celui des variable DonneeTimeTriModel
    public void createTableViewTri(){
        tableColumnIndexTest.setCellValueFactory(new PropertyValueFactory<>("index"));
        tableColumnTriSelection.setCellValueFactory(new PropertyValueFactory<>("triSelection"));
        tableColumnTriInsertion.setCellValueFactory(new PropertyValueFactory<>("triInsertion"));
        tableColumnTriBulle.setCellValueFactory(new PropertyValueFactory<>("triBulle"));
        tableColumnTriFusion.setCellValueFactory(new PropertyValueFactory<>("triFusion"));
        tableColumnTriRapide.setCellValueFactory(new PropertyValueFactory<>("triRapide"));

        //la liste observé
        observableListDonneeTimeTri = FXCollections.observableArrayList(listTri);//ici la liste observé est vide
        tableView.setItems(observableListDonneeTimeTri);//ici on passe la liste observé vide en parmettre
        
    }
    

      /**
     * addItemTableView : pour ajouter les valeurs  ou donnée dans le tableview  
     * @throws SQLException 
     */
    @FXML
    public void addItemTableViewTri(){
        //passage des valeurs la liste observé pour que sa s'affiche dans le tableview
        for(int j=0,nbTest=(new GroupRadioButtonController()).getNumberOfTest();j<nbTest;j++){// O: triSelection 1: triInsertion 2:triBulle 4:triFusion 5:triRapide
            DonneeTimeTriModel c1 = new DonneeTimeTriModel(j+1,super.tabTimeForEachAlgo[0][j],super.tabTimeForEachAlgo[1][j],super.tabTimeForEachAlgo[2][j],super.tabTimeForEachAlgo[3][j],super.tabTimeForEachAlgo[4][j]);
            listTri.add(c1);
        }
        
        observableListDonneeTimeTri = FXCollections.observableArrayList(listTri);// ici la liste observé n'est plus vide 
        tableView.setItems(observableListDonneeTimeTri);// on modifie l'observation avec les nouvelles valeurs de la var observé
        listTri.clear();
    }
  

    
//    @FXML
//    public void restAll(){
//        DonneeTimeTriModel reset = new DonneeTimeTriModel();
//        (new CheckboxController()).setReturnEtatCheckbox(true);
//        observableListDonneeTimeTri.removeAll(listTri);
//        observableListDonneeTimeTri.add(reset);
//        tableView.setItems(observableListDonneeTimeTri);
//    }
   
   
}
























//    public void selecionarItemTableViewClientes(DonneeTimeTriModel donneTimeTri){
//        if(donneTimeTri!=null)
//        System.out.println("cliente selecionado no TableView "+ donneTimeTri.getIndex());
//    }

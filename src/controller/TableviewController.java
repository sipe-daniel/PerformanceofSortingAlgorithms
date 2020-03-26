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
    
    public void createTableViewTri(){
        tableColumnIndexTest.setCellValueFactory(new PropertyValueFactory<>("index"));
        tableColumnTriSelection.setCellValueFactory(new PropertyValueFactory<>("triSelection"));
        tableColumnTriInsertion.setCellValueFactory(new PropertyValueFactory<>("triInsertion"));
        tableColumnTriBulle.setCellValueFactory(new PropertyValueFactory<>("triBulle"));
        tableColumnTriFusion.setCellValueFactory(new PropertyValueFactory<>("triFusion"));
        tableColumnTriRapide.setCellValueFactory(new PropertyValueFactory<>("triRapide"));

       =
        observableListDonneeTimeTri = FXCollections.observableArrayList(listTri);
        tableView.setItems(observableListDonneeTimeTri);
        
    }
    

    /**
    * addItemTableView : pour ajouter les valeurs  ou donnée dans le tableview 
    */
    
    @FXML
    public void addItemTableViewTri(){
        for(int arr_elt=0,nbTest=(new GroupRadioButtonController()).getNumberOfTest();arr_elt<nbTest;arr_elt++){// O: triSelection 1: triInsertion 2:triBulle 4:triFusion 5:triRapide
            DonneeTimeTriModel c1 = new DonneeTimeTriModel(arr_elt+1,super.timeTableForEachAlgo[0][arr_elt],super.timeTableForEachAlgo[1][arr_elt],super.timeTableForEachAlgo[2][arr_elt],super.timeTableForEachAlgo[3][arr_elt],super.timeTableForEachAlgo[4][arr_elt]);
            listTri.add(c1);
        }
        
        observableListDonneeTimeTri = FXCollections.observableArrayList(listTri);
        tableView.setItems(observableListDonneeTimeTri);
        listTri.clear();
    }
    
    
    public void removeItemTableViewTri(){
        listTri.clear();
       
        observableListDonneeTimeTri = FXCollections.observableArrayList(listTri);// ici la liste observé n'est plus vide 
        tableView.edit(0, tableColumnTriBulle);
        listTri.clear();
    }

}


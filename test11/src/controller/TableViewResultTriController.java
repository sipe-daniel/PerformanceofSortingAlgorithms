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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.DonneeTimeTriModel;
import model.DonneeValeurRetourModel;

/**
 *
 * @author jordan
 */
public class TableViewResultTriController extends CoreController implements Initializable{
    @FXML private TableView<DonneeValeurRetourModel> tableViewResult;
    @FXML private TableColumn<DonneeValeurRetourModel,String> tableColumnIndexTest;
    @FXML private TableColumn<DonneeValeurRetourModel,String> tableColumnTriSelection;
    @FXML private TableColumn<DonneeValeurRetourModel,String> tableColumnTriInsertion;
    @FXML private TableColumn<DonneeValeurRetourModel,String> tableColumnTriBulle;
    @FXML private TableColumn<DonneeValeurRetourModel,String> tableColumnTriFusion;
    @FXML private TableColumn<DonneeValeurRetourModel,String> tableColumnTriRapide;
    
    
    private static List<DonneeValeurRetourModel> listTriValue= new ArrayList<>();
    private ObservableList<DonneeValeurRetourModel> observableListDonneeValueTri;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {    
        this.createTableViewTri();

    }

    private void createTableViewTri(){
        // nom des colum lié au var
        tableColumnIndexTest.setCellValueFactory(new PropertyValueFactory<>("initialValue"));
        tableColumnTriSelection.setCellValueFactory(new PropertyValueFactory<>("triSelection"));
        tableColumnTriInsertion.setCellValueFactory(new PropertyValueFactory<>("triInsertion"));
        tableColumnTriBulle.setCellValueFactory(new PropertyValueFactory<>("triBulle"));
        tableColumnTriFusion.setCellValueFactory(new PropertyValueFactory<>("triFusion"));
        tableColumnTriRapide.setCellValueFactory(new PropertyValueFactory<>("triRapide"));

        
        observableListDonneeValueTri = FXCollections.observableArrayList(listTriValue);
        tableViewResult.setItems(observableListDonneeValueTri);
    }
    
    
     @FXML
    public void addItemTableView(){
        String initialBoard = "";
        for(int j = 0; j < super.array.size();j++){
            for(int i = 0; i < super.array.get(j).size();i++){
                initialBoard +=   ""+super.array.get(j).get(i);
            }   
                System.out.println("dans mon initial board"+initialBoard);
                initialBoard += "\n ";   
                
        }
        System.out.println("dans mon initial board"+initialBoard);
        for(int j=0,nbTest=(new GroupRadioButtonController()).getNumberOfTest();j<nbTest;j++){// O: triSelection 1: triInsertion 2:triBulle 4:triFusion 5:triRapide
                                                                                 //super.tabTimeForEachAlgo[0][j] //super.tabTimeForEachAlgo[1][j]//super.tabTimeForEachAlgo[2][j] //super.tabTimeForEachAlgo[3][j] //super.tabTimeForEachAlgo[4][j]
//            DonneeValeurRetourModel c1 = new DonneeValeurRetourModel(initialBoard,super.tableOfResults[0][j],super.tableOfResults[1][j],super.tableOfResults[2][j],super.tableOfResults[3][j],super.tableOfResults[4][j]);
//            String a= " "+super.array.get(0).get(0)+12;
           
           
            DonneeValeurRetourModel c1 = new DonneeValeurRetourModel(" 3" ,"3","000","000","000","000");
            listTriValue.add(c1);
        }
        
        observableListDonneeValueTri = FXCollections.observableArrayList(listTriValue);
        tableViewResult.setItems(observableListDonneeValueTri);
        listTriValue.clear();
    }
    
    
   
}


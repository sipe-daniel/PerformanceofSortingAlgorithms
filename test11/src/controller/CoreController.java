/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.TriModel;

import controller.GroupRadioButtonController;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author jordan
 */
public class CoreController extends TriModel{
    protected static long tabTimeForEachAlgo[][] = new long[5][5];
    protected String tableOfResults[][]= new String[5][5];
   
    
    /*declaration les variable instance*/
    private int nbTab; 
    /*nombre de point pour chaque test*/
    private int[] tabPlage;
    //garde les valeurs initialement genere aleatoirement
    protected List<List<Integer>> array;
    // stocke temporairement les valeurs c'est a travers lui que sera traité les données
    private List<List<Integer>> arrayRetour;


   

   

public CoreController(){
    this.array = new ArrayList<>();
    this.arrayRetour = new ArrayList<>();
}

 /**
 * 
 * @param nbValEntrer
 * @param val la valeur aleatoire generé
 * @param tab
 * @return 
 */
public boolean doublon(int nbValEntrer, int val, ArrayList<Integer> tab){

    for (int i = 0; i < nbValEntrer; i++) {
        if(tab.get(i) == val){
            return true;
        }
    }
    return false;
}
/**
 * setValueNumberTest() pour entrer le nb de donnees de chaque  test
 */
//optimiser
private void setValueNumberTest(){
    GroupRadioButtonController donnneController = new GroupRadioButtonController();
    nbTab = new GroupRadioButtonController().getNumberOfTest();
    tabPlage = new int[nbTab];
   
    for(int i = 0; i < nbTab;i++){
        tabPlage[i] = donnneController.getNumberValuetab().get(i); //optimiser
    } 
}
/**
 * setInsertEltParTab remplir le tableau qui va être greffé au grand tableau
 * @param i
 * @param plage
 * @param a 
 */
private void setInsertEltParTab(int plage, ArrayList a){
    Random rand = new Random();                         // pour generer une valeur aleatoire
    Boolean verification;                              // verifie s'il y'a repetion ou non de nb généré            
    int nbValEntrer = 0;                               // pour savoir comment evaluer la repetition
    int valeurAl;                                      // la valeur aleatoire genéré

    for(int j = 0; j < plage ;j++){
        if(nbValEntrer != 0){
            do{
                valeurAl = rand.nextInt(plage)-(plage/2);
                verification = doublon(nbValEntrer,valeurAl,a);
            }while(verification == true);

            a.add(j,valeurAl);
            nbValEntrer++;
        }else{
            valeurAl = rand.nextInt(plage)-(plage/2);
            a.add(j,valeurAl);
            nbValEntrer++;
        }
    }
}
/**
 * setInsertValeur pour remplir le tableau avec les valeurs entré generé aleatoirement
 */
public void setInsertTabValue(){
    int plage;                                        // la plage de nombre
    ArrayList<Integer> a = new ArrayList<>();         // pour stoker le tableau qui seront inserer dans le grand tableau

    for(int i = 0; i < nbTab; i++){
        plage = tabPlage[i];
  
        this.setInsertEltParTab(plage, a);

        array.add(i, (List<Integer>) a.clone());
        a.clear();                                  // pour eviter que le array copie la reference au lieu de l'image
    }
}
/**
 * printTab: permet d'afficher le tableau rempli ou le tableau initiale
 */
public void printTab(){
   for (int i = 0; i < nbTab; i++) {
       for (int j = 0; j < array.get(i).size(); j++) {
           System.out.print(array.get(i).get(j)+" ");
       }
       System.out.println();
   }
}
//   *
//*    *
//***  ***
/**
 * printTabRetours pour afficher le tableau de retour
 */
public void printTabRetours(int indiceType){
//   String elemntStock = " "; pour afficher dans le deuxieme tableview mais sa ne vaut pas la peine car trop de valeur

   for (int i = 0; i < arrayRetour.size(); i++) {
       for (int j = 0; j < arrayRetour.get(i).size(); j++) {
           System.out.print(arrayRetour.get(i).get(j)+ " ");
//           elemntStock += arrayRetour.get(i).get(j)+", ";
           
       }
       
//       pour afficher dans le deuxieme tableview mais sa ne vaut pas la peine car trop de valeur
//       System.out.print(elemntStock+ "uiouoio ");
//       this.tableOfResults[indiceType][i] = elemntStock;
//       elemntStock="";
       System.out.println();
   }

}
/**
 * copytabdyn pour faire un copie du tableau generé
 * @throws ArrayIndexOutOfBoundsException 
 */
public void  copytabdyn() throws ArrayIndexOutOfBoundsException{
    int a;
    
    for(int i= 0; i < tabPlage.length;i++)
    {
        arrayRetour.add(i,new ArrayList<>());
        for(int j = 0; j < tabPlage[i];j++)
        {
           arrayRetour.get(i).add(j,array.get(i).get(j)); 
        }       
    }
}

/**
 * initializeBoardValueTime :: initialise toute les case du tableau tabTimeForEachAlgo avec -1
 * pour pouvoir distigué quel sont les valeurs changé"s ou generées par l'operation
 */
public void initializeBoardValueTime(){
    for(int i = 0;i<5; i++){
        for(int j = 0;j<5;j++)
            this.tabTimeForEachAlgo[i][j] = -50;
    }

}


/**
 * core:: la deuxieme fonction principale apres la fonction run qui est dans MainController
 * @param BoardTypeAlgo
 * @param tabPlage
 * @throws IllegalAccessException
 * @throws IllegalArgumentException
 * @throws InvocationTargetException
 * @throws NoSuchMethodException 
 */



// le coeur de notre 
// tranferer ici nbtab, plage
public void core(List<String> BoardTypeAlgo, List<Integer> tabPlage) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException {
    long timebegin, timeOver = 0;
    Method testMethod;
    
    this.setValueNumberTest(); //pour entrer le nb de donnees de chaque  test
    this.setInsertTabValue();   //pour remplir le tableau avec les valeurs entré generé aleatoirement
   
    
    this.printTab();
    System.out.println();
    this.copytabdyn();//permet d'initialiser le tableau retour
    this.initializeBoardValueTime();//permet d'initialiser le tableau time avec des -1
    int indexOfBoardTypeAlgo = 0;//indice qui permet de parcourir les val du tableauTYpeTri
    int i = 0;
    
    do{
          System.out.println(indexOfBoardTypeAlgo+"test");
          for(int indexBoardValue = 0; indexBoardValue < nbTab; indexBoardValue++)
            {
                timebegin = System.currentTimeMillis();
                    testMethod = TriModel.class.getMethod(BoardTypeAlgo.get(indexOfBoardTypeAlgo),int.class,List.class,ArrayList.class);
                    testMethod.invoke(new TriModel(), indexBoardValue, tabPlage, arrayRetour);
                timeOver = System.currentTimeMillis() - timebegin;

                 System.out.println("le temps mis par le "+BoardTypeAlgo.get(indexOfBoardTypeAlgo)+"est : "+timeOver+"seconde");
                
                this.tabTimeForEachAlgo[this.detecteType(BoardTypeAlgo.get(indexOfBoardTypeAlgo))][i] = timeOver;i++; //je peux aussi activer ceci et desactivé celui qui suit
//                    this.fillingBoardPrimary(indexOfBoardTypeAlgo,BoardTypeAlgo, arrayRetour.get(indexBoardValue),timeOver);
                this.affichargetabtime();
            }
           i=0;
           this.printTabRetours(this.detecteType(BoardTypeAlgo.get(indexOfBoardTypeAlgo)));
           //pour reinitialiser le tableau retour
           arrayRetour.clear();//on vide l'ancien tableau pour que le tableau n'augmente pas de taille plutot
           this.copytabdyn();//on recopie les valeurs du tableau initiale
           System.out.println("tableau reinitialisé");

        indexOfBoardTypeAlgo++;
    }while (indexOfBoardTypeAlgo < BoardTypeAlgo.size());
//       printTableStockResult(tabStockResult);

       System.out.println("taille tableau "+arrayRetour.size());
}


/**
 * detecteType:: pour faire correspondre le nom de chaque l'algo a un nombre
 * pour pouvoir les distinguer lors de l'affichage
 * @param typeTri
 * @return 
 */
int detecteType(String typeTri){
       switch(typeTri){
        case "triSelection":  return 0; //0 correspond au triSelection
        case "triInsertion":  return 1;  //1 correspond au triInsertion
        case "triBulle":      return 2;      //...
        case "coreTriFusion": return 3;
        case "coreTriRapide": return 4; 
       }
       return -1;
}
/**
 * affichargetabtime: pour afficher le tableau tabTimeForEachAlgo
 */
public void affichargetabtime(){
    for(int j= 0;j<tabTimeForEachAlgo.length;j++){
        for(int i = 0;i< tabTimeForEachAlgo.length;i++){
            System.out.print(tabTimeForEachAlgo[j][i]+" ");
        }
        System.out.println();
    }
}

}














































//boolean doublonTypeTri(int tab[],int typeTester){
//   
//    for(int i=0,len=tab.length;i<len;i++){
//        if(tab[i]==typeTester){
//            System.out.println("+++++++++++++++++++++++++++++++++++"+tab[i]);
//            System.out.println("+++++++++++++++++++++++++++++++++++"+typeTester);
//            return true;
//        }
//            
//    }
//    return false;
//}









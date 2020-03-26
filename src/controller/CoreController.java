/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.TriModel;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 *
 * @author jordan
 */

public class CoreController extends TriModel{
    protected static long timeTableForEachAlgo[][] = new long[5][5];
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
 * @param arr
 * @return 
 */

public boolean doublon(int nbValEntrer, int val, ArrayList<Integer> arr){
    for (int arr_elt = 0; arr_elt < nbValEntrer; arr_elt++) {
        if(arr.get(arr_elt) == val){
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
    GroupRadioButtonController donneeController = new GroupRadioButtonController();
    nbTab = new GroupRadioButtonController().getNumberOfTest();
    tabPlage = new int[nbTab];
   
    for(int arr_elt = 0; arr_elt < nbTab;arr_elt++){
        tabPlage[arr_elt] = donneeController.getNumberValuetab().get(arr_elt); //optimiser
    } 
}


/**
 * setInsertEltParTab remplir le tableau qui va être greffé au grand tableau
 * @param i
 * @param plage
 * @param a 
 */

private void setInsertEltParTab(int plage, ArrayList arr){
    Random rand = new Random();                         
    Boolean verification;                                         
    int nbValEntrer = 0;                               
    int valeurAl;                                      

    for(int arr_elt = 0; arr_elt < plage ;arr_elt++){
        if(nbValEntrer != 0){
            do{
                valeurAl = rand.nextInt(plage)-(plage/2);
                verification = doublon(nbValEntrer,valeurAl,arr);
            }while(verification == true);

            arr.add(arr_elt,valeurAl);
            nbValEntrer++;
        }else{
            valeurAl = rand.nextInt(plage)-(plage/2);
            arr.add(arr_elt,valeurAl);
            nbValEntrer++;
        }
    }
}

public void setInsertTabValue(){
    int plage;                                        
    ArrayList<Integer> arr = new ArrayList<>();

    for(int i = 0; i < nbTab; i++){
        plage = tabPlage[i];
        this.setInsertEltParTab(plage, arr);
        array.add(i, (List<Integer>) arr.clone());
        arr.clear();                                  
    }
}

public void printTab(){
   for (int arr_index = 0; arr_index < nbTab; arr_index++) {
       for (int arr_elt = 0; arr_elt < array.get(arr_index).size(); arr_elt++) {
           System.out.print(array.get(arr_index).get(arr_elt)+" ");
       }
       System.out.println();
   }
}

public void printTabRetours(int indiceType){
   for (int arr_index = 0; arr_index < arrayRetour.size(); arr_index++) {
       for (int arr_elt = 0; arr_elt < arrayRetour.get(arr_index).size(); arr_elt++) {
           System.out.print(arrayRetour.get(arr_index).get(arr_elt)+ " ");
       }
       System.out.println();
   }

}


/**
 * copytabdyn pour faire une copie du tableau généré
 * @throws ArrayIndexOutOfBoundsException 
 */

public void copytabdyn() throws ArrayIndexOutOfBoundsException{
    for(int arr_index= 0; arr_index < tabPlage.length;arr_index++)
    {
        arrayRetour.add(arr_index,new ArrayList<>());
        for(int arr_elt = 0; arr_elt < tabPlage[arr_index]; arr_elt++)
        {
           arrayRetour.get(arr_index).add(arr_elt,array.get(arr_index).get(arr_elt)); 
        }       
    }
}

public void initializedTimeValueTab(){  /////initializedTimeValueTab
    for(int arr_index = 0; arr_index<5; arr_index++){
        for(int arr_elt = 0; arr_elt<5; arr_elt++)
            CoreController.timeTableForEachAlgo[arr_index][arr_elt] = -50; 
    }

}


/**
 * core:: la deuxieme fonction principale apres la fonction run qui est dans MainController
 * @param ArrTypeAlgo
 * @param tabPlage
 * @throws IllegalAccessException
 * @throws IllegalArgumentException
 * @throws InvocationTargetException
 * @throws NoSuchMethodException 
 */

public void core(List<String> ArrTypeAlgo, List<Integer> tabPlage) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException {
    long timebegin, timeOver;

    Method CallWithNameMethod;
    
    this.setValueNumberTest(); 
    this.setInsertTabValue();   
    
    this.printTab();
    System.out.println();
    this.copytabdyn();//permet d'initialiser le tableau retour
    this.initializedTimeValueTab();
    int tableIndexTypeAlgo = 0;
    int i = 0;
    
    do{
          System.out.println(tableIndexTypeAlgo+"test");
          for(int indexTabVal = 0; indexTabVal < nbTab; indexTabVal++)
            {
                timebegin = System.currentTimeMillis();
                    CallWithNameMethod = TriModel.class.getMethod(ArrTypeAlgo.get(tableIndexTypeAlgo),int.class,List.class,ArrayList.class);
                    CallWithNameMethod.invoke(new TriModel(), indexTabVal, tabPlage, arrayRetour);
                timeOver = System.currentTimeMillis() - timebegin;

                 System.out.println("le temps mis par le "+ArrTypeAlgo.get(tableIndexTypeAlgo)+"est : "+timeOver+"seconde");
                
                CoreController.timeTableForEachAlgo[this.identifiedType(ArrTypeAlgo.get(tableIndexTypeAlgo))][i] = timeOver;i++; 
                this.affichargetabtime();
            }
           i=0;
           this.printTabRetours(this.identifiedType(ArrTypeAlgo.get(tableIndexTypeAlgo)));
           arrayRetour.clear();
           this.copytabdyn();
           System.out.println("tableau reinitialisé");

        tableIndexTypeAlgo++;
    }while (tableIndexTypeAlgo < ArrTypeAlgo.size());

       System.out.println("taille tableau "+arrayRetour.size());
}

int identifiedType(String typeTri){
       switch(typeTri){
        case "triSelection":  return 0; //0 correspond au triSelection
        case "triInsertion":  return 1;  //1 correspond au triInsertion
        case "triBulle":      return 2;      //...
        case "coreTriFusion": return 3;
        case "coreTriRapide": return 4; 
       }
       return -1;
}

public void affichargetabtime(){ 
    for (long[] timeTableForEachAlgo1 : timeTableForEachAlgo) {
        for (int arr_elt = 0; arr_elt< timeTableForEachAlgo.length; arr_elt++) {
            System.out.print(timeTableForEachAlgo1[arr_elt] + " ");
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









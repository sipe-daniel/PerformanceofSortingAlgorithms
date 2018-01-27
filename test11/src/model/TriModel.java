/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


/**
 *
 * @author jordan
 */
public class TriModel {
    /*declaration les variable instance*/
    private int nbTab;
    
    /*nombre de point pour chaque test*/
    protected int[] tabPlage;
    private List<Integer> arrayRetour;
    private static final Scanner clavier = new Scanner(System.in);
    
//    protected TriModel(){
//
//    }
    /*constructeur*/
//    public Tri(int pNbTab,int pNbCol){
//         array = new ArrayList<>();
//         nbTab = pNbTab;
//    
//    }


    /**
     * triSelection
     * @param indice
     * @param t
     * @param array
    */
    public void triSelection(int indice,List<Integer> t,ArrayList<ArrayList<Integer>> array){
        int i,j;
        int indMin, min, tmp;
        int plage = t.get(indice);
       
        for( j = 0; j != plage; j++)
        {
            min = array.get(indice).get(j);
            indMin = j;

          for(i = j; i < plage; i++)
            {
                
               if (array.get(indice).get(i) < min)
                {
                    min = array.get(indice).get(i);
                    indMin = i;
                }
            }

            if(array.get(indice).get(indMin) < array.get(indice).get(j))
            {
                tmp = array.get(indice).get(j);
                array.get(indice).set(j, array.get(indice).get(indMin));
                array.get(indice).set(indMin, tmp);
            }
            // dois normalement revoyer le temps(si possible un hashMap pour preciser le tri ou test)
            // ou dois passé a un tableau qui est le tableau de retour 
            //declaré globale
        }

    }
    
    /**
     * triInsertion
     * @param indice
     * @param t
     * @param array  
     */

    public void triInsertion(int indice,List<Integer> t,ArrayList<ArrayList<Integer>> array){
        int i, j;
        int plage =  t.get(indice);
        int elementInsere;

        for (i = 1; i < plage; i++) {
            /* Stockage de la valeur en i */
            elementInsere = array.get(indice).get(i);
               for (j = i; j > 0 && array.get(indice).get(j-1)>elementInsere; j--) {
                   array.get(indice).set(j, array.get(indice).get(j-1));
               }
            /* Insertion de la valeur stockée à la place vacante */
              array.get(indice).set(j,elementInsere);          
        }
        
    }
    
   
    
       /**
     * triBulle
     * @param indice
     * @param t
     * @param array  
     */
    
      public void triBulle(int indice,List<Integer> t,ArrayList<ArrayList<Integer>> array){
        int  j = t.get(indice)  , tmp,s,v;
        boolean permute = false;
       do{
           for(int i = 0; i < j-1; i++)
           {
               permute = false;
          
               if(array.get(indice).get(i) > array.get(indice).get(i+1)){
                   tmp = array.get(indice).get(i+1);
                   array.get(indice).set(i+1,array.get(indice).get(i));
                   array.get(indice).set(i,tmp);
     
                   permute = true;
               }
           }
           j = j - 1;
       }while((j != 1)||(permute != false));
    }
//        void triBulle(int indice,List<Integer> t,ArrayList<ArrayList<Integer>> array){
//        int  j = (int) t.get(indice) , tmp,s,v;
//        boolean permute = false;
//       do{
//           for(int i = 0; i < j-1; i++)
//           {
//               permute = false;
//          
//               if(array.get(indice).get(i) > array.get(indice).get(i+1)){
//                   tmp = array.get(indice).get(i+1);
//                   array.get(indice).set(i+1,array.get(indice).get(i));
//                   array.get(indice).set(i,tmp);
//     
//                   permute = true;
//               }
//           }
//           j = j - 1;
//       }while((j != 1)||(permute != false));
//    }
    /***************************************************************/
    /**********************        Tri Fusion       ****************/
    /***************************************************************/
    
    /**
     * 
     * @param indice
     * @param deb1
     * @param fin1
     * @param fin2
     * @param array 
     */
    
    void fusion(int indice,int deb1,int fin1,int fin2,ArrayList<ArrayList<Integer>> array){
        int deb2 = fin1 + 1;
        int compt1 = deb1;
        int compt2 = deb2;
        int i;

        ArrayList<Integer> table1 = new ArrayList<>();
        for(i=deb1;i<=fin1;i++)

          table1.add(i-deb1,array.get(indice).get(i));
        for(i = deb1 ; i<= fin2;i++)
        {
            if(compt1 == deb2)break;

                else if(compt2 == (fin2+1))
                {
                    array.get(indice).set(i, table1.get(compt1 - deb1));
                    compt1++;
                }
                else if(table1.get(compt1-deb1) < array.get(indice).get(compt2))
                {
                    array.get(indice).set(i, table1.get(compt1 - deb1));
                    compt1++;
                }else
                {
                    array.get(indice).set(i, array.get(indice).get(compt2));
                    compt2++;
                }
        }
        
    }
    /**
     * 
     * @param indice
     * @param deb
     * @param fin
     * @param array 
     */
    
    void tri_fusion_bis(int indice,int deb,int fin, ArrayList<ArrayList<Integer>> array)
    {
        if(deb != fin)
        {
            int milieu = (fin + deb)/2;
            tri_fusion_bis(indice,deb,milieu,array);
            tri_fusion_bis(indice,milieu + 1,fin,array);
            
            fusion(indice,deb,milieu,fin,array);
        }
    }   
    
    /**
     * 
     * @param indice
     * @param plage
     * @param array 
     */
    
    void tri_fusion(int indice,int plage, ArrayList<ArrayList<Integer>> array){
       
        if(plage > 0)
        {
            tri_fusion_bis(indice,0,plage-1,array);
        }

    }

    /**
     * 
     * @param indice
     * @param t
     * @param array 
     */
    
    public void coreTriFusion(int indice,List<Integer> t, ArrayList<ArrayList<Integer>> array){
        int plage = t.get(indice);
        
        tri_fusion(indice,plage, array);
    }
    
    
    /***************************************************************/
    /**********************        Tri rapide       ****************/
    /***************************************************************/
    /**
     * 
     * @param indice
     * @param i
     * @param j
     * @param array 
     */
    
    void echanger(int indice,int i,int j, ArrayList<ArrayList<Integer>> array){
        int tmp;

        tmp = array.get(indice).get(i);
        
          array.get(indice).set(i, array.get(indice).get(j));
          array.get(indice).set(j, tmp);
    }
    /**
     * 
     * @param indice
     * @param deb
     * @param fin
     * @param array
     * @return 
     */
    
    int partition(int indice,int deb,int fin,ArrayList<ArrayList<Integer>> array){
        int compt = deb;
        double pivot = array.get(indice).get(deb);
        
        int i;

        for(i = deb + 1;i <= fin;i++) {
            if(array.get(indice).get(i) < pivot){
                compt++;
                echanger(indice,compt,i,array);
            }
        }
        echanger(indice,compt,deb,array);

        return(compt);
    }
    
    /**
     * 
     * @param indice
     * @param debut
     * @param fin
     * @param array 
     */
    
    void tri_rapide_bis(int indice,int debut,int fin, ArrayList<ArrayList<Integer>> array){

        if(debut < fin){
            int pivot = partition(indice,debut,fin,array);
            tri_rapide_bis(indice,debut,pivot-1,array);
            tri_rapide_bis(indice,pivot+1,fin,array);
        }
    }
    
    /**
     * 
     * @param indice
     * @param plage
     * @param array 
     */
    
    void tri_rapide(int indice,int plage, ArrayList<ArrayList<Integer>> array) {
        tri_rapide_bis(indice,0,plage-1,array);
    }
    
    /**
     * 
     * @param indice
     * @param t
     * @param array 
     */
    
    public void coreTriRapide(int indice,List<Integer> t,ArrayList<ArrayList<Integer>> array ){
       int plage = t.get(indice);
       tri_rapide( indice,plage ,array);
    }
}

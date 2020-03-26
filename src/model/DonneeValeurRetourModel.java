/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author jordan
 */
public class DonneeValeurRetourModel {


    private String initialValue="";
    private String triSelection="";
    private String triInsertion="";
    private String triBulle="";
    private String triFusion="";
    private String triRapide="";
    
    public DonneeValeurRetourModel(){ 
    }
    /**
     * DonneeTimeTri :: recupere les valeurs que doit contenir le tableView
     * @param pIndex
     * @param pTriSelection
     * @param pTriInsertion
     * @param pTriBulle
     * @param pTriFusion
     * @param pTriRapide 
     */
    
    public DonneeValeurRetourModel(String pInitialValue, String  pTriSelection,String  pTriInsertion,String pTriBulle,String  pTriFusion,String  pTriRapide){
            this.initialValue =  pInitialValue;
            this.triSelection =  pTriSelection;
            this.triInsertion =  pTriInsertion;
            this.triBulle     =  pTriBulle;
            this.triFusion    =  pTriFusion;
            this.triRapide    =  pTriRapide;
    }

    public void alertConvertValueAcceptablet(String pTriSelection,String pTriInsertion,String pTriBulle,String pTriFusion,String pTriRapide ){
        if(pTriSelection == null)
            this.triSelection = " ";
       
        
        if(pTriInsertion == null)
            this.triInsertion = " ";
 
        
        if(pTriBulle == null)
            this.triBulle = " ";
        
        
        if(pTriFusion == null)
            this.triFusion = " ";
     
        
        if(pTriRapide == null)
            this.triRapide = " ";
  
    }

    public String getInitialValue() {
        return initialValue;
    }

    public void setInitialValue(int initialValue) {
        this.initialValue = String.format("%s", initialValue);
    }

    public String getTriSelection() {
        return triSelection;
    }

    public void setTriSelection(int triSelection) {
        this.triSelection = String.format("%s", triSelection);
    }

    public String getTriInsertion() {
        return triInsertion;
    }

    public void setTriInsertion(int triInsertion) {
        this.triInsertion = String.format("%s", triInsertion);
    }

    public String getTriBulle() {
        return triBulle;
    }

    public void setTriBulle(int triBulle) {
        this.triBulle = String.format("%s", triBulle);
    }

    public String getTriFusion() {
        return triFusion;
    }

    public void setTriFusion(int triFusion) {
        this.triFusion = String.format("%s", triFusion);
    }

    public String getTriRapide() {
        return triRapide;
    }

    public void setTriRapide(int triRapide) {
        this.triRapide = String.format("%s", triRapide);
    }
    
    

}



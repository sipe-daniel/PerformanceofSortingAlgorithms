/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author jordan
 */
public class DonneeTimeTriModel {
    final int DEFAULT_VALUEOFTHE_CHECKBOX = -50;
    private String index;
    private String triSelection;
    private String triInsertion;
    private String triBulle;
    private String triFusion;
    private String triRapide;
    
    public DonneeTimeTriModel(){
        
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
    public DonneeTimeTriModel(long pIndex, long pTriSelection,long pTriInsertion,long pTriBulle,long pTriFusion,long pTriRapide){
        this.index = String.format("%s", pIndex);
        if((pTriSelection==-50)||(pTriInsertion==-50)||(pTriBulle==-50)||(pTriFusion==-50)||(pTriRapide==-50))
                this.alertConvertValueAcceptable(pTriSelection,pTriInsertion,pTriBulle,pTriFusion,pTriRapide);
        else{
            this.triSelection = String.format("%s", pTriSelection);
            this.triInsertion = String.format("%s", pTriInsertion);
            this.triBulle = String.format("%s", pTriBulle);
            this.triFusion = String.format("%s", pTriFusion);
            this.triRapide = String.format("%s", pTriRapide);
        }
    }
    /**
     * alertConvertValueAcceptable : est appelé pour initialiser s'il y'a une valeur pas nomarle(-50)
     * @param pTriSelection
     * @param pTriInsertion
     * @param pTriBulle
     * @param pTriFusion
     * @param pTriRapide 
     */
    public void alertConvertValueAcceptable(long pTriSelection,long pTriInsertion,long pTriBulle,long pTriFusion,long pTriRapide ){
        if(pTriSelection == DEFAULT_VALUEOFTHE_CHECKBOX)
            this.triSelection = " ";
        else
            this.triSelection = String.format("%s", pTriSelection);
        
        if(pTriInsertion == DEFAULT_VALUEOFTHE_CHECKBOX)
            this.triInsertion = " ";
        else
            this.triInsertion = String.format("%s", pTriInsertion);
        
        if(pTriBulle == DEFAULT_VALUEOFTHE_CHECKBOX)
            this.triBulle = " ";
        else
            this.triBulle = String.format("%s", pTriBulle);
        
        if(pTriFusion == DEFAULT_VALUEOFTHE_CHECKBOX)
            this.triFusion = " ";
        else
            this.triFusion = String.format("%s", pTriFusion);
        
        if(pTriRapide == DEFAULT_VALUEOFTHE_CHECKBOX)
            this.triRapide = " ";
        else
            this.triRapide = String.format("%s", pTriRapide);
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = String.format("%s", index);
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

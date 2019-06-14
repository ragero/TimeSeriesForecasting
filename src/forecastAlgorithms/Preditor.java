/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forecastAlgorithms;

import java.util.List;
import structures.Item;

/**
 *
 * @author rafael
 */
public abstract class Preditor {
    
    private String nomePreditor;
    
    public Preditor(String nomePreditor){
        this.nomePreditor = nomePreditor;
    }
    
    public abstract double prever(List<Item> serie);
    
    public void setNomePreditor(String nomePreditor){
        this.nomePreditor = nomePreditor;
    }
    
    public String getNomePreditor(){
        return nomePreditor;
    }
    
    public abstract String toString();
    
}

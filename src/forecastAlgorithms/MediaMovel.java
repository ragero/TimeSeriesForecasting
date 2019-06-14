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
public class MediaMovel extends Preditor{
    
    private int tamJanela;

    public MediaMovel(){
        super("Media Móvel");
    }
    
    @Override
    public double prever(List<Item> serie) {
        double valor = 0;
        
        int tamanhoSerie = serie.size();
        int idIni = tamanhoSerie - tamJanela;
        if(idIni < 0){
            idIni = 0;
        }
        for(int id=idIni;id<tamanhoSerie;id++){
            valor += serie.get(id).getValor();
        }
        
        return valor/tamJanela;
        
    }
    
    public int getTamJanela() {
        return tamJanela;
    }

    public void setTamJanela(int tamJanela) {
        this.tamJanela = tamJanela;
    }
    
    @Override 
    public String toString(){
        return this.getNomePreditor() + " - Janela: " + this.tamJanela;
    }
    
    
}

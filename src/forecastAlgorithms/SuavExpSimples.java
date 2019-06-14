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
public class SuavExpSimples extends Preditor{

    double alpha;
    
    public SuavExpSimples(){
        super("SuavizacaoExponecialSimples");
    }
    
    @Override
    public double prever(List<Item> serie) {
        int tamSerie = serie.size();
        
        double[] s = new double[tamSerie];
        s[0] = serie.get(0).getValor();
        for(int id=1;id<tamSerie;id++){
            s[id] = alpha * serie.get(id).getValor() + (1 - alpha) * s[id-1];
        }
        
        return s[tamSerie-1];
    }
    
    public double getAlpha() {
        return alpha;
    }

    public void setAlpha(double alpha) {
        this.alpha = alpha;
    }
    
    
    @Override 
    public String toString(){
        return this.getNomePreditor() + " - Alpha: " + this.alpha;
    }
}

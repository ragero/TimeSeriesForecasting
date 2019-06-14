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
public class SuavExpAjusteTendendia extends Preditor{
    
    private double alpha;
    private double beta;

    public SuavExpAjusteTendendia(){
        super("Suavização Exponencial Simples com Ajuste de Tendência");
    }
    
    public double getAlpha() {
        return alpha;
    }

    public void setAlpha(double alpha) {
        this.alpha = alpha;
    }

    public double getBeta() {
        return beta;
    }

    public void setBeta(double beta) {
        this.beta = beta;
    }

    @Override
    public double prever(List<Item> serie) {
        int tamSerie = serie.size();
        double[] s = new double[tamSerie];
        double[] m = new double[tamSerie];
        
        s[0] = serie.get(0).getValor();
        m[0] = 0;
        
        for(int id=1;id<tamSerie;id++){
            s[id] = alpha * serie.get(id).getValor() + (1 - alpha)*(s[id-1] + m[id-1]);
            m[id] = beta * (s[id] - s[id-1]) + (1 - beta)*m[id-1];
        }
        
        return s[tamSerie-1] + m[tamSerie-1];
    }

    @Override
    public String toString() {
        return this.getNomePreditor() + " - Alpha: " + this.alpha + " - Beta: " + this.beta;
    }
    
    
    
}

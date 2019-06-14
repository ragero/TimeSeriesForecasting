/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package configurations;

/**
 *
 * @author rafael
 */
public class ConfiguracaoSuavExpAjusteTendencia {
    
    private double alpha;
    private double beta;

    public ConfiguracaoSuavExpAjusteTendencia(double alpha, double beta) {
        this.alpha = alpha;
        this.beta = beta;
    }

    public ConfiguracaoSuavExpAjusteTendencia() {
        this.alpha = 0.9;
        this.beta = 0.1;
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
    
    
    
}

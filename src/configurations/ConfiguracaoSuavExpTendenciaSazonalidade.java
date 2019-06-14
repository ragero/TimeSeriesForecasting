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
public class ConfiguracaoSuavExpTendenciaSazonalidade {
    
    private double alpha;
    private double beta;
    private double gamma;
    private int l;

    public ConfiguracaoSuavExpTendenciaSazonalidade(double alpha, double beta, double gamma, int l) {
        this.alpha = alpha;
        this.beta = beta;
        this.gamma = gamma;
        this.l = l;
    }

    public ConfiguracaoSuavExpTendenciaSazonalidade() {
        this.alpha = 0.9;
        this.beta = beta;
        this.gamma = gamma;
        this.l = l;
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

    public double getGamma() {
        return gamma;
    }

    public void setGamma(double gamma) {
        this.gamma = gamma;
    }

    public int getL() {
        return l;
    }

    public void setL(int l) {
        this.l = l;
    }
    
    
    
}

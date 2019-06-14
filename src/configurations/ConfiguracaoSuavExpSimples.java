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
public class ConfiguracaoSuavExpSimples {
    
    private double alpha;

    public ConfiguracaoSuavExpSimples(double alpha) {
        this.alpha = alpha;
    }

    public ConfiguracaoSuavExpSimples() {
        this.alpha = 0.9;
    }
    
    public double getAlpha() {
        return alpha;
    }

    public void setAlpha(double alpha) {
        this.alpha = alpha;
    }
    
    
    
}

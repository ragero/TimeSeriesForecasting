/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structures;

/**
 *
 * @author rafael
 */
public class Avaliacao {
    
    double valorReal;
    double valorPredito;
    
    public Avaliacao(double valorReal, double valorPredito){
        this.valorReal = valorReal;
        this.valorPredito = valorPredito;
    }

    public double getValorReal() {
        return valorReal;
    }

    public void setValorReal(double valorReal) {
        this.valorReal = valorReal;
    }

    public double getValorPredito() {
        return valorPredito;
    }

    public void setValorPredito(double valorPredito) {
        this.valorPredito = valorPredito;
    }
    
}

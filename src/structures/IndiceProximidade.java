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
public class IndiceProximidade implements Comparable<IndiceProximidade>{
    
    private int indice;
    private double proximidade;

    public IndiceProximidade(int indice, double proximidade) {
        this.indice = indice;
        this.proximidade = proximidade;
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }

    public double getProximidade() {
        return proximidade;
    }

    public void setProximidade(double proximidade) {
        this.proximidade = proximidade;
    }

    @Override
    public int compareTo(IndiceProximidade outro) {
        if(this.proximidade > outro.proximidade){
            return -1;
        }else if(this.proximidade < outro.proximidade){
            return +1;
        }else{
            return 0;
        }
    }
    
    
    
}

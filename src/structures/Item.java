/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structures;

import org.joda.time.DateTime;

/**
 *
 * @author rafael
 */
public class Item implements Comparable<Item>{
    
    DateTime data;
    double valor;
    
    public Item(DateTime data, double valor){
        this.data = data;
        this.valor = valor;
    }

    public DateTime getData() {
        return data;
    }

    public void setData(DateTime data) {
        this.data = data;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public int compareTo(Item outro) {
        if(this.valor > outro.valor){
            return -1;
        }else if(this.valor < outro.valor){
            return +1;
        }else{ 
            return 0;
        }
    }
    
    
    
}

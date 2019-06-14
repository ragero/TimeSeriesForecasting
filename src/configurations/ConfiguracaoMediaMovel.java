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
public class ConfiguracaoMediaMovel {
    
    private int tamanhoJanela;

    public ConfiguracaoMediaMovel(){
        this.tamanhoJanela = 10;
    }
    
    public ConfiguracaoMediaMovel(int tamanhoJanela) {
        this.tamanhoJanela = tamanhoJanela;
    }

    public int getTamanhoJanela() {
        return tamanhoJanela;
    }

    public void setTamanhoJanela(int tamanhoJanela) {
        this.tamanhoJanela = tamanhoJanela;
    }
    
    
    
}

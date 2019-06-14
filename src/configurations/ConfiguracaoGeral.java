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
public class ConfiguracaoGeral {
    
    //Configuracoes do Algoritmos
    private ConfiguracaoMediaMovel configuracaoMediaMovel;
    private ConfiguracaoPerceptron configuracaoPerceptron;
    private ConfiguracaoSuavExpAjusteTendencia configuracaoSuavExpAjusteTendencia;
    private ConfiguracaoSuavExpSimples configuracaoSuavExpSimples;
    private ConfiguracaoSuavExpTendenciaSazonalidade configuracaoSuavExpTendenciaSazonalidade;
    private ConfiguracaoTSKNN configuracaoTSKNN;
    
    //Numero de previsões a serem feitas
    private int numPrevisoes;

    //Algoritmos selecionados
    private boolean mediaMovel;
    private boolean perceptron;
    private boolean suavExpAjusteTendencia;
    private boolean suavExpSimples;
    private boolean suavExpTendenciaSazonalidade;
    private boolean tsknn;
    
    public ConfiguracaoGeral() {
        configuracaoMediaMovel = new ConfiguracaoMediaMovel();
        configuracaoPerceptron = new ConfiguracaoPerceptron();
        configuracaoSuavExpAjusteTendencia = new ConfiguracaoSuavExpAjusteTendencia();
        configuracaoSuavExpSimples = new ConfiguracaoSuavExpSimples();
        configuracaoSuavExpTendenciaSazonalidade = new ConfiguracaoSuavExpTendenciaSazonalidade();
        configuracaoTSKNN = new ConfiguracaoTSKNN();
        
        numPrevisoes = 10;
        
        mediaMovel = false;
        perceptron = false;
        suavExpAjusteTendencia = false;
        suavExpSimples = false;
        suavExpTendenciaSazonalidade = false;
        tsknn = false;
    }

    public ConfiguracaoMediaMovel getConfiguracaoMediaMovel() {
        return configuracaoMediaMovel;
    }

    public void setConfiguracaoMediaMovel(ConfiguracaoMediaMovel configuracaoMediaMovel) {
        this.configuracaoMediaMovel = configuracaoMediaMovel;
    }

    public ConfiguracaoPerceptron getConfiguracaoPerceptron() {
        return configuracaoPerceptron;
    }

    public void setConfiguracaoPerceptron(ConfiguracaoPerceptron configuracaoPerceptron) {
        this.configuracaoPerceptron = configuracaoPerceptron;
    }

    public ConfiguracaoSuavExpAjusteTendencia getConfiguracaoSuavExpAjusteTendencia() {
        return configuracaoSuavExpAjusteTendencia;
    }

    public void setConfiguracaoSuavExpAjusteTendencia(ConfiguracaoSuavExpAjusteTendencia configuracaoSuavExpAjusteTendencia) {
        this.configuracaoSuavExpAjusteTendencia = configuracaoSuavExpAjusteTendencia;
    }

    public ConfiguracaoSuavExpSimples getConfiguracaoSuavExpSimples() {
        return configuracaoSuavExpSimples;
    }

    public void setConfiguracaoSuavExpSimples(ConfiguracaoSuavExpSimples configuracaoSuavExpSimples) {
        this.configuracaoSuavExpSimples = configuracaoSuavExpSimples;
    }

    public ConfiguracaoSuavExpTendenciaSazonalidade getConfiguracaoSuavExpTendenciaSazonalidade() {
        return configuracaoSuavExpTendenciaSazonalidade;
    }

    public void setConfiguracaoSuavExpTendenciaSazonalidade(ConfiguracaoSuavExpTendenciaSazonalidade configuracaoSuavExpTendenciaSazonalidade) {
        this.configuracaoSuavExpTendenciaSazonalidade = configuracaoSuavExpTendenciaSazonalidade;
    }

    public ConfiguracaoTSKNN getConfiguracaoTSKNN() {
        return configuracaoTSKNN;
    }

    public void setConfiguracaoTSKNN(ConfiguracaoTSKNN configuracaoTSKNN) {
        this.configuracaoTSKNN = configuracaoTSKNN;
    }

    public int getNumPrevisoes() {
        return numPrevisoes;
    }

    public void setNumPrevisoes(int numPrevisoes) {
        this.numPrevisoes = numPrevisoes;
    }

    public boolean isMediaMovel() {
        return mediaMovel;
    }

    public void setMediaMovel(boolean mediaMovel) {
        this.mediaMovel = mediaMovel;
    }

    public boolean isPerceptron() {
        return perceptron;
    }

    public void setPerceptron(boolean perceptron) {
        this.perceptron = perceptron;
    }

    public boolean isSuavExpAjusteTendencia() {
        return suavExpAjusteTendencia;
    }

    public void setSuavExpAjusteTendencia(boolean suavExpAjusteTendencia) {
        this.suavExpAjusteTendencia = suavExpAjusteTendencia;
    }

    public boolean isSuavExpSimples() {
        return suavExpSimples;
    }

    public void setSuavExpSimples(boolean suavExpSimples) {
        this.suavExpSimples = suavExpSimples;
    }

    public boolean isSuavExpTendenciaSazonalidade() {
        return suavExpTendenciaSazonalidade;
    }

    public void setSuavExpTendenciaSazonalidade(boolean suavExpTendenciaSazonalidade) {
        this.suavExpTendenciaSazonalidade = suavExpTendenciaSazonalidade;
    }

    public boolean isTsknn() {
        return tsknn;
    }

    public void setTsknn(boolean tsknn) {
        this.tsknn = tsknn;
    }
    
    
    
}

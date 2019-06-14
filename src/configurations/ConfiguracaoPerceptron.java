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
public class ConfiguracaoPerceptron {
    
    private double learningRate;
    private double difMediaMin;
    private int numMaxIteracoes;
    private int tamanhoJanela;

    public ConfiguracaoPerceptron(double learningRate, double difMediaMin, int numMaxIteracoes, int tamanhoJanela) {
        this.learningRate = learningRate;
        this.difMediaMin = difMediaMin;
        this.numMaxIteracoes = numMaxIteracoes;
        this.tamanhoJanela = tamanhoJanela;
    }

    public ConfiguracaoPerceptron() {
        this.learningRate = 0.01;
        this.difMediaMin = 0.0001;
        this.numMaxIteracoes = 1000;
        this.tamanhoJanela = 10;
    }

    public int getTamanhoJanela() {
        return tamanhoJanela;
    }

    public void setTamanhoJanela(int tamanhoJanela) {
        this.tamanhoJanela = tamanhoJanela;
    }
    
    public double getLearningRate() {
        return learningRate;
    }

    public void setLearningRate(double learningRate) {
        this.learningRate = learningRate;
    }

    public double getDifMediaMin() {
        return difMediaMin;
    }

    public void setDifMediaMin(double difMediaMin) {
        this.difMediaMin = difMediaMin;
    }

    public int getNumMaxIteracoes() {
        return numMaxIteracoes;
    }

    public void setNumMaxIteracoes(int numMaxIteracoes) {
        this.numMaxIteracoes = numMaxIteracoes;
    }
    
    
    
}

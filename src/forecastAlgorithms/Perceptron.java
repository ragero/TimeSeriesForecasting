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
public class Perceptron extends Preditor{

    private int tamJanela;
    private double taxaAprendizado;
    private int numMaxIteracoes;
    private double difMinima;
    
    public Perceptron() {
        super("Perceptron");
        this.tamJanela = 10;
        this.taxaAprendizado = 0.00000000001;
        this.numMaxIteracoes = 100000;
        this.difMinima = 0.0001;
    }

    @Override
    public double prever(List<Item> serie) {
        
        double[][] treino = new double[serie.size() - tamJanela][tamJanela + 1]; // Sempre a última posição do vetor será o valor alvo (valor a ser predito)
        
        //Criando dados de treino
        for(int id=0;id<(serie.size() - tamJanela);id++){
            List<Item> subSerie = serie.subList(id, id + tamJanela);
            for(int id2=0;id2<subSerie.size();id2++){
                treino[id][id2] = subSerie.get(id2).getValor();
            }
            treino[id][tamJanela] = serie.get(id + tamJanela).getValor();
        }
        
        
        
        //Padronizando a treino
        int tamData = tamJanela+1;
        double[] max = new double[tamData];
        for(int atr=0;atr<tamData;atr++){
            double maxAtr = Double.MIN_VALUE * -1;
            for(int id=0;id<treino.length;id++){
                if(treino[id][atr] > maxAtr){
                    maxAtr = treino[id][atr];
                }
            }
            max[atr]= maxAtr;
            for(int id=0;id<treino.length;id++){
                treino[id][atr] = treino[id][atr]/maxAtr;
            }
        }
        
        
        double[] ws = new double[tamJanela + 1];
        
        boolean sair = false;
        int numIteracoes = 1;
        while(sair == false){
            double acmErro = 0;
            double erro;
            for(int id=0;id<treino.length;id++){
                double acmValor = 0;
                for(int atr=0;atr<tamJanela;atr++){
                    acmValor += treino[id][atr]*ws[atr];
                }
                acmValor += 1*ws[tamJanela];
                
                erro = treino[id][tamJanela] - acmValor;
                for(int atr=0;atr<tamJanela;atr++){
                    ws[atr] = ws[atr] + taxaAprendizado * erro * treino[id][atr];
                }
                ws[tamJanela] = ws[tamJanela] + taxaAprendizado * erro;
                acmErro += Math.abs(erro);
                
            }
            
            acmErro = acmErro / treino.length;
            
            System.out.println("ACMERRO: " + acmErro);
            
            if(acmErro < difMinima){
                sair = true;
            }
                
            numIteracoes++;
            if(numIteracoes == numMaxIteracoes){
                sair = true;
            }
        }
        
        //Calculando o valor da predição 
        
        List<Item> subSerieConsulta = serie.subList(serie.size()- tamJanela, serie.size());
        double predicao = 0;
        double soma = 0;
        for(int atr=0;atr<subSerieConsulta.size();atr++){
            predicao += subSerieConsulta.get(atr).getValor()/max[atr] *ws[atr];
        }
        predicao += 1*ws[tamJanela];
        
        return predicao * max[tamData-1] ;
    }

    @Override
    public String toString() {
        return this.getNomePreditor() + " - Taxa Aprendizado: " + taxaAprendizado + " - Tamanho Janela: " + tamJanela;
    }
    
    public int getTamJanela() {
        return tamJanela;
    }

    public void setTamJanela(int tamJanela) {
        this.tamJanela = tamJanela;
    }
    
    
    public double getTaxaAprendizado() {
        return taxaAprendizado;
    }

    public void setTaxaAprendizado(double taxaAprendizado) {
        this.taxaAprendizado = taxaAprendizado;
    }

    public int getNumMaxIteracoes() {
        return numMaxIteracoes;
    }

    public void setNumMaxIteracoes(int numMaxIteracoes) {
        this.numMaxIteracoes = numMaxIteracoes;
    }

    public double getDifMinima() {
        return difMinima;
    }

    public void setDifMinima(double difMinima) {
        this.difMinima = difMinima;
    }
}

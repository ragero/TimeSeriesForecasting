/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forecastAlgorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import structures.IndiceProximidade;
import structures.Item;

/**
 *
 * @author rafael
 */
public class TSKNN extends Preditor{
    
    // Parâmetros referentes ao TSKNN
    private int k;
    private int tamConsulta;
    
    // Parâmetros referentes à distância Euclidiana
    private boolean euclidiana;
    private boolean pearson;
    private boolean spearman;

    //Parâmetros referentes ao cálculo da predição
    private boolean media;
    private boolean variacaoMedia;
    private boolean variacaoRelativa;
    
    
    public TSKNN(){
        super("TSKNN");
    }

    @Override
    public double prever(List<Item> serie) {
        
        ArrayList<IndiceProximidade> proximidades = new ArrayList<IndiceProximidade>();
        
        List<Item> subSerieConsulta = serie.subList(serie.size()- tamConsulta, serie.size());
        List<Item> subSeriePesquisa = serie.subList(0, serie.size()- tamConsulta);
        
        for(int id=0;id<subSeriePesquisa.size()-tamConsulta;id++){
            List<Item> subSerie = subSeriePesquisa.subList(id, id+tamConsulta);
            double sim = 0;
            if(spearman){
                sim = calculaSimilaridadeSpearman(subSerie, subSerieConsulta);
            }else if(pearson){
                sim = calculaSimilaridadePearson(subSerie, subSerieConsulta);
            }else{
                sim = calculaSimilaridadeEuclideana(subSerie, subSerieConsulta);
            }
            
            proximidades.add(new IndiceProximidade(id,sim));
        }
        
        
        Collections.sort(proximidades);
        
        double acumula = 0;
        
        if(media){
            for(int id=0;id<k;id++){
                int idK = proximidades.get(id).getIndice();
                acumula += serie.get(idK + tamConsulta).getValor();
            }    
            acumula = acumula / k;
            return acumula;
        }else if(variacaoMedia){
            for(int id=0;id<k;id++){
                int idK = proximidades.get(id).getIndice();
                acumula += serie.get(idK + tamConsulta).getValor() - serie.get(idK + tamConsulta -1).getValor();
            }
            acumula = acumula / k;
            return serie.get(serie.size() - 1).getValor() + acumula;
        }else{
            for(int id=0;id<k;id++){
                int idK = proximidades.get(id).getIndice();
                acumula += (serie.get(idK + tamConsulta).getValor() - serie.get(idK + tamConsulta-1).getValor()) / serie.get(idK + tamConsulta-1).getValor();
            }
            acumula = acumula / k;    
            return (serie.get(serie.size() - 1).getValor() + (serie.get(serie.size() - 1).getValor() * acumula));
        }
        
            
    }
    
    
    public double calculaSimilaridadeSpearman(List<Item> subSerie, List<Item>subSerieConsulta){
    
        List<Item> rankingSubSerie = new ArrayList<Item>(subSerie);
        List<Item> rankingSubSerieConsulta = new ArrayList<Item>(subSerieConsulta);
        
        //Collections.copy(rankingSubSerie, subSerie);
        //Collections.copy(rankingSubSerieConsulta, subSerieConsulta);
        
        Collections.sort(rankingSubSerie);
        Collections.sort(rankingSubSerieConsulta);
        
        double[] vetorRankingSubSerie = new double[subSerie.size()];
        double[] vetorRankingSubSerieConsulta = new double[subSerie.size()];
        
        for(int id=0;id<subSerie.size();id++){
            vetorRankingSubSerie[id] = rankingSubSerie.indexOf(subSerie.get(id));
            vetorRankingSubSerieConsulta[id] = rankingSubSerieConsulta.indexOf(subSerieConsulta.get(id));
        }
        
        
        double correlacao = 0;
        for(int id=0;id<subSerie.size();id++){
            correlacao += Math.pow((vetorRankingSubSerie[id] - vetorRankingSubSerieConsulta[id]), 2);
        }
        
        correlacao = correlacao / (subSerie.size() * (Math.pow(subSerie.size() - 1, 2)));
        correlacao = 1 - correlacao;
        
        return correlacao;
    }
    
    public double calculaSimilaridadePearson(List<Item> subSerie, List<Item>subSerieConsulta){
        double mediaSubSerie = 0;
        double mediaSubSerieConsulta = 0;
        
        //Calculando a média das Subseries
        for(int id=0;id<subSerie.size();id++){
            mediaSubSerie += subSerie.get(id).getValor();
            mediaSubSerieConsulta += subSerieConsulta.get(id).getValor();
        }
        
        mediaSubSerie = mediaSubSerie/subSerie.size();
        mediaSubSerieConsulta = mediaSubSerieConsulta/subSerieConsulta.size();
        
        double correlacao = 0;
        double normaSubSerie = 0;
        double normaSubSerieConsulta = 0;
        
        for(int id=0;id<subSerie.size();id++){
            correlacao += (subSerie.get(id).getValor() - mediaSubSerie) * (subSerieConsulta.get(id).getValor() - mediaSubSerieConsulta);
            normaSubSerie += Math.pow((subSerie.get(id).getValor() - mediaSubSerie),2);
            normaSubSerieConsulta += Math.pow((subSerieConsulta.get(id).getValor() - mediaSubSerieConsulta),2);
        }
        normaSubSerie = Math.sqrt(normaSubSerie);
        normaSubSerieConsulta = Math.sqrt(normaSubSerieConsulta);
        
        correlacao = correlacao / (normaSubSerie * normaSubSerieConsulta);
        
        return correlacao;
    }

    public double calculaSimilaridadeEuclideana(List<Item> subSerie, List<Item>subSerieConsulta){
        double dist = 0;
        
        //Calculando a média das Subseries
        for(int id=0;id<subSerie.size();id++){
            dist += Math.pow((subSerie.get(id).getValor() - subSerieConsulta.get(id).getValor()), 2);
        }
        
        dist = Math.sqrt(dist);
        
        //"invertendo" a distância já que ordeno do maior valor para o menor valor e, no caso da distância euclideana, quanto menor o valor, mais próximas são as subséries
        if(dist == 0){
            dist = 0.0000000000001;
        }
        return 1/dist;
    }
    
    @Override
    public String toString() {
        String medida = "";
        if(pearson){
            medida = "Pearson";
        }else if(spearman){
            medida = "Spearman";
        }else{
            medida = "Euclideana";
        }
        
        String tipoPrevisao = "";
        if(media){
            tipoPrevisao = "Média";
        }else if(variacaoMedia){
            tipoPrevisao = "Variação Média";
        }else if(variacaoRelativa){
            tipoPrevisao = "Variação Média Relativa";
        }
        
        return this.getNomePreditor() + " - " + medida +  " - " + tipoPrevisao  + " - K: " + " - TamConsulta: " + this.tamConsulta;
    }
    
    public int getK() {
        return k;
    }

    public void setK(int k) {
        this.k = k;
    }
  
    public int getTamConsulta() {
        return tamConsulta;
    }

    public void setTamConsulta(int tamConsulta) {
        this.tamConsulta = tamConsulta;
    }
    
    public boolean isEuclidiana() {
        return euclidiana;
    }

    public void setEuclidiana(boolean euclidiana) {
        this.euclidiana = euclidiana;
    }

    public boolean isPearson() {
        return pearson;
    }

    public void setPearson(boolean pearson) {
        this.pearson = pearson;
    }

    public boolean isSpearman() {
        return spearman;
    }

    public void setSpearman(boolean spearman) {
        this.spearman = spearman;
    }

    public boolean isMedia() {
        return media;
    }

    public void setMedia(boolean media) {
        this.media = media;
    }

    public boolean isVariacaoMedia() {
        return variacaoMedia;
    }

    public void setVariacaoMedia(boolean variacaoMedia) {
        this.variacaoMedia = variacaoMedia;
    }

    public boolean isVariacaoRelativa() {
        return variacaoRelativa;
    }

    public void setVariacaoRelativa(boolean variacaoRelativa) {
        this.variacaoRelativa = variacaoRelativa;
    }
}

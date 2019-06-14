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
public class ConfiguracaoTSKNN {
    
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

    public ConfiguracaoTSKNN(int k, int tamConsulta, boolean euclidiana, boolean pearson, boolean spearman, boolean media, boolean variacaoMedia, boolean variacaoRelativa) {
        this.k = k;
        this.tamConsulta = tamConsulta;
        this.euclidiana = euclidiana;
        this.pearson = pearson;
        this.spearman = spearman;
        this.media = media;
        this.variacaoMedia = variacaoMedia;
        this.variacaoRelativa = variacaoRelativa;
    }

    public ConfiguracaoTSKNN() {
        this.k = 5;
        this.tamConsulta = 5;
        this.euclidiana = false;
        this.pearson = false;
        this.spearman = true;
        this.media = false;
        this.variacaoMedia = true;
        this.variacaoRelativa = false;
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
    
    
    
}

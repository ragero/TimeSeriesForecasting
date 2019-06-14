/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package previsao;

import configurations.ConfiguracaoGeral;
import configurations.ConfiguracaoMediaMovel;
import configurations.ConfiguracaoPerceptron;
import configurations.ConfiguracaoSuavExpAjusteTendencia;
import configurations.ConfiguracaoSuavExpSimples;
import configurations.ConfiguracaoSuavExpTendenciaSazonalidade;
import configurations.ConfiguracaoTSKNN;
import forecastAlgorithms.MediaMovel;
import forecastAlgorithms.Perceptron;
import forecastAlgorithms.Preditor;
import forecastAlgorithms.SuavExpAjusteTendendia;
import forecastAlgorithms.SuavExpSimples;
import forecastAlgorithms.SuavExpTendenciaSazonalidade;
import forecastAlgorithms.TSKNN;
import formularios.FormularioPlotagemSeries;
import formularios.FormularioResultados;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.jfree.data.time.Month;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import structures.Avaliacao;
import structures.Item;

/**
 *
 * @author rafael
 */
public class Previsao {
    
    public void prever(ConfiguracaoGeral configuracao){
        
        if(configuracao.isMediaMovel()){
            MediaMovel preditor = new MediaMovel();
            ConfiguracaoMediaMovel config = configuracao.getConfiguracaoMediaMovel();
            preditor.setTamJanela(config.getTamanhoJanela());
            avaliar(preditor,configuracao);
        }
        if(configuracao.isSuavExpSimples()){
            SuavExpSimples preditor = new SuavExpSimples();
            ConfiguracaoSuavExpSimples config = configuracao.getConfiguracaoSuavExpSimples();
            preditor.setAlpha(config.getAlpha());
            avaliar(preditor,configuracao);
        }
        if(configuracao.isSuavExpAjusteTendencia()){
            SuavExpAjusteTendendia preditor = new SuavExpAjusteTendendia();
            ConfiguracaoSuavExpAjusteTendencia config = configuracao.getConfiguracaoSuavExpAjusteTendencia();
            preditor.setAlpha(config.getAlpha());
            preditor.setBeta(config.getBeta());
            avaliar(preditor,configuracao);
        }
        if(configuracao.isSuavExpTendenciaSazonalidade()){
            SuavExpTendenciaSazonalidade preditor = new SuavExpTendenciaSazonalidade();
            ConfiguracaoSuavExpTendenciaSazonalidade config = configuracao.getConfiguracaoSuavExpTendenciaSazonalidade();
            preditor.setAlpha(config.getAlpha());
            preditor.setBeta(config.getBeta());
            preditor.setGamma(config.getGamma());
            preditor.setSazonality(config.getL());
            avaliar(preditor,configuracao);
        }
        if(configuracao.isTsknn()){
            TSKNN preditor = new TSKNN();
            ConfiguracaoTSKNN config = configuracao.getConfiguracaoTSKNN();
            preditor.setK(config.getK());
            preditor.setTamConsulta(config.getTamConsulta());
            preditor.setMedia(config.isMedia());
            preditor.setVariacaoMedia(config.isVariacaoMedia());
            preditor.setVariacaoRelativa(config.isVariacaoRelativa());
            preditor.setSpearman(config.isSpearman());
            preditor.setPearson(config.isPearson());
            preditor.setEuclidiana(config.isEuclidiana());
            avaliar(preditor,configuracao);
        }
        if(configuracao.isPerceptron()){
            Perceptron preditor = new Perceptron();
            ConfiguracaoPerceptron config = configuracao.getConfiguracaoPerceptron();
            preditor.setDifMinima(config.getDifMediaMin());
            preditor.setNumMaxIteracoes(config.getNumMaxIteracoes());
            preditor.setTamJanela(config.getTamanhoJanela());
            preditor.setTaxaAprendizado(config.getLearningRate());
            avaliar(preditor,configuracao);
        }
        
    } 
    
    public void avaliar(Preditor preditor, ConfiguracaoGeral configuracao){
        int numPrevisoes = configuracao.getNumPrevisoes();
        ArrayList<Item> serieReferencia = FormularioPlotagemSeries.getSerieReferencia();
        int numItens = serieReferencia.size();
        
        int iniPrev = numItens - numPrevisoes;
        if(iniPrev <= 0){
            JOptionPane.showMessageDialog(null, "Não é possível realizar a previsao");
            return;
        }
        
        ArrayList<Avaliacao> avaliacoes = new ArrayList<Avaliacao>();
        String nomePreditor = preditor.toString() + " - #Prev: " + numPrevisoes;
        TimeSeries s2 = new TimeSeries(nomePreditor, Day.class);
        
        for(int prev=iniPrev;prev<numItens;prev++){
            
            double valorPredito = preditor.prever(serieReferencia.subList(0, prev));
            avaliacoes.add(new Avaliacao(serieReferencia.get(prev).getValor(),valorPredito));
            s2.add(new Day(serieReferencia.get(prev).getData().getDayOfMonth(),serieReferencia.get(prev).getData().getMonthOfYear(),serieReferencia.get(prev).getData().getYear()), valorPredito);
        }
        
        FormularioPlotagemSeries.getDataset().addSeries(s2);
        
        medidasAvaliacao(nomePreditor, avaliacoes);
    }
    
    public void medidasAvaliacao(String nomePreditor, ArrayList<Avaliacao> avaliacoes){
        
        int numPredicoes = avaliacoes.size();
        
        double me = 0; // ME - Mean Error - Erro Médio
        double mpe = 0; // MPE - Mean Percentual Error - Erro Médio Percentual
        double mad = 0; // MAD - Mean Absolute Desviation - Desvio Médio Absoluto
        double mape = 0; // MAPE - Mean Absolute Percentage Error - Erro Percentual Médio Absoluto
        double mse = 0; // MSE - Mean Squared Error - Erro Médio Quadrático
        double sde = 0; // SDE - Standar Deviation of Errors - SDE
        
        for(Avaliacao aval : avaliacoes){
            double diferenca = aval.getValorReal() - aval.getValorPredito();
            
            me += diferenca;
            mpe += diferenca / aval.getValorReal();
            mad += Math.abs(diferenca);
            mape += Math.abs(diferenca) / aval.getValorReal();
            mse += Math.pow(diferenca,2);
            sde += Math.pow(diferenca,2);
        }
        
        me = me / numPredicoes;
        mpe = mpe / numPredicoes;
        mad = mad / numPredicoes;
        mape = mape / numPredicoes;
        mse = mse / numPredicoes;
        sde = Math.sqrt(sde / numPredicoes);
        
        FormularioResultados.getTResultados().append(nomePreditor + " =========================\n");
        FormularioResultados.getTResultados().append("ME = " + me + "\n");
        FormularioResultados.getTResultados().append("MPE = " + mpe + "\n");
        FormularioResultados.getTResultados().append("MAD = " + mad + "\n");
        FormularioResultados.getTResultados().append("MAPE = " + mape + "\n");
        FormularioResultados.getTResultados().append("MSE = " + mse + "\n");
        FormularioResultados.getTResultados().append("SDE = " + sde + "\n");
        FormularioResultados.getTResultados().append("\n\n");
        
    }
    
}

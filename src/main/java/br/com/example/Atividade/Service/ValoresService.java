package br.com.example.Atividade.Service;


import br.com.example.Atividade.DTO.Valores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class ValoresService {

    public void insercao(List<Double> listValores){

        Assert.isTrue(!listValores.isEmpty(), "Valores não encontrados");
        Assert.isTrue(!(listValores.size() < 20), "A lista não tem a quantidade de valores necessarios");

        listValores.forEach( i -> {
            Assert.isTrue(!i.isNaN(), "Existe algum valor que não é um numero");
        });

    }

    public Double media(List<Double> listValores){

        Double soma = 0.0;
        Double media = 0.0;

        for(Double i : listValores){
            soma += i;
        }

        media = soma/listValores.size();

        return media;
    }

    public Double desvioPadrao(List<Double> listValores, Double media){

        Double soma = 0.0;

        Double desvioPadrao = 0.0;

        for (Double i : listValores){
            soma += (i - media) * (i - media);
        }

        desvioPadrao = Math.sqrt(soma/listValores.size());

        return desvioPadrao;
    }

    public int quantValores(List<Double> listValores){
        return listValores.size();
    }

    public Double mediana(List<Double> listValores){
        int tamanho = listValores.size();

        listValores.sort(null);

        if (tamanho % 2 == 0){
            int meioUm = tamanho / 2;
            int meioDois = meioUm - 1;

            return (listValores.get(meioUm) + listValores.get(meioDois)) / 2;
        } else {
            return listValores.get(tamanho/2);
        }
    }
}

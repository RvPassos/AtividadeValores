package br.com.example.Atividade.DTO;


import java.util.List;


public class Valores {
    private List<Double> ListValores;

    public Valores(){
    }

    public List<Double> getListValores() {
        return ListValores;
    }


    public void setListValores(List<Double> listValores) {
        ListValores = listValores;
    }

    public Valores(List<Double> valores){
        this.ListValores = valores;
    }
}

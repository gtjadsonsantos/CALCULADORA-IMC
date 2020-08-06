package br.sc.senac.models;

public class Imc {
    private double weight;
    private double heigth;

    public Imc(){}
    
    public Imc(double weight, double heigth) {
        this.weight = weight;
        this.heigth = heigth;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeigth() {
        return heigth;
    }

    public void setHeigth(double heigth) {
        this.heigth = heigth;
    }

}
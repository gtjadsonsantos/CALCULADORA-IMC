package br.sc.senac.controllers;

import br.sc.senac.models.Imc;

public class ControllerImc {

    public double calculateImc(Imc imc) {

        double result = imc.getWeight() / (imc.getHeigth() * imc.getHeigth());

        return result;
    }
}
package com.teste.java;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.teste.java.controller.Main;
import com.teste.java.modal.Funcao;
import com.teste.java.modal.Funcionario;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     * @throws ParseException
     */
    public static void main(String[] args) throws ParseException {
        Main main = new Main();
        String mesAno = "04/2022";

        List<Funcionario> funcionarios = new ArrayList<Funcionario>();

        funcionarios.add(new Funcionario("Ana Silva", new Funcao("Vendedor",  12000.00), "12/2021"));
        funcionarios.add(new Funcionario("Jorge Carvalho", new Funcao("Secretário",  7000.00), "01/2018"));
        funcionarios.add(new Funcionario("Bento Albino", new Funcao("Gerente",  20000.00), "03/2014"));

        main.valorTotalPagoSalarioBeneficio(funcionarios, mesAno);
        main.valorTotalPagoSalario(funcionarios, mesAno);
        main.valorTotalPagoBeneficio(funcionarios, mesAno);
        main.valorMaisAltoNoMes(funcionarios, mesAno);
        main.valorMaisAltoBeneficioNoMes(funcionarios, mesAno);
        main.maisVendeuNoMes(funcionarios, mesAno);
    }
}

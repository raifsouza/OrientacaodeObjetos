package com.teste.java.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import com.teste.java.modal.Funcionario;
import com.teste.java.modal.Venda;
import com.teste.java.modal.Funcao;

public class Main {

    public void valorTotalPagoSalarioBeneficio(List<Funcionario> funcionarios, String mesAno) throws ParseException {
        System.out.println("\n------------------------------------- Valor Total Pago (Salario + Beneficio) ------------------------------------");
        for(Funcionario funcionario: funcionarios){
            funcionario.BonificacaoSalario(mesAno);
            funcionario.BonificacaoBeneficio(mesAno);
            Double totalPago = funcionario.getSalario() + funcionario.getBeneficio();

            System.out.println("O total pago para o funcionário: "+funcionario.getNome()+" no mês "+ mesAno+ " foi de: R$ "+ totalPago);
        }
        System.out.println("-----------------------------------------------------------------------------------------------------------------\n");
    }

    public void valorTotalPagoSalario(List<Funcionario> funcionarios, String mesAno) throws ParseException {
        System.out.println("------------------------------------- Valor Total Pago Salario ------------------------------------");
        for(Funcionario funcionario: funcionarios){
            funcionario.BonificacaoSalario(mesAno);

            System.out.println("O total pago para o funcionário: "+funcionario.getNome()+" no mês "+ mesAno+ " foi de: R$ "+ funcionario.getSalario());
        }
        System.out.println("---------------------------------------------------------------------------------------------------\n");
    }

    public void valorTotalPagoBeneficio(List<Funcionario> funcionarios, String mesAno) throws ParseException {
        System.out.println("------------------------------------- Valor Total Pago Beneficio ------------------------------------");
        for(Funcionario funcionario: funcionarios){
            if (!funcionario.getFuncao().getCargo().equals("Gerente")) {
                funcionario.BonificacaoSalario(mesAno);

                System.out.println("O total pago para o funcionário: "+funcionario.getNome()+" no mês "+ mesAno+ " foi de: R$ "+ funcionario.getBeneficio());
            }
        }
        System.out.println("---------------------------------------------------------------------------------------------------\n");
    }

    public void valorMaisAltoNoMes(List<Funcionario> funcionarios, String mesAno) throws ParseException {
        System.out.println("------------------------------------- Valor Mais Alto no Mes ------------------------------------");

        Double maiorSalario = 0.0;
        String nome = null;

        for(Funcionario funcionario: funcionarios){
            funcionario.BonificacaoSalario(mesAno);
            Double totalPago = funcionario.getSalario() + funcionario.getBeneficio();

            if(totalPago > maiorSalario) {
                maiorSalario = totalPago;
                nome = funcionario.getNome();
            }

        }

        System.out.println("O funcionário que recebeu o valor mais alto no mês "+mesAno+ " foi: "+ nome);

        System.out.println("---------------------------------------------------------------------------------------------------\n");
    }

    public void valorMaisAltoBeneficioNoMes(List<Funcionario> funcionarios, String mesAno) throws ParseException {
        System.out.println("------------------------------------- Valor Mais Alto no Mes ------------------------------------");

        Double maiorBeneficio = 0.0;
        String nome = null;

        for(Funcionario funcionario: funcionarios){
            if (!funcionario.getFuncao().getCargo().equals("Gerente")) {
                funcionario.BonificacaoSalario(mesAno);

                if(funcionario.getBeneficio() > maiorBeneficio) {
                    maiorBeneficio = funcionario.getBeneficio();
                    nome = funcionario.getNome();
                }
            }
        }

        System.out.println("O funcionário que recebeu o valor mais alto no mês "+mesAno+ " foi: "+ nome);

        System.out.println("---------------------------------------------------------------------------------------------------\n");
    }

    public void maisVendeuNoMes(List<Funcionario> funcionarios, String mesAno) throws ParseException {
        System.out.println("------------------------------------- Valor Mais Alto no Mes ------------------------------------");

        List<Venda> vendas = new ArrayList<Venda>();
        String vendedor = null;
        Double vendeuMais = 0.0;

        vendas.add(new Venda(new Funcionario("Ana Silva", new Funcao("Vendedor",  12000.00), "12/2021"), "12/2021", 5200.00));
        vendas.add(new Venda(new Funcionario("João Mendes ", new Funcao("Vendedor",  12000.00), "12/2021"), "12/2021", 3400.00));

        vendas.add(new Venda(new Funcionario("Ana Silva", new Funcao("Vendedor",  12000.00), "12/2021"), "01/2022", 4000.00));
        vendas.add(new Venda(new Funcionario("João Mendes ", new Funcao("Vendedor",  12000.00), "12/2021"), "01/2022", 7700.00));

        vendas.add(new Venda(new Funcionario("Ana Silva", new Funcao("Vendedor",  12000.00), "12/2021"), "02/2022", 4200.00));
        vendas.add(new Venda(new Funcionario("João Mendes ", new Funcao("Vendedor",  12000.00), "12/2021"), "02/2022", 5000.00));

        vendas.add(new Venda(new Funcionario("Ana Silva", new Funcao("Vendedor",  12000.00), "12/2021"), "03/2022", 5850.00));
        vendas.add(new Venda(new Funcionario("João Mendes ", new Funcao("Vendedor",  12000.00), "12/2021"), "03/2022", 5900.00));

        vendas.add(new Venda(new Funcionario("Ana Silva", new Funcao("Vendedor",  12000.00), "12/2021"), "04/2022", 7000.00));
        vendas.add(new Venda(new Funcionario("João Mendes ", new Funcao("Vendedor",  12000.00), "12/2021"), "04/2022", 6500.00));

        for(Funcionario funcionario: funcionarios){
            if(funcionario.getFuncao().getCargo().equals("Vendedor")) {
                for(Venda venda: vendas) {
                    if(venda.getMesAno().equals(mesAno) && venda.getVendido() > vendeuMais) {
                        vendedor = funcionario.getNome();
                    }
                }
            }
        }

        System.out.println("O vendedor que mais vendeu no mês "+mesAno+ " foi: "+ vendedor);

        System.out.println("---------------------------------------------------------------------------------------------------\n");

    }

}

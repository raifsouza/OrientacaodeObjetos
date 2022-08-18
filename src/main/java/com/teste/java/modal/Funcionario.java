package com.teste.java.modal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Funcionario {
    String nome;
    Funcao funcao;
    String mesAnoContratacao;
    Double salario;
    Double beneficio;

    public Funcionario(String nome, Funcao funcao, String mesAnoContratacao) {
        this.nome = nome;
        this.funcao = funcao;
        this.mesAnoContratacao = mesAnoContratacao;
        this.salario = 0.0;
        this.beneficio = 0.0;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Funcao getFuncao() {
        return funcao;
    }
    public void setFuncao(Funcao funcao) {
        this.funcao = funcao;
    }
    public String getMesAnoContratacao() {
        return mesAnoContratacao;
    }
    public void setMesAnoContratacao(String mesAnoContratacao) {
        this.mesAnoContratacao = mesAnoContratacao;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public Double getBeneficio() {
        return beneficio;
    }

    public void setBeneficio(Double beneficio) {
        this.beneficio = beneficio;
    }

    private Long diferencaAno(String mesAno) throws ParseException{
        SimpleDateFormat myFormat = new SimpleDateFormat("MM/yyyy");

        Date date1 = myFormat.parse(mesAno);

        Date date2 = myFormat.parse(mesAnoContratacao);

        long diff = date1.getTime() - date2.getTime();

        long diffDays = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);

        long diffYears = diffDays / 365;

        return diffYears;
    }

    public void BonificacaoSalario(String mesAno) throws ParseException{
        Long diffYears = diferencaAno(mesAno);

        switch(this.funcao.getCargo()) {
            case "Secretário":
                this.salario = this.funcao.getSalario() + (diffYears * 1000);
                break;
            case "Vendedor":
                this.salario = this.funcao.getSalario() + (diffYears * 1800);
                break;
            case "Gerente":
                this.salario = this.funcao.getSalario() + (diffYears * 3000);
                break;
        }
    }

    public void BonificacaoBeneficio(String mesAno){
        switch(this.funcao.getCargo()) {
            case "Secretário":
                this.beneficio = this.salario * 1.2;
                break;
            case "Vendedor":
                this.beneficio = this.salario * 1.3;
                break;
        }
    }
}

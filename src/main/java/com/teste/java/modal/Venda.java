package com.teste.java.modal;

public class Venda {
    Funcionario funcionario;
    String mesAno;
    Double vendido;

    public Venda(Funcionario funcionario, String mesAno, Double vendido) {
        this.funcionario = funcionario;
        this.mesAno = mesAno;
        this.vendido = vendido;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }
    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    public String getMesAno() {
        return mesAno;
    }
    public void setMesAno(String mesAno) {
        this.mesAno = mesAno;
    }
    public Double getVendido() {
        return vendido;
    }
    public void setVendido(Double vendido) {
        this.vendido = vendido;
    }

}

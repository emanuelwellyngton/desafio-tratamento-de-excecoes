package model;

import exception.SaldoInsuficienteException;
import exception.ValorInvalidoException;

public class ContaBancaria {

    private String nomeDoTitular;
    private  long numeroDaConta;
    private double saldo;

    @Override
    public String toString() {
        return "ContaBancaria{" +
                "nomeDoTitular='" + nomeDoTitular + '\'' +
                ", numeroDaConta=" + numeroDaConta +
                ", saldo=" + saldo +
                '}';
    }

    public ContaBancaria(String nomeDoTitular, double saldo) {
        if(saldo <= 0) {
            throw new ValorInvalidoException("Valor do saldo inicial não por de menor ou igual a zero.");
        } else {
            this.nomeDoTitular = nomeDoTitular;
            this.saldo = saldo;
        }
    }

    public String getNomeDoTitular() {
        return nomeDoTitular;
    }

    public void setNomeDoTitular(String nomeDoTitular) {
        this.nomeDoTitular = nomeDoTitular;
    }

    public long getNumeroDaConta() {
        return numeroDaConta;
    }

    public void setNumeroDaConta(long numeroDaConta) {
        this.numeroDaConta = numeroDaConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        if(valor > 0) {
            this.saldo += valor;
        } else {
            throw new ValorInvalidoException("Impossível depositar valor igual ou menor que zero.");
        }
    }

    public void sacar(double valor) {
        if(valor > this.saldo) {
            throw new SaldoInsuficienteException("Saldo insuficiente para realizar saque.");
        } else {
            this.saldo -= valor;
        }
    }
}

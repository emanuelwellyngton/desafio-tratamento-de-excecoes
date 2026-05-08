package model;

import exception.SaldoInsuficienteException;
import exception.ValorInvalidoException;

import java.math.BigDecimal;

public class ContaBancaria {

    private String nomeDoTitular;
    private  long numeroDaConta;
    private BigDecimal saldo;

    @Override
    public String toString() {
        return "ContaBancaria{" +
                "nomeDoTitular='" + nomeDoTitular + '\'' +
                ", numeroDaConta=" + numeroDaConta +
                ", saldo=" + saldo +
                '}';
    }

    public ContaBancaria(String nomeDoTitular, BigDecimal saldo) {
        if(saldo.compareTo(BigDecimal.ONE) < 0) {
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

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void depositar(BigDecimal valor) {
        if(valor.compareTo(BigDecimal.ZERO) > 0) {
            this.saldo = this.saldo.add(valor);
        } else {
            throw new ValorInvalidoException("Impossível depositar valor igual ou menor que zero.");
        }
    }

    public void sacar(BigDecimal valor) {
        if(valor.compareTo(this.saldo) > 0) {
            throw new SaldoInsuficienteException("Saldo insuficiente para realizar saque.");
        } else {
            this.saldo = this.saldo.subtract(valor);
        }
    }
}

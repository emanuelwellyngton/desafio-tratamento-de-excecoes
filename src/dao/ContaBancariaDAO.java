package dao;

import exception.ContaInvalidaException;
import model.ContaBancaria;

import java.util.ArrayList;
import java.util.List;

public class ContaBancariaDAO {

    private List<ContaBancaria> contasBancarias = new ArrayList<ContaBancaria>();
    private int contador = 1;

    public ContaBancaria save(ContaBancaria contaBancaria) {
        contaBancaria.setNumeroDaConta(this.contador);
        contasBancarias.add(contaBancaria);
        contador++;
        return contaBancaria;
    }

    public ContaBancaria getAccountByNumber(int accountNumber) {
        return contasBancarias.stream().filter(
                (c) -> c.getNumeroDaConta() == accountNumber
        ).findFirst().orElseThrow(
                () -> new ContaInvalidaException("Conta não encontrada.")
        );
    }

}

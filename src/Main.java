import dao.ContaBancariaDAO;
import exception.ContaInvalidaException;
import exception.SaldoInsuficienteException;
import exception.ValorInvalidoException;
import model.ContaBancaria;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static ContaBancariaDAO dao = new ContaBancariaDAO();

    public static void main(String[] args) {

        showMenu();
        scanner.close();
    }

    public static void showMenu() {
        while (true) {
            try {
                System.out.println("Bem-vindo ao JavaBank!\nEscolha uma opção:\n");
                System.out.println("1 - Abrir conta");
                System.out.println("2 - Depósito");
                System.out.println("3 - Saque");
                System.out.println("4 - Saldo");
                System.out.println("5 - Sair");

                var option = scanner.nextInt();

                switch (option) {
                    case 1 -> promptAbrirConta();
                    case 2 -> promptDdepositar();
                    case 3 -> promptSacar();
                    case 4 -> promptSaldo();
                    case 5 -> System.exit(0);
                    default -> System.out.println("Opção inválida. Tente novamente!\n");
                }
            } catch (InputMismatchException ex) {
                System.out.println("Entrada inválida. Tente novamente!");
                scanner.nextLine();
            }
        }
    }

    public static void promptAbrirConta() {
        try {
            System.out.println("Digite o nome do titular da conta:");
            var nome = scanner.next();
            System.out.println("Digite o saldo inicial da conta:");
            var saldoInicial = scanner.nextBigDecimal();

            var contaBancaria = dao.save(new ContaBancaria(nome, saldoInicial));

            System.out.println("Conta aberta com sucesso! \n");
            System.out.println(contaBancaria);
        } catch (ValorInvalidoException ex) {
            System.out.println(ex.getMessage());
        } finally {
            promptToReturnToMenu();
        }
    }

    public static void promptDdepositar() {
       try {
           System.out.println("Digite o número da conta em que deseja realizar o depósito:");
           var numeroConta = scanner.nextInt();
           var conta = dao.getAccountByNumber(numeroConta);
           System.out.println("Digite o valor do depósito:");
           var valor = scanner.nextBigDecimal();
           conta.depositar(valor);
       } catch (ValorInvalidoException ex) {
           System.out.println(ex.getMessage());
       } finally {
           promptToReturnToMenu();
       }
    }

    public static void promptSacar() {
        try {
            System.out.println("Digite o número da conta em que deseja realizar o saque:");
            var numeroConta = scanner.nextInt();
            var conta = dao.getAccountByNumber(numeroConta);
            System.out.println("Digite o valor do saque:");
            var valor = scanner.nextBigDecimal();
            conta.sacar(valor);
            System.out.printf("Saque realizado com sucesso na conta nº %s\n", conta.getNumeroDaConta());
        } catch (SaldoInsuficienteException ex) {
            System.out.println(ex.getMessage());
        } catch (ContaInvalidaException ex) {
            System.out.println(ex.getMessage());
        } finally {
            promptToReturnToMenu();
        }
    }

    public static void promptSaldo() {
        try {
            System.out.println("Digite o número da conta que deseja verificar o saldo:");
            var numeroConta = scanner.nextInt();
            var conta = dao.getAccountByNumber(numeroConta);
            System.out.printf("O saldo atual da conta nº %s é de R$%s\n", conta.getNumeroDaConta(),
                    conta.getSaldo());
        } catch (ContaInvalidaException ex) {
            System.out.println(ex.getMessage());
        } finally {
            promptToReturnToMenu();
        }
    }

    public static void promptToReturnToMenu() {
        System.out.println("\nDigite 0 para voltar ao menu:");
        var option = 1;
        while (option != 0) {
           option = scanner.nextInt();
        }
        System.out.println();
    }

}

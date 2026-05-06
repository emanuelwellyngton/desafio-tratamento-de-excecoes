# Desafio Java — Tratamento de Exceções

## Objetivo

Desenvolver uma aplicação em **Java** que simule um pequeno sistema bancário via terminal, aplicando boas práticas de **tratamento de exceções**, validação de dados e organização de código.

---

## Contexto

Em aplicações reais, erros acontecem o tempo todo: entrada inválida, operações indevidas, dados inconsistentes e falhas de negócio.

Neste desafio, o objetivo é construir um sistema simples que lide corretamente com essas situações, utilizando exceções de forma clara, organizada e reutilizável.

---

## Funcionalidades

O sistema deve permitir:

- Criar uma conta bancária
- Realizar depósito
- Realizar saque
- Consultar saldo
- Encerrar aplicação

---

## Dados da conta

Ao criar a conta, solicitar:

- Nome do titular
- Número da conta
- Saldo inicial

---

## Regras de negócio

- O nome do titular não pode ser vazio
- O número da conta deve conter apenas números
- O saldo inicial não pode ser negativo
- O valor do depósito deve ser maior que zero
- O valor do saque deve ser maior que zero
- Não deve ser permitido sacar valor maior que o saldo disponível

---

## Exceções obrigatórias

Crie pelo menos **3 exceções personalizadas**.

Exemplos:

- `SaldoInsuficienteException`
- `ValorInvalidoException`
- `ContaInvalidaException`

---

## Requisitos técnicos

Sua solução deve utilizar:

- `try`
- `catch`
- `finally`
- `throw`
- `throws`

Também deve:

- Separar a aplicação em classes
- Organizar o código em pacotes
- Exibir mensagens amigáveis ao usuário
- **Não encerrar o programa ao ocorrer erro**
- Permitir novas operações após tratamento da exceção

---

## Estrutura sugerida

```text
src/
 ├── app/
 │    └── Main.java
 ├── model/
 │    └── ContaBancaria.java
 └── exceptions/
      ├── SaldoInsuficienteException.java
      ├── ValorInvalidoException.java
      └── ContaInvalidaException.java

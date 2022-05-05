package br.com.serratec.entidades;

import java.util.Scanner;

import br.com.serratec.excecoes.DocumentoInvalido;
import br.com.serratec.excecoes.jaContemSeguroException;
import br.com.serratec.excecoes.valorInvalidoException;

// A formatação dessa classe não ficou muito boa. Sugiro sempre rodar um ctrl+shift+f para melhorar a legibilidade
public class Cliente extends Usuario {

    private double ValorSeguro;
    private boolean seguroDeVida;

    public Cliente(String nome, String cpf, String senha) throws DocumentoInvalido {
        super(nome, cpf, senha);
    }

    public boolean ContemSegurodeVida() {
        return seguroDeVida;
    }

    @Override
    public String toString() {
        if (ValorSeguro > 0.0) {
            return "Cliente [ nome=" + nome + ", cpf=" + cpf + ", Valor do Seguro de Vida= " + ValorSeguro + " ]";
        } else {
            return "Cliente [ nome=" + nome + ", cpf=" + cpf + "]";
        }
    }

    public double getValorSeguro() {
        return ValorSeguro;
    }

    public void ContrataSeguro(Conta conta, Scanner leitor) throws valorInvalidoException, jaContemSeguroException {
        do {
            try {
                if (conta.getSaldo() == 0) {
                    System.out.println("Seu saldo é insuficiente!");
                    break;
                }
                System.out.println("Insira o valor do seguro de vida:");
                double valorInseridoSeguro = leitor.nextDouble();
                leitor.nextLine();
                valorInseridoSeguro = valorInseridoSeguro * 0.8;
                if (valorInseridoSeguro <= 0 || valorInseridoSeguro > conta.getSaldo()) {
                    throw new valorInvalidoException();
                } else if (this.ContemSegurodeVida() == true) {
                    throw new jaContemSeguroException();
                }
                this.ValorSeguro = valorInseridoSeguro;
                conta.setSeguro(valorInseridoSeguro);
                this.seguroDeVida = true;
                System.out.println("Seguro de vida contratado no valor de R$" + valorInseridoSeguro);

            } catch (valorInvalidoException e) {
                System.out.println(e.getMessage());
            } catch (jaContemSeguroException e) {
                System.out.println(e.getMessage());
            }
        } while (ContemSegurodeVida() == false);
    }
}
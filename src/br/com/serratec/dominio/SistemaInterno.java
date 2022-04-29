package br.com.serratec.dominio;

import java.util.InputMismatchException;
import java.util.Scanner;

import br.com.serratec.entidades.Conta;

public class SistemaInterno {
	
	public static void main(String[] args) {	
		Scanner leitor = new Scanner(System.in);
		//Fazer parte de login
		//Passar conta para o menu para que sejam chamados os metodos do menu
	}
	
	public static void mostraMenuInicial(Scanner leitor) {
		int opcao = leitorOpcao(leitor, 2, "1 - Movimentações na conta" + "\n2 - Relatórios" + "\n0 - Sair" + "\nInsira sua escolha: ");

		switch (opcao) {
		case 1:
			mostraMenuMovimentacao(leitor);//adicionar conta
			break;
		case 2:
			mostraMenuRelatorio(leitor);//adicionar conta
			break;
		default:
			System.out.println("Sair");
			System.exit(0);
		}
	}
	
	public static void mostraMenuMovimentacao(Scanner leitor, Conta conta) {
		int opcao = leitorOpcao(leitor, 3, "1 - Saque" + "\n2 - Depósito" + "\n3 - Transfêrencia" + "\n0 - Sair" + "\nInsira sua escolha: ");

		switch (opcao) {
		case 1:
			conta.sacar()
			break;
		case 2:
			conta.depositar();
			break;
		case 3:
			conta.transferencia();//Passar id da conta para fazer a transferencia
			break;
		default:
			System.out.println("Sair");
			System.exit(0);
		}
	}
	
	public static void mostraMenuRelatorio(Scanner leitor, Conta conta) {
		int opcao = leitorOpcao(leitor, 3, "1 - Saldo" + "\n2 - Tributação Conta Corrente" + "\n3 - Rendimento Conta Poupança" + "\n0 - Sair" + "\nInsira sua escolha: ");

		switch (opcao) {
		case 1:
			conta.getSaldo();
			break;
		case 2:
			//Tributação Conta Corrente
			break;
		case 3:
			//Rendimento Conta Poupança
			break;
		default:
			System.out.println("Sair");
			System.exit(0);
		}
	}
	
	public static int leitorOpcao(Scanner leitor, int opcaoMaxima, String textoPrevio) {
		int opcao;

		do {
			System.out.print(textoPrevio);
			try {
				opcao = leitor.nextInt();
				if (opcao >= 0 && opcao <= opcaoMaxima) {
					break;
				}
				System.out.println("Opção Inválida: Digite um número dentro da faixa.");
			} catch (InputMismatchException ex) {
				System.out.println("Caracters Inválido!");
			} finally {
				leitor.nextLine();
			}
		} while (true);

		return opcao;
	}
}

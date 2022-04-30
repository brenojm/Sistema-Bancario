package br.com.serratec.dominio;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import br.com.serratec.entidades.Cliente;
import br.com.serratec.entidades.Conta;
import br.com.serratec.entidades.ContaCorrente;
import br.com.serratec.entidades.ContaPoupanca;
import br.com.serratec.entidades.Funcionario;
import br.com.serratec.entidades.Usuario;
import br.com.serratec.excecoes.CadastroJaExisteException;
import br.com.serratec.excecoes.CadastroNaoExisteException;
import br.com.serratec.excecoes.ContaInvalidaException;
import br.com.serratec.excecoes.DocumentoInvalido;
import br.com.serratec.excecoes.valorInvalidoException;
import br.com.serratec.manipuladores.ManipuladorUsuarios;
import br.com.serratec.repositorios.RepositorioUsuario;
import br.com.serratec.validador.ValidarCpf;
import br.com.serratec.entidades.Gerente;
import br.com.serratec.entidades.Diretor;
import br.com.serratec.entidades.Presidente;
import br.com.serratec.repositorios.RepositorioContaCorrente;
import br.com.serratec.repositorios.RepositorioContaPoupanca;
public class SistemaInterno {
	
	public static void main(String[] args) throws DocumentoInvalido, CadastroNaoExisteException, valorInvalidoException, ContaInvalidaException, CadastroJaExisteException, IOException {
		ManipuladorUsuarios.arquivoUsuarioloader();
		Scanner leitor = new Scanner(System.in);
		Usuario usuario=Login(leitor);
		System.out.println("Login efetuado com sucesso!");

			System.out.println("Fazer os logins aqui");
			mostraMenuInicial(leitor,descobirTipoConta(usuario));

	}
	public static void mostraMenuInicial(Scanner leitor, Conta tipoconta) throws valorInvalidoException, DocumentoInvalido, ContaInvalidaException, CadastroNaoExisteException {
		int opcao = leitorOpcao(leitor, 2, "1 - Movimentações na conta" + "\n2 - Relatórios" + "\n0 - Sair" + "\nInsira sua escolha: ");

		switch (opcao) {
		case 1:
			mostraMenuMovimentacao(leitor, tipoconta);
			break;
		case 2:
			mostraMenuRelatorio(leitor, tipoconta);
			break;
			
		default:
			System.out.println("Sair");
			System.exit(0);
		}
	}
	
	public static void mostraMenuMovimentacao(Scanner leitor, Conta conta) throws valorInvalidoException, DocumentoInvalido, ContaInvalidaException, CadastroNaoExisteException {
		int opcao = leitorOpcao(leitor, 3, "1 - Saque" + "\n2 - Depósito" + "\n3 - Transfêrencia" + "\n0 - Sair" + "\nInsira sua escolha: ");
		switch (opcao) {
		case 1:
			System.out.println("Insira o valor que deseja sacar: ");
			double valorInseridoSaque = leitor.nextDouble();
			conta.sacar(valorInseridoSaque);
			break;
		case 2:
			System.out.println("Insira o valor que deseja depositar: ");
			double valorInseridoDeposito = leitor.nextDouble();
			conta.depositar(valorInseridoDeposito);
			break;
		case 3:
			System.out.println("Insira o valor que deseja transferir: ");
			double valorInseridoTransferencia = leitor.nextDouble();
			System.out.println("Insira o cpf do remetente: ");
			String cpf = ValidarCpf.validarCpf(leitor.nextLine());
			int tipo=leitorOpcao(leitor, 2, "Escolha o tipo de conta do remetente \n1 - Conta corrente \n2 - Conta poupança");
			char tipoContaRecebe='0';
			switch(tipo) {
			case 1:
				tipoContaRecebe='c';
				break;
			case 2:
				tipoContaRecebe='p';
				break;
			default:
				System.exit(0);
				break;
			}
			conta.transferencia(valorInseridoTransferencia, cpf, tipoContaRecebe);//Passar id da conta para fazer a transferencia
			break;
		default:
			System.out.println("Sair");
			System.exit(0);
		}
	}
	
	public static void mostraMenuRelatorio(Scanner leitor, Conta conta) {
		if(conta instanceof ContaCorrente) {
			if(conta.getUsuario() instanceof Cliente) {
				int opcao = leitorOpcao(leitor, 3, "1 - Saldo" + "\n2 - Tributação Conta Corrente" + "\n0 - Sair" + "\nInsira sua escolha: ");
				switch (opcao) {
				case 1:
					conta.getSaldo();
					break;
				case 2:
					((ContaCorrente) conta).TributacaoContaCorrente();
					break;
				default:
					System.out.println("Sair");
					System.exit(0);
				}
			}else if(conta.getUsuario() instanceof Gerente) {
				int opcao = leitorOpcao(leitor, 3, "1 - Saldo" + "\n2 - Tributação Conta Corrente" +"\n3- Relatorio do número de clientes em sua agencia " +"\n0 - Sair" + "\nInsira sua escolha: ");
				switch (opcao) {
				case 1:
					conta.getSaldo();
					break;
				case 2:
					((ContaCorrente) conta).TributacaoContaCorrente();
					break;
				case 3:
					Gerente usuario=(Gerente) conta.getUsuario();
					usuario.relatorioClientes(usuario.getAgencia());
					break;
				default:
					System.out.println("Sair");
					System.exit(0);
				}
			}else if(conta.getUsuario() instanceof Diretor) {
				int opcao = leitorOpcao(leitor, 3, "1 - Saldo" + "\n2 - Tributação Conta Corrente" +"\n3- Relatorio do número de clientes no banco"+"\n4- Lista dos clientes"+ "\n0 - Sair" + "\nInsira sua escolha: ");
				switch (opcao) {
				case 1:
					conta.getSaldo();
					break;
				case 2:
					((ContaCorrente) conta).TributacaoContaCorrente();
					break;
				case 3:
					System.out.println("O número total de cliente no banco é: "+RepositorioUsuario.getQuantidadeTotal());
					break;
				case 4:
					System.out.println("-----------------LISTA CLIENTES-----------------");
					RepositorioUsuario.listaAlfabetica();
					break;
				default:
					System.out.println("Sair");
					System.exit(0);
				}
			}
			else if(conta.getUsuario() instanceof Presidente) {
				int opcao = leitorOpcao(leitor, 3, "1 - Saldo" + "\n2 - Tributação Conta Corrente" +"\n3- Relatorio do número de clientes no banco"+"\n4- Lista dos clientes"+"\n5- Total de Capital no banco "+ "\n0 - Sair" + "\nInsira sua escolha: ");
				switch (opcao) {
				case 1:
					conta.getSaldo();
					break;
				case 2:
					((ContaCorrente) conta).TributacaoContaCorrente();
					break;
				case 3:
					System.out.println("O número total de cliente no banco é: "+RepositorioUsuario.getQuantidadeTotal());
					break;
				case 4:
					System.out.println("-----------------LISTA CLIENTES-----------------");
					RepositorioUsuario.listaAlfabetica();
					break;
				case 5:
					System.out.println("Total de capital: R$"+Presidente.getCapitalTotalBanco());
				default:
					System.out.println("Sair");
					System.exit(0);
				}
			}
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
	
	public static Usuario Login(Scanner leitor) throws DocumentoInvalido, CadastroNaoExisteException{
		do {
			String cpf="", senha="";
			try {
				System.out.println("Digite seu CPF: ");
				cpf = leitor.nextLine();
				System.out.println("Digite sua senha: ");
				senha = leitor.nextLine();
				ValidarCpf.validarCpf(cpf);
				Usuario usuario=RepositorioUsuario.retornaUsuario(cpf);
				if(usuario.getSenha().equals(senha)) {
					return usuario;
				}
			}catch (DocumentoInvalido e) {
				System.out.println(e.getMessage());
			}catch(CadastroNaoExisteException e) {
				System.out.println(e.getMessage());
			}
		}while(true);
		
	}
	
	public static Conta descobirTipoConta(Usuario usuario) {
		Scanner leitor = new Scanner(System.in);
		
		ContaCorrente contaCorrente = RepositorioContaCorrente.getMapaContaCorrenteCpf(usuario.getCpf());
		ContaPoupanca contaPoupanca = RepositorioContaPoupanca.getMapaContaPoupancaCpf(usuario.getCpf());
		Conta tipoconta = contaCorrente;
		if(contaCorrente!=null && contaPoupanca!=null) {
			int opcao = leitorOpcao(leitor,2,"Escolha a conta que deseja usar: \n1 - Conta corrente \n2 - Conta poupanca");
			leitor.close();
			switch(opcao) {
			case 1:
				tipoconta= contaCorrente;
				break;
			case 2:
				tipoconta= contaPoupanca;
				break;
			default:
				System.exit(0);
				break;
			}
		}else if(contaCorrente!=null) {
			tipoconta= contaCorrente;
		}else if(contaPoupanca!= null) {
			tipoconta= contaPoupanca;
		}
		return tipoconta;
		
	}
}

package br.com.serratec.dominio;

import java.util.InputMismatchException;
import java.util.Scanner;

import br.com.serratec.entidades.Cliente;
import br.com.serratec.entidades.Conta;
import br.com.serratec.entidades.Funcionario;
import br.com.serratec.entidades.Usuario;
import br.com.serratec.excecoes.CadastroJaExisteException;
import br.com.serratec.excecoes.CadastroNaoExisteException;
import br.com.serratec.excecoes.DocumentoInvalido;
import br.com.serratec.repositorios.RepositorioUsuario;
import br.com.serratec.validador.ValidarCpf;
import br.com.serratec.entidades.Gerente;
import br.com.serratec.entidades.Diretor;
import br.com.serratec.entidades.Presidente;
public class SistemaInterno {
	
	public static void main(String[] args) throws DocumentoInvalido, CadastroNaoExisteException {	
		Scanner leitor = new Scanner(System.in);
		Usuario usuario=Login(leitor);
		System.out.println("Login efetuado com sucesso!");
		
		//Pode-se fazer em boolen----- private boolean clienteOuFuncionario=(usuario.getClass() == Cliente.class)
		
		if(usuario.getClass() == Cliente.class) {
			System.out.println("Fazer o login de cliente aqui");
		}
		if(usuario.getClass() == Gerente.class) {
			System.out.println("Fazer o login de gerente aqui");
		}
		if(usuario.getClass() == Diretor.class) {
			System.out.println("Fazer o login de Diretor aqui");
		}
		if(usuario.getClass() == Presidente.class) {
			System.out.println("Fazer o login de Presidente aqui");
		}
	}
		
		//Passar conta para o menu para que sejam chamados os metodos do menu
	
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

}

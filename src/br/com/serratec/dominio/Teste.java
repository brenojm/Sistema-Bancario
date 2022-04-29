package br.com.serratec.dominio;

import java.util.Scanner;

import br.com.serratec.entidades.Cliente;
import br.com.serratec.entidades.Funcionario;
import br.com.serratec.entidades.Usuario;
import br.com.serratec.excecoes.CadastroJaExisteException;
import br.com.serratec.excecoes.CadastroNaoExisteException;
import br.com.serratec.excecoes.DocumentoInvalido;
import br.com.serratec.repositorios.RepositorioUsuario;
import br.com.serratec.validador.ValidarCpf;

public class teste {

	public static void main(String[] args) throws DocumentoInvalido, CadastroNaoExisteException, CadastroJaExisteException {
		UsuariosLoader();
		System.out.println(RepositorioUsuario.NumerosUsuarios());
		System.out.println(RepositorioUsuario.retornaUsuario("12345678901"));
		System.out.println(RepositorioUsuario.retornaUsuario("32144568901"));
		Scanner leitor = new Scanner(System.in);
		Login(leitor);
		System.out.println("Login efetuado com sucesso!");
	}
	public static void UsuariosLoader() throws DocumentoInvalido, CadastroJaExisteException {
		Usuario usuario1 = new Funcionario("João","12345678901","12345","gerente");
		RepositorioUsuario.adicionaUsuario(usuario1);
		Usuario usuario2 = new Cliente("Maria", "32144568901","123",334.0);
		RepositorioUsuario.adicionaUsuario(usuario2);
		
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

package br.com.serratec.dominio;

import java.util.Scanner;

import br.com.serratec.entidades.Cliente;
import br.com.serratec.entidades.Diretor;
import br.com.serratec.entidades.Funcionario;
import br.com.serratec.entidades.Usuario;
import br.com.serratec.excecoes.CadastroJaExisteException;
import br.com.serratec.excecoes.CadastroNaoExisteException;
import br.com.serratec.excecoes.DocumentoInvalido;
import br.com.serratec.repositorios.RepositorioUsuario;
import br.com.serratec.validador.ValidarCpf;

public class teste2 {
	Scanner leitor = new Scanner(System.in);
	public static void main(String[] args) throws DocumentoInvalido, CadastroNaoExisteException, CadastroJaExisteException {	
		Scanner leitor = new Scanner(System.in);
		UsuariosLoader();
		//Usuario usuario=Login(leitor);
		System.out.println("Login efetuado com sucesso!");
		Usuario usuario1 = new Cliente("João","12345678901","12345");
		if(usuario1.getClass() == Diretor.class) {
			System.out.println("asasa");
		}else {
			System.out.println("waa");
		}
		//switch(usuario.getClass() = ) {
		
		//}
	}
	public static void UsuariosLoader() throws DocumentoInvalido, CadastroJaExisteException {
		
		
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

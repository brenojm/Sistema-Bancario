package br.com.serratec.dominio;

import br.com.serratec.entidades.Cliente;
import br.com.serratec.entidades.Funcionario;
import br.com.serratec.entidades.Usuario;
import br.com.serratec.excecoes.DocumentoInvalido;
import br.com.serratec.repositorios.FuncionarioRepositorio;
import br.com.serratec.repositorios.UsuarioRepositorio;

public class teste {

	public static void main(String[] args) throws DocumentoInvalido {
		UsuariosLoader();
		System.out.println(UsuarioRepositorio.mapaUsuarios.size());
		System.out.println(UsuarioRepositorio.retornaUsuario("12345678901"));
		System.out.println(UsuarioRepositorio.retornaUsuario("32144568901"));
	}
	public static void UsuariosLoader() throws DocumentoInvalido {
		Usuario usuario1 = new Funcionario("João","12345678901","12345","gerente");
		UsuarioRepositorio.adicionaUsuario(usuario1);
		Usuario usuario2 = new Cliente("Maria", "32144568901","123",334.0);
		UsuarioRepositorio.adicionaUsuario(usuario2);
		
	}
}

package br.com.serratec.repositorios;

import java.util.HashMap;

import br.com.serratec.entidades.Usuario;
import br.com.serratec.excecoes.CadastroJaExisteException;
import br.com.serratec.excecoes.CadastroNaoExisteException;

public class RepositorioUsuario {
	private static HashMap<String, Usuario> mapaUsuario = new HashMap< String, Usuario>() ;
	
	public static void adicionaUsuario(Usuario Usuario) throws CadastroJaExisteException {
		if (mapaUsuario.containsKey(Usuario.getCpf())) {
			throw new CadastroJaExisteException();
		}
		mapaUsuario.put(Usuario.getCpf(), Usuario);
	}
	
	public static void removeUsuario(String cpf) throws CadastroNaoExisteException {
		if (!mapaUsuario.containsKey(cpf)) {
			throw new CadastroNaoExisteException();
		}
		mapaUsuario.remove(cpf);
	}
	
	public static Usuario retornaUsuario(String cpf) throws CadastroNaoExisteException {
		Usuario UsuarioPesquisado = mapaUsuario.get(cpf);
		if (UsuarioPesquisado == null) {
			throw new CadastroNaoExisteException();
		}
		return UsuarioPesquisado;
	}
	public static int NumerosUsuarios() {
		return mapaUsuario.size();
	}
	
}

package br.com.serratec.repositorios;

import java.util.HashMap;
import br.com.serratec.entidades.Funcionario;
import br.com.serratec.entidades.Usuario;
import br.com.serratec.excecoes.ContaInvalida;
public class UsuarioRepositorio {
	public static HashMap< String,Usuario> mapaUsuarios = new HashMap< String,Usuario>();

	public static void adicionaUsuario(Usuario usuario){
		if (mapaUsuarios.containsKey(usuario.getCpf())) {
			throw new ContaInvalida();
		}
			mapaUsuarios.put(usuario.getCpf(),usuario);
		}
	public static void removeFuncionario(String cpf) throws ContaInvalida{
		if (!mapaUsuarios.containsKey(cpf)) {
			throw new ContaInvalida();
		}
		mapaUsuarios.remove(cpf);
	}
	public static Usuario retornaUsuario(String cpf){
		Usuario usuarioPesquisado = mapaUsuarios.get(cpf);
		if (usuarioPesquisado == null) {
			throw new ContaInvalida();
		}
		return usuarioPesquisado;
	}
	
}

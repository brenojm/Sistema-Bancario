package br.com.serratec.repositorios;

import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeMap;

import br.com.serratec.entidades.Cliente;
import br.com.serratec.entidades.Usuario;
import br.com.serratec.excecoes.CadastroJaExisteException;
import br.com.serratec.excecoes.CadastroNaoExisteException;

public class RepositorioUsuario {

	private static HashMap<String, Usuario> mapaUsuario = new HashMap<String, Usuario>();
	private static TreeMap<String, Usuario> arvoreAlfabeto = new TreeMap<String, Usuario>();
	private static int quantidadeTotal;

	public static void adicionaUsuario(Usuario Usuario) throws CadastroJaExisteException {
		if (mapaUsuario.containsKey(Usuario.getCpf())) {
			throw new CadastroJaExisteException();
		}
		mapaUsuario.put(Usuario.getCpf(), Usuario);
		quantidadeTotal++;
		if (Usuario instanceof Cliente) {
			arvoreAlfabeto.put(Usuario.getCpf(), Usuario);
		}
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

	public static int getQuantidadeTotal() {
		return quantidadeTotal;
	}

	public static void listaAlfabetica() {
		arvoreAlfabeto.values().stream().sorted(Comparator.comparing(Usuario -> Usuario.getNome()))
				.forEach(System.out::println);
	}
}

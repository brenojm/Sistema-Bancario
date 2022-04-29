package br.com.serratec.repositorios;

import java.util.HashMap;

import br.com.serratec.entidades.ContaCorrente;
import br.com.serratec.excecoes.CadastroJaExisteException;
import br.com.serratec.excecoes.CadastroNaoExisteException;

public class RepositorioContaCorrente {
	private static HashMap<String, ContaCorrente> mapaContaCorrente = new HashMap< String, ContaCorrente>() ;
	
	public static void adicionaUsuario(ContaCorrente ContaCorrente) throws CadastroJaExisteException {
		if (mapaContaCorrente.containsKey(ContaCorrente.getIdConta())) {
			throw new CadastroJaExisteException();
		}
		mapaContaCorrente.put(ContaCorrente.getIdConta(), ContaCorrente);
	}
	
	public static void removeConta(String IdConta) throws CadastroNaoExisteException {
		if (!mapaContaCorrente.containsKey(IdConta)) {
			throw new CadastroNaoExisteException();
		}
		mapaContaCorrente.remove(IdConta);
	}
	
	public static ContaCorrente retornaConta(String IdConta) throws CadastroNaoExisteException {
		ContaCorrente ContaCorrentePesquisada = mapaContaCorrente.get(IdConta);
		if (ContaCorrentePesquisada == null) {
			throw new CadastroNaoExisteException();
		}
		return ContaCorrentePesquisada;
	}
	public static int NumerosUsuarios() {
		return mapaContaCorrente.size();
	}

}

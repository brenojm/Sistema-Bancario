package br.com.serratec.repositorios;

import java.util.HashMap;

import br.com.serratec.entidades.ContaCorrente;
import br.com.serratec.excecoes.CadastroJaExisteException;
import br.com.serratec.excecoes.CadastroNaoExisteException;

public class RepositorioContaCorrente {
	private static HashMap<String, ContaCorrente> mapaContaCorrente = new HashMap< String, ContaCorrente>() ;
	
	public static void adicionaContaCorrente(ContaCorrente ContaCorrente) throws CadastroJaExisteException {
		if (mapaContaCorrente.containsKey(ContaCorrente.getIdConta())) {
			throw new CadastroJaExisteException();
		}
		mapaContaCorrente.put(ContaCorrente.getIdConta(), ContaCorrente);
	}
	
	public static void removeContaCorrente(String IdContaCorrente) throws CadastroNaoExisteException {
		if (!mapaContaCorrente.containsKey(IdContaCorrente)) {
			throw new CadastroNaoExisteException();
		}
		mapaContaCorrente.remove(IdContaCorrente);
	}
	
	public static ContaCorrente retornaContaCorrente(String IdContaCorrente) throws CadastroNaoExisteException {
		ContaCorrente ContaCorrentePesquisada = mapaContaCorrente.get(IdContaCorrente);
		if (ContaCorrentePesquisada == null) {
			throw new CadastroNaoExisteException();
		}
		return ContaCorrentePesquisada;
	}
	public static int NumeroContaCorrente() {
		return mapaContaCorrente.size();
	}

}

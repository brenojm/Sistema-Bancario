package br.com.serratec.repositorios;

import java.util.HashMap;

import br.com.serratec.entidades.ContaPoupanca;
import br.com.serratec.excecoes.CadastroJaExisteException;
import br.com.serratec.excecoes.CadastroNaoExisteException;

public class RepositorioContaPoupanca {
private static HashMap<String, ContaPoupanca> mapaContaPoupanca = new HashMap< String, ContaPoupanca>() ;
	
	public static void adicionaConta(ContaPoupanca ContaPoupanca) throws CadastroJaExisteException {
		if (mapaContaPoupanca.containsKey(ContaPoupanca.getIdConta())) {
			throw new CadastroJaExisteException();
		}
		mapaContaPoupanca.put(ContaPoupanca.getIdConta(), ContaPoupanca);
	}
	
	public static void removeContaPoupanca(String IdContaPoupanca) throws CadastroNaoExisteException {
		if (!mapaContaPoupanca.containsKey(IdContaPoupanca)) {
			throw new CadastroNaoExisteException();
		}
		mapaContaPoupanca.remove(IdContaPoupanca);
	}
	
	public static ContaPoupanca retornaContaPoupanca(String IdContaPoupanca) throws CadastroNaoExisteException {
		ContaPoupanca ContaPoupancaPesquisada = mapaContaPoupanca.get(IdContaPoupanca);
		if (ContaPoupancaPesquisada == null) {
			throw new CadastroNaoExisteException();
		}
		return ContaPoupancaPesquisada;
	}
	public static int NumeroContaPoupanca() {
		return mapaContaPoupanca.size();
	}

}

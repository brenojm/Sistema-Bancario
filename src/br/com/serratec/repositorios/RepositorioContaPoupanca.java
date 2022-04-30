package br.com.serratec.repositorios;

import java.util.HashMap;

import br.com.serratec.entidades.ContaCorrente;
import br.com.serratec.entidades.ContaPoupanca;
import br.com.serratec.excecoes.CadastroJaExisteException;
import br.com.serratec.excecoes.CadastroNaoExisteException;

public class RepositorioContaPoupanca {
private static HashMap<String, ContaPoupanca> mapaContaPoupanca = new HashMap< String, ContaPoupanca>() ;
	
	public static void adicionaConta(ContaPoupanca ContaPoupanca) throws CadastroJaExisteException {
		if (mapaContaPoupanca.containsKey(ContaPoupanca.getCpfPorUsuario())) {
			throw new CadastroJaExisteException();
		}
		mapaContaPoupanca.put(ContaPoupanca.getCpfPorUsuario(), ContaPoupanca);
	}
	
	public static void removeContaPoupanca(String cpf) throws CadastroNaoExisteException {
		if (!mapaContaPoupanca.containsKey(cpf)) {
			throw new CadastroNaoExisteException();
		}
		mapaContaPoupanca.remove(cpf);
	}
	
	public static ContaPoupanca retornaContaPoupanca(String cpf) throws CadastroNaoExisteException {
		ContaPoupanca ContaPoupancaPesquisada = mapaContaPoupanca.get(cpf);
		if (ContaPoupancaPesquisada == null) {
			throw new CadastroNaoExisteException();
		}
		return ContaPoupancaPesquisada;
	}
	public static int NumeroContaPoupanca() {
		return mapaContaPoupanca.size();
	}
	public static ContaPoupanca getMapaContaPoupancaCpf(String cpf) {
		ContaPoupanca contaPoupanca=mapaContaPoupanca.get(cpf);
		return contaPoupanca;
	}
	public static double getCapitalPoupanca() {
		double total = 0;
		for(ContaPoupanca contaAtual: mapaContaPoupanca.values()) {
			total+=contaAtual.getSaldo();
		}
		return total;
	}
}

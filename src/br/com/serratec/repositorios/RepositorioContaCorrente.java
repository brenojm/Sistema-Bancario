package br.com.serratec.repositorios;

import java.util.HashMap;

import br.com.serratec.entidades.ContaCorrente;
import br.com.serratec.entidades.Usuario;
import br.com.serratec.excecoes.CadastroJaExisteException;
import br.com.serratec.excecoes.CadastroNaoExisteException;

public class RepositorioContaCorrente {
	private static HashMap<String, ContaCorrente> mapaContaCorrente = new HashMap< String, ContaCorrente>() ;
	
	public static void adicionaContaCorrente(ContaCorrente ContaCorrente) throws CadastroJaExisteException {
		if (mapaContaCorrente.containsKey(ContaCorrente.getCpfPorUsuario())) {
			throw new CadastroJaExisteException();
		}
		mapaContaCorrente.put(ContaCorrente.getCpfPorUsuario(), ContaCorrente);
	}
	
	public static void removeContaCorrente(String cpf) throws CadastroNaoExisteException {
		if (!mapaContaCorrente.containsKey(cpf)) {
			throw new CadastroNaoExisteException();
		}
		mapaContaCorrente.remove(cpf);
	}
	
	public static ContaCorrente retornaContaCorrente(String cpf) throws CadastroNaoExisteException {
		ContaCorrente ContaCorrentePesquisada = mapaContaCorrente.get(cpf);
		if (ContaCorrentePesquisada == null) {
			throw new CadastroNaoExisteException();
		}
		return ContaCorrentePesquisada;
	}
	public static int NumeroContaCorrente() {
		return mapaContaCorrente.size();
	}
	public static ContaCorrente getMapaContaCorrenteCpf(String cpf) {
		ContaCorrente contaCorrente=mapaContaCorrente.get(cpf);
		return contaCorrente;
	}
	public static double getCapitalCorrente() {
		double total = 0;
		for(ContaCorrente contaAtual: mapaContaCorrente.values()) {
			total+=contaAtual.getSaldo();
		}
		return total;
	}
}

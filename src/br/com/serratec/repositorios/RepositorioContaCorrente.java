package br.com.serratec.repositorios;

import java.util.HashMap;

import br.com.serratec.entidades.Cliente;
import br.com.serratec.entidades.Conta;
import br.com.serratec.entidades.ContaCorrente;
import br.com.serratec.excecoes.CadastroJaExisteException;
import br.com.serratec.excecoes.CadastroNaoExisteException;

public class RepositorioContaCorrente {
	private static HashMap<String, ContaCorrente> mapaContaCorrente = new HashMap<String, ContaCorrente>();

	public static void adicionaContaCorrente(Conta conta) throws CadastroJaExisteException {
		if (mapaContaCorrente.containsKey(conta.getCpfPorUsuario())) {
			throw new CadastroJaExisteException();
		}
		mapaContaCorrente.put(conta.getCpfPorUsuario(), (ContaCorrente) conta);
		ContaCorrente contaCorrente = RepositorioContaCorrente.getMapaContaCorrenteCpf(conta.getCpfPorUsuario());
		if (conta.getUsuario() instanceof Cliente) {
			switch (contaCorrente.getAgencia()) {
			case 1234:
				Conta.aumentaQuantidadeAgencia1234();
			case 4321:
				Conta.aumentaQuantidadeAgencia4321();
			case 7833:
				Conta.aumentaQuantidadeAgencia7883();
			case 3533:
				Conta.aumentaQuantidadeAgencia3533();
			}
		}
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
		ContaCorrente contaCorrente = mapaContaCorrente.get(cpf);
		return contaCorrente;
	}

	public static double getCapitalCorrente() {
		double total = 0;
		for (ContaCorrente contaAtual : mapaContaCorrente.values()) {
			total += contaAtual.getSaldo();
		}
		return total;
	}
}

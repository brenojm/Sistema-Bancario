package br.com.serratec.repositorios;

import java.util.HashMap;

import br.com.serratec.entidades.Cliente;
import br.com.serratec.entidades.Conta;
import br.com.serratec.entidades.ContaPoupanca;
import br.com.serratec.excecoes.CadastroJaExisteException;
import br.com.serratec.excecoes.CadastroNaoExisteException;

public class RepositorioContaPoupanca {
	private static HashMap<String, ContaPoupanca> mapaContaPoupanca = new HashMap<String, ContaPoupanca>();

	public static void adicionaConta(Conta conta) throws CadastroJaExisteException {
		if (mapaContaPoupanca.containsKey(conta.getCpfPorUsuario())) {
			throw new CadastroJaExisteException();
		}
		mapaContaPoupanca.put(conta.getCpfPorUsuario(), (ContaPoupanca) conta);
		ContaPoupanca contaPoupanca = RepositorioContaPoupanca.getMapaContaPoupancaCpf(conta.getCpfPorUsuario());

		if (conta.getUsuario() instanceof Cliente) {
			// Essa solução não escala muito bem já que exige que tenha uma função para cada agência
			switch (contaPoupanca.getAgencia()) {
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
		ContaPoupanca contaPoupanca = mapaContaPoupanca.get(cpf);
		return contaPoupanca;
	}

	public static double getCapitalPoupanca() {
		double total = 0;
		for (ContaPoupanca contaAtual : mapaContaPoupanca.values()) {
			total += contaAtual.getSaldo();
		}
		return total;
	}
}

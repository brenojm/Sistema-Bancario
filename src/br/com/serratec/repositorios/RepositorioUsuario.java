package br.com.serratec.repositorios;

import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeMap;

import br.com.serratec.dominio.SistemaInterno;
import br.com.serratec.entidades.Cliente;
import br.com.serratec.entidades.Conta;
import br.com.serratec.entidades.ContaCorrente;
import br.com.serratec.entidades.ContaPoupanca;
import br.com.serratec.entidades.Gerente;
import br.com.serratec.entidades.Usuario;
import br.com.serratec.excecoes.CadastroJaExisteException;
import br.com.serratec.excecoes.CadastroNaoExisteException;

public class RepositorioUsuario {
	private static HashMap<String, Usuario> mapaUsuario = new HashMap<String, Usuario>();
	private static TreeMap<String, Usuario> arvoreAlfabeto = new TreeMap<String, Usuario>();
	private static int quantidadeAgencia1234, quantidadeAgencia4321, quantidadeAgencia7883, quantidadeAgencia3533,quantidadeTotal;

	public static void adicionaUsuario(Usuario Usuario) throws CadastroJaExisteException {
		if (mapaUsuario.containsKey(Usuario.getCpf())) {
			throw new CadastroJaExisteException();
		}
		mapaUsuario.put(Usuario.getCpf(), Usuario);
		quantidadeTotal++;
		if (Usuario instanceof Cliente) {
			ContaCorrente contaCorrente = RepositorioContaCorrente.getMapaContaCorrenteCpf(Usuario.getCpf());
			ContaPoupanca contaPoupanca = RepositorioContaPoupanca.getMapaContaPoupancaCpf(Usuario.getCpf());
			if (contaCorrente != null) {
				switch (contaCorrente.getAgencia()) {
				case 1234:
					quantidadeAgencia1234++;
				case 4321:
					quantidadeAgencia4321++;
				case 7833:
					quantidadeAgencia7883++;
				case 3533:
					quantidadeAgencia3533++;
				}
			}
				if (contaPoupanca != null) {
					switch (contaPoupanca.getAgencia()) {
					case 1234:
						quantidadeAgencia1234++;
					case 4321:
						quantidadeAgencia4321++;
					case 7833:
						quantidadeAgencia7883++;
					case 3533:
						quantidadeAgencia3533++;
					}
				}
				if (Usuario instanceof Cliente) {
					arvoreAlfabeto.put(Usuario.getCpf(), Usuario);
				}
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

	public static int getQuantidadeAgencia(int numAgencia) {
		switch (numAgencia) {
		case 1234:
			return quantidadeAgencia1234;
		case 4321:
			return quantidadeAgencia4321;
		case 7833:
			return quantidadeAgencia7883;
		case 3533:
			return quantidadeAgencia3533;
		default:
			return 0;
		}
	}

	public static int getQuantidadeTotal() {
		return quantidadeTotal;
	}

	public static void listaAlfabetica() {
		arvoreAlfabeto.values().stream().sorted(Comparator.comparing(Usuario -> Usuario.getNome())).forEach(System.out::println);
	}
}

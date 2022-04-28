package br.com.serratec.repositorios;

import java.util.HashMap;
import br.com.serratec.entidades.Funcionario;
import br.com.serratec.excecoes.ContaInvalidaException;

public class FuncionarioRepositorio {
	private static HashMap<String, Funcionario> mapaFuncionarios = new HashMap<String, Funcionario>();
	
	public static void adicionaFuncionario(Funcionario funcionario) throws ContaInvalidaException {
		if (mapaFuncionarios.containsKey(funcionario.getCpf())) {
			throw new ContaInvalidaException();
		}
		mapaFuncionarios.put(funcionario.getCpf(), funcionario);
	}
	public static void removeFuncionario(String Cpf) throws ContaInvalidaException {
		if (!mapaFuncionarios.containsKey(Cpf)) {
			throw new ContaInvalidaException();
		}
		mapaFuncionarios.remove(Cpf);
	}
	public static Funcionario retornaFuncionario(String Cpf) throws ContaInvalidaException {
		Funcionario funcionarioPesquisado = mapaFuncionarios.get(Cpf);
		if (funcionarioPesquisado == null) {
			throw new ContaInvalidaException();
		}
		return funcionarioPesquisado;
	}
	
}

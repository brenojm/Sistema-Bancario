package br.com.serratec.repositorios;

import java.util.HashMap;
import br.com.serratec.entidades.Funcionario;
import br.com.serratec.excecoes.ContaInvalida;

public class FuncionarioRepositorio {
	private static HashMap<String, Funcionario> mapaFuncionarios = new HashMap<String, Funcionario>();
	
	public static void adicionaFuncionario(Funcionario funcionario){
		if (mapaFuncionarios.containsKey(funcionario.getCpf())) {
			throw new ContaInvalida();
		}
		mapaFuncionarios.put(funcionario.getCpf(), funcionario);
	}
	public static void removeFuncionario(String Cpf) throws ContaInvalida{
		if (!mapaFuncionarios.containsKey(Cpf)) {
			throw new ContaInvalida();
		}
		mapaFuncionarios.remove(Cpf);
	}
	public static Funcionario retornaFuncionario(String Cpf){
		Funcionario funcionarioPesquisado = mapaFuncionarios.get(Cpf);
		if (funcionarioPesquisado == null) {
			throw new ContaInvalida();
		}
		return funcionarioPesquisado;
	}
	
}

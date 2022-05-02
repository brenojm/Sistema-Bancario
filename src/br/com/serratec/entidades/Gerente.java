package br.com.serratec.entidades;

import br.com.serratec.excecoes.DocumentoInvalido;

public class Gerente extends Funcionario {
	private int agencia;

	public Gerente(String nome, String cpf, String senha, String cargo, int Agencia) throws DocumentoInvalido {
		super(nome, cpf, senha, cargo);
		this.agencia = Agencia;
	}

	public int getAgencia() {
		return agencia;
	}

	public void relatorioClientes(int agencia) {
		System.out
				.println("Numero de clientes na agencia " + agencia + " é de: " + Conta.getQuantidadeAgencia(agencia));

	}
}

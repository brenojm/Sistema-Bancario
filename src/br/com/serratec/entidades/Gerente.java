package br.com.serratec.entidades;

import br.com.serratec.excecoes.DocumentoInvalido;

public class Gerente extends Funcionario {
	private int agencia;
	
	public Gerente(String nome, String cpf, String senha, String cargo, int Agencia) throws DocumentoInvalido {
		super(nome, cpf, senha, cargo);
		this.Agencia = agencia;
	}

	public int getAgencia() {
		return agencia;
	}
	
}

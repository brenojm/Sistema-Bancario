package br.com.serratec.entidades;

public class Gerente extends Funcionario {
	private int agencia;
	
	public Gerente(String nome, String cpf, String senha, String cargo, int Agencia) {
		super(nome, cpf, senha, cargo);
		this.agencia = agencia;
	}

	public int getAgencia() {
		return agencia;
	}
	
}
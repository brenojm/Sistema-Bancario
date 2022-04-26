package br.com.serratec.entidades;

public class Funcionario extends Usuario{
	protected String cargo;
	
	public Funcionario(String nome, String cpf, String senha, String cargo) {
		super(nome, cpf, senha);
		this.cargo = cargo;
	}

	
}

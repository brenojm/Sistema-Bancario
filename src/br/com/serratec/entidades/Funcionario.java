package br.com.serratec.entidades;

public class Funcionario extends Usuario{
	protected String cargo;
	private static int TotalFuncionarios;
	
	public Funcionario(String nome, String cpf, String senha, String cargo) {
		super(nome, cpf, senha);
		this.cargo = cargo;
		TotalFuncionarios++;
	}

	public String getCargo() {
		return cargo;
	}

	public static int getTotalFuncionarios() {
		return TotalFuncionarios;
	}
	
}

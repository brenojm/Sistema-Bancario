package br.com.serratec.entidades;

public abstract class Usuario {
	protected String nome;
	protected String cpf;
	protected String senha;

	public Usuario(String nome, String cpf, String senha) {
		this.nome = nome;
		this.cpf = cpf;
		this.senha = senha;
	}

//	public boolean autenticar() {
//		
//	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

}

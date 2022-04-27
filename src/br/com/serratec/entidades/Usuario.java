package br.com.serratec.entidades;

import br.;

public abstract class Usuario {
	protected String nome;
	protected final String cpf;
	protected String senha;

	public Usuario(String nome, String cpf, String senha) {
		this.nome = nome;
		this.cpf = cpf;
		this.senha = senha;
	}

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

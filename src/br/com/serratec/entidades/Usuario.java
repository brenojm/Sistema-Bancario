package br.com.serratec.entidades;

import br.com.serratec.excecoes.DocumentoInvalido;
import br.com.serratec.validador.ValidarCpf;

public abstract class Usuario {
	protected String nome;
	protected String cpf;
	protected String senha;

	public Usuario(String nome, String cpf, String senha) throws DocumentoInvalido {
		this.nome = nome;
		this.cpf = ValidarCpf.validarCpf(cpf);
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

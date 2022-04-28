package br.com.serratec.entidades;

import br.com.serratec.excecoes.DocumentoInvalido;

public class Presidente extends Funcionario{

	public Presidente(String nome, String cpf, String senha, String cargo) throws DocumentoInvalido {
		super(nome, cpf, senha, cargo);
	}
}

package br.com.serratec.entidades;

import br.com.serratec.excecoes.DocumentoInvalido;

public class Cliente extends Funcionario {

	public Cliente(String nome, String cpf, String senha, String cargo) throws DocumentoInvalido {
		super(nome, cpf, senha, cargo);
		
	}

}

package br.com.serratec.entidades;

import br.com.serratec.excecoes.AutenticacaoLogin;
import br.com.serratec.excecoes.DocumentoInvalido;


public class Funcionario extends Usuario{
	protected String cargo;
	
	public Funcionario(String nome, String cpf, String senha, String cargo) throws DocumentoInvalido {
		super(nome, cpf, senha);
		this.cargo = cargo;
	}

	public String getCargo() {
		return cargo;
	}
	public void autenticar(String login) throws AutenticacaoLogin {
		if(!this.cpf.equals(login)) {
			throw new AutenticacaoLogin();
		}
	}
}

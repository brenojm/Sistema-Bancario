package br.com.serratec.entidades;

import br.com.serratec.interfaces.metodosConta;

public abstract class Conta implements metodosConta{
	protected Usuario usuario;
	protected int agencia;
	protected int idConta;
	protected char tipoConta;
	
	public Conta(Usuario usuario, int agencia, int idConta, char tipoConta) {
		this.usuario = usuario;
		this.agencia = agencia;
		this.idConta = idConta;
		this.tipoConta = tipoConta;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public int getIdConta() {
		return idConta;
	}

	public char getTipoConta() {
		return tipoConta;
	}

	
	
}

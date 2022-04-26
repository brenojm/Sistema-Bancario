package br.com.serratec.entidades;

public class Conta {
	protected Usuario usuario;
	protected int agencia;
	protected int idConta;
	protected char tipoConta;
	protected double saldo;
	
	public Conta(Usuario usuario, int agencia, int idConta, char tipoConta) {
		this.usuario = usuario;
		this.agencia = agencia;
		this.idConta = idConta;
		this.tipoConta = tipoConta;
	}
	
	
}

package br.com.serratec.entidades;

public class ContaCorrente extends Conta {
	private String tipo;
	
	public ContaCorrente(Usuario usuario, int agencia, int idConta, char tipoConta, String tipo) {
		super(usuario, agencia, idConta, tipoConta);
		this.tipo = tipo;
	}
	
	public double TributacaoContaCorrente(double i) {
		
	}

}

package br.com.serratec.entidades;

public class ContaPoupanca extends Conta{
	private String tipo;
	
	public ContaPoupanca(Usuario usuario, int agencia, int idConta, char tipoConta) {
		super(usuario, agencia, idConta, tipoConta);
		
	}
	
	public double rendimentoPoupanca(double i) {
		
	}

}

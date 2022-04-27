package br.com.serratec.excecoes;

public class SaldoInsuficiente extends Exception  {
	
	@Override
	public String getMessage() {
		return "Saldo insuficiente!";
	}

}

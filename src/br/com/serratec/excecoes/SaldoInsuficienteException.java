package br.com.serratec.excecoes;

public class SaldoInsuficienteException extends Exception {
	@Override
	public String getMessage() {
		return "Saldo Insuficiente";
	}
}

package br.com.serratec.excecoes;

public class ContaInvalidaException extends Exception {

	@Override
	public String getMessage() {
		return "Conta Inválida";
	}
}

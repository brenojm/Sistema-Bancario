package br.com.serratec.excecoes;

public class ContaInvalida extends RuntimeException {

	@Override
	public String getMessage() {
		return "Conta invalida!";
	}
	
}

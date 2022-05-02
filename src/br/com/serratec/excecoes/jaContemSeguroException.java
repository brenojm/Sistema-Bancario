package br.com.serratec.excecoes;

public class jaContemSeguroException extends Exception {
	@Override
	public String getMessage() {
		return "Cliente já contém seguro de vida";
	}
}

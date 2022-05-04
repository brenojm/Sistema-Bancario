package br.com.serratec.excecoes;

// Cuidado com o padrão. As classes devem começar com letra maiuscula
public class jaContemSeguroException extends Exception {
	@Override
	public String getMessage() {
		return "Cliente já contém seguro de vida";
	}
}

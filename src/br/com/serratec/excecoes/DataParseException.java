package br.com.serratec.excecoes;

public class DataParseException extends RuntimeException {
	
	@Override
	public String getMessage() {
		return "Data Inválida";
	}
}

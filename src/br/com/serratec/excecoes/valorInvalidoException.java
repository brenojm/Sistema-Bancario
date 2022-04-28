package br.com.serratec.excecoes;

public class valorInvalidoException extends Exception  {
	
	@Override
	public String getMessage() {
		return "Valor Inválido";
	}

}

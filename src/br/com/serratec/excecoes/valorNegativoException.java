package br.com.serratec.excecoes;

public class valorNegativoException extends Exception  {
	
	@Override
	public String getMessage() {
		return "Valor Menor";
	}

}

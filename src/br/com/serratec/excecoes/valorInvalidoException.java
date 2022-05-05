package br.com.serratec.excecoes;

// Cuidado com o padrão. As classes devem começar com letra maiuscula
public class valorInvalidoException extends Exception  {
	
	@Override
	public String getMessage() {
		return "Valor Inválido";
	}

}

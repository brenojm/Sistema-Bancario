package br.com.serratec.excecoes;

public class DocumentoInvalido extends Exception {

	@Override
	public String getMessage() {
		return "Documento inválido!";
	}
	
}

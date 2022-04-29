package br.com.serratec.excecoes;

public class CadastroJaExisteException extends Exception {
	@Override
	public String getMessage() {
		return "O cadastro já existe";
	
	}
}

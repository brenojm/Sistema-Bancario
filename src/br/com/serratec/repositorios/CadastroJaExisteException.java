package br.com.serratec.repositorios;

public class CadastroJaExisteException extends Exception {
	@Override
	public String getMessage() {
		return "O cadastro já existe";
	
	}
}

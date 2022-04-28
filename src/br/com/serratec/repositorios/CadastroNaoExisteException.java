package br.com.serratec.repositorios;

public class CadastroNaoExisteException extends Exception {
	@Override
	public String getMessage() {
		return "O cadastro não existe.";
	}

}

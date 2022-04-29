package br.com.serratec.excecoes;

public class CadastroNaoExisteException extends Exception {
	@Override
	public String getMessage() {
		return "O cadastro não existe.";
	}

}

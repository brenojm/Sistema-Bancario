package br.com.serratec.excecoes;

public class LoginInvalidoException extends Exception {
	
	@Override
	public String getMessage() {
		return "Login incorreto!";
	}
	

}

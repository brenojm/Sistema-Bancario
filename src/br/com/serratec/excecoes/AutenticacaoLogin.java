package br.com.serratec.excecoes;

public class AutenticacaoLogin extends Exception {
	
	
	@Override
	public String getMessage() {
		return "Credenciais incorretas";
	}
	
}

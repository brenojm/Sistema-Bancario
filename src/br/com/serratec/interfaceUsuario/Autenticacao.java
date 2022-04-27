package br.com.serratec.interfaceUsuario;

import br.com.serratec.excecoes.AutenticacaoLogin;

public interface Autenticacao {
	public abstract void autenticar(String login) throws AutenticacaoLogin;
}

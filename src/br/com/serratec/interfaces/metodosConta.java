package br.com.serratec.interfaces;

import br.com.serratec.entidades.Conta;
import br.com.serratec.excecoes.ContaInvalidaException;
import br.com.serratec.excecoes.valorInvalidoException;

public interface metodosConta {
	
	public boolean sacar(double valorInserido) throws valorInvalidoException;
	
	public void depositar(double valor) throws valorInvalidoException;
	
	public boolean transferencia(double valorInserido, Conta conta) throws valorInvalidoException, ContaInvalidaException;
	
}

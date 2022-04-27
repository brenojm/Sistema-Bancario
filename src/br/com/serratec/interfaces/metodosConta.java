package br.com.serratec.interfaces;

import br.com.serratec.entidades.ContaCorrente;
import br.com.serratec.excecoes.valorNegativoException;

public interface metodosConta {
	
	public boolean sacar(double valorInserido);
	
	public void depositar(double valor) throws valorNegativoException;
	
	public boolean transferencia(double valorInserido, ContaCorrente conta);
	
	public double getSaldo();
}

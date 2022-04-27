package br.com.serratec.interfaces;

public interface metodosConta {
	
	public boolean sacar(double valorInserido);
	
	public void depositar();
	
	public boolean transferencia();
	
	public double getSaldo();
}

package br.com.serratec.enums;

public enum Agencias {
	Agencia1(1234),
	Agencia2(4321),
	Agencia3(7883),
	Agencia(3533);
	
	private int numAgencia;

	private Agencias(int numAgencia) {
		this.numAgencia = numAgencia;
	}
	public int getNumAgencia() {
		return numAgencia;
	}
}

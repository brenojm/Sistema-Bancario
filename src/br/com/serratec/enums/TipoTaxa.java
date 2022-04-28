package br.com.serratec.enums;

public enum TipoTaxa {
	SAQUE(0.10),
	DEPOSITO(0.10),
	TRANSFERENCIA(0.20),
	RENDIMENTO(0.05),
	SEGURO(0.80);
	
	private double valorTaxa;
	
	//Private para não permitir um new taxa
	TipoTaxa(double valorTaxa) {
		this.valorTaxa = valorTaxa;
	}

	public double getValorTaxa() {
		return valorTaxa;
	}
	
	
	
	
	
	
}

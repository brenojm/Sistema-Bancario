package br.com.serratec.excecoes;

public class PeriodoInvalidoException extends Exception {
	
	@Override
	public String getMessage() {
		return "Período menor que o tempo minímo de 1 mês";
	}
}

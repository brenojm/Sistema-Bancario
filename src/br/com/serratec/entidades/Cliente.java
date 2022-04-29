package br.com.serratec.entidades;

import br.com.serratec.excecoes.DocumentoInvalido;

public class Cliente extends Usuario{
	
	private double ValorSeguro;

	public Cliente(String nome, String cpf, String senha, double valorSeguro) throws DocumentoInvalido {
		super(nome, cpf, senha);
		ValorSeguro = valorSeguro;
	}
	
	@Override
	public String toString() {
		if(ValorSeguro>0.0) {
			return "Cliente [ nome=" + nome + ", cpf=" + cpf + ", senha=" + senha +", Valor do Seguro de Vida= " + ValorSeguro+" ]";
		}else {
			return "Cliente [ nome=" + nome + ", cpf=" + cpf + ", senha=" + senha + "]";
		}
	}
	public double getValorSeguro() {
		return ValorSeguro;
	}
	public void setValorSeguro(double valorSeguro) {
		ValorSeguro = valorSeguro;
	}
}
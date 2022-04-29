package br.com.serratec.entidades;

import br.com.serratec.excecoes.DocumentoInvalido;
import br.com.serratec.entidades.Conta;
public class Cliente extends Usuario{
	
	private double ValorSeguro;
	private boolean SegurodeVida; 
	public Cliente(String nome, String cpf, String senha, double valorSeguro) throws DocumentoInvalido {
		super(nome, cpf, senha);
		ValorSeguro = valorSeguro;
	}
	public boolean ContemSegurodeVida(){
		return SegurodeVida;	
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
	public boolean ContrataSeguro(double valorSeguro) {
		if(valorSeguro<0 && valorSeguro>Conta.saldo) {
			return false;
		}
	}
}
package br.com.serratec.entidades;

import br.com.serratec.excecoes.DocumentoInvalido;
import br.com.serratec.excecoes.jaContemSeguroException;
import br.com.serratec.excecoes.valorInvalidoException;
public class Cliente extends Usuario{
	
	private double ValorSeguro;
	private boolean seguroDeVida; 
	public Cliente(String nome, String cpf, String senha) throws DocumentoInvalido{
		super(nome, cpf, senha);
	}
	public boolean ContemSegurodeVida(){
		return seguroDeVida;	
	}
	@Override
	public String toString() {
		if(ValorSeguro>0.0) {
			return "Cliente [ nome=" + nome + ", cpf=" + cpf + ", Valor do Seguro de Vida= " + ValorSeguro +" ]";
		}else {
			return "Cliente [ nome=" + nome + ", cpf=" + cpf + "]";
		}
	}
	public double getValorSeguro() {
		return ValorSeguro;
	}
	public void ContrataSeguro(double valorSeguro, Conta conta) throws valorInvalidoException, jaContemSeguroException {
		if(valorSeguro<=0 || valorSeguro>conta.getSaldo()) {
			throw new valorInvalidoException();
		} else if(this.ContemSegurodeVida() == true) {
			throw new jaContemSeguroException();
		}
		this.ValorSeguro = valorSeguro;
		conta.setSeguro(valorSeguro);
		this.seguroDeVida = true;
		System.out.println("Seguro de vida contratado no valor de R$" + valorSeguro);
	}
}
package br.com.serratec.entidades;

import br.com.serratec.enums.TipoTaxa;
import br.com.serratec.excecoes.valorNegativoException;

public class ContaPoupanca extends Conta {
	private String tipo;
	private double saldoContaPoupanca;

	public ContaPoupanca(Usuario usuario, int agencia, int idConta, char tipoConta) {
		super(usuario, agencia, idConta, tipoConta);

	}

	public double rendimentoPoupanca(double valorInserido) {
		
	}
	
	@Override
	public boolean sacar(double valorInserido) {
		if (valorInserido <= this.getSaldo() && valorInserido > 0) {
			this.saldoContaPoupanca -= (valorInserido - TipoTaxa.SAQUE.getValorTaxa());
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void depositar(double valorInserido) throws valorNegativoException {
		if (valorInserido > 0) {
			this.saldoContaPoupanca += (valorInserido - TipoTaxa.DEPOSITO.getValorTaxa());
			System.out.println("Depósito Realizado com sucesso!");
		} else {
			throw new valorNegativoException();
		}
	}
	
	@Override
	public boolean transferencia(double valorInserido, Conta conta) {
		// TODO
	}
	
	@Override
	public double getSaldo() {
		return saldoContaPoupanca;
	}

}

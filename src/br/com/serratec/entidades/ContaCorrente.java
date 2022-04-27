package br.com.serratec.entidades;

import br.com.serratec.enums.TipoTaxa;
import br.com.serratec.excecoes.valorNegativoException;

public final class ContaCorrente extends Conta {
	private String tipo;
	private double saldoContaCorrente;

	public ContaCorrente(Usuario usuario, int agencia, int idConta, char tipoConta, String tipo) {
		super(usuario, agencia, idConta, tipoConta);
		this.tipo = tipo;
	}

	// private double valorGasto;

	public double TributacaoContaCorrente() {

	}

	@Override
	public boolean sacar(double valorInserido) {
		if (valorInserido <= this.getSaldo() && valorInserido > 0) {
			this.saldoContaCorrente -= (valorInserido - TipoTaxa.SAQUE.getValorTaxa());
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void depositar(double valorInserido) throws valorNegativoException {
		if (valorInserido > 0) {
			this.saldoContaCorrente += (valorInserido - TipoTaxa.DEPOSITO.getValorTaxa());
			System.out.println("Depósito Realizado com sucesso!");
		} else {
			throw new valorNegativoException();
		}
	}
	
	
//TODO	public boolean transferencia(double valorInserido, ContaCorrente conta) {
//		if(conta.tipoConta == 'c') {
//			if(valorInserido > 0 && valorInserido <= this.saldoContaCorrente) {
//				this.saldoContaCorrente -= valorInserido;
//				conta. += valorInserido;
//				System.out.println("Transferência no valor de R$" + valorInserido + " para " + conta.getUsuario().getNome());
//				return true;
//			}else{
//				return false;
//			}
//		}
//		
//		
//	}
	
	@Override
	public double getSaldo() {
		return saldoContaCorrente;
	}

}

package br.com.serratec.entidades;

import br.com.serratec.enums.TipoTaxa;

public final class ContaCorrente extends Conta {

	public ContaCorrente( int agencia, String idConta, char tipoConta, Usuario usuario) {
		super(usuario, agencia, idConta,tipoConta );
	}
	//TODO Mostrar se o cliente tem seguro de vida no relatorio

	public void TributacaoContaCorrente() {
		double valorTotalGasto = this.valorGastoSaque + this.valorGastoDeposito + this.valorGastoTransferencia;
		System.out.println("--=====TOTAL GASTO EM OPERAÇÕES=====--" + 
							"\nSaques : R$" + this.valorGastoSaque +
							"\nDepósitos: R$" + this.valorGastoDeposito +
							"\nTransferências: R$" + this.valorGastoTransferencia +
							"\nTotal: R$" + valorTotalGasto);
		
		System.out.println("\n--=====TAXAS POR OPERAÇÃO=====--" +
							"\nSaque: R$" + TipoTaxa.SAQUE.getValorTaxa() +
							"\nDepósito: R$" + TipoTaxa.DEPOSITO.getValorTaxa() +
							"\nTransferência: R$" + TipoTaxa.TRANSFERENCIA.getValorTaxa() + " (Obs:Cobrado apenas do remetente)");
		
		
	}


}

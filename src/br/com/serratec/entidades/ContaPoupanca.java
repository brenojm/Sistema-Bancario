package br.com.serratec.entidades;

import br.com.serratec.enums.TipoTaxa;
import br.com.serratec.excecoes.valorInvalidoException;

public class ContaPoupanca extends Conta {

	public ContaPoupanca(Usuario usuario, int agencia, int idConta, char tipoConta) {
		super(usuario, agencia, idConta, tipoConta);

	}

	public double rendimentoPoupanca(double valorInserido, int QuantidadeDias) {
		
	}
	

}

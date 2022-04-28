package br.com.serratec.entidades;

import br.com.serratec.enums.TipoTaxa;
import br.com.serratec.excecoes.ContaInvalidaException;
import br.com.serratec.excecoes.valorInvalidoException;
import br.com.serratec.interfaces.metodosConta;

public abstract class Conta implements metodosConta {
	private Usuario usuario;
	private int agencia;
	private int idConta;
	private char tipoConta;
	private double saldo;

	protected double valorGastoSaque;
	protected double valorGastoDeposito;
	protected double valorGastoTransferencia;

	public Conta(Usuario usuario, int agencia, int idConta, char tipoConta) {
		this.usuario = usuario;
		this.agencia = agencia;
		this.idConta = idConta;
		this.tipoConta = tipoConta;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public int getIdConta() {
		return idConta;
	}

	public char getTipoConta() {
		return tipoConta;
	}
	
	@Override
	public boolean sacar(double valorInserido) throws valorInvalidoException {

		if (valorInserido <= 0 && valorInserido > this.saldo) {
			throw new valorInvalidoException();
		}
		double valorInseridoComTaxa = (valorInserido - TipoTaxa.SAQUE.getValorTaxa());
		this.saldo -= valorInseridoComTaxa;
		this.valorGastoSaque += valorInserido;
		System.out.println("Saque no valor de R$" + valorInseridoComTaxa + " realizado com sucesso!");
		return true;

	}
	
	@Override
	public void depositar(double valorInserido) throws valorInvalidoException {
		if (valorInserido <= 0 && valorInserido > this.saldo) {
			throw new valorInvalidoException();
		}
		double valorInseridoComTaxa = (valorInserido - TipoTaxa.DEPOSITO.getValorTaxa());
		this.saldo += valorInseridoComTaxa;
		this.valorGastoDeposito += TipoTaxa.DEPOSITO.getValorTaxa();
		System.out.println("Depósito no valor de R$" + valorInseridoComTaxa + " realizado com sucesso!");

	}
	
	@Override
	public boolean transferencia(double valorInserido, Conta contaInserida) throws valorInvalidoException, ContaInvalidaException {

		if (valorInserido <= 0 && valorInserido > this.saldo) {
			throw new valorInvalidoException();
		} else if (contaInserida == null) {
			throw new ContaInvalidaException();
			//TODO ContaInserida deve ser verificada se existe
		}
		
		double valorInseridoComTaxa = (valorInserido - TipoTaxa.TRANSFERENCIA.getValorTaxa());
		this.saldo -= valorInseridoComTaxa;
		contaInserida.saldo += valorInseridoComTaxa;
		valorGastoTransferencia += valorInserido;
		System.out.println("Transferência no valor de R$" + valorInseridoComTaxa + " para " + contaInserida.getUsuario().getNome() + " concluída!");
		return true;

	}

	public double getSaldo() {
		return saldo;
	}

}

package br.com.serratec.entidades;

import br.com.serratec.enums.TipoTaxa;
import br.com.serratec.excecoes.CadastroNaoExisteException;
import br.com.serratec.excecoes.ContaInvalidaException;
import br.com.serratec.excecoes.valorInvalidoException;
import br.com.serratec.interfaces.metodosConta;
import br.com.serratec.repositorios.RepositorioContaCorrente;
import br.com.serratec.repositorios.RepositorioContaPoupanca;

public abstract class Conta implements metodosConta {
	private Usuario usuario;
	private int agencia;
	private String idConta;
	private char tipoConta;
	private double saldo;

	protected double valorGastoSaque;
	protected double valorGastoDeposito;
	protected double valorGastoTransferencia;
	
	public Conta(Usuario usuario, int agencia, String idConta, char tipoConta) {
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

	public String getIdConta() {
		return idConta;
	}

	public char getTipoConta() {
		return tipoConta;
	}
	public String getCpfPorUsuario(){
		return usuario.getCpf();
	}
	@Override
	public void sacar(double valorInserido) throws valorInvalidoException {

		if (valorInserido <= 0 && valorInserido > this.saldo) {
			throw new valorInvalidoException();
		}
		double valorInseridoComTaxa = (valorInserido - TipoTaxa.SAQUE.getValorTaxa());
		this.saldo -= valorInseridoComTaxa;
		this.valorGastoSaque += valorInserido;
		Presidente.somarCapital(TipoTaxa.SAQUE.getValorTaxa());
		System.out.println("Saque no valor de R$" + valorInseridoComTaxa + " realizado com sucesso!");
	}
	
	@Override
	public void depositar(double valorInserido) throws valorInvalidoException {
		if (valorInserido <= 0 && valorInserido > this.saldo) {
			throw new valorInvalidoException();
		}
		double valorInseridoComTaxa = (valorInserido - TipoTaxa.DEPOSITO.getValorTaxa());
		this.saldo += valorInseridoComTaxa;
		this.valorGastoDeposito += TipoTaxa.DEPOSITO.getValorTaxa();
		Presidente.somarCapital(TipoTaxa.DEPOSITO.getValorTaxa());
		System.out.println("Depósito no valor de R$" + valorInseridoComTaxa + " realizado com sucesso!");

	}
	
	@Override
	public void transferencia(double valorInserido, String cpf, char tipoContaDoRecebe) throws valorInvalidoException, ContaInvalidaException, CadastroNaoExisteException {
		Conta contaInserida = null;
		if (valorInserido <= 0 && valorInserido > this.saldo) {
			throw new valorInvalidoException();
		} else if (tipoContaDoRecebe=='c' && RepositorioContaCorrente.retornaContaCorrente(cpf) != null) {
			throw new ContaInvalidaException();
		} else if(tipoContaDoRecebe=='p' && RepositorioContaPoupanca.retornaContaPoupanca(cpf) != null) {
			throw new ContaInvalidaException();
		}
		if(tipoContaDoRecebe=='c') {
			contaInserida= RepositorioContaCorrente.retornaContaCorrente(cpf);
		}else if(tipoContaDoRecebe=='p'){
			contaInserida= RepositorioContaPoupanca.retornaContaPoupanca(cpf);
		}
		double valorInseridoComTaxa = (valorInserido - TipoTaxa.TRANSFERENCIA.getValorTaxa());
		this.saldo -= valorInseridoComTaxa;
		contaInserida.saldo += valorInseridoComTaxa;
		valorGastoTransferencia += valorInserido;
		Presidente.somarCapital(TipoTaxa.TRANSFERENCIA.getValorTaxa());
		System.out.println("Transferência no valor de R$" + valorInseridoComTaxa + " para " + contaInserida.getUsuario().getNome() + " concluída!");
	}

	public double getSaldo() {
		return saldo;
	}
}

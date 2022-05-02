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
	protected static int quantidadeAgencia1234, quantidadeAgencia4321, quantidadeAgencia7883, quantidadeAgencia3533;
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

	public String getCpfPorUsuario() {
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
	public void transferencia(double valorInserido, String cpf, char tipoContaDoRecebe)
			throws valorInvalidoException, ContaInvalidaException, CadastroNaoExisteException {
		Conta contaInserida = null;
		if (valorInserido <= 0 && valorInserido > this.saldo) {
			throw new valorInvalidoException();
		} else if (tipoContaDoRecebe == 'c' && RepositorioContaCorrente.retornaContaCorrente(cpf) == null) {
			throw new ContaInvalidaException();
		} else if (tipoContaDoRecebe == 'p' && RepositorioContaPoupanca.retornaContaPoupanca(cpf) == null) {
			throw new ContaInvalidaException();
		}
		if (tipoContaDoRecebe == 'c') {
			contaInserida = RepositorioContaCorrente.retornaContaCorrente(cpf);
		} else if (tipoContaDoRecebe == 'p') {
			contaInserida = RepositorioContaPoupanca.retornaContaPoupanca(cpf);
		}
		double valorInseridoComTaxa = (valorInserido - TipoTaxa.TRANSFERENCIA.getValorTaxa());
		this.saldo -= valorInseridoComTaxa;
		contaInserida.saldo += valorInseridoComTaxa;
		valorGastoTransferencia += valorInserido;
		Presidente.somarCapital(TipoTaxa.TRANSFERENCIA.getValorTaxa());
		System.out.println("Transferência no valor de R$" + valorInseridoComTaxa + " para "
				+ contaInserida.getUsuario().getNome() + " concluída!");
	}

	public void getSaldoMenu() {
		System.out.printf("%s%.1f%s", "Seu saldo atual é R$", saldo, "\n");
	}
	
	public void setSeguro(double valorSeguro) {
		this.saldo -= valorSeguro;
	}

	public double getSaldo() {
		return saldo;
	}

	public static int getQuantidadeAgencia(int numAgencia) {
		switch (numAgencia) {
		case 1234:
			return quantidadeAgencia1234;
		case 4321:
			return quantidadeAgencia4321;
		case 7833:
			return quantidadeAgencia7883;
		case 3533:
			return quantidadeAgencia3533;
		default:
			return 0;
		}
	}

	public static void aumentaQuantidadeAgencia1234() {
		Conta.quantidadeAgencia1234++;
	}

	public static void aumentaQuantidadeAgencia4321() {
		Conta.quantidadeAgencia4321++;
	}

	public static void aumentaQuantidadeAgencia7883() {
		Conta.quantidadeAgencia7883++;
	}

	public static void aumentaQuantidadeAgencia3533() {
		Conta.quantidadeAgencia3533++;
	}

}

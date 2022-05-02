package br.com.serratec.interfaces;

import br.com.serratec.excecoes.CadastroNaoExisteException;
import br.com.serratec.excecoes.ContaInvalidaException;
import br.com.serratec.excecoes.valorInvalidoException;

public interface metodosConta {

	public void sacar(double valorInserido) throws valorInvalidoException;

	public void depositar(double valor) throws valorInvalidoException;

	public void transferencia(double valorInserido, String cpf, char tipoConta)
			throws valorInvalidoException, ContaInvalidaException, CadastroNaoExisteException;

}

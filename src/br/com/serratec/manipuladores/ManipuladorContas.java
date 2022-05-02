package br.com.serratec.manipuladores;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import br.com.serratec.entidades.Conta;
import br.com.serratec.entidades.ContaCorrente;
import br.com.serratec.entidades.ContaPoupanca;
import br.com.serratec.entidades.Usuario;
import br.com.serratec.excecoes.CadastroJaExisteException;
import br.com.serratec.excecoes.CadastroNaoExisteException;
import br.com.serratec.repositorios.RepositorioContaCorrente;
import br.com.serratec.repositorios.RepositorioContaPoupanca;
import br.com.serratec.repositorios.RepositorioUsuario;

public class ManipuladorContas {
	public static void arquivoContasloader() throws CadastroNaoExisteException, IOException, CadastroJaExisteException {
		File arquivoContas = new File("contas.txt");

		FileReader leitorContas = null;
		leitorContas = new FileReader(arquivoContas);

		BufferedReader leitorContasbr = new BufferedReader(leitorContas);

		do {
			String contaString = leitorContasbr.readLine();
			if (contaString == null) {
				break;
			}
			String[] contaVetor = contaString.split(";");

			int agencia = Integer.parseInt(contaVetor[0]);
			String idConta = contaVetor[1];
			char tipoConta = contaVetor[2].charAt(0);
			String usuariocpf = contaVetor[3];
			Usuario usuario = RepositorioUsuario.retornaUsuario(usuariocpf);
			if (tipoConta == 'c') {
				Conta conta = new ContaCorrente(agencia, idConta, tipoConta, usuario);
				RepositorioContaCorrente.adicionaContaCorrente(conta);
			}
			if (tipoConta == 'p') {
				Conta conta = new ContaPoupanca(agencia, idConta, tipoConta, usuario);
				RepositorioContaPoupanca.adicionaConta(conta);
			}
		} while (true);

		leitorContas.close();
		leitorContasbr.close();

	}
}

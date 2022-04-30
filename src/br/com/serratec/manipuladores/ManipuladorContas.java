package br.com.serratec.manipuladores;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import br.com.serratec.entidades.Cliente;
import br.com.serratec.entidades.Conta;
import br.com.serratec.entidades.ContaCorrente;
import br.com.serratec.entidades.ContaPoupanca;
import br.com.serratec.entidades.Diretor;
import br.com.serratec.entidades.Gerente;
import br.com.serratec.entidades.Presidente;
import br.com.serratec.entidades.Usuario;
import br.com.serratec.excecoes.CadastroJaExisteException;
import br.com.serratec.excecoes.CadastroNaoExisteException;
import br.com.serratec.repositorios.RepositorioContaCorrente;
import br.com.serratec.repositorios.RepositorioContaPoupanca;
import br.com.serratec.repositorios.RepositorioUsuario;

public class ManipuladorContas {
		public static void arquivoContasloader(String cpf, ContaCorrente ContaCorrente, ContaPoupanca ContaPoupanca) throws CadastroNaoExisteException, IOException, CadastroJaExisteException{
	        	File arquivoContas = new File("contas.txt");

	        	FileReader leitorContas = null;
	        	leitorContas = new FileReader(arquivoContas);

	        	BufferedReader leitorContasbr = new BufferedReader(leitorContas);

	        	do {
	            String contaString = leitorContasbr.readLine();
	            if(contaString == null) {
	                break;
	            }
	            String[] contaVetor = contaString.split(";");

	            int agencia = Integer.parseInt(contaVetor[0]);
	            String idConta = contaVetor[1];
	            char tipoConta = valueOf(contaVetor[2]);
	            Usuario usuario = RepositorioUsuario.retornaUsuario(cpf) ;
	            
	        	if(tipoConta == 'c') {
	        	Conta conta = new ContaCorrente(agencia, idConta, tipoConta, usuario);	
	            RepositorioContaCorrente.adicionaContaCorrente(ContaCorrente);
	        	}
	        	if(tipoConta == 'p') {
	        	Conta conta = new ContaPoupanca(agencia, idConta, tipoConta,usuario);
	        	RepositorioContaPoupanca.adicionaConta(ContaPoupanca);
	        	}
		}while(true);
	        	
	        	leitorContas.close();
	        	leitorContasbr.close();
	        
				}
				private static char valueOf(String string) {
					
					return 0;
				}

}

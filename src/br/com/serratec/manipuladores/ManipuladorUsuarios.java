package br.com.serratec.manipuladores;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import br.com.serratec.entidades.Cliente;
import br.com.serratec.entidades.Diretor;
import br.com.serratec.entidades.Gerente;
import br.com.serratec.entidades.Presidente;
import br.com.serratec.entidades.Usuario;
import br.com.serratec.excecoes.CadastroJaExisteException;
import br.com.serratec.excecoes.DocumentoInvalido;
import br.com.serratec.repositorios.RepositorioUsuario;

public class ManipuladorUsuarios {
	public static void arquivoUsuarioloader() throws CadastroJaExisteException, DocumentoInvalido, IOException{
        	File arquivoUsuario = new File("usuarios.txt");

        	FileReader leitorUsuario = null;
        	leitorUsuario = new FileReader(arquivoUsuario);

        	BufferedReader leitorUsuariobr = new BufferedReader(leitorUsuario);

        	do {
            String usuarioString = leitorUsuariobr.readLine();
            if(usuarioString == null) {
                break;
            }
            String[] usuarioVetor = usuarioString.split(";");

            String nome = usuarioVetor[0];
            String cpf = usuarioVetor[1];
            String senha = usuarioVetor[2];
            String cargo = usuarioVetor[3];
            int agencia = Integer.parseInt(usuarioVetor[4]);
            if(cargo.equals("gerente")) {
            Usuario usuario = new Gerente (nome, cpf, senha, cargo, agencia);
            RepositorioUsuario.adicionaUsuario(usuario);
        	}
        	if(cargo.equals("presidente")) {
            Usuario usuario = new Presidente (nome, cpf, senha, cargo);
            RepositorioUsuario.adicionaUsuario(usuario);
			}
			if(cargo.equals("diretor")) {
			Usuario usuario = new Diretor (nome, cpf, senha, cargo);
			RepositorioUsuario.adicionaUsuario(usuario);
			}
			if(cargo.equals(null)) {
			Usuario usuario = new Cliente (nome, cpf, senha);
			RepositorioUsuario.adicionaUsuario(usuario);
			}


			}while(true);
        	
        	leitorUsuario.close();
        	leitorUsuariobr.close();
			}
			}

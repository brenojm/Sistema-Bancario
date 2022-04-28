package br.com.serratec.dominio;

import br.com.serratec.entidades.Funcionario;
import br.com.serratec.excecoes.DocumentoInvalido;

public class Teste {
	
	public static void main (String[] args) throws DocumentoInvalido{
		Funcionario usuario1= new Funcionario("Maria", "12345678901", "123","Gerente");
		Funcionario usuario2= new Funcionario("João",  "10987654324", "321","Presidente");
	
		System.out.println(usuario1.toString()+"\n"+usuario2.toString());
	}

}
package br.com.serratec.entidades;

import br.com.serratec.excecoes.DocumentoInvalido;

public class Presidente extends Funcionario{

	public Presidente(String nome, String cpf, String senha, String cargo) throws DocumentoInvalido {
		super(nome, cpf, senha, cargo);
	}
	
	//Variavel para soma das taxas cobradas pelo banco, para somar no capital total do campo
	private static double capitalTaxa;
	//TODO Somar todos os saldos junto a capital de taxas para ter o capital total do banco
	private static double capitalTotalBanco;
	
	public static double getCapitalTaxa() {
		return capitalTaxa;
	}

	public static void somarCapital(double taxaInserida) {
		capitalTaxa += taxaInserida;
	}
	
	public double getCapitalTotalBanco() {
		return capitalTotalBanco;
	}

	
}

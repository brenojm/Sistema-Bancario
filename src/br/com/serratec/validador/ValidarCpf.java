package br.com.serratec.validador;


import br.com.serratec.excecoes.DocumentoInvalido;

public class ValidarCpf {
	public static String validarCpf(String cpf) throws DocumentoInvalido {
		if(cpf.length() != 11) {
			throw new DocumentoInvalido();
		}
		return cpf;
	}
}

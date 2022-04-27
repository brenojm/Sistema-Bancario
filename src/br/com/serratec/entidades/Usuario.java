package br.com.serratec.entidades;

import br.com.serratec.excecoes.AutenticacaoLogin;
import br.com.serratec.excecoes.DocumentoInvalido;
import br.com.serratec.interfaceUsuario.Autenticacao;
import br.com.serratec.validador.ValidarCpf;

public abstract class Usuario implements Autenticacao {
	protected String nome;
	protected final String cpf;
	protected String senha;

	public Usuario(String nome, String cpf, String senha) throws DocumentoInvalido {
		this.nome = nome;
		this.cpf = ValidarCpf.validarCpf(cpf);
		this.senha = senha;
	}
	public void autenticar(String login) throws AutenticacaoLogin {
		if(!this.cpf.equals(login) && !this.senha.equals(login)) {
			throw new AutenticacaoLogin();
		}
	}
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}
<<<<<<< Updated upstream
	public void autenticar(String cpfDigitado, String senhaDigitada ) throws LoginInvalidoException 
        if(!this.cpf.equals(cpfDigitado)  && !this.senha.equals(senhaDigitada)) {
           throw new LoginInvalido();
                System.out.println("Usuário logado com sucesso");
            }

}  


    

=======
	
}
>>>>>>> Stashed changes

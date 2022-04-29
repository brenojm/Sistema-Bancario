package br.com.serratec.entidades;

import java.time.LocalDate;
import java.util.List;


import br.com.serratec.excecoes.CpfInvalidoException;
import br.com.serratec.excecoes.SaldoInsuficienteException;
import br.com.serratec.excecoes.valorInvalidoException;
import br.com.serratec.interfaces.TaxasDaConta;

public class SeguroVida {
	private double ValorSeguro;

	public double getValorSeguro() {
		return ValorSeguro;
	}

	public void setValorSeguro(double valorSeguro) {
		ValorSeguro = valorSeguro;
	}	
	private String cpfSegurado;
    private double valorSegurado;
    private int qtdMeses;
    private double tributoSeguro;
    private List<String> listaSegurados;
    private LocalDate dataContratacao;
	
   
    
    public SeguroVida(String cpfSegurado, double valorSegurado, int qtdMeses, List<String> segurados) throws CpfInvalidoException, SaldoInsuficienteException, valorInvalidoException {
        if (qtdMeses <= 0 || valorSegurado <= 0) {
            throw new valorInvalidoException();
        }
        
        // falta o repositório da conta
        //if((valorSegurado * TaxasDaConta.taxaSeguroDeVida) > (cpfSegurado).getSaldo()) {
        //    throw new SaldoInsuficienteException();
    
        this.cpfSegurado = cpfSegurado;
        this.valorSegurado = valorSegurado;
        this.qtdMeses = qtdMeses;
        this.dataContratacao = LocalDate.now();
        this.listaSegurados = segurados;
        this.tributoSeguro = valorSegurado * TaxasDaConta.taxaSeguroDeVida;
    
    }
    
            
         
            				        
            				   
            				        
        public SeguroVida(String cpfSegurado, double valorSegurado, int qtdMeses, double tributoSeguro,
		List<String> listaSegurados, LocalDate dataContratacao) {
		super();
		this.cpfSegurado = cpfSegurado;
		this.valorSegurado = valorSegurado;
		this.qtdMeses = qtdMeses;
		this.tributoSeguro = tributoSeguro;
		this.listaSegurados = listaSegurados;
		this.dataContratacao = dataContratacao;
	}
        
        public double calculaValorMensal() {
        return (this.valorSegurado * (1 - TaxasDaConta.taxaSeguroDeVida)) / qtdMeses;  
        }






		public String getCpfSegurado() {
			return cpfSegurado;
		}






		public double getValorSegurado() {
			return valorSegurado;
		}






		public int getQtdMeses() {
			return qtdMeses;
		}






		public double getTributoSeguro() {
			return tributoSeguro;
		}






		public List<String> getListaSegurados() {
			return listaSegurados;
		}






			public LocalDate getDataContratacao() {
			return dataContratacao;
		}
        
										
            
    
    
    
}
       
    
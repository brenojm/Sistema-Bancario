package br.com.serratec.entidades;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import br.com.serratec.enums.TipoTaxa;
import br.com.serratec.excecoes.DataParseException;
import br.com.serratec.excecoes.PeriodoInvalidoException;
import br.com.serratec.excecoes.valorInvalidoException;

public class ContaPoupanca extends Conta {

	public ContaPoupanca( int agencia, String idConta, char tipoConta, Usuario usuario) {
		super(usuario, agencia, idConta, tipoConta);

	}

	public void rendimentoPoupanca(double valorInserido, String dataInicialString, String dataFinalString) throws valorInvalidoException {
			if(valorInserido <= 0 && valorInserido > this.getSaldo()) {
				throw new valorInvalidoException();
			}
			
		//try {
			
			DateTimeFormatter formatoDataBrasil = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate dataInseridaInicial = LocalDate.parse(dataInicialString, formatoDataBrasil);
			LocalDate dataInseridaFinal = LocalDate.parse(dataFinalString, formatoDataBrasil);
			if(1 <= dataInseridaFinal.getMonthValue() - dataInseridaInicial.getMonthValue()) {
				//throw new PeriodoInvalidoException();
			}
//			if(dataInseridaInicial.isBefore(LocalDate.now())) {
//				throw new DataParseException();
//			}
//			if(dataInseridaFinal.isBefore(dataInseridaInicial)) {
//				throw new DataParseException();
//			}
			
			int mesesInseridos = (dataInseridaFinal.getMonthValue() - dataInseridaInicial.getMonthValue());
			double rendimentoTotal=valorInserido;
			for(int i = 1; i<=mesesInseridos ; i++) {
				rendimentoTotal += rendimentoTotal*TipoTaxa.RENDIMENTO.getValorTaxa();
				
			}
			
			System.out.println("--===Simulação Rendimento da Poupança===--" +
								"\nRendimento: R$" + String.format("%.2f",rendimentoTotal) +
								"\nData Inicial: " + formatoDataBrasil.format(dataInseridaInicial) +
								"\nData Final: " + formatoDataBrasil.format(dataInseridaFinal) +
								"\nMeses: " + mesesInseridos +
								"\nRendimento Líquido: R$" + String.format("%.2f",(rendimentoTotal - valorInserido)) +
								"\nValor Inicial : R$" + String.format("%.2f",valorInserido));
			
			
//		} catch (DataParseException e){
//			e.getMessage();
//		} 
//		catch (PeriodoInvalidoException e) {
//			e.getMessage();
//		}
		
	}
	
	

}

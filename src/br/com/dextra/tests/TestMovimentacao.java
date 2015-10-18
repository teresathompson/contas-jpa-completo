package br.com.dextra.tests;

import java.math.BigDecimal;
import java.util.List;

import br.com.dextra.financas.modelo.Movimentacao;
import br.com.banco.service.MovimentacaoService;
import br.com.banco.service.PessoaService;

public class TestMovimentacao {


	public static void main(String[] args) {

		// Testando persistencia de dados basica
		Movimentacao mov1 = new Movimentacao();
		mov1.setDescricao("Saque");
		mov1.setTipo("SAIDA");
		mov1.setValor(1000D);
		mov1.setData("2015-08-13");

		//MovimentacaoService.inserir(mov1);
		procuraMovimentacaoPorDescricao("Saque");
		impriveTotalMovimentacaoPorTipo("SAIDA");
	}


	public static void procuraMovimentacaoPorDescricao(String descricao) {

		System.out.println("---------------- Listando uma movimentacao com descricao : " + descricao + " --------------");

		Movimentacao mov = 
		MovimentacaoService.buscaApenasUmaMovimentacao(descricao);

		System.out.println(mov.getDescricao());
		System.out.println(mov.getTipo());

		System.out.println("-------------------------------------------------------------------------------");
	}
	
	public static void impriveTotalMovimentacaoPorTipo(String tipo){
		
		System.out.println("---------------- Imprimindo total de movimetacoes do tipo : " + tipo + " --------------");
		
		Double totalMovimentacoes = MovimentacaoService.somaTotalMovimentacoesPorTipo(tipo);
		
		System.out.println("Total de "+ tipo + " R$ " + totalMovimentacoes);
		
		System.out.println("-----------------------------------------------------------------------------");
		
	}
}

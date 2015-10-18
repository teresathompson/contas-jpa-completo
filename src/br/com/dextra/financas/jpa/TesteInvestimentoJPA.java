package br.com.dextra.financas.jpa;

import java.util.ArrayList;
import java.util.List;

import br.com.banco.service.InvestimentoService;
import br.com.dextra.financas.modelo.Investimento;

public class TesteInvestimentoJPA {
	
	public static void main(String[] args) {
		
		
		// Criado novo investimento
		Investimento di = new Investimento();
		Investimento poup = new Investimento();
		
		di.setDescricao("Tesouro Nacional");
		di.setValor(1000D);
		di.setRendimentoMensal(9D);
		
		poup.setDescricao("Previdencia Privada");
		poup.setValor(45000D);
		poup.setRendimentoMensal(0.6D);
		
	
		
		// Peristindo dados atraves da classe InvestimentoService
		InvestimentoService.inserir(di);
		InvestimentoService.inserir(poup);
		
		
		TesteInvestimentoJPA.listarInvestimentosPorRendimentoValor(1000, 10);
		
		System.out.println("--------------------------------------------------------------");
		
		TesteInvestimentoJPA.listarInvestimentoPorParteNome("DI");
		
	
				
	}
	
	public void inserirInvestimento() {
		
		// Criado novo investimento
		Investimento investimento = new Investimento();
		
		investimento.setDescricao("DI");
		investimento.setValor(2200D);
		investimento.setRendimentoMensal(8D);
	}
	
	public void listarInvestimentosDecrescente() {
		
		// Coletando lista de investimentos ordenados por valor (decrescente)
		List<Investimento> listaInvestimentos = new ArrayList<Investimento>();
		
		listaInvestimentos = InvestimentoService.buscarOrdenadoPorValor();
		
		for(Investimento inv : listaInvestimentos) {
			System.out.println(inv.getDescricao());
			System.out.println(inv.getValor());
			System.out.println(inv.getRendimentoMensal());
		}
	}
	
	public static void listarInvestimentosPorRendimentoValor
	(double valorInvestimento,double rendimentoMensal){
		
		List<Investimento> listaInvestimentosPorRendaValor = new ArrayList<Investimento>();
		
		listaInvestimentosPorRendaValor = 
				InvestimentoService.buscarInvestimentosPorValorRendaMensal
				(valorInvestimento, rendimentoMensal);
		
		for(Investimento inv : listaInvestimentosPorRendaValor) {
			System.out.println(inv.getDescricao());
			System.out.println(inv.getValor());
			System.out.println(inv.getRendimentoMensal());
		}
		
		
	}
	
	
	public static void listarInvestimentoPorParteNome(String parteNome) {
		
		List<Investimento> listaInvestimentosPorParteNome = new ArrayList<Investimento>();
		
		listaInvestimentosPorParteNome = InvestimentoService.buscarInvestimentoPorParteNome(parteNome);
		
		for(Investimento inv : listaInvestimentosPorParteNome) {
			System.out.println(inv.getDescricao());
			System.out.println(inv.getValor());
			System.out.println(inv.getRendimentoMensal());
		}
		
		
	}
}

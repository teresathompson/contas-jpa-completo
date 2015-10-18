package br.com.banco.service;

import java.util.List;

import javax.persistence.TypedQuery;

import common.service.EntityManagerUtil;
import br.com.dextra.financas.modelo.Investimento;

public class InvestimentoService {
	
	public static Investimento inserir(Investimento i) {
		EntityManagerUtil.begin();
		EntityManagerUtil.getEM().persist(i);
		EntityManagerUtil.commit();
		return i;
	}
	
	public static Investimento buscarPorId(Long id) {
		return EntityManagerUtil.getEM().find(Investimento.class, id);
	}
	
	
	public static List<Investimento> buscarOrdenadoPorValor() {
		
		String jpql = "FROM " + Investimento.class.getSimpleName()
					+ " ORDER BY valor DESC";

		TypedQuery<Investimento> query = 
				EntityManagerUtil.getEM().createQuery(jpql,Investimento.class);
		
		return query.getResultList(); 
	}
	
	public static List<Investimento> buscarInvestimentosPorValorRendaMensal
								(double valorInvestimento, double rendaMensal){
		
		String jpql = "FROM " + Investimento.class.getSimpleName() + " "
				+ "WHERE valor >= :valorInvestimento AND "
				+ "rendimentomensal > :rendaMensal ";
				
		
		TypedQuery<Investimento> query = 
				EntityManagerUtil.getEM().createQuery(jpql,Investimento.class);
		
		query.setParameter("rendaMensal", rendaMensal);
		query.setParameter("valorInvestimento", valorInvestimento);
		
		return query.getResultList();
	}
	
	public static List<Investimento> buscarInvestimentoPorParteNome(String parteNome) {
		
		String jpql = "FROM " + Investimento.class.getSimpleName() + " WHERE descricao LIKE :parteNome";
		
		TypedQuery<Investimento> query = EntityManagerUtil.getEM().createQuery(jpql,Investimento.class);
		
		query.setParameter("parteNome", "%" + parteNome + "%");
		
		return query.getResultList();
		
		
		
	}
}

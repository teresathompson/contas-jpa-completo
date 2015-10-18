package br.com.banco.service;

import java.math.BigDecimal;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.dextra.financas.modelo.Conta;
import br.com.dextra.financas.modelo.Movimentacao;
import br.com.dextra.financas.modelo.Pessoa;
import common.service.EntityManagerUtil;

public class MovimentacaoService {
	
	public static Movimentacao inserir(Movimentacao m) {
		EntityManagerUtil.begin();
		EntityManagerUtil.getEM().persist(m);
		EntityManagerUtil.commit();
		return m;
	}
	
	
	public static Movimentacao buscarPorId(Long id) {
		return EntityManagerUtil.getEM().find(Movimentacao.class, id);
	}
	
	public static Movimentacao buscaApenasUmaMovimentacao
	(String descricao){
		
		String jpql = "";
		jpql += "SELECT movimentacao FROM Movimentacao "
				+ " movimentacao ";
		jpql += " WHERE movimentacao.descricao = :descricao";
		
		TypedQuery<Movimentacao> query = 
				EntityManagerUtil.getEM().
				createQuery(jpql, Movimentacao.class);
		
		query.setParameter("descricao",descricao);
		
		//Movimentacao movimentacao = new Movimentacao();
		//return movimentacao = query.getSingleResult();
		return query.getSingleResult();
		
	}
	
	public static Double somaTotalMovimentacoesPorTipo(String tipo) {
		
		String jpql = "select sum(m.valor) from Movimentacao m where m.tipo=:tipo";

		Query query = EntityManagerUtil.getEM().createQuery(jpql);

		query.setParameter("tipo", tipo);
		
		return (Double) query.getSingleResult();
		
	}

}

package br.com.banco.service;

import java.util.List;

import javax.persistence.TypedQuery;

import br.com.dextra.financas.modelo.Pessoa;
import br.com.dextra.financas.modelo.PessoaAula1;
import br.com.dextra.financas.modelo.UF;
import common.service.EntityManagerUtil;

public class PessoaServiceAula1 {
	
	
	/**
	 * Metodo padrao do EntityManager para persistir dados
	 * @param p
	 * @return
	 */
	public static PessoaAula1 inserir(PessoaAula1 p) {
		EntityManagerUtil.begin();
		EntityManagerUtil.getEM().persist(p);
		EntityManagerUtil.commit();
		return p;
	}

	/**
	 * Metodo padrao do EntityManager que retorna registro pela chave primaria
	 * @param id
	 * @return
	 */
	public static PessoaAula1 buscarPorId(Long id) {
		return EntityManagerUtil.
				getEM().find(PessoaAula1.class, id);
	}
	
	public static List<PessoaAula1> buscaTodasPessoas() {
		String jpql = "SELECT p FROM " + PessoaAula1.class.getSimpleName() + " p";
		
		TypedQuery<PessoaAula1> qry = 
		EntityManagerUtil.getEM().
		createQuery(jpql, PessoaAula1.class);
		return qry.getResultList();
	}
	
	
}

package br.com.banco.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.dextra.financas.modelo.UF;
import br.com.dextra.financas.modelo.Pessoa;
import common.service.EntityManagerUtil;

public class PessoaService {

	public static Pessoa inserir(Pessoa p) {
		EntityManagerUtil.begin();
		EntityManagerUtil.getEM().persist(p);
		EntityManagerUtil.commit();
		return p;
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public static Pessoa buscarPorId(Long id) {
		return EntityManagerUtil.getEM().find(Pessoa.class, id);
	}


	/**
	 * 
	 * @return
	 */
	public static List<Pessoa> buscarOrdenadoPorNome() {

		String jpql = "FROM " + Pessoa.class.getSimpleName()
				+ " ORDER BY nome DESC";

		TypedQuery<Pessoa> query = 
				EntityManagerUtil.getEM().createQuery(jpql,Pessoa.class);


		return query.getResultList(); 
	}

	/**
	 * 
	 */
	public static void listarPessoasDecrescente() {

		// Coletando lista de investimentos ordenados por valor (decrescente)
		List<Pessoa> listaPessoas = new ArrayList<Pessoa>();

		listaPessoas = PessoaService.buscarOrdenadoPorNome();

		for(Pessoa p : listaPessoas) {
			System.out.println(p.getId());
			System.out.println(p.getNome());
		}
	}

	public static List<Pessoa> buscarPorEstado(UF uf) {
		String jpql = "SELECT p FROM " + Pessoa.class.getSimpleName() + " p"
				+ " WHERE p.endereco.estado = :uf";

		TypedQuery<Pessoa> qry = EntityManagerUtil.getEM().createQuery(jpql, Pessoa.class);
		qry.setParameter("uf", uf);

		return qry.getResultList();
	}

	public static List<Pessoa> listaAgenciasPessoasPorEstado(UF uf) {
		String jpql = "";
		jpql += "SELECT pessoa FROM Pessoa pessoa";
		jpql += " WHERE pessoa.agencia.estado = :uf";

		TypedQuery<Pessoa> qry = EntityManagerUtil.getEM().createQuery(jpql, Pessoa.class);
		qry.setParameter("uf", uf);

		return qry.getResultList();
	}

	public static List<Pessoa> listaPessoasComDDDInformado(String DDD) {

		String jpql = "";
		jpql += "SELECT pessoa FROM Pessoa pessoa";
		jpql += " INNER JOIN pessoa.telefones telefone";
		jpql += " WHERE telefone.DDD = :ddd";

		TypedQuery<Pessoa> query = EntityManagerUtil.getEM().createQuery(jpql, Pessoa.class);
		query.setParameter("ddd", DDD);

		return query.getResultList();

	}

	public static List<Pessoa> listaPessoasDoPacoteInformado(String nomePacote) {
		String jpql = "";
		jpql += "SELECT p FROM Pessoa p";
		jpql += " INNER JOIN p.pacoteServicos pacoteServicos ";
		jpql += " WHERE pacoteServicos.nome = :nomePacote";

		TypedQuery<Pessoa> query = EntityManagerUtil.getEM().createQuery(jpql, Pessoa.class);
		query.setParameter("nomePacote",nomePacote);

		return query.getResultList();
	}

	public static List<Object[]> 
	listaApenasUmAtributoDePessoa(String nome) {

		String jpql;
		jpql = "SELECT p FROM "
				+ " Pessoa p WHERE p.nome = :nome";

		Query query = EntityManagerUtil.getEM().createQuery(jpql);
		query.setParameter("nome",nome);

		List<Object[]> lista = query.getResultList();

		return lista;
	}

	public static void testaCacheJPA(Long id) {

		Pessoa pAnt = null;
		for(int i = 1 ; i <= 1000 ; i++){
			Pessoa p = EntityManagerUtil.getEM().
					find(Pessoa.class, id);
			//pode-se tentar fazer o mesmo select várias vezes
			//mas o entity manager somente irá ao banco uma vez

			System.out.println(p.getNome());
			if (pAnt != null) {
				// sempre o mesmo endereço de memória
				System.out.println
				("Testando se objeto pAnt == p:");	
				System.out.println(pAnt==p);
			}
			pAnt = p;
		}		
	}

	public static Pessoa testaQueryCacheada(String nome) {

		Query query = EntityManagerUtil.getEM().
				createNamedQuery("Pessoa.findByNome");
		query.setParameter(1, nome);
		
		try {
			return (Pessoa) query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
}




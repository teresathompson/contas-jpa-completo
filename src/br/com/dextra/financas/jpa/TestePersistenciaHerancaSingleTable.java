package br.com.dextra.financas.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.dextra.testesheranca.PessoaFisicaSingleTable;
import br.com.dextra.testesheranca.PessoaJuridicaSingleTable;

public class TestePersistenciaHerancaSingleTable {
	
	public static void main(String[] args) {
		
		PessoaFisicaSingleTable pfsingle = new PessoaFisicaSingleTable();
		PessoaJuridicaSingleTable pjsingle = new PessoaJuridicaSingleTable();
		
		pfsingle.setNome("Jorge Magnani");
		pfsingle.setCPF("111.111.111-11");
		
		pjsingle.setNome("Empresa tal");
		pjsingle.setCNPJ("000000/00001");
		
		
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("contas-postgres");

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		em.persist(pfsingle);
		em.persist(pjsingle);

		em.getTransaction().commit();
		em.close();
		
	}

}

package br.com.dextra.financas.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.dextra.testesheranca.PessoaFisicaJoined;
import br.com.dextra.testesheranca.PessoaJuridicaJoined;

public class TestePersistenciaHerancaJoined {

	public static void main(String[] args) {
		
		PessoaFisicaJoined pfJoined = new PessoaFisicaJoined();
		PessoaJuridicaJoined pjJoined = new PessoaJuridicaJoined();
		
		pfJoined.setNome("Homem Aranha");
		pfJoined.setCPF("333.333.333-00");
		
		
		pjJoined.setNome("Dextraining");
		pjJoined.setCNPJ("0000000/00001");
		
		
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("contas-postgres");

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		em.persist(pfJoined);
		em.persist(pjJoined);

		em.getTransaction().commit();
		em.close();
		
		
	}
	
}

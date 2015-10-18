package br.com.dextra.financas.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.dextra.testesheranca.PessoaFisicaTablePerClass;
import br.com.dextra.testesheranca.PessoaJuridicaTablePerClass;
import br.com.dextra.testesheranca.PessoaTablePerClass;

public class TestePersistenciaHerancaTablePerClass {
	
	public static void main(String[] args) {
		
		//PessoaTablePerClass p1 = new PessoaTablePerClass();
		//PessoaTablePerClass p2 = new PessoaTablePerClass();
		PessoaFisicaTablePerClass pfTablePerClass = new PessoaFisicaTablePerClass();
		PessoaJuridicaTablePerClass pjTablePerClass = new PessoaJuridicaTablePerClass();
		
		
		//p1.setNome("Zé");
		pfTablePerClass.setNome("Jorge Magnani");
		pfTablePerClass.setCPF("111.111.111-11");
		
		//p2.setNome("João");
		pjTablePerClass.setNome("Empresa de laranja");
		pjTablePerClass.setCNPJ("000000/0001");
		
		
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("contas-postgres");

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		//em.persist(p1);
		//em.persist(p2);
		em.persist(pfTablePerClass);
		em.persist(pjTablePerClass);

		em.getTransaction().commit();
		em.close();
		
		
	}

}

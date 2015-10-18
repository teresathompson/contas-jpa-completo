package br.com.dextra.financas.jpa;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.dextra.financas.modelo.Conta;

public class TesteJPA {

	public static void main(String[] args) {

		double inicio = System.currentTimeMillis();
		
		
		Conta conta = new Conta();
		conta.setTitular("Armando da Silva");
		conta.setBanco("Banco do Brasil");
		conta.setAgencia("0316");
		conta.setNumero("54321");
		conta.setSaldo(new BigDecimal(1234.48));

		/**
		 * Usando HSQLDB
		 */

		// EntityManagerFactory emf = Persistence
		// 		.createEntityManagerFactory("contas-hsqldb");

		/**
		 * Usando PostgreSQL
		 */
		EntityManagerFactory emf = Persistence
		 		.createEntityManagerFactory("contas-postgres");

		/*
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("contasmysql");

		*/
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		em.persist(conta);

		em.getTransaction().commit();
		em.close();
		
		double fim = System.currentTimeMillis();
		System.out.println("Executado em: " + (fim - inicio)/1000 + "s");
	}
}

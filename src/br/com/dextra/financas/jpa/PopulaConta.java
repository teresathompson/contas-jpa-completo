package br.com.dextra.financas.jpa;

import javax.persistence.EntityManager;

import br.com.dextra.financas.modelo.Conta;
import common.service.JPAUtil;


public class PopulaConta {

	public static void main(String[] args) {

		/**
		 * Nesta classe estamos gerenciando o EntityManager manualmente, 
		 * mas isso é proposital, neste exemplo, 
		 * vamos explorar os estados dos Objetos gerenciados pelo JPA.
		 */

		EntityManager manager = new JPAUtil().getEntityManager();

		manager.getTransaction().begin();

		/**
		 * 1 - Estado MANAGED
		 */

		Conta conta1 = new Conta();
		Conta conta2 = new Conta();
		Conta conta3 = new Conta();
		Conta conta4 = new Conta();
		Conta conta5 = new Conta();


		conta1.setBanco("001 - BANCO DO BRASIL");
		conta1.setNumero("16987-8");
		conta1.setAgencia("6543");
		conta1.setTitular("Maria dos Santos");

		conta2.setBanco("237 - BANCO BRADESCO");
		conta2.setNumero("86759-1");
		conta2.setAgencia("1745");
		conta2.setTitular("Paulo Roberto Souza");

		conta3.setBanco("341 - BANCO ITAU UNIBANCO");
		conta3.setNumero("46346-3");
		conta3.setAgencia("4606");
		conta3.setTitular("Antonio Duraes");

		conta4.setBanco("033 - BANCO SANTANDER");
		conta4.setNumero("12345-6");
		conta4.setAgencia("9876");
		conta4.setTitular("Leandra Marques");

		conta5.setBanco("104 - CAIXA ECONOMICA FEDERAL");
		conta5.setNumero("98654-3");
		conta5.setAgencia("1234");
		conta5.setTitular("Alexandre Duarte");

		// persistindo as contas
		manager.persist(conta1);
		manager.persist(conta2);
		manager.persist(conta3);
		manager.persist(conta4);
		manager.persist(conta5);

		manager.getTransaction().commit();
		

		// Agora vamos buscar um objeto do banco e forcar um UPDATE,
		// após o update, o objeto deverá ficar no estado MANAGED!

	
		Conta contaUpdate = manager.find(Conta.class, 24L);

		manager.getTransaction().begin();
		contaUpdate.setTitular("Homem de Ferro");
		manager.getTransaction().commit();
	
		
		/**
		 * 2 - Estado TRANSIENT
		 * 
		 * Podemos dizer que um objeto que foi criado mas ainda não foi 
		 * persistido pelo JPA, esta no estado de TRANSIENT.
		 * 
		 */
		
		
		Conta contaTransiente = new Conta();
		
		contaTransiente.setBanco("007 - BANCO DO JAMES");
		contaTransiente.setNumero("0000-7");
		contaTransiente.setAgencia("7777");
		contaTransiente.setTitular("James Bond");
		
		
		manager.getTransaction().begin();
		
		
		// Rode um select no banco e verifique se a conta do James bound foi incluida
		// Nao foi, correto, isso porque nao chamamos o metodo persist, ou seja a entidate
		// contaTransiente ainda esta no estado TRANSIENT
		
		// DESCOMENTE O CÓDIGO ABAIXO
		manager.persist(contaTransiente);
		
		manager.getTransaction().commit();
		
		// verifique novamente no banco de dados

		/**
		 * 3 - Estado de DETACHED
		 * 
		 * Vamos supor que queremos atualizar os dados da 
		 * conta do James,
		 * mas neste caso, nós sabemos o id da conta entao, 
		 * vamos criar
		 * um novo objeto para representar a conta do James.
		 */
		
		
		Conta contaJamesDetached = new Conta();
		
		//contaJamesDetached.setId(56L);
		contaJamesDetached.setBanco("001 - BANCO DO CHAPOLIN");
		contaJamesDetached.setNumero("1111-0");
		contaJamesDetached.setAgencia("1111");
		contaJamesDetached.setTitular("CHAPOLIN");

		// Neste caso, teremos que utilizar o metodo MERGE, sendo assim
		// nossa entidade passará do estado de DETACHED para MANAGED!

		/*manager.getTransaction().begin();
		contaJamesDetached = manager.merge(contaJamesDetached);
		manager.getTransaction().commit();		
		*/
		/**
		 * 4 - Estado de REMOVED
		 * 
		 * Bom, como próprio nome já diz, vamos remover um 
		 * registro do banco!
		 */
		
		contaJamesDetached.setId(57L);
		contaJamesDetached.setAgencia("0909");
		contaJamesDetached.setNumero("133332");
		
		//manager.close();
		
		//manager.getTransaction().begin();
		manager.remove(contaJamesDetached);
		
		// O que acontece aqui?? para nossa infelicidade, recebemos uma exception:
		// java.lang.IllegalArgumentException: 
		// Removing a detached instance br.com.dextra.financas.modelo.Conta#56
		// isso acontece porque o objeto contaJamesDetached já esta desatachado, entao temos que recuperar o objeto
		// do banco de dados primeiro.
		
		// DESCOMENTE O CODIDO ABAIXO
		//contaJamesDetached = manager.find(Conta.class, 10L);
		//manager.remove(contaJamesDetached);
		//manager.getTransaction().commit();
		
		// Repare na console que um delete foi executado!!
		
		// ISSO É LINDO NAO??? JPA É O BIXO!!!!

		
		
		
		
		//manager.close();

	}
}

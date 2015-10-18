package br.com.dextra.financas.jpa;

import java.util.List;

import br.com.banco.service.PessoaServiceAula1;
import br.com.dextra.financas.modelo.Pessoa;
import br.com.dextra.financas.modelo.PessoaAula1;

public class TestePersistenciaPessoaAula1 {
	
	public static void main(String[] args) {
		
		PessoaAula1 p1 = new PessoaAula1();
		PessoaAula1 p2 = new PessoaAula1();
		
		// Setando valores
		p1.setNome("HE-MAN");
		p1.setIdade(100);
		p1.setDataNascimento("1950-01-01");
		p2.setNome("SHE-HA");
		p2.setIdade(100);
		p2.setDataNascimento("1950-01-01");
		
		/**
		 * Persistindo dados
		 */
		PessoaServiceAula1.inserir(p1);
		PessoaServiceAula1.inserir(p2);
		
		
		/**
		 * Buscando dados
		 */
		//bucaPessoaPorId(2L);
		listaPessoas();
	}

	public static void bucaPessoaPorId(Long id) {
		PessoaAula1 p1 = new PessoaServiceAula1().buscarPorId(id);
		
		System.out.println("----------------- LISTANDO DADOS POR ID -------------------");
		System.out.println("ID...: " + p1.getId());
		System.out.println("Nome..:" + p1.getNome());
		System.out.println("-----------------------------------------------------------");
	}
	
	public static void listaPessoas() {
		
		System.out.println("---------------- Listando pessoas --------------");
		
		List nomesDasPessoas = PessoaServiceAula1.buscaTodasPessoas();
		
		for (Object nomes : nomesDasPessoas) {
			PessoaAula1 p = (PessoaAula1) nomes;			
			System.out.println(p.getNome());
		}		
		System.out.println("-------------------------------------------------------------------------------");
	}
	
}

package br.com.dextra.financas.jpa;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.mapping.Array;

import br.com.banco.service.AgenciaService;
import br.com.banco.service.EnderecoService;
import br.com.banco.service.PacoteServicoService;
import br.com.banco.service.PessoaService;
import br.com.banco.service.TelefoneService;
import br.com.dextra.financas.modelo.Agencia;
import br.com.dextra.financas.modelo.Endereco;
import br.com.dextra.financas.modelo.PacoteServicos;
import br.com.dextra.financas.modelo.Pessoa;
import br.com.dextra.financas.modelo.Telefone;
import br.com.dextra.financas.modelo.UF;

public class TestePersistenciaPessoa {

	public static void main(String[] args) {
		
		
		/**
		 * Setando e Persistindo endereco
		 */
		
		Endereco enderecoJoazinho = new Endereco();
		
		enderecoJoazinho.setCidade("Campinas");
		enderecoJoazinho.setEstado(UF.SP);
		enderecoJoazinho.setLogradouro("Rua 10, 342");
		
		Endereco enderecoMariazinha = new Endereco();
		
		enderecoMariazinha.setCidade("Saquarema");
		enderecoMariazinha.setEstado(UF.RJ);
		enderecoMariazinha.setLogradouro("Rua da Praia, 223");
		
		//EnderecoService.inserir(enderecoJoazinho);
		//EnderecoService.inserir(enderecoMariazinha);
		
		
		/**
		 * Setando e persistindo Agencia
		 */
		
		Agencia agencia = new Agencia();
		agencia.setCidade("Sao paulo");
		agencia.setEstado(UF.SP);
		agencia.setLogradouro("AV. Paulita, 442");
		
		
		AgenciaService.inserir(agencia);
		
		
		/**
		 * Setando e persistindo Telefones
		 */
		
		Telefone fone1 = new Telefone();
		Telefone fone2 = new Telefone();
		Telefone fone3 = new Telefone();
		Telefone fone4 = new Telefone();
		
		fone1.setDDD("11");
		fone1.setTelefone("3222-7723");
		
		fone2.setDDD("19");
		fone2.setTelefone("3461-1212");
		
		fone3.setDDD("43");
		fone3.setTelefone("3334-2093");
		
		fone4.setDDD("12");
		fone4.setTelefone("2323-3443");
		/*
		TelefoneService.inserir(fone1);
		TelefoneService.inserir(fone2);
		TelefoneService.inserir(fone3);
		TelefoneService.inserir(fone4);
		*/
		
		List<Telefone> fonesJoazinho = new ArrayList<Telefone>();
		fonesJoazinho.add(fone1);
		fonesJoazinho.add(fone2);
		
		List<Telefone> fonesMariazinha = new ArrayList<Telefone>();
		fonesMariazinha.add(fone3);
		fonesMariazinha.add(fone4);
		

		/**
		 * Setando e persistindo Pacote de Servicos
		 */
		
		
		PacoteServicos pc1 = new PacoteServicos();
		PacoteServicos pc2 = new PacoteServicos();
		
		pc1.setNome("Pacote básico");
		pc1.setValor(155D);
		
		pc2.setNome("Pacote Plus");
		pc2.setValor(247D);
		
		//PacoteServicoService.inserir(pc1);
		//PacoteServicoService.inserir(pc2);
		
		List<PacoteServicos> pacotesJoazinho = new ArrayList<PacoteServicos>();
		pacotesJoazinho.add(pc1);
		
		List<PacoteServicos> pacoteMarizinha = new ArrayList<PacoteServicos>();
		pacoteMarizinha.add(pc2);
		
		
		/**
		 * Setando e persistindo Pessoas
		 */
		
		Pessoa joazinho = new Pessoa();
		Pessoa mariazinha = new Pessoa();
		
		
		joazinho.setNome("Joazinho");
		joazinho.setEndereco(enderecoJoazinho);
		joazinho.setAgencia(agencia);
		joazinho.setTelefones(fonesJoazinho);
		joazinho.setPacoteServicos(pacotesJoazinho);
		
		
		mariazinha.setNome("Mariazinha");
		mariazinha.setEndereco(enderecoMariazinha);	
		mariazinha.setAgencia(agencia);
		mariazinha.setTelefones(fonesMariazinha);
		mariazinha.setPacoteServicos(pacoteMarizinha);
		
		PessoaService.inserir(joazinho);
		PessoaService.inserir(mariazinha);		
		
		/**
		 * Listando todas as pessoas que moram em um determinado estado
		 */
		
		//listaPessoasPorEstado(UF.RJ);
		//listaAgenciaPessoasPorEstado(UF.SP);
		//listaPessoasPorDDD("19");
		//listaPessoasQuePossuemDeterminadoPacoteInformado("Pacote básico");
		//listaNomeDasPessoas("Joazinho");
		testaCachePadraoJPA(11);
		testaQueryCacheadaJPA("Joazinho");

	}
	
	public static void listaPessoasPorEstado(UF uf){
		List<Pessoa> listaPessoasPorEstadoInformado = new ArrayList<Pessoa>();
		listaPessoasPorEstadoInformado = PessoaService.buscarPorEstado(uf);
		
		System.out.println("---------------- Listando pessoas do estado: " + uf + " --------------");
		
		for (Pessoa p : listaPessoasPorEstadoInformado) {
			
			System.out.println(p.getNome() + " - " + p.getEndereco().getCidade() + " - " + p.getEndereco().getEstado());
			
		}
		
		System.out.println("----------------------------------------------------------------------");
		
	}
	
	public static void listaAgenciaPessoasPorEstado(UF uf) {
		
		List<Pessoa> listaagenciapessoasporestado = new ArrayList<Pessoa>();
		listaagenciapessoasporestado = PessoaService.listaAgenciasPessoasPorEstado(UF.SP);
		
		System.out.println("--- Listando pessoas da agencia: " + uf );
		for (Pessoa p : listaagenciapessoasporestado) {
			System.out.println(p.getNome());
			System.out.println(p.getAgencia().getCidade());
			System.out.println(p.getAgencia().getEstado());
			System.out.println(p.getAgencia().getLogradouro());
		}	
	}

	public static void listaPessoasPorDDD(String DDD) {
		
		List<Pessoa> listaPessoaPorDDD = new ArrayList<Pessoa>();
		listaPessoaPorDDD = PessoaService.listaPessoasComDDDInformado(DDD);
		
		System.out.println("----- Listando Pessoas com telefones do DDD: " + DDD);
		for (Pessoa p :listaPessoaPorDDD) {
			System.out.println(p.getNome());
			for (Telefone fones : p.getTelefones()) {
				System.out.println(fones.getDDD());
				System.out.println(fones.getTelefone());
			}
		}
		
	}
	
	public static void listaPessoasQuePossuemDeterminadoPacoteInformado(String nomePacote){
		List<Pessoa> listaPessoaPorNomePacote = new ArrayList<Pessoa>();
		listaPessoaPorNomePacote = PessoaService.listaPessoasDoPacoteInformado(nomePacote);
		
		System.out.println("----- Listando Pessoas com Pacote: " + nomePacote);
		for (Pessoa p :listaPessoaPorNomePacote) {
			System.out.println(p.getNome());
			for (PacoteServicos pacote : p.getPacoteServicos()) {
				System.out.println(pacote.getNome());
				System.out.println(pacote.getValor());
			}
		}
	}
	
	public static void listaNomeDasPessoas(String nome) {
		
		System.out.println("---------------- Listando somente pessoas com nome: " + nome + " --------------");
		
		List nomesDasPessoas = 
				
		PessoaService.listaApenasUmAtributoDePessoa(nome);
		
		for (Object nomes : nomesDasPessoas) {
			Pessoa p = (Pessoa) nomes;			
			System.out.println(p.getNome());
		}
		
		System.out.println("-------------------------------------------------------------------------------");
	}
	
	public static void testaCachePadraoJPA(long id) {
		
		System.out.println("---------------- Testando queries nomeadas (cached query) --------------");
		
		PessoaService.testaCacheJPA(id);
		
		System.out.println("-------------------------------------------------------------------------");
		
	}
	
	public static void testaQueryCacheadaJPA(String nome) {
		
		System.out.println("---------------- Testando queries nomeadas (cached query) --------------");
		
		Pessoa p = PessoaService.testaQueryCacheada(nome);
		System.out.println(p.getNome());
		
		System.out.println("-------------------------------------------------------------------------");
	}
	
}

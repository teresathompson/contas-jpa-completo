package br.com.dextra.financas.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

//@Entity
@SequenceGenerator(name = "SEQ_PINVEST", 
				sequenceName = "SEQ_PINVEST", initialValue = 1)
public class PessoaInvestimento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, 
					generator = "SEQ_PINVEST")	
	private long id;
	
	@Column
	private String nome;
	
	//@Embedded
	@ElementCollection
	//@OneToMany(mappedBy = "pessoa")
	//private List<Investimento> investimentos = new ArrayList<Investimento>();
	private List <Investimento> investimentos;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	/*
	public List<Investimento> getInvestimentos() {
		return investimentos;
	}

	public void setInvestimentos(List<Investimento> investimentos) {
		this.investimentos = investimentos;
	}
	*/
}

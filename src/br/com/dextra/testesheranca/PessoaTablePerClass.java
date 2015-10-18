package br.com.dextra.testesheranca;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
//@Entity
//@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class PessoaTablePerClass {

	/*
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id = 0L;
	*/
	
	@Column
	private String nome;


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}

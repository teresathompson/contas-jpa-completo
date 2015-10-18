package br.com.dextra.testesheranca;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PessoaFisicaTablePerClass extends PessoaTablePerClass {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
//	@Embedded
	private Long id;
	
	
	private String CPF;

		
	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}
}

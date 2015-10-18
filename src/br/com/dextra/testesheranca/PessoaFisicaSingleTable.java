package br.com.dextra.testesheranca;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "PF")
public class PessoaFisicaSingleTable extends PessoaSingleTable {

	private String CPF;

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String CPF) {
		this.CPF = CPF;
	}
	
}

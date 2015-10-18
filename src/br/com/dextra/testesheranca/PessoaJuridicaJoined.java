package br.com.dextra.testesheranca;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "PJ")
public class PessoaJuridicaJoined  extends PessoaJoined {

	private String CNPJ;
	
	public String getCNPJ() {
		return CNPJ;
	}

	public void setCNPJ(String cNPJ) {
		CNPJ = cNPJ;
	}
	
}

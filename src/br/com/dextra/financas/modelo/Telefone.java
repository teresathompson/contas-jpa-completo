package br.com.dextra.financas.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "SEQ_FONE", 
		sequenceName = "SEQ_FONE", initialValue = 1)
public class Telefone {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, 
					generator = "SEQ_FONE")

	private Long id;
	private String DDD;
	private String telefone;
	
	
	public String getDDD() {
		return DDD;
	}
	public void setDDD(String dDD) {
		DDD = dDD;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
}

package br.com.dextra.financas.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "SEQ_PACOTES", 
				   sequenceName = "SEQ_PACOTES", initialValue = 1)

public class PacoteServicos {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, 
					generator = "SEQ_PACOTES")
	private long id;
	
	private String nome;

	@Column(precision = 2, scale = 2)
	private Double valor;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
	
}

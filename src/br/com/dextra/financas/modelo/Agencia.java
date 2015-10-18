package br.com.dextra.financas.modelo;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import br.com.dextra.financas.modelo.UF;

@Entity
@SequenceGenerator(name = "SEQ_AGENCIA", 
				sequenceName = "SEQ_AGENCIA", initialValue = 1)
public class Agencia {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, 
					generator = "SEQ_AGENCIA")

	private long id;
	
	private String numero;
	
	@Enumerated(EnumType.STRING)
	private UF estado;

	private String cidade;

	private String logradouro;

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public UF getEstado() {
		return estado;
	}

	public void setEstado(UF estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}	
}

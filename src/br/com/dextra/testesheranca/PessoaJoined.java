package br.com.dextra.testesheranca;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="tipoPessoa")
public class PessoaJoined {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_pessoa;
	
	private String nome;

	public Long getId() {
		return id_pessoa;
	}

	public void setId(Long id) {
		this.id_pessoa = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}

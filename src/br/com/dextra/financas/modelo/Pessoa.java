package br.com.dextra.financas.modelo;

import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.QueryHint;
import javax.persistence.SequenceGenerator;
import javax.persistence.Version;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;



@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@SequenceGenerator(name = "SEQ_PESSOA",sequenceName = "SEQ_PESSOA", initialValue = 1)

@NamedQuery(name="Pessoa.findByNome",
query="SELECT p FROM Pessoa p WHERE p.nome = ?1",
hints={@QueryHint(name="org.hibernate.cacheable", 
value="true")})
public class Pessoa  {

	@Version
	private Long versaoNumerica;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, 
					generator = "SEQ_PESSOA")
	private long id;
		
	@Column
	private String nome;

	@OneToOne(cascade={CascadeType.PERSIST, 
			CascadeType.MERGE, CascadeType.REMOVE})
	private Endereco endereco;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Agencia agencia;
	
	@OneToMany(cascade={CascadeType.PERSIST, 
			CascadeType.MERGE, CascadeType.REMOVE})
	//, fetch=FetchType.EAGER
	@JoinColumn(name="pessoa_id")
	private List<Telefone> telefones;
	
	@ManyToMany(cascade={CascadeType.PERSIST, 
			CascadeType.MERGE, CascadeType.REMOVE},
			fetch=FetchType.EAGER)
	private List<PacoteServicos> pacoteServicos;
	
	// Getters and Setters
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Endereco getEndereco() {
		if (endereco == null) {
			endereco = new Endereco();
		}
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	public Agencia getAgencia() {
		if (agencia == null) {
			agencia = new Agencia();
		}
		return agencia;
	}
	
	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}
	
	
	public List<Telefone> getTelefones() {
		
		if (telefones == null) {
			telefones = (List<Telefone>) new Telefone();
		}
		return telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
		
	}
	
	public List<PacoteServicos> getPacoteServicos() {
		return pacoteServicos;
	}

	public void setPacoteServicos(List<PacoteServicos> pacotes) {
		this.pacoteServicos = pacotes;
		
	}	
}

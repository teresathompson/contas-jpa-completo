package br.com.dextra.financas.modelo;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class InvestimentoAula1 {
	
	@Id
	@SequenceGenerator(name = "SEQ_INVEST", 
			sequenceName = "SEQ_INVEST", initialValue = 1)
		
	private Integer id_investimento;

	//@Column(length = 200, nullable = false)
	private String descricao;

	//@Column(precision = 10, scale = 10, nullable = false)
	private BigDecimal valor;

	//@Column(precision = 10, scale = 10, nullable = false)
	private BigDecimal rendimentoMensal;

	public Integer getId_investimento() {
		return id_investimento;
	}

	public void setId_investimento(Integer id_investimento) {
		this.id_investimento = id_investimento;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public BigDecimal getRendimentoMensal() {
		return rendimentoMensal;
	}

	public void setRendimentoMensal(BigDecimal rendimentoMensal) {
		this.rendimentoMensal = rendimentoMensal;
	}
}

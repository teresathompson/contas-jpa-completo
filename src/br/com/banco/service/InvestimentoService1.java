package br.com.banco.service;

import br.com.dextra.financas.modelo.InvestimentoAula1;
import common.service.EntityManagerUtil;

public class InvestimentoService1 {
	
	public static InvestimentoAula1 inserir(InvestimentoAula1 i) {
		EntityManagerUtil.begin();
		EntityManagerUtil.getEM().persist(i);
		EntityManagerUtil.commit();
		return i;
	}
	
	public static InvestimentoAula1 buscarPorId(Long id) {
		return EntityManagerUtil.getEM().find(InvestimentoAula1.class, id);
	}


}

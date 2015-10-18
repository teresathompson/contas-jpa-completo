package br.com.banco.service;

import br.com.dextra.financas.modelo.PacoteServicos;
import common.service.EntityManagerUtil;

public class PacoteServicoService {
	
	public static PacoteServicos inserir(PacoteServicos p) {
		EntityManagerUtil.begin();
		EntityManagerUtil.getEM().persist(p);
		EntityManagerUtil.commit();
		return p;
	}

}

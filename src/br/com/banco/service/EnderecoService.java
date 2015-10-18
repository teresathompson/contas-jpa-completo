package br.com.banco.service;

import br.com.dextra.financas.modelo.Endereco;
import common.service.EntityManagerUtil;

public class EnderecoService {

	public static Endereco inserir(Endereco e) {
		EntityManagerUtil.begin();
		EntityManagerUtil.getEM().persist(e);
		EntityManagerUtil.commit();
		return e;
	}
	
}

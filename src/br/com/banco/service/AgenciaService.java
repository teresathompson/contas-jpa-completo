package br.com.banco.service;

import br.com.dextra.financas.modelo.Agencia;

import common.service.EntityManagerUtil;

public class AgenciaService {

	public static Agencia inserir(Agencia a) {
		EntityManagerUtil.begin();
		EntityManagerUtil.getEM().persist(a);
		EntityManagerUtil.commit();
		return a;
	}
	
}

package br.com.banco.service;

import br.com.dextra.financas.modelo.Telefone;

import common.service.EntityManagerUtil;

public class TelefoneService {

	public static Telefone inserir(Telefone t) {
		EntityManagerUtil.begin();
		EntityManagerUtil.getEM().persist(t);
		EntityManagerUtil.commit();
		return t;
	}
	
}

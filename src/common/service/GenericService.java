package common.service;

import java.util.List;

import javax.persistence.TypedQuery;

import common.domain.BaseEntity;

public class GenericService<T extends BaseEntity> {
	
	private Class<T> clazz;

	public GenericService(Class<T> clazz) {
		this.clazz = clazz;
	}

	public T salvar(T c) {
		EntityManagerUtil.begin();
		try {
			if (c.getId() != null)
				return EntityManagerUtil.getEM().merge(c);
			else
				EntityManagerUtil.getEM().persist(c);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			EntityManagerUtil.commit();
		}
		return c;
	}

	public void excluir(T c) {
		EntityManagerUtil.begin();
		EntityManagerUtil.getEM().remove(c);
		EntityManagerUtil.commit();
	}

	public T buscarPorId(Long id) {
		return EntityManagerUtil.getEM().find(clazz, id);
	}
	
	public List<T> buscarTodos() {
		String jpql = "SELECT c FROM " 
				+ clazz.getSimpleName() + " c";

		TypedQuery<T> qry = EntityManagerUtil.getEM()
				.createQuery(jpql, clazz);
		
//		qry.setFirstResult(10);
//		qry.setMaxResults(10);

		return qry.getResultList();
	}
}

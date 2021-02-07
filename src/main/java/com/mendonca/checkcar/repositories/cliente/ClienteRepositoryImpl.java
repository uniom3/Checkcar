package com.mendonca.checkcar.repositories.cliente;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.mendonca.checkcar.entities.cliente.Cliente;


public abstract  class ClienteRepositoryImpl implements ClienteRepository {
	
	@PersistenceContext
	EntityManager entityManager;
	
	public List<Cliente> findByName(String nome){
		StringBuilder consultvalue = new StringBuilder();
		consultvalue.append("SELECT obj FROM Cliente obj WHERE obj.nome LIKE :nome ORDER BY obj.nome");
		TypedQuery<Cliente> query = entityManager.createQuery(consultvalue.toString(), Cliente.class);
		query.setParameter("nome", "%"+nome+"%");
		System.out.println(query.getResultList());
		return query.getResultList();
	}

}

package com.mendonca.checkcar.repositories.colaborador;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.mendonca.checkcar.entities.colaborador.Departamento;

@Repository
public abstract class DepartamentoRepositoryImpl implements DepartamentoRepository{

	@PersistenceContext
	EntityManager entityManager;

	public List<Departamento> findByName(String nome) {
		StringBuilder consultvalue = new StringBuilder();
		consultvalue.append("SELECT obj FROM Departamento obj WHERE obj.nome LIKE :nome ORDER BY obj.nome");
		TypedQuery<Departamento> query = entityManager.createQuery(consultvalue.toString(), Departamento.class);
		query.setParameter("nome", "%" + nome + "%");

		return query.getResultList();
	}
	
}

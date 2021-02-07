package com.mendonca.checkcar.repositories.cliente;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.mendonca.checkcar.entities.cliente.ClienteFisica;

@Repository
public class ClienteFisicaRepositoryImpl {

	@PersistenceContext
	EntityManager entityManager;
	
	StringBuilder consultvalue = new StringBuilder();
	ClienteFisica pessoaFisica = new ClienteFisica();

	public List<ClienteFisica> findByName(String nome) {
		StringBuilder consultvalue = new StringBuilder();
		consultvalue.append("SELECT obj FROM ClienteFisica obj WHERE obj.nome LIKE :nome ORDER BY obj.nome");
		TypedQuery<ClienteFisica> query = entityManager.createQuery(consultvalue.toString(), ClienteFisica.class);
		query.setParameter("nome", "%" + nome + "%");
		return query.getResultList();
	}
	
	public List<ClienteFisica> findByCpf(String cpf) {
		StringBuilder consultvalue = new StringBuilder();
		consultvalue.append("SELECT obj FROM ClienteFisica obj WHERE obj.cpf LIKE :cpf ORDER BY obj.nome");
		TypedQuery<ClienteFisica> query = entityManager.createQuery(consultvalue.toString(), ClienteFisica.class);
		query.setParameter("cpf", "%" + cpf + "%");
		return query.getResultList();
	}
}

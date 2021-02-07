package com.mendonca.checkcar.repositories.cliente;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.mendonca.checkcar.entities.cliente.ClienteJuridica;

@Repository
public class ClienteJuridicaRepositoryImpl {

	@PersistenceContext
	EntityManager entityManager;
	
	StringBuilder consultvalue = new StringBuilder();
	ClienteJuridica pessoaFisica = new ClienteJuridica();
	
	public List<ClienteJuridica> findByName(String nome){
		StringBuilder consultvalue = new StringBuilder();
		consultvalue.append("SELECT obj FROM ClienteJuridica obj WHERE obj.nome LIKE :nome ORDER BY obj.nome");
		TypedQuery<ClienteJuridica> query = entityManager.createQuery(consultvalue.toString(), ClienteJuridica.class);
		query.setParameter("nome", "%"+nome+"%");
		return query.getResultList();
	}
	
	public List<ClienteJuridica> findByRazao(String razao){
		StringBuilder consultvalue = new StringBuilder();
		consultvalue.append("SELECT obj FROM ClienteJuridica obj WHERE obj.razaoSocial LIKE :razaoSocial ORDER BY obj.razaoSocial");
		TypedQuery<ClienteJuridica> query = entityManager.createQuery(consultvalue.toString(), ClienteJuridica.class);
		query.setParameter("razaoSocial", "%"+razao+"%");
		return query.getResultList();
	}
	
	public List<ClienteJuridica> findByCNPJ(String cnpj){
		StringBuilder consultvalue = new StringBuilder();
		consultvalue.append("SELECT obj FROM ClienteJuridica obj WHERE obj.cnpj LIKE :cnpj ORDER BY obj.nome");
		TypedQuery<ClienteJuridica> query = entityManager.createQuery(consultvalue.toString(), ClienteJuridica.class);
		query.setParameter("cnpj", "%"+cnpj+"%");
		return query.getResultList();
	}

}

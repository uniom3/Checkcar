package com.mendonca.checkcar.repositories.cliente;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mendonca.checkcar.entities.cliente.ClienteFisica;

@Repository
public interface ClienteFisicaRepository extends JpaRepository<ClienteFisica, Long> {

	@Transactional(readOnly=true)
	@Query("SELECT obj FROM Cliente obj WHERE obj.nome LIKE :nome ORDER BY obj.nome")
	public List<ClienteFisica> findByName(@Param("nome") String nome);

}

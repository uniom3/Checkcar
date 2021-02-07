package com.mendonca.checkcar.repositories.cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mendonca.checkcar.entities.cliente.Cliente;
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
	

}

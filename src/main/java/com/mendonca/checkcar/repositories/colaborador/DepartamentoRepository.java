package com.mendonca.checkcar.repositories.colaborador;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mendonca.checkcar.entities.colaborador.Departamento;

@Repository
public interface DepartamentoRepository extends JpaRepository<Departamento, Long>{
	
}

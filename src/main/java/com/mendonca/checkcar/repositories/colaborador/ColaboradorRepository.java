package com.mendonca.checkcar.repositories.colaborador;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mendonca.checkcar.entities.colaborador.Colaborador;

@Repository
public interface ColaboradorRepository extends JpaRepository<Colaborador, Long>{


}

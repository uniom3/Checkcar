package com.mendonca.checkcar.repositories.produto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mendonca.checkcar.entities.produto.Grupo;

@Repository
public interface GrupoRepository extends JpaRepository<Grupo, Long> {

}

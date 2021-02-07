package com.mendonca.checkcar.repositories.produto;

import com.mendonca.checkcar.entities.produto.Fabricante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FabricanteRepository extends JpaRepository<Fabricante, Long> {

}


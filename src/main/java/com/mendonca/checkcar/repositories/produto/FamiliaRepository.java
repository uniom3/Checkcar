package com.mendonca.checkcar.repositories.produto;

import com.mendonca.checkcar.entities.produto.Familia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FamiliaRepository extends JpaRepository<Familia, Long> {

}


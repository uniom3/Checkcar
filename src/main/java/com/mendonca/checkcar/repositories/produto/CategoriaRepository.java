package com.mendonca.checkcar.repositories.produto;

import com.mendonca.checkcar.entities.produto.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}

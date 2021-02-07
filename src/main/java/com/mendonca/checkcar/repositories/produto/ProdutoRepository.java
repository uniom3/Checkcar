package com.mendonca.checkcar.repositories.produto;

import com.mendonca.checkcar.entities.produto.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    @Query("SELECT obj FROM Produto obj WHERE obj.descricao LIKE :nome order by obj.descricao")
    public List<Produto> findByName(@Param("nome") String nome);

}

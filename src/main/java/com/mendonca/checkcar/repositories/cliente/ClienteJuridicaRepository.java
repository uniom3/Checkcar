package com.mendonca.checkcar.repositories.cliente;

import com.mendonca.checkcar.entities.cliente.ClienteFisica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mendonca.checkcar.entities.cliente.ClienteJuridica;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ClienteJuridicaRepository extends JpaRepository<ClienteJuridica, Long>{


    @Transactional(readOnly = true)
    @Query("SELECT obj FROM ClienteJuridica obj WHERE obj.nome LIKE :nome ORDER BY obj.nome")
    public List<ClienteJuridica> findByName(@Param("nome") String nome);

    @Transactional(readOnly = true)
    @Query("SELECT obj FROM ClienteJuridica obj WHERE obj.razaoSocial LIKE :nome ORDER BY obj.nome")
    public List<ClienteJuridica> findByRazao(@Param("nome") String nome);

    @Transactional(readOnly = true)
    @Query("SELECT obj FROM ClienteJuridica obj WHERE obj.cnpj = :cnpj")
    public ClienteJuridica findByCnpj(@Param("cnpj") String cnpj);

}

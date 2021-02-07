package com.mendonca.checkcar.services.produto;

import com.mendonca.checkcar.entities.produto.Produto;
import com.mendonca.checkcar.repositories.produto.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> findAll(){
        return produtoRepository.findAll();
    }

    public Optional<Produto> findById(Long id){
        return produtoRepository.findById(id);
    }

    public List<Produto> findByName(String nome){
        return produtoRepository.findByName(nome);
    }

    public Produto insert(Produto produto){
        produto.setId(null);
        try {
            produtoRepository.save(produto);
        }catch (Exception e){
            e.getMessage();
        }
        return produto;
    }

}

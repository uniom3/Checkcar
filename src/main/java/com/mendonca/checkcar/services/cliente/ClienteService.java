package com.mendonca.checkcar.services.cliente;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mendonca.checkcar.entities.cliente.Cliente;
import com.mendonca.checkcar.repositories.cliente.ClienteRepository;
import com.mendonca.checkcar.repositories.cliente.ClienteRepositoryImpl;

@Service
public class ClienteService {

	private ClienteRepositoryImpl pessoaRepositoryImpl;
	@Autowired
	private ClienteRepository pessoaRepository;

	public List<Cliente> findAll() {
		return pessoaRepositoryImpl.findAll();
	}

	public Optional<Cliente> findById(Long id) {
		return pessoaRepositoryImpl.findById(id);
	}

	public Cliente insert(Cliente obj) {
		obj.setId(null);
		pessoaRepository.save(obj);
		return obj;
	}

	public Cliente editar(Cliente obj) {
		pessoaRepository.save(obj);
		return obj;
	}

	public void excluir(Long id) {
		pessoaRepositoryImpl.deleteById(id);
	}
	
	@Transactional(readOnly = true)
	public Optional<Cliente> buscarPorId(Long id) {		
		return pessoaRepositoryImpl.findById(id);
	}

}

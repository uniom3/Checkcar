package com.mendonca.checkcar.services.cliente;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mendonca.checkcar.entities.cliente.ClienteFisica;
import com.mendonca.checkcar.repositories.cliente.ClienteFisicaRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class ClienteFisicaService {

	@Autowired
	private ClienteFisicaRepository pessoaFisicaRepository;
		
	public List<ClienteFisica> findAll() {
		return pessoaFisicaRepository.findAll();
	}

	public Optional<ClienteFisica> findById(Long id) {
		return pessoaFisicaRepository.findById(id);
	}

	public ClienteFisica insert(ClienteFisica obj) {
		obj.setId(null);
		try {
			pessoaFisicaRepository.save(obj);
		} catch (Exception e) {
			e.getMessage();
		}
		return obj;
	}

	public ClienteFisica editar(ClienteFisica obj) {
		pessoaFisicaRepository.save(obj);
		return obj;
	}

	public void excluir(Long id) {
		pessoaFisicaRepository.deleteById(id);
	}

	@Transactional(readOnly = true)
	public Optional<ClienteFisica> buscarPorId(Long id) {
		return pessoaFisicaRepository.findById(id);
	}

	public ClienteFisica find(Long id) throws ObjectNotFoundException {
		Optional<ClienteFisica> obj = pessoaFisicaRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + ClienteFisica.class.getName()));
	}

	public List<ClienteFisica> findByName(String nome){
		return pessoaFisicaRepository.findByName(nome);
	}

	public ClienteFisica findByCpf(String cpf){
		return pessoaFisicaRepository.findByCpf(cpf);
	}

}

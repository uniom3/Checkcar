package com.mendonca.checkcar.services.cliente;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mendonca.checkcar.entities.cliente.ClienteJuridica;
import com.mendonca.checkcar.repositories.cliente.ClienteJuridicaRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class ClienteJuridicaService {

	
	@Autowired
	private ClienteJuridicaRepository pessoaJuridicaRepository;
	
	public List<ClienteJuridica> findAll() {
		return pessoaJuridicaRepository.findAll();
	}

	public Optional<ClienteJuridica> findById(Long id) {
		return pessoaJuridicaRepository.findById(id);
	}

	public ClienteJuridica insert(ClienteJuridica obj) {
		obj.setId(null);
		pessoaJuridicaRepository.save(obj);
		return obj;
	}

	public ClienteJuridica editar(ClienteJuridica obj) {
		pessoaJuridicaRepository.save(obj);
		return obj;
	}

	public void excluir(Long id) {
		pessoaJuridicaRepository.deleteById(id);
	}
	
	@Transactional(readOnly = true)
	public Optional<ClienteJuridica> buscarPorId(Long id) {		
		return pessoaJuridicaRepository.findById(id);
	}

	public ClienteJuridica find(Long id) throws ObjectNotFoundException {
		Optional<ClienteJuridica> obj = pessoaJuridicaRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + ClienteJuridica.class.getName()));
	}
	
	public List<ClienteJuridica> findByNome(String nome){
		return pessoaJuridicaRepository.findByName(nome);
	}
	
	public List<ClienteJuridica> findByRazao(String razao){
		return pessoaJuridicaRepository.findByRazao(razao);
	}
	
	public ClienteJuridica findByCnpj(String cnpj){
		return pessoaJuridicaRepository.findByCnpj(cnpj);
	}
	
	
}

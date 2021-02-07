package com.mendonca.checkcar.services.colaborador;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import com.mendonca.checkcar.services.ServiceUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mendonca.checkcar.entities.colaborador.Colaborador;
import com.mendonca.checkcar.repositories.colaborador.ColaboradorRepository;
import com.mendonca.checkcar.repositories.colaborador.ColaboradorRepositoryImpl;
import com.mendonca.checkcar.services.exceptions.ObjectNotFoundException;

@Service
public class ColaboradorService {

	@Autowired
	private ColaboradorServiceImpl colaboradorServiceImpl;
	
	@Autowired
	private ColaboradorRepository colaboradorRepository;
	
	@Autowired
	private ColaboradorRepositoryImpl colaboradorRepositoryImpl;

	ServiceUtils utils = new ServiceUtils();

	Colaborador colaborador = new Colaborador();

	public Colaborador find(Long id) {

		Optional<Colaborador> obj = colaboradorRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Colaborador.class.getName()));
	}

	public List<Colaborador> findAll() {
		return colaboradorRepository.findAll();
	}

	public Optional<Colaborador> findById(Long id) {
		return colaboradorRepository.findById(id);
	}

	public Colaborador insert(Colaborador obj) throws IOException {
		if(!obj.getImagem().equals(null)) {
			colaboradorServiceImpl.copiarImagem(obj);
		}else {
			
		}
		
		obj.setId(null);
		colaboradorRepository.save(obj);
		return obj;
	}

	public List<Colaborador> findByName(String nome) {
		return colaboradorRepositoryImpl.findByName(nome);
	}

	public Colaborador editar(Colaborador obj) throws Exception {
		colaboradorServiceImpl.verficarImagem(obj);
		colaboradorRepository.save(obj);
		return obj;

	}

	public List<Colaborador> buscarPorCargo(Long id) {
		return colaboradorRepositoryImpl.findByCargoId(id);
	}

	public void excluir(Long id) {
		colaboradorServiceImpl.excluirimagem(id);
		colaboradorRepository.deleteById(id);
	}

}
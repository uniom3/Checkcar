package com.mendonca.checkcar.web.conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.mendonca.checkcar.entities.colaborador.Cargo;
import com.mendonca.checkcar.services.colaborador.CargoService;

@Component
public class StringToCargoConversor implements Converter<String, Cargo> {

	@Autowired
	private CargoService service;
	
	@Override
	public Cargo convert(String text) {
		if (text.isEmpty()) {
			return null;
		}
		Integer id = Integer.valueOf(text);
		return service.buscarPorId(id);
	}
}

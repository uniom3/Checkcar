package com.mendonca.checkcar.resources.cliente;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mendonca.checkcar.entities.cliente.ClienteFisica;
import com.mendonca.checkcar.entities.enums.UF;
import com.mendonca.checkcar.services.cliente.ClienteFisicaService;

import javassist.tools.rmi.ObjectNotFoundException;

@Controller
@RequestMapping("/pessoaFisicas")
public class ClienteFisicaResource {
	
	@Autowired
	private ClienteFisicaService pessoaService;
		
	@GetMapping(value = "/cadastrar")
	public String cadastrar(ClienteFisica pessoa) {
		return "pessoa/cadastroFisica";
	}
	

	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("pessoaFisicas", pessoaService.findAll());
		return "pessoa/listaFisica";
	}

	@PostMapping("/salvar")
	public String salvar(@Valid ClienteFisica pessoa, BindingResult result, RedirectAttributes attr) {
		if (result.hasErrors()) {
			return "pessoa/cadastroFisica";
		}
		try {
			attr.addFlashAttribute("sucess", "ClienteFisicaFisica inserido com sucesso.");
			pessoaService.insert(pessoa);				
			attr.addFlashAttribute("sucess", "ClienteFisicaFisica inserido com sucesso.");
		} catch (Exception e) {
			e.getMessage();
		}
		return "redirect:/pessoaFisicas/cadastrar";
	}

	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) throws ObjectNotFoundException {
		model.addAttribute("pessoaFisica", pessoaService.find(id));
		return "pessoa/cadastroFisica";
	}

	@PostMapping("/editar")
	public String editar(@Valid ClienteFisica pessoa, BindingResult result, RedirectAttributes attr) {
		try {
			pessoaService.editar(pessoa);
			attr.addFlashAttribute("sucess", "ClienteFisicaFisica editado com sucesso.");
		} catch (Exception e) {
			e.getMessage();
		}
		return "redirect:/pessoaFisicas/cadastrar";
	}

	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
		pessoaService.excluir(id);
		attr.addFlashAttribute("sucess", "Cliente Física excluido com sucesso.");
		return "redirect:/pessoaFisicas/listar";
	}
	
	@GetMapping("/buscar/nome")
	public String getPorNome(@RequestParam("nome") String nome, ModelMap model) {		
		model.addAttribute("pessoaFisicas", pessoaService.findByName(nome));
		return "pessoa/listaFisica";
	}
	
    @GetMapping("/buscar/cpf")
    public String getPorCpf(@RequestParam("cpf") String cpf, ModelMap model) {
    	model.addAttribute("pessoaFisicas", pessoaService.findByCpf(cpf));
    	return "pessoa/listaFisica";
    }
	
	
	@ModelAttribute("ufs")
	public UF[] getUFs() {
		return UF.values();
	}
	
}

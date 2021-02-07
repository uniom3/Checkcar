package com.mendonca.checkcar.resources.cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mendonca.checkcar.entities.cliente.Cliente;
import com.mendonca.checkcar.entities.enums.UF;
import com.mendonca.checkcar.services.cliente.ClienteService;

@Controller
@RequestMapping("/pessoas")
public class ClienteResource {
	
	@Autowired
	private ClienteService pessoaService;
	
	@GetMapping(value = "/cadastrar")
	public String cadastrar(Cliente pessoa) {
		return "pessoa/cadastro";
	}
	

	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("pessoas", pessoaService.findAll());
		return "pessoa/lista";
	}

	@PostMapping("/salvar")
	public String salvar(Cliente pessoa, BindingResult result, RedirectAttributes attr) {
		if (result.hasErrors()) {
			return "pessoa/cadastro";
		}
		try {
			pessoaService.insert(pessoa);
			attr.addFlashAttribute("sucess", "Cliente inserido com sucesso.");
		} catch (Exception e) {
			
		}
		return "redirect:/pessoas/cadastrar";
	}

	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("pessoa", pessoaService.findById(id));
		return "pessoa/cadastro";
	}

	@PostMapping("/editar")
	public String editar(Cliente pessoa, BindingResult result, RedirectAttributes attr) {
		try {
			pessoaService.editar(pessoa);
			attr.addFlashAttribute("sucess", "Cliente editado com sucesso.");
		} catch (Exception e) {
			e.getMessage();
		}
		return "redirect:/pessoas/cadastrar";
	}

	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
		pessoaService.excluir(id);
		attr.addFlashAttribute("sucess", "Cliente excluido com sucesso.");
		return "redirect:/pessoas/listar";
	}
	
	@ModelAttribute("ufs")
	public UF[] getUFs() {
		return UF.values();
	}
	
}

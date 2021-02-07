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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mendonca.checkcar.entities.cliente.ClienteJuridica;
import com.mendonca.checkcar.entities.enums.UF;
import com.mendonca.checkcar.services.cliente.ClienteJuridicaService;

import javassist.tools.rmi.ObjectNotFoundException;

@Controller
@RequestMapping("/pessoaJuridicas")
public class ClienteJuridicaResource {
	
	@Autowired
	private ClienteJuridicaService pessoaService;
	
	@GetMapping(value = "/cadastrar")
	public String cadastrar(ClienteJuridica pessoa) {
		return "pessoa/cadastroJuridica";
	}
	

	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("pessoaJuridicas", pessoaService.findAll());
		return "pessoa/listaJuridica";
	}

	@PostMapping("/salvar")
	public String salvar(ClienteJuridica pessoa, BindingResult result, RedirectAttributes attr) {
		System.out.println(result.getAllErrors());
		if (result.hasErrors()) {
			return "pessoa/cadastroJuridica";
		}
		try {

			pessoaService.insert(pessoa);	
			
			attr.addFlashAttribute("sucess", "ClienteJuridica inserido com sucesso.");
		} catch (Exception e) {
			
		}
		return "redirect:/pessoaJuridicas/cadastrar";
	}

	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) throws ObjectNotFoundException {
		model.addAttribute("pessoaJuridica", pessoaService.find(id));
		return "pessoa/cadastroJuridica";
	}

	@PostMapping("/editar")
	public String editar(ClienteJuridica pessoa, BindingResult result, RedirectAttributes attr) {
		try {
			pessoaService.editar(pessoa);
			attr.addFlashAttribute("sucess", "Cliente Juridica editado com sucesso.");
		} catch (Exception e) {
			e.getMessage();
		}
		return "redirect:/pessoaJuridicas/cadastrar";
	}

	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
		pessoaService.excluir(id);
		attr.addFlashAttribute("sucess", "Cliente Juridica excluido com sucesso.");
		return "redirect:/pessoaJuridicas/listar";
	}
	
	@GetMapping("/buscar/nome")
	public String findByNome(@RequestParam("nome") String nome, ModelMap model) {
		model.addAttribute("pessoaJuridicas", pessoaService.findByNome(nome));
		return "pessoa/listaJuridica";
		
	}
	
	@GetMapping("/buscar/razao")
	public String findByRazao(@RequestParam("razao") String razao, ModelMap model) {
		model.addAttribute("pessoaJuridicas", pessoaService.findByRazao(razao));
		return "pessoa/listaJuridica";
	}
	
	@GetMapping("/buscar/cnpj")
	public String findByCnpj(@RequestParam("cnpj") String cnpj, ModelMap model) {
		model.addAttribute("pessoaJuridicas", pessoaService.findByCnpj(cnpj));
		return "pessoa/listaJuridica";
	}
	
	@ModelAttribute("ufs")
	public UF[] getUFs() {
		return UF.values();
	}
	
}

package com.mendonca.checkcar.resources.produto;

import com.mendonca.checkcar.entities.produto.Produto;
import com.mendonca.checkcar.services.produto.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("produtos")
public class ProdutoResource {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping(value = "/cadastrar")
    public String cadastrar(Produto produto){
        return "produto/cadastroProduto";
    }

    @GetMapping("/listar")
    public String listar(ModelMap model){
        model.addAttribute("produto", produtoService.findAll());
            return "produto/listaProduto";
        }
    @PostMapping("/salvar")
    public String salvar(@Valid Produto produto, BindingResult resut, RedirectAttributes attr){
        if(resut.hasErrors()){
            return "produto/cadastroProduto";
        }
        try {
            produtoService.insert(produto);
            attr.addFlashAttribute("sucess", "Produto inserido com Sucesso.");
        }catch (Exception e){
            e.getMessage();
        }
        return"redirect:/produto/cadastrar";
    }

}

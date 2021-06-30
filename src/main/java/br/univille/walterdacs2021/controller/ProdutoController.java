package br.univille.walterdacs2021.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.walterdacs2021.model.Produto;
import br.univille.walterdacs2021.service.ProdutoService;

@Controller
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService service;
    
    @GetMapping
    public ModelAndView index(){
        /*Produto prod1 = new Produto();
        prod1.setDescricao("Produto legal 1");
        prod1.setDataRegistro(new Date());
        prod1.setPreco(2000);

        Produto prod2 = new Produto();
        prod2.setDescricao("Produto legal 2");
        prod2.setDataRegistro(new Date());
        prod2.setPreco(5000);*/

        List<Produto> listaProdutos = service.getAllProdutos();
        /*listaProdutos.add(prod1);
        listaProdutos.add(prod2);*/

        return new ModelAndView("produto/index","listaProdutos",listaProdutos);
    }
    @GetMapping("/novo")
    public ModelAndView novo(@ModelAttribute Produto produto){
        return new ModelAndView("produto/form");
    }

    @PostMapping(params = "form")
    public ModelAndView save(Produto produto){
        service.save(produto);
        return new ModelAndView("redirect:/produto");
    }

    @GetMapping(value = "/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") Produto produto){
        return new ModelAndView("produto/form","produto",produto);
    }

}

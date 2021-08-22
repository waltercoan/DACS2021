package br.univille.walterdacs2021.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.walterdacs2021.model.Categoria;
import br.univille.walterdacs2021.service.CategoriaService;

/***
 * CategoriaController representa a camada controller da aplicação
 * que deve ser responsável por receber as requisições HTTP, aplicar
 * o mecanismo de rotas do SpringBoot, executar a lógica dos métodos 
 * mapeados chamando as classes de serviço para realizar as ações
 * necessárias e então repassar o resultado dos dados dentro de instâncias
 * das classes model para a view que será retornada como resposta
 * para o cliente.
 */

@Controller
@RequestMapping("/categoria")
public class CategoriaController {
    @Autowired
    private CategoriaService service;

    @GetMapping
    public ModelAndView index(){
        List<Categoria> listaCategoria = service.getAllCategorias();

        return new ModelAndView("categoria/index","listaCategorias",listaCategoria);
    }

    @GetMapping("/novo")
    public ModelAndView novo(@ModelAttribute Categoria categoria){
        return new ModelAndView("categoria/form");
    }

    @PostMapping(params = "form")
    public ModelAndView save(Categoria categoria){
        service.save(categoria);
        return new ModelAndView("redirect:/categoria");
    }

    @GetMapping(value = "/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") Categoria categoria){
        return new ModelAndView("categoria/form","categoria",categoria);
    }

    @GetMapping(value = "/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Categoria categoria){
        service.delete(categoria);
        return new ModelAndView("redirect:/categoria");
    }
}

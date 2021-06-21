package br.univille.walterdacs2021.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/produto")
public class ProdutoController {
    
    @GetMapping
    public ModelAndView index(){

        return new ModelAndView("produto/index");
    }
}

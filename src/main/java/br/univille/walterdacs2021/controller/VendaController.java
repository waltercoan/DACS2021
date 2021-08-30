package br.univille.walterdacs2021.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.walterdacs2021.model.Venda;
import br.univille.walterdacs2021.service.VendaService;

@Controller
@RequestMapping("/venda")
public class VendaController {
    
    @Autowired
    private VendaService service;

    @GetMapping
    public ModelAndView index(){
        List<Venda> listaVendas = service.getAllVendas();
        return new ModelAndView("venda/index","listaVendas",listaVendas);
    }
}

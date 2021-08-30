package br.univille.walterdacs2021.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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

    @GetMapping("/novo")
    public ModelAndView novo(@ModelAttribute Venda venda){
        HashMap<String,Object> dados = new HashMap<>();

        dados.put("venda",venda);
        return new ModelAndView("venda/form",dados);
    }

    @PostMapping(params = "form")
    public ModelAndView save(Venda venda){
        service.save(venda);
        return new ModelAndView("redirect:/venda");
    }
}

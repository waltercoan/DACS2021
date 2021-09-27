package br.univille.walterdacs2021.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;




@Controller
@RequestMapping("/")
public class HomeController {
    
    @GetMapping
    public ModelAndView index(){
        /*logica muito doida! */

        Date dataAgora = new Date();
        SimpleDateFormat sdf 
            = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");

        HashMap<String,String> dados = new HashMap<>();
        dados.put("tempo", sdf.format(dataAgora));
        dados.put("nomeapp","App Java lindo!!!");

        return new ModelAndView("home/index", dados);
        //return new ModelAndView("home/index", "tempo", sdf.format(dataAgora));
    }
    
    
}
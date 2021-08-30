package br.univille.walterdacs2021.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.univille.walterdacs2021.model.ItemVenda;
import br.univille.walterdacs2021.model.Produto;
import br.univille.walterdacs2021.model.Venda;
import br.univille.walterdacs2021.service.ProdutoService;
import br.univille.walterdacs2021.service.VendaService;

@Controller
@RequestMapping("/venda")
public class VendaController {
    
    @Autowired
    private VendaService service;
    @Autowired
    private ProdutoService produtoService;
    @GetMapping
    public ModelAndView index(){
        List<Venda> listaVendas = service.getAllVendas();
        return new ModelAndView("venda/index","listaVendas",listaVendas);
    }

    @GetMapping("/novo")
    public ModelAndView novo(@ModelAttribute Venda venda){
        HashMap<String,Object> dados = new HashMap<>();
        List<Produto> listaProdutos = produtoService.getAllProdutos();
        dados.put("venda",venda);
        dados.put("listaProdutos",listaProdutos);
        dados.put("novoitemvenda", new ItemVenda());
        return new ModelAndView("venda/form",dados);
    }

    @PostMapping()
    public ModelAndView save(Venda venda){

        venda.setValorTotal(venda.getColItemVenda().stream().reduce( 0f, (acumulador, item) -> acumulador + item.getValor(),Float::sum));
        service.save(venda);
        return new ModelAndView("redirect:/venda");
    }

    @PostMapping(params= {"insertproc"})
    public ModelAndView insertproc(Venda venda, ItemVenda novoitemvenda) {

        //Adiciona o novo item de venda na venda
        novoitemvenda.setValor(novoitemvenda.getProduto().getPreco() - novoitemvenda.getValorDesconto());
        venda.getColItemVenda().add(novoitemvenda);

        HashMap<String,Object> dados = new HashMap<>();
        List<Produto> listaProdutos = produtoService.getAllProdutos();
        dados.put("venda",venda);
        dados.put("listaProdutos",listaProdutos);
        dados.put("novoitemvenda", new ItemVenda());

        return new ModelAndView("venda/form",dados);
    }

    @PostMapping(params= {"removeproc"})
    public ModelAndView removeproc(@RequestParam(name = "removeproc") int index, Venda venda, ItemVenda novoitemvenda) {

        //Remove o item de venda da venda
        venda.getColItemVenda().remove(index);

        HashMap<String,Object> dados = new HashMap<>();
        List<Produto> listaProdutos = produtoService.getAllProdutos();
        dados.put("venda",venda);
        dados.put("listaProdutos",listaProdutos);
        dados.put("novoitemvenda", new ItemVenda());

        return new ModelAndView("venda/form",dados);
    }
}

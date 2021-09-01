package br.univille.walterdacs2021.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.univille.walterdacs2021.model.Produto;
import br.univille.walterdacs2021.service.ProdutoService;


@RestController
@RequestMapping("/api/v1/produtos")
public class ProdutoControllerAPI {
    
    @Autowired
    private ProdutoService service;

    @GetMapping
    public ResponseEntity<List<Produto>> getAll(){
        try{
            return new ResponseEntity<List<Produto>>(service.getAllProdutos(), HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

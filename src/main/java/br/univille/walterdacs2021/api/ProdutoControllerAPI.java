package br.univille.walterdacs2021.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.univille.walterdacs2021.model.Produto;
import br.univille.walterdacs2021.service.ProdutoService;
import io.swagger.models.Response;


@RestController
@RequestMapping("/api/v1/produtos")
public class ProdutoControllerAPI {
    
    @Autowired
    private ProdutoService service;

    @GetMapping
    public ResponseEntity<List<Produto>> getAll(){
        try{
            List<Produto> listaProdutos = service.getAllProdutos();
            return new ResponseEntity<List<Produto>>(listaProdutos, HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> getById(@PathVariable("id") Produto produto){
        try{
            return new ResponseEntity<Produto>(produto,HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @PostMapping
    public ResponseEntity<Produto> save(@RequestBody Produto produto){
        try{
            produto.setId(0);
            service.save(produto);
            return new ResponseEntity<Produto>(produto,HttpStatus.CREATED);
        }catch(Exception ex){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Produto> delete(@PathVariable("id") Produto produto){
        try{
            service.delete(produto);
            return new ResponseEntity<Produto>(produto,HttpStatus.OK);
        }catch(Exception ex){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> update(@PathVariable("id") Produto produtoAntigo,
                                            @RequestBody Produto produtoAlterado){
        produtoAntigo.setDescricao(produtoAlterado.getDescricao());
        produtoAntigo.setPreco(produtoAlterado.getPreco());
        produtoAntigo.setDataRegistro(produtoAlterado.getDataRegistro());
        produtoAntigo.setCategoria(produtoAlterado.getCategoria());
        
        service.save(produtoAntigo);

        return new ResponseEntity<Produto>(produtoAntigo,HttpStatus.OK);

    }

}

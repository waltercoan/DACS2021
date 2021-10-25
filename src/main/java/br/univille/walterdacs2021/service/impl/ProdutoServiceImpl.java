package br.univille.walterdacs2021.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.univille.walterdacs2021.model.Fornecedor;
import br.univille.walterdacs2021.model.Produto;
import br.univille.walterdacs2021.repository.ProdutoRepository;
import br.univille.walterdacs2021.service.ProdutoService;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

@Service
public class ProdutoServiceImpl implements ProdutoService{

    @Autowired
    private ProdutoRepository repository;

    @Override
    public List<Produto> getAllProdutos() {
        return repository.findAll();
    }

    @Override
    public Produto save(Produto produto) {
        return repository.save(produto);
    }

    @Override
    public void delete(Produto produto) {
       repository.delete(produto);
    }

    @Override
    public List<Produto> importProduto(Fornecedor fornecedor) {
        if(fornecedor != null){
            try {
                URL endereco = new URL(fornecedor.getUrlAPI());
                HttpURLConnection conn = (HttpURLConnection)endereco.openConnection();
                conn.setRequestMethod("GET");
                conn.connect();
                int responseCode = conn.getResponseCode();
                
                if(responseCode == 200){ //StatusCode 200 Sucesso!! Consegui chamar a API
                    Scanner leitor = new Scanner(endereco.openStream());
                    StringBuilder jsonText = new StringBuilder();
                    while(leitor.hasNext()){
                        jsonText.append(leitor.nextLine());
                    }
        
                    Gson gson = new Gson();
                
                    Type typeListProdutos = new TypeToken<ArrayList<Produto>>(){}.getType();
                    ArrayList<Produto> listaProdutos = gson.fromJson(jsonText.toString(), typeListProdutos);
                    return listaProdutos;
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return new ArrayList<Produto>();
    }
}

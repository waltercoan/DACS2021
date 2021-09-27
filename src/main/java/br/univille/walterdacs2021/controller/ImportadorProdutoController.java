package br.univille.walterdacs2021.controller;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.walterdacs2021.model.Produto;

@Controller
@RequestMapping("/import-produto")
public class ImportadorProdutoController {
    
    @GetMapping
    public ModelAndView index(){

        try {
            URL endereco = new URL("http://1b22-186-237-248-5.ngrok.io/api/v1/produtos");
            HttpURLConnection conn = (HttpURLConnection)endereco.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            int responseCode = conn.getResponseCode();
            System.out.println(responseCode);
            Scanner leitor = new Scanner(endereco.openStream());
            
            StringBuilder jsonText = new StringBuilder();
            while(leitor.hasNext()){
                jsonText.append(leitor.nextLine());
            }

            Gson gson = new Gson();
           
            Type typeListProdutos = new TypeToken<ArrayList<Produto>>(){}.getType();
            ArrayList<Produto> listaProdutos = gson.fromJson(jsonText.toString(), typeListProdutos);
            
            for(Produto umProduto : listaProdutos){
                System.out.println(umProduto.getDescricao());
            }
            


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ModelAndView("/importproduto/index");
    }
}

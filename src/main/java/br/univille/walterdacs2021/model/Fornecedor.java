package br.univille.walterdacs2021.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Fornecedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String urlAPI;
    private String urlAPIAuth;
    private String usuario;
    private String senha;
    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getUrlAPI() {
        return urlAPI;
    }
    public void setUrlAPI(String urlAPI) {
        this.urlAPI = urlAPI;
    }
    public String getUrlAPIAuth() {
        return urlAPIAuth;
    }
    public void setUrlAPIAuth(String urlAPIAuth) {
        this.urlAPIAuth = urlAPIAuth;
    }
    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }

    
    
}

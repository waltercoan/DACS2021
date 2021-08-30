package br.univille.walterdacs2021.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ItemVenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private float valor;
    private float valorDesconto;
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    private Produto produto;


    public Produto getProduto() {
        return produto;
    }
    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public float getValor() {
        return valor;
    }
    public void setValor(float valor) {
        this.valor = valor;
    }
    public float getValorDesconto() {
        return valorDesconto;
    }
    public void setValorDesconto(float valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    
}

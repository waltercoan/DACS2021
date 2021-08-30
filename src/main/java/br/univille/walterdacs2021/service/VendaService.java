package br.univille.walterdacs2021.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.univille.walterdacs2021.model.Venda;

@Service
public interface VendaService {
    public List<Venda> getAllVendas();
    public Venda save(Venda venda);
    public void delete(Venda venda);
}

package br.univille.walterdacs2021.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.univille.walterdacs2021.model.Fornecedor;

@Service
public interface FornecedorService {
    public List<Fornecedor> getAllFornecedores();
}

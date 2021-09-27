package br.univille.walterdacs2021.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.walterdacs2021.model.Fornecedor;
import br.univille.walterdacs2021.repository.FornecedorRepository;
import br.univille.walterdacs2021.service.FornecedorService;

@Service
public class FornecedorServiceImpl implements FornecedorService{
    
    @Autowired
    private FornecedorRepository repository;

    @Override
    public List<Fornecedor> getAllFornecedores() {
        return repository.findAll();
    }
    
}

package br.univille.walterdacs2021.service;

import java.util.List;
import org.springframework.stereotype.Service;
import br.univille.walterdacs2021.model.Categoria;

/***
 * CategoriaService serve como interface que
 * expõe para a aplicação os métodos que esse serviço
 * é capaz de fazer.
 */
@Service
public interface CategoriaService {
    public List<Categoria> getAllCategorias();
    public Categoria save(Categoria categoria);
    public void delete(Categoria categoria);
}

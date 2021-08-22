package br.univille.walterdacs2021.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.univille.walterdacs2021.model.Categoria;

/***
 * CategoriaRepository representa o repositório de dados que 
 * utiliza a API JPA conectada ao Hibernate para fazer a persistência
 * dos dados através do banco de dados relacional.
 * Provê os métodos: save(), findAll(), delete() gerados pela interface JpaRepository (Spring Data)
 */
@Repository
public interface CategoriaRepository extends JpaRepository<Categoria,Long>{
    
}

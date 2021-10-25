package br.univille.walterdacs2021.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.univille.walterdacs2021.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    /*SELECT * FROM Usuario where Usuario.usuario = "zezinho" */
    Usuario findByUsuario(String usuario);
    /*Select * from usuario where usuario.usuario = "zezinho" and usuario.senha = "1234" */
    Usuario findByUsuarioAndSenha(String usuario,String senha);
}

package br.com.fiap.checkpoint1.repository;

import br.com.fiap.checkpoint1.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByEmail(String email);
}
package dev.matt.A2F.repositorio;

import dev.matt.A2F.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RepositorioUser extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByNome(String nome);  // Método para buscar um usuário pelo nome
}

//Repositório para salvar e buscar usuarios no BD

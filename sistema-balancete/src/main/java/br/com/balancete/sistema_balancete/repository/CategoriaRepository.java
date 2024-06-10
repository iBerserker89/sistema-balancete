package br.com.balancete.sistema_balancete.repository;

import br.com.balancete.sistema_balancete.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoriaRepository  extends JpaRepository<Categoria, Long> {
    Optional<Categoria> findById(Long id);
}

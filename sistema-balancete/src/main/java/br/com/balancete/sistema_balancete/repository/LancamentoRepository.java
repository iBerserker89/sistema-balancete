package br.com.balancete.sistema_balancete.repository;

import br.com.balancete.sistema_balancete.model.Lancamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.OptionalLong;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long> {
    Optional<Lancamento> findById(Long id);
}

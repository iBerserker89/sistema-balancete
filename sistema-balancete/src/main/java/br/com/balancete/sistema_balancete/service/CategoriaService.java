package br.com.balancete.sistema_balancete.service;

import br.com.balancete.sistema_balancete.model.Categoria;
import br.com.balancete.sistema_balancete.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> encontrarTodos() {
        return categoriaRepository.findAll();
    }

    public Categoria salvar(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public void apagar(Long id) {
        categoriaRepository.deleteById(id);
    }

    public Categoria findById(Long id) {
        return categoriaRepository.getReferenceById(id);
    }
}

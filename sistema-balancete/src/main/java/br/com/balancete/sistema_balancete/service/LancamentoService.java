package br.com.balancete.sistema_balancete.service;

import br.com.balancete.sistema_balancete.model.Lancamento;
import br.com.balancete.sistema_balancete.repository.LancamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LancamentoService {
    @Autowired
    private LancamentoRepository lancamentoRepository;

    public LancamentoService(LancamentoRepository lancamentoRepository) {
        this.lancamentoRepository = lancamentoRepository;
    }

    public List<Lancamento> encontrarTodos() {
        return lancamentoRepository.findAll();
    }

    public Lancamento salvar(Lancamento lancamento) {
        return lancamentoRepository.save(lancamento);
    }

    public void apagar(Long id) {
        lancamentoRepository.deleteById(id);
    }

    public Lancamento findById(Long id) {
        return lancamentoRepository.getReferenceById(id);
    }
}

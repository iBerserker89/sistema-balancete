package br.com.balancete.sistema_balancete.controller;

import br.com.balancete.sistema_balancete.model.Categoria;
import br.com.balancete.sistema_balancete.model.Lancamento;
import br.com.balancete.sistema_balancete.model.TipoLancamento;
import br.com.balancete.sistema_balancete.service.CategoriaService;
import br.com.balancete.sistema_balancete.service.LancamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/lancamentos")
public class LancamentoController {
    @Autowired
    private LancamentoService lancamentoService;
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public String list(Model model) {
        List<Lancamento> lancamentos = lancamentoService.encontrarTodos();
        BigDecimal totalDespesas = lancamentoService.sumByTipo(TipoLancamento.DESPESA);
        BigDecimal totalReceitas = lancamentoService.sumByTipo(TipoLancamento.RECEITA);
        model.addAttribute("lancamentos", lancamentos);
        model.addAttribute("totalDespesas", totalDespesas);
        model.addAttribute("totalReceitas", totalReceitas);
        return "lancamentos/list";
    }

    @GetMapping("/novo")
    public String novoLancamentoForm(Model model) {
        model.addAttribute("lancamento", new Lancamento());
        List<Categoria> categorias = categoriaService.encontrarTodos();
        model.addAttribute("categorias", categorias);
        return "lancamentos/form";
    }

    @PostMapping
    public String saveLancamento(@ModelAttribute Lancamento lancamento) {
        lancamentoService.salvar(lancamento);
        return "redirect:/lancamentos";
    }

    @GetMapping("/editar/{id}")
    public String editarLancamentoForm(@PathVariable Long id, Model model) {
        Lancamento lancamento = lancamentoService.findById(id);
        model.addAttribute("lancamento", lancamento);
        List<Categoria> categorias = categoriaService.encontrarTodos();
        model.addAttribute("categorias", categorias);
        return "lancamentos/form";
    }

    @PostMapping("/editar/{id}")
    public String updateLancamento(@PathVariable Long id, @ModelAttribute Lancamento lancamento ) {
        lancamento.setId(id);
        lancamentoService.salvar(lancamento);

        return "redirect:/lancamentos";
    }

    @GetMapping("/deletar/{id}")
    public String deleteLancamento(@PathVariable Long id) {
        lancamentoService.apagar(id);
        return "redirect:/lancamentos";
    }

    @GetMapping("/soma-por-tipo")
    public Map<String, BigDecimal> getSomaPorTipo() {
        Map<String, BigDecimal> somaPorTipo = new HashMap<>();
        somaPorTipo.put("DESPESAS", lancamentoService.sumByTipo(TipoLancamento.DESPESA));
        somaPorTipo.put("RECEITAS", lancamentoService.sumByTipo(TipoLancamento.RECEITA));
        return somaPorTipo;
    }
}

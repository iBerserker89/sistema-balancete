package br.com.balancete.sistema_balancete.controller;


import br.com.balancete.sistema_balancete.model.Lancamento;
import br.com.balancete.sistema_balancete.model.TipoLancamento;
import br.com.balancete.sistema_balancete.repository.LancamentoRepository;
import br.com.balancete.sistema_balancete.service.CategoriaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import br.com.balancete.sistema_balancete.service.LancamentoService;
import br.com.balancete.sistema_balancete.model.Lancamento;

import java.util.List;


@Controller
public class HomeController {


    @GetMapping("/")
    public String index(Model model) {


        model.addAttribute("totalDespesas", 1500);
        model.addAttribute("totalReceitas", 1500);
        return "index";
    }
}

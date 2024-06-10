package br.com.balancete.sistema_balancete.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("totalDespesas", 1000);
        model.addAttribute("totalReceitas", 1500);
        return "index";
    }
}

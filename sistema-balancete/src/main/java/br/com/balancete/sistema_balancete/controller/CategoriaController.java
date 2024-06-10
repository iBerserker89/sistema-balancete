package br.com.balancete.sistema_balancete.controller;

import br.com.balancete.sistema_balancete.model.Categoria;
import br.com.balancete.sistema_balancete.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/categorias")
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public String list(Model model) {
        List<Categoria> categorias = categoriaService.encontrarTodos();
        model.addAttribute("categorias", categorias);
        return "categorias/list";
    }

    @GetMapping("/nova")
    public String novaCategoriaForm(Model model) {
        model.addAttribute("categoria", new Categoria());
        return "categorias/form";
    }

    @PostMapping
    public String salvarCategoria(@ModelAttribute Categoria categoria) {
        categoriaService.salvar(categoria);
        return "redirect:/categorias";
    }

    @GetMapping("/editar/{id}")
    public String editarCategoriaForm(@PathVariable Long id, Model model) {
        Categoria categoria = categoriaService.findById(id);
        model.addAttribute("categoria", categoria);
        return "categorias/form";
    }

    @PostMapping("/editar/{id}")
    public String updateCategoria(@PathVariable Long id, @ModelAttribute Categoria categoria) {
        categoria.setId(id);
        categoriaService.salvar(categoria);
        return "redirect:/categorias";
    }

    @GetMapping("/deletar/{id}")
    public String deleteCategoria(@PathVariable Long id) {
        categoriaService.apagar(id);
        return "redirect:/categorias";
    }
}

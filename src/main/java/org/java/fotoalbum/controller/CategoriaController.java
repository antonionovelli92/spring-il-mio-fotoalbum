package org.java.fotoalbum.controller;

import org.java.fotoalbum.pojo.Categoria;
import org.java.fotoalbum.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;

@Controller
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/categorie")
    public String goToCategoriaIndex(Model model) {
        model.addAttribute("categoriaList", categoriaService.findAll());
        return "categoria-index";
    }

    @GetMapping("/categorie/{id}")
    public String goToCategoriaDetails(Model model, @PathVariable("id") int id) {
        Categoria categoria = categoriaService.findById(id).orElseThrow(() -> new IllegalArgumentException("ID categoria non valido"));
        model.addAttribute("categoria", categoria);
        return "categoria-details";
    }

    @GetMapping("/categorie/create")
    public String getCreate(Model model) {
        model.addAttribute("categoria", new Categoria());
        return "categoria-create";
    }

    @PostMapping("/categorie/create")
    public String storeCategoria(Model model, @Valid @ModelAttribute Categoria categoria, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("categoria", categoria);
            model.addAttribute("errors", bindingResult);
            return "categoria-create";
        }
        categoriaService.save(categoria);
        return "redirect:/categorie";
    }

    @GetMapping("/categorie/edit/{id}")
    public String editCategoria(Model model, @PathVariable int id) {
        Categoria categoria = categoriaService.findById(id).orElseThrow(() -> new IllegalArgumentException("ID categoria non valido"));
        model.addAttribute("categoria", categoria);
        return "categoria-edit";
    }

    @PostMapping("/categorie/update/{id}")
    public String updateCategoria(Model model, @PathVariable int id, @ModelAttribute @Valid Categoria categoria, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("categoria", categoria);
            model.addAttribute("errors", bindingResult);
            return "categoria-edit";
        }
        categoriaService.save(categoria);
        return "redirect:/categorie/" + id;
    }

    @PostMapping("/categorie/delete/{id}")
    public String deleteCategoria(@PathVariable("id") int id) {
        Categoria categoria = categoriaService.findById(id).orElseThrow(() -> new IllegalArgumentException("ID categoria non valido"));
        categoriaService.delete(categoria);
        return "redirect:/categorie";
    }
}

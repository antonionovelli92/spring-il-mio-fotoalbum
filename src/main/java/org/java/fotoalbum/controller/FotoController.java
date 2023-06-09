package org.java.fotoalbum.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.java.fotoalbum.pojo.Categoria;
import org.java.fotoalbum.pojo.Foto;
import org.java.fotoalbum.service.CategoriaService;
import org.java.fotoalbum.service.FotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;

@Controller
public class FotoController {

    @Autowired
    private FotoService fotoService;
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/")
    public String goToFotoIndex(Model model) {
        model.addAttribute("fotoList", fotoService.findAll());
        return "foto-index";
    }

    @GetMapping("/fotoalbum/{id}")
    public String goToFotoDetails(Model model, @PathVariable("id") int id) {
        Foto foto = fotoService.findById(id).orElseThrow(() -> new IllegalArgumentException("ID foto non valido"));
        model.addAttribute("foto", foto);
        return "foto-details";
    }

    @GetMapping("/fotoalbum/create")
    public String getCreate(Model model) {
        model.addAttribute("foto", new Foto());
        model.addAttribute("categorie", categoriaService.findAll());
        return "foto-create";
    }

    @PostMapping("/fotoalbum/create")
    public String storeFoto(Model model, @Valid @ModelAttribute Foto foto,
                            @RequestParam("categorie") List<String> categorieIds,
                            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("foto", foto);
            model.addAttribute("errors", bindingResult);
            model.addAttribute("categorie", categoriaService.findAll());
            return "foto-create";
        }

        List<Integer> categorieIntIds = categorieIds.stream()
                                .map(Integer::valueOf)
                                .collect(Collectors.toList());

        List<Categoria> categorie = categoriaService.getCategorieByIds(categorieIntIds);
        foto.setCategorie(categorie);

        fotoService.save(foto);
        return "redirect:/";
    }




    @GetMapping("/fotoalbum/edit/{id}")
    public String editFoto(Model model, @PathVariable int id) {
        Foto foto = fotoService.findById(id).orElseThrow(() -> new IllegalArgumentException("ID foto non valido"));
        model.addAttribute("foto", foto);
        return "foto-edit";
    }

    @PostMapping("/fotoalbum/update/{id}")
    public String updateFoto(Model model, @PathVariable int id, @ModelAttribute @Valid Foto foto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("foto", foto);
            model.addAttribute("errors", bindingResult);
            return "edit";
        }
        fotoService.save(foto);
        return "redirect:/fotoalbum/" + id;
    }

    @PostMapping("/fotoalbum/delete/{id}")
    public String deleteFoto(@PathVariable("id") int id) {
        Foto foto = fotoService.findById(id).orElseThrow(() -> new IllegalArgumentException("ID foto non valido"));
        fotoService.delete(foto);
        return "redirect:/fotoalbum";
    }
}

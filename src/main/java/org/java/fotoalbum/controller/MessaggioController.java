package org.java.fotoalbum.controller;

import org.java.fotoalbum.pojo.Messaggio;
import org.java.fotoalbum.service.MessaggioService;
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
public class MessaggioController {

    @Autowired
    private MessaggioService messaggioService;

    @GetMapping("/messaggi")
    public String goToMessaggioIndex(Model model) {
        model.addAttribute("messaggioList", messaggioService.findAll());
        return "messaggio-index";
    }

    @GetMapping("/messaggi/{id}")
    public String goToMessaggioDetails(Model model, @PathVariable("id") int id) {
        Messaggio messaggio = messaggioService.findById(id).orElseThrow(() -> new IllegalArgumentException("ID messaggio non valido"));
        model.addAttribute("messaggio", messaggio);
        return "messaggio-details";
    }

    @GetMapping("/messaggi/create")
    public String getCreate(Model model) {
        model.addAttribute("messaggio", new Messaggio());
        return "messaggio-create";
    }

    @PostMapping("/messaggi/create")
    public String storeMessaggio(Model model, @Valid @ModelAttribute Messaggio messaggio, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("messaggio", messaggio);
            model.addAttribute("errors", bindingResult);
            return "messaggio-create";
        }
        messaggioService.save(messaggio);
        return "redirect:/messaggi";
    }

    @GetMapping("/messaggi/edit/{id}")
    public String editMessaggio(Model model, @PathVariable int id) {
        Messaggio messaggio = messaggioService.findById(id).orElseThrow(() -> new IllegalArgumentException("ID messaggio non valido"));
        model.addAttribute("messaggio", messaggio);
        return "messaggio-edit";
    }

    @PostMapping("/messaggi/update/{id}")
    public String updateMessaggio(Model model, @PathVariable int id, @ModelAttribute @Valid Messaggio messaggio, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("messaggio", messaggio);
            model.addAttribute("errors", bindingResult);
            return "messaggio-edit";
        }
        messaggioService.save(messaggio);
        return "redirect:/messaggi/" + id;
    }

    @PostMapping("/messaggi/delete/{id}")
    public String deleteMessaggio(@PathVariable("id") int id) {
        Messaggio messaggio = messaggioService.findById(id).orElseThrow(() -> new IllegalArgumentException("ID messaggio non valido"));
        messaggioService.delete(messaggio);
        return "redirect:/messaggi";
    }
    
    
}

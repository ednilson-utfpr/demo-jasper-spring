package com.mballem.curso.jasper.spring.controller;

import com.mballem.curso.jasper.spring.model.Situacao;
import com.mballem.curso.jasper.spring.service.SituacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("situacao")
public class SituacaoController {

    @Autowired
    private SituacaoService situacaoService;

    @GetMapping(value = {"new", "novo", "form"})
    public String form(Model model) {
        model.addAttribute("situacao", new Situacao());
        return "situacao/form";
    }

    @PostMapping
    public String save(@Valid Situacao situacao, BindingResult result, Model model, RedirectAttributes attributes) {
        if ( result.hasErrors() ) {
            model.addAttribute("situacao", situacao);
            return "situacao/form";
        }

        situacaoService.save(situacao);
        attributes.addFlashAttribute("sucesso", "Registro salvo com sucesso!");
        return "redirect:/situacao";
    }

    @GetMapping("{id}")
    public String form(@PathVariable Long id, Model model) {
        model.addAttribute("situacao", situacaoService.findOne(id));
        return "situacao/form";
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable Long id, RedirectAttributes attributes) {
        try {
            situacaoService.delete(id);
            attributes.addFlashAttribute("sucesso", "Registro removido com sucesso!");
        } catch (Exception e) {
            attributes.addFlashAttribute("erro", "Falha ao remover o registro!");
        }
        return "redirect:/situacao";
    }
}
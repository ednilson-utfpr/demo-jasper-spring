package com.mballem.curso.jasper.spring.controller;


import com.mballem.curso.jasper.spring.model.Produto;
import com.mballem.curso.jasper.spring.service.CategoriaService;
import com.mballem.curso.jasper.spring.service.PedidoItemService;
import com.mballem.curso.jasper.spring.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;
    @Autowired
    private CategoriaService categoriaService;
    @Autowired
    private PedidoItemService pedidoItemService;


    @GetMapping (value = {"lista"})
    public String list(Model model) {
        model.addAttribute("produtos", produtoService.findAll());
        return "produto/lista";
    }






//	@Autowired
//	private MarcaService marcaService;

//    @GetMapping
//    public String list(@RequestParam("nome") Optional<String> nome, @RequestParam("categoria") Optional<Long> categoria, Model model) {
//        String filtro = nome.orElse("");
//        Long filtroCateg = categoria.orElse(0L);
////        if (!filtro.isEmpty()) {
////            model.addAttribute("produtos", produtoService.findByNomeContaining(filtro));
////        } else {
////            model.addAttribute("produtos", produtoService.findAll());
////        }
//        if (!filtroCateg.equals(0L)) {
//            model.addAttribute("produtos", produtoService.findAllByCategoria_Id(filtroCateg));
//        } else {
//            model.addAttribute("produtos", produtoService.findAll());
//        }
//
//        model.addAttribute("categorias", categoriaService.findAll());
//        return "produto/list";
//    }

    @GetMapping
    public String list(@RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size,
                       @RequestParam("nome") Optional<String> nome, @RequestParam("categoria") Optional<Long> categoria,
                       Model model) {

        String filtro = nome.orElse("");
        Long filtroCateg = categoria.orElse(0L);
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(5);

        Page<Produto> list;
        if (!filtroCateg.equals(0L)) {
            list = this.produtoService.findAllByCategoria_Id(filtroCateg, PageRequest.of(currentPage - 1, pageSize));
        } else {
            list = this.produtoService.findAll(PageRequest.of(currentPage - 1, pageSize));
        }

        model.addAttribute("produtos", list);

        if (list.getTotalPages() > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, list.getTotalPages()).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }

        model.addAttribute("categorias", categoriaService.findAll());
        return "produto/list";
    }

    @GetMapping(value = {"new", "novo", "form"})
    public String form(Model model) {
        model.addAttribute("produto", new Produto());
        carregarCombos(model);
        return "produto/form";
    }

    //Carrega os combos na edição da tabela
    private void carregarCombos(Model model) {
        model.addAttribute("categorias", categoriaService.findAll());
    }

    @PostMapping
    public String save(@Valid Produto produto, BindingResult result, Model model, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            model.addAttribute("produto", produto);
            return "produto/form";
        }

        produtoService.save(produto);
        attributes.addFlashAttribute("sucesso", "Registro salvo com sucesso!");
        return "redirect:/produto/lista";
    }

//    @GetMapping("{id}") // /produto/25
//    public String form(@PathVariable Long id, Model model) {
//        Produto produto = produtoService.findOne(id);
//        model.addAttribute("produto", produto);
//        PedidoItem pedidoItem = new PedidoItem();
//        pedidoItem.setProduto(produto);
//        pedidoItem.setValor(produto.getValor());
//        model.addAttribute("pedidoItem", pedidoItem);
//        carregarCombos(model);
//        return "produto/details";
//    }

//EDITAR PRODUTO
    @GetMapping("{id}")
    public String form(@PathVariable Long id, Model model) {
        model.addAttribute("produto", produtoService.findOne(id));
        //Carrega os combos na edição da tabela
        carregarCombos(model);
        return "produto/form";
    }



    //REMOVER PRODUTO
    @DeleteMapping("{id}")
    public String delete(@PathVariable Long id, RedirectAttributes attributes) {
        try {
            produtoService.delete(id);
            //categoriaService.delete(id);
            attributes.addFlashAttribute("sucesso",
                    "Registro removido com sucesso!");
        } catch (Exception e) {
            attributes.addFlashAttribute("erro",
                    "Falha ao remover o registro!");
        }
        return "redirect:/produto";
    }


//    @DeleteMapping("{id}") // /produto/25
//    public String delete(@PathVariable Long id, RedirectAttributes attributes) {
//        try {
//            produtoService.delete(id);
//            attributes.addFlashAttribute("sucesso", "Registro removido com sucesso!");
//        } catch (Exception e) {
//            attributes.addFlashAttribute("erro", "Falha ao remover o registro!");
//        }
//        return "redirect:/produto";
//    }
}
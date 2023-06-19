package com.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.ecommerce.model.Produto;
import com.ecommerce.service.ProdutoService;
import java.util.List;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public List<Produto> getAllProdutos() {
        return produtoService.getAllProdutos();
    }

    @GetMapping("/{id}")
    public Produto getProdutoById(@PathVariable Long id) {
        return produtoService.getProdutoById(id);
    }

    @PostMapping
    public Produto createProduto(@RequestBody Produto produto) {
        return produtoService.saveProduto(produto);
    }

    @PutMapping("/{id}")
    public Produto updateProduto(@PathVariable Long id, @RequestBody Produto produtoDetails) {
        Produto produto = produtoService.getProdutoById(id);
        produto.setNome(produtoDetails.getNome());
        produto.setPreco(produtoDetails.getPreco());
        return produtoService.saveProduto(produto);
    }

    @DeleteMapping("/{id}")
    public void deleteProduto(@PathVariable Long id) {
        produtoService.deleteProduto(id);
    }

    @GetMapping("/pagina")
    public String getProdutos(Model model) {
        model.addAttribute("produtos", produtoService.getAllProdutos());
        model.addAttribute("produto", new Produto());
        return "produto";
    }

    @PostMapping("/pagina")
    public String createProduto(@ModelAttribute Produto produto) {
        produtoService.saveProduto(produto);
        return "redirect:/produtos/pagina";
    }
}





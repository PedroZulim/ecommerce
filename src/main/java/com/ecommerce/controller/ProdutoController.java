package com.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.ecommerce.model.Produto;
import com.ecommerce.service.ProdutoService;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public List<Produto> getAllProdutos() {
        return produtoService.getAllProdutos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> getProdutoById(@PathVariable Long id) {
        Produto produto = produtoService.getProdutoById(id);
        if (produto != null) {
            return ResponseEntity.ok(produto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Produto createProduto(@RequestBody Produto produto) {
        return produtoService.saveProduto(produto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> updateProduto(@PathVariable Long id, @RequestBody Produto produtoDetails) {
        Produto produto = produtoService.getProdutoById(id);
        if (produto != null) {
            produto.setNome(produtoDetails.getNome());
            produto.setPreco(produtoDetails.getPreco());
            produtoService.saveProduto(produto);
            return ResponseEntity.ok(produto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduto(@PathVariable Long id) {
        Produto produto = produtoService.getProdutoById(id);
        if (produto != null) {
            produtoService.deleteProduto(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}




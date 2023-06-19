package com.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.ecommerce.model.ItemPedido;
import com.ecommerce.service.ItemPedidoService;
import java.util.List;

@Controller
@RequestMapping("/itensPedido")
public class ItemPedidoController {

    @Autowired
    private ItemPedidoService itemPedidoService;

    @GetMapping
    public List<ItemPedido> getAllItensPedido() {
        return itemPedidoService.getAllItensPedido();
    }

    @GetMapping("/{id}")
    public ItemPedido getItemPedidoById(@PathVariable Long id) {
        return itemPedidoService.getItemPedidoById(id);
    }

    @PostMapping
    public ItemPedido createItemPedido(@RequestBody ItemPedido itemPedido) {
        return itemPedidoService.saveItemPedido(itemPedido);
    }

    @PutMapping("/{id}")
    public ItemPedido updateItemPedido(@PathVariable Long id, @RequestBody ItemPedido itemPedidoDetails) {
        ItemPedido itemPedido = itemPedidoService.getItemPedidoById(id);
        itemPedido.setProduto(itemPedidoDetails.getProduto());
        itemPedido.setQuantidade(itemPedidoDetails.getQuantidade());
        return itemPedidoService.saveItemPedido(itemPedido);
    }

    @DeleteMapping("/{id}")
    public void deleteItemPedido(@PathVariable Long id) {
        itemPedidoService.deleteItemPedido(id);
    }

    @GetMapping("/pagina")
    public String getItensPedido(Model model) {
        model.addAttribute("itensPedido", itemPedidoService.getAllItensPedido());
        model.addAttribute("itemPedido", new ItemPedido());
        return "itemPedido";
    }

    @PostMapping("/pagina")
    public String createItemPedido(@ModelAttribute ItemPedido itemPedido) {
        itemPedidoService.saveItemPedido(itemPedido);
        return "redirect:/itensPedido/pagina";
    }
}


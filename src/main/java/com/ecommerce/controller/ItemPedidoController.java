package com.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.ecommerce.model.ItemPedido;
import com.ecommerce.service.ItemPedidoService;
import java.util.List;

@RestController
@RequestMapping("/itens-pedido")
public class ItemPedidoController {

    @Autowired
    private ItemPedidoService itemPedidoService;

    @GetMapping
    public List<ItemPedido> getAllItemPedidos() {
        return itemPedidoService.getAllItemPedidos();
    }

    @GetMapping("/{id}")
    public ItemPedido getItemPedidoById(@PathVariable Long id) {
        return itemPedidoService.getItemPedidoById(id);
    }

    @PostMapping
    public ItemPedido createItemPedido(@RequestBody ItemPedido itemPedido) {
        return itemPedidoService.saveItemPedido(itemPedido);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItemPedido(@PathVariable Long id) {
        itemPedidoService.deleteItemPedido(id);
        return ResponseEntity.noContent().build();
    }
}


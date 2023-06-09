package com.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ecommerce.model.ItemPedido;
import com.ecommerce.repository.ItemPedidoRepository;
import java.util.List;

@Service
public class ItemPedidoService {

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    public List<ItemPedido> getAllItemPedidos() {
        return itemPedidoRepository.findAll();
    }

    public ItemPedido getItemPedidoById(Long id) {
        return itemPedidoRepository.findById(id).orElse(null);
    }

    public ItemPedido saveItemPedido(ItemPedido itemPedido) {
        return itemPedidoRepository.save(itemPedido);
    }

    public void deleteItemPedido(Long id) {
        itemPedidoRepository.deleteById(id);
    }
}
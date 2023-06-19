package com.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.ecommerce.model.Pedido;
import com.ecommerce.service.PedidoService;
import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public List<Pedido> getAllPedidos() {
        return pedidoService.getAllPedidos();
    }

    @GetMapping("/{id}")
    public Pedido getPedidoById(@PathVariable Long id) {
        return pedidoService.getPedidoById(id);
    }

    @PostMapping
    public Pedido createPedido(@RequestBody Pedido pedido) {
        return pedidoService.savePedido(pedido);
    }

    @PutMapping("/{id}")
    public Pedido updatePedido(@PathVariable Long id, @RequestBody Pedido pedidoDetails) {
        Pedido pedido = pedidoService.getPedidoById(id);
        pedido.setCliente(pedidoDetails.getCliente());
        pedido.setItensPedido(pedidoDetails.getItensPedido());
        return pedidoService.savePedido(pedido);
    }

    @DeleteMapping("/{id}")
    public void deletePedido(@PathVariable Long id) {
        pedidoService.deletePedido(id);
    }

    // Adicionado o método GET para renderizar a página de pedidos
    @GetMapping("/pagina")
    public String getPedidos(Model model) {
        model.addAttribute("pedidos", pedidoService.getAllPedidos());
        model.addAttribute("pedido", new Pedido());
        return "pedido";
    }

    // Adicionado o método POST para processar o formulário de pedidos
    @PostMapping("/pagina")
    public String createPedido(@ModelAttribute Pedido pedido) {
        pedidoService.savePedido(pedido);
        return "redirect:/pedidos/pagina";
    }
}



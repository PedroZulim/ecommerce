package com.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.ecommerce.model.Cliente;
import com.ecommerce.service.ClienteService;
import java.util.List;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<Cliente> getAllClientes() {
        return clienteService.getAllClientes();
    }

    @GetMapping("/{id}")
    public Cliente getClienteById(@PathVariable Long id) {
        return clienteService.getClienteById(id);
    }

    @PostMapping
    public Cliente createCliente(@RequestBody Cliente cliente) {
        return clienteService.saveCliente(cliente);
    }

    @PutMapping("/{id}")
    public Cliente updateCliente(@PathVariable Long id, @RequestBody Cliente clienteDetails) {
        Cliente cliente = clienteService.getClienteById(id);
        cliente.setNome(clienteDetails.getNome());
        return clienteService.saveCliente(cliente);
    }

    @DeleteMapping("/{id}")
    public void deleteCliente(@PathVariable Long id) {
        clienteService.deleteCliente(id);
    }

    @GetMapping("/pagina")
    public String getClientes(Model model) {
        model.addAttribute("clientes", clienteService.getAllClientes());
        model.addAttribute("cliente", new Cliente());
        return "cliente";
    }

    @PostMapping("/pagina")
    public String createCliente(@ModelAttribute Cliente cliente) {
        clienteService.saveCliente(cliente);
        return "redirect:/clientes/pagina";
    }
}


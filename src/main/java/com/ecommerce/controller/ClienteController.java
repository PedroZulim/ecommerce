package com.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.ecommerce.model.Cliente;
import com.ecommerce.service.ClienteService;
import java.util.List;

@RestController
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

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable Long id) {
        clienteService.deleteCliente(id);
        return ResponseEntity.noContent().build();
    }
}

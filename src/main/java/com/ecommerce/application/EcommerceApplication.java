package com.ecommerce.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.ecommerce.model.Cliente;
import com.ecommerce.model.Produto;
import com.ecommerce.repository.ClienteRepository;
import com.ecommerce.repository.ProdutoRepository;
import com.ecommerce.service.ClienteService;

@SpringBootApplication
public class EcommerceApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(EcommerceApplication.class, args);

		ClienteService clienteService = context.getBean(ClienteService.class);

		Cliente cliente = new Cliente();
		System.out.println(clienteService.getAllClientes());

	}
}

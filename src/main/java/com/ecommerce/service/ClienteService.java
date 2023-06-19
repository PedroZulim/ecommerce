package com.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ecommerce.model.Cliente;

@RestController
public class ClienteService {

  @Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
  
  @Autowired
  private ClienteRepository clienteRepository;


	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@RequestMapping(path="/getcliente", method=RequestMethod.GET)
	public ResponseEntity<String> getCliente(Long id){

		Cliente respCli = new Cliente();
		String errResp = "";
		ResponseEntity<String> response = null;

		try {

			response = new ResponseEntity<String>(respCli.toString(), HttpStatus.OK);
		
		} catch (Exception e) {

			errResp = "{\"sucesso\": \"False - Erro ao localizar cliente !\"}";
			response = new ResponseEntity<String>(errResp, HttpStatus.EXPECTATION_FAILED);

		}
		return response;
		
	}
	
}
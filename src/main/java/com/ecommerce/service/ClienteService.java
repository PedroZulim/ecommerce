package com.ecommerce.service;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ecommerce.model.Cliente;

@RestController
public class ClienteService {
	
  RestTemplate restTemplate;

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
package br.com.estagiogubee.microservice.loja.service;

import org.springframework.web.client.RestTemplate;

import br.com.estagiogubee.microservice.loja.controller.dto.CompraDTO;
import br.com.estagiogubee.microservice.loja.controller.dto.InfoFornecedorDTO;

public class CompraService {

	public void realizaCompra(CompraDTO compra) {
		
		RestTemplate client = new RestTemplate();
		client.exchange("http://localhost:8081/info/"+compra.getEndereco().getEstado(),
					HttpMethod.GET,
					null,
					InfoFornecedorDTO.class
				)
		
	}

}

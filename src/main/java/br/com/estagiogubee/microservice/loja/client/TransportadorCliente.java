package br.com.estagiogubee.microservice.loja.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.estagiogubee.microservice.loja.controller.dto.InfoEntregaDTO;
import br.com.estagiogubee.microservice.loja.controller.dto.VoucherDTO;

@FeignClient("transportador")
public interface TransportadorCliente {

	@RequestMapping(path = "/entrega", method = RequestMethod.POST)
	public VoucherDTO reservaEntrega(InfoEntregaDTO pedidoDTO);
	
}

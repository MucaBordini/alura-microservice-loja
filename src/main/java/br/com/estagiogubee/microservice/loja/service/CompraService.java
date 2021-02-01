package br.com.estagiogubee.microservice.loja.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.estagiogubee.microservice.loja.client.FornecedorClient;
import br.com.estagiogubee.microservice.loja.controller.dto.CompraDTO;
import br.com.estagiogubee.microservice.loja.controller.dto.InfoFornecedorDTO;
import br.com.estagiogubee.microservice.loja.controller.dto.InfoPedidoDTO;
import br.com.estagiogubee.microservice.loja.model.Compra;

@Service
public class CompraService {
	
	@Autowired
	private FornecedorClient fornecedorClient;
	
	public Compra realizaCompra(CompraDTO compra) {
		
		InfoFornecedorDTO info = fornecedorClient.getInfoPorEstado(compra.getEndereco().getEstado());
		
		InfoPedidoDTO pedido = fornecedorClient.realizaPedido(compra.getItens());
		
		Compra compraSalva = new Compra();
		compraSalva.setPedidoId(pedido.getId());
		compraSalva.setTempoDePreparo(pedido.getTempoDePreparo());
		compraSalva.setEnderecoDestino(compra.getEndereco().toString());
		
		return compraSalva;
		
		
	}

}

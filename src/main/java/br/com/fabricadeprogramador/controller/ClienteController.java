package br.com.fabricadeprogramador.controller;

import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.fabricadeprogramador.model.Cliente;
import br.com.fabricadeprogramador.repository.ClienteRepository;

@Named
@ViewScoped
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;
	
	private Cliente cliente =  new Cliente();
	
	
	public void salvar(){
		
		clienteRepository.save(getCliente());
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}

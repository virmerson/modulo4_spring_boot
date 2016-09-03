package br.com.fabricadeprogramador.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.fabricadeprogramador.model.Cliente;
import br.com.fabricadeprogramador.model.Contato;
import br.com.fabricadeprogramador.repository.ClienteRepository;

@Named
@ViewScoped
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;
	
	private List<Cliente> clientes;
	
	private Cliente cliente =  new Cliente();

	private boolean modoEdicao=false;
	
	private String descricaoContato;
	
	@PostConstruct
	public void init() {
		setClientes(clienteRepository.buscarTodos());
	}
	
	
	public void salvar(){
		
		clienteRepository.save(cliente);
		if(!isModoEdicao())
			clientes.add(cliente);
		cliente = new Cliente();
		setModoEdicao(false);
	}

	public void excluir(Cliente cliente){
		clienteRepository.delete(cliente);
		clientes.remove(cliente);
	}
	
	public void editar(Cliente cliente){
		setCliente(cliente);
		setModoEdicao(true);
	}
	
	public void cancelar(){
		cliente = new Cliente();
		setModoEdicao(false);
	}

	
	public void adicionarContato(){
		
		Contato contato = new Contato();
		contato.setDescricao(getDescricaoContato());
		contato.setCliente(cliente);
		
		cliente.getContatos().add(contato);
		
		setDescricaoContato("");
	}
	
	public void excluirContato(Contato contato){
		
		cliente.getContatos().remove(contato);
	}
	
	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public List<Cliente> getClientes() {
		return clientes;
	}
	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	public boolean isModoEdicao() {
		return modoEdicao;
	}
	public void setModoEdicao(boolean modoEdicao) {
		this.modoEdicao = modoEdicao;
	}


	public String getDescricaoContato() {
		return descricaoContato;
	}


	public void setDescricaoContato(String descricaoContato) {
		this.descricaoContato = descricaoContato;
	}
}

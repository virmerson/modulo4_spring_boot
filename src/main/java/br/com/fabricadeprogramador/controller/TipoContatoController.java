package br.com.fabricadeprogramador.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.fabricadeprogramador.model.TipoContato;
import br.com.fabricadeprogramador.repository.TipoContatoRepository;
import lombok.Getter;
import lombok.Setter;

@Named
@ViewScoped
public class TipoContatoController {

		@Autowired
		private TipoContatoRepository tipoContatoRepository;
		
		@Getter @Setter
		private List<TipoContato> tipoContatos;
		
		@PostConstruct
		public void init(){
			setTipoContatos(tipoContatoRepository.findAll());
		}

	
}

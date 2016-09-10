package br.com.fabricadeprogramador.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contato {
	@Id
	@GeneratedValue
	private Integer id;
	private String descricao;
	
	@JoinColumn
	@ManyToOne
	private Cliente cliente;
	
	@JoinColumn
	@ManyToOne
	private TipoContato tipoContato;
	
}

package br.com.fabricadeprogramador.controller.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.fabricadeprogramador.model.TipoContato;
import br.com.fabricadeprogramador.repository.TipoContatoRepository;

@Component
public class TipoContatoConverter implements Converter {

	@Autowired
	TipoContatoRepository tipoContatoRepository;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value.isEmpty())
			return null;
		try {
			TipoContato tipoContato = tipoContatoRepository.findOne(new Integer(value));
			return tipoContato;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value instanceof TipoContato) {
			TipoContato tipoContato = (TipoContato) value;
			return tipoContato.getId().toString();
		} else {
			return null;
		}
	}

}

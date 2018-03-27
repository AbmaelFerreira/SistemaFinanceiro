package com.fisioana.financeiro.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.persistence.EntityManager;

import com.fisioana.financeiro.model.Pessoa;
import com.fisioana.financeiro.repository.Pessoas;
import com.fisioana.financeiro.util.FacesUtil;
import com.fisioana.financeiro.util.Repositorios;

@FacesConverter(forClass = Pessoa.class)
public class PessoaConverter implements Converter {

	Repositorios repositorios = new Repositorios();
	EntityManager em = (EntityManager) FacesUtil.getRequestAttibute("conexao");

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Pessoa retorno = null;

		if (value != null) {
			Pessoas pessoas = this.repositorios.getPessoas();
			retorno = pessoas.porCodigo(new Integer(value));
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			return ((Pessoa) value).getCodigo().toString();
		}
		return null;
	}

}
package com.fisioana.financeiro.converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import com.fisioana.financeiro.model.Lancamento;
import com.fisioana.financeiro.repository.Lancamentos;
import com.fisioana.financeiro.util.FacesUtil;
import com.fisioana.financeiro.util.Repositorios;

@FacesConverter(forClass = Lancamento.class)
public class LancamentoConverter implements Converter {

	Repositorios repositorios = new Repositorios();

	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Lancamento retorno = null;
		Lancamentos lancamentos = this.repositorios.getLancamentos();

		if (value != null && !value.equals("")) {
			retorno = lancamentos.porCodigo(new Integer(value));

			if (retorno == null) {
				String descricaoErro = FacesUtil.getMessagemI18n("entry_does_not_exist");
				FacesMessage messagem = new FacesMessage(FacesMessage.SEVERITY_ERROR, descricaoErro, descricaoErro);
				throw new ConverterException(messagem);
			}
		}

		return retorno;
	}

	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Integer codigo = ((Lancamento) value).getCodigo();
			return codigo == null ? "" : codigo.toString();
		}
		return null;
	}
}

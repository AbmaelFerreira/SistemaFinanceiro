package com.fisioana.financeiro.view;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import com.fisioana.financeiro.model.Lancamento;
import com.fisioana.financeiro.model.Pessoa;
import com.fisioana.financeiro.model.TipoLancamento;
import com.fisioana.financeiro.repository.Pessoas;
import com.fisioana.financeiro.service.GestaoLancamentos;
import com.fisioana.financeiro.service.RegraNegocioExceptio;
import com.fisioana.financeiro.util.FacesUtil;
import com.fisioana.financeiro.util.Repositorios;

@ManagedBean
@ViewScoped
public class CadastroLancamentoBean {

	private Repositorios repositorios = new Repositorios();
	private List<Pessoa> pessoas = new ArrayList<Pessoa>();
	private Lancamento lancamento = new Lancamento();

	@PostConstruct
	public void init() {

		Pessoas pessoas = this.repositorios.getPessoas();
		this.pessoas = pessoas.todas();
	}

	public void lancamentoPagoModificado(ValueChangeEvent event) {
		this.lancamento.setPago((Boolean) event.getNewValue());
		this.lancamento.setDataPagamento(null);
		FacesContext.getCurrentInstance().renderResponse();
	}

	public void cadastrar() throws RegraNegocioExceptio {
		GestaoLancamentos gestaolancamento = new GestaoLancamentos(this.repositorios.getLancamentos());
		try {
			gestaolancamento.salvar(lancamento);

			this.lancamento = new Lancamento();

			FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_INFO, FacesUtil.getMessagemI18n("entry_saved"));

		} catch (RegraNegocioExceptio e) {
			FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_ERROR, FacesUtil.getMessagemI18n(e.getMessage()));
		}
	}

	public boolean isEditando() {
		return this.lancamento.getCodigo() != null;
	}

	public TipoLancamento[] getTiposLancamentos() {
		return TipoLancamento.values();
	}

	public void setLancamento(Lancamento lancamento) {
		this.lancamento = lancamento;
		if (this.lancamento == null) {
			this.lancamento = new Lancamento();
		}
	}

	public Lancamento getLancamento() {
		return lancamento;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

}
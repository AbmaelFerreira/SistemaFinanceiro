package com.fisioana.financeiro.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;

import com.fisioana.financeiro.model.Lancamento;
import com.fisioana.financeiro.repository.Lancamentos;
import com.fisioana.financeiro.service.GestaoLancamentos;
import com.fisioana.financeiro.service.RegraNegocioExceptio;
import com.fisioana.financeiro.util.FacesUtil;
import com.fisioana.financeiro.util.Repositorios;

@ManagedBean
public class ConsultaLancamentoBean implements Serializable {
	private static final long serialVersionUID = 1L;

	Repositorios repositorios = new Repositorios();

	private List<Lancamento> lancamentos = new ArrayList<Lancamento>();
	private Lancamento lancamentoSelecionado;
	
	private Lancamento lancamento;

	
	@PostConstruct
	public void inicializar() {
		Lancamentos lancamentos = repositorios.getLancamentos();
		this.lancamentos = lancamentos.todos();
		this.lancamento = lancamentos.somar();
	}

	public void excluir() {

		GestaoLancamentos gestaoLancamentos = new GestaoLancamentos(this.repositorios.getLancamentos());
		try {
			gestaoLancamentos.excluir(lancamentoSelecionado);
			FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_INFO, "Lançamento excluído com sucesso!");
			this.inicializar();
		} catch (RegraNegocioExceptio e) {
			FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_ERROR, e.getMessage());
		}
	}

	public List<Lancamento> getLancamentos() {
		return lancamentos;
	}

	public Lancamento getLancamentoSelecionado() {
		return lancamentoSelecionado;
	}

	public void setLancamentoSelecionado(Lancamento lancamentoSelecionado) {
		this.lancamentoSelecionado = lancamentoSelecionado;
	}
}
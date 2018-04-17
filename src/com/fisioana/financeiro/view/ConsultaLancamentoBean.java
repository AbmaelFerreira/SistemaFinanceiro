package com.fisioana.financeiro.view;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.event.ActionEvent;

import com.fisioana.financeiro.model.Lancamento;
import com.fisioana.financeiro.repository.Lancamentos;
import com.fisioana.financeiro.service.GestaoLancamentos;
import com.fisioana.financeiro.service.RegraNegocioExceptio;
import com.fisioana.financeiro.util.FacesUtil;
import com.fisioana.financeiro.util.Repositorios;

@ManagedBean
public class ConsultaLancamentoBean implements Serializable {
	
	//ATRIBUTOS E OBJETOS

	Repositorios repositorios = new Repositorios();
	private static final long serialVersionUID = 1L;
	private List<Lancamento> lancamentos = new ArrayList<Lancamento>();
	private Lancamento lancamentoSelecionado;
	private BigDecimal valorTotal;
	
	
	@PostConstruct
	public void inicializar() 
	{
		Lancamentos lancamentos = repositorios.getLancamentos();
		this.lancamentos = lancamentos.todos();
		
	}
		//METODOS PRINCIPAIS
	
//	public void somarValor(ActionEvent event) {
//		Lancamentos somaValores = this.repositorios.getLancamentos();
//		for(Lancamento lancamento:somaValores.todos())
//		{
//			this.valorTotal = this.valorTotal.add(lancamento.getValor());
//		}
//			
//		
//	}
	
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
	
				//GETTES AND SETTERES
	

	public List<Lancamento> getLancamentos() {
		return lancamentos;
	}

	public Lancamento getLancamentoSelecionado() {
		return lancamentoSelecionado;
	}

	public void setLancamentoSelecionado(Lancamento lancamentoSelecionado) {
		this.lancamentoSelecionado = lancamentoSelecionado;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

}
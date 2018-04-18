package com.fisioana.financeiro.view;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;

import com.fisioana.financeiro.model.Lancamento;
import com.fisioana.financeiro.repository.Lancamentos;
import com.fisioana.financeiro.util.Repositorios;

@ManagedBean
public class RegistroCliqueBotaoListener implements ActionListener {
	
	Repositorios repositorios = new Repositorios();
	private List<Lancamento> lancamentos = new ArrayList<Lancamento>();

	private BigDecimal valorTotal= new BigDecimal(0);
	Lancamento lancamento = new Lancamento();
	
	public void processAction(ActionEvent event) throws AbortProcessingException 
	{
		Lancamentos lancamentos = repositorios.getLancamentos();
		this.lancamentos = lancamentos.todos();
		for(Lancamento lancamento:this.lancamentos)
		{
			System.out.println("O valor é "+lancamento.getValor());
			this.valorTotal = this.valorTotal.add(lancamento.getValor());
		}
			System.out.println("O valor é "+lancamento.getValor());
	}
	

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}


	public List<Lancamento> getLancamentos() {
		return lancamentos;
	}


	public void setLancamentos(List<Lancamento> lancamentos) {
		this.lancamentos = lancamentos;
	}


	public Lancamento getLancamento() {
		return lancamento;
	}


	public void setLancamento(Lancamento lancamento) {
		this.lancamento = lancamento;
	}


}

package com.fisioana.financeiro.repository;

import java.util.List;

import com.fisioana.financeiro.model.Lancamento;

public interface Lancamentos {

	public List<Lancamento> todos();

	public Lancamento comDadosIguais(Lancamento lancamento);

	public Lancamento porCodigo(Integer codigo);

	public Lancamento Guarda(Lancamento lancamento);

	public void remover(Lancamento lancamento);
	//public List<Lancamento> somaValor();


}

package com.fisioana.financeiro.repository;

import java.util.List;

import com.fisioana.financeiro.model.Pessoa;

public interface Pessoas {
	
	public List<Pessoa> todas();

	public Pessoa porCodigo(Integer codigo);

}

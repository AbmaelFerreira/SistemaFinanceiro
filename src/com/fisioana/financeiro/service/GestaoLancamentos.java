package com.fisioana.financeiro.service;

import com.fisioana.financeiro.model.Lancamento;
import com.fisioana.financeiro.repository.Lancamentos;

public class GestaoLancamentos {

	private Lancamentos lancamentos;

	public GestaoLancamentos(Lancamentos lancamentos) {
		this.lancamentos = lancamentos;
	}

	public void salvar(Lancamento lancamento) throws RegraNegocioExceptio {
		if (existeLancamentoSemelhante(lancamento)) {
			throw new RegraNegocioExceptio("existing_entry ");
		}

		this.lancamentos.Guarda(lancamento);
	}

	private boolean existeLancamentoSemelhante(Lancamento lancamento) {
		Lancamento lancamentoSemelhante = this.lancamentos.comDadosIguais(lancamento);

		return lancamentoSemelhante != null && !lancamentoSemelhante.equals(lancamento);
	}

	public void excluir(Lancamento lancamento) throws RegraNegocioExceptio {
		if (lancamento.isPago()) {
			throw new RegraNegocioExceptio("Lançamento pago não pode ser excluido");
		}
		this.lancamentos.remover(lancamento);
	}
	
	
}

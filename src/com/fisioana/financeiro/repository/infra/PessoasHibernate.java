package com.fisioana.financeiro.repository.infra;

import java.util.List;

import javax.persistence.EntityManager;

import com.fisioana.financeiro.model.Pessoa;
import com.fisioana.financeiro.repository.Pessoas;

public class PessoasHibernate implements Pessoas {

	EntityManager em;

	public PessoasHibernate(EntityManager em) {
		this.em = em;
	}

	public List<Pessoa> todas() {
		return this.em.createQuery("from Pessoa", Pessoa.class).getResultList();
	}

	public Pessoa porCodigo(Integer codigo) {
		return em.find(Pessoa.class, codigo);
	}

}

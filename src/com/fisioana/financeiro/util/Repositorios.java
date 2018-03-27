package com.fisioana.financeiro.util;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.fisioana.financeiro.repository.Pessoas;
import com.fisioana.financeiro.repository.infra.LancamentosHibernate;
import com.fisioana.financeiro.repository.infra.PessoasHibernate;

public class Repositorios implements Serializable {

	private static final long serialVersionUID = 1L;
	// EntityManager em = (EntityManager) FacesUtil.getRequestAttibute("conexao");
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemploPU");
	EntityManager em = emf.createEntityManager();

	public Pessoas getPessoas() {
		return new PessoasHibernate(em);
	}

	public LancamentosHibernate getLancamentos() {
		return new LancamentosHibernate(em);
	}
}

package com.fisioana.financeiro.repository.infra;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.fisioana.financeiro.model.Lancamento;
import com.fisioana.financeiro.repository.Lancamentos;

public class LancamentosHibernate implements Lancamentos {
	EntityManager em;

	public LancamentosHibernate(EntityManager em) {
		this.em = em;
	}

	@Override
	public List<Lancamento> todos() {
		return em.createQuery("from Lancamento", Lancamento.class).getResultList();
	}

	public Lancamento Guarda(Lancamento lancamento) {
		em.getTransaction().begin();
		em.merge(lancamento);
		em.getTransaction().commit();

		return lancamento;
	}

	@Override
	public void remover(Lancamento aExcluir) {
		em.getTransaction().begin();
		em.remove(aExcluir);
		em.getTransaction().commit();

	}

	@SuppressWarnings("deprecation")
	@Override
	public Lancamento comDadosIguais(Lancamento lancamento) {
		Session session = this.em.unwrap(Session.class);

		return (Lancamento) session.createCriteria(Lancamento.class).add(Restrictions.eq("tipo", lancamento.getTipo()))
				.add(Restrictions.eq("pessoa", lancamento.getPessoa()))
				.add(Restrictions.ilike("descricao", lancamento.getDescricao()))
				.add(Restrictions.eq("valor", lancamento.getValor()))
				.add(Restrictions.eq("dataVencimento", lancamento.getDataVencimento())).uniqueResult();
	}

	@Override
	public Lancamento porCodigo(Integer codigo) {
		return em.find(Lancamento.class, codigo);
	}
	
//	List<Lancamento> listaLan = new ArrayList<Lancamento>();
//	Lancamento valorTotal = new Lancamento();
	
//	public List<Lancamento> somaValor () {
//		return this.listaLan =  em.createQuery("sum (valor)from Lancamento", Lancamento.class).getParameterValue(arg0).getSingleResult();
//	}
//		
//		//return (Lancamento) em.createQuery("SUM(VALOR) FROM LANCAMENTO", Lancamento.class).getResultList();
//	
//	
}
	
	

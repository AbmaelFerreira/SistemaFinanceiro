package com.fisioana.financeiro.util;

//@WebFilter(servletNames = { "Faces Servlet" })
public class HibernateFilter/* implements Filter*/ {
/*
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemploPU");
		EntityManager em = emf.createEntityManager();

		try {
			em.getTransaction().begin();
			request.setAttribute("conexao", em);

			chain.doFilter(request, response);

			em.getTransaction().commit();

		} catch (Exception e) {
			//if (em.getTransaction() != null) {
				em.getTransaction().rollback();
			//}
		} finally {
			
		}
	}

	public void init(FilterConfig arg0) throws ServletException {

	}

	public void destroy() {
	}*/
}

package com.fisioana.financeiro.view;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.fisioana.financeiro.util.FacesUtil;

@ManagedBean
public class SegurancaBean {

	private String usuario;
	private String senha;

	public String Logar() {
		try {
			this.getRequest().login(this.usuario, this.senha);
			return "Home?faces-redirect=true";

		} catch (ServletException e) {
			FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_ERROR,
					FacesUtil.getMessagemI18n("username_password_does_not_match"));
			return null;
		}
	}

	public String Sair() throws ServletException {
		this.getRequest().logout();
		return "Login?faces-redirect=true";
	}

	private HttpServletRequest getRequest() {

		FacesContext contex = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) contex.getExternalContext().getRequest();
		return (HttpServletRequest) contex.getExternalContext().getRequest();
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}

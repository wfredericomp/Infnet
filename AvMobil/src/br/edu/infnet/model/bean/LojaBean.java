package br.edu.infnet.model.bean;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.edu.infnet.model.Loja;

@ManagedBean
@ViewScoped
@SessionScoped
public class LojaBean {
	private Loja loja = new Loja();

	public Loja getLoja() {
		return loja;
	}

	public void gravaLoja() {
		System.out.println(this.loja.getNome());
		loja.setNome(this.loja.getNome());

		System.out.println(this.loja.getEndereco());
		loja.setEndereco(this.loja.getEndereco());
		
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("loja.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

package br.edu.infnet.model.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.edu.infnet.model.Carro;

@ManagedBean
@ViewScoped
public class CarroBean {
	
	static ArrayList<Carro> listCarros = new ArrayList<Carro>();
	private Carro carro = new Carro();

	public Carro getCarro() {
		return carro;
	}

	public void addMessage(String msn) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
				msn, null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
	
	public List<String> tipoCarro(){
		ArrayList<String> listTiposCarros = new ArrayList<String>();
		
		return listTiposCarros;
	}

}

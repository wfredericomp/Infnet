package br.edu.infnet.model.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.edu.infnet.model.Carro;
import br.edu.infnet.model.Loja;
import br.edu.infnet.model.DAO.CarroDAO;
import br.edu.infnet.model.DAO.LojaDAO;
import br.edu.infnet.model.colecoes.TipoCarro;

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

	public List<String> getTipoCarros() {
		ArrayList<String> listTiposCarros = new ArrayList<String>();

		if (listTiposCarros.size() < 8) {
			for (TipoCarro tipo : TipoCarro.values()) {
				listTiposCarros.add(tipo.toString());
			}
		}

		return listTiposCarros;
	}

	public String gravaCarro() throws Exception {
		boolean db;
		System.out.println(this.carro.getChassi().toUpperCase());
		carro.setChassi(this.carro.getChassi().toUpperCase());

		System.out.println(this.carro.getMontadora().toUpperCase());
		carro.setMontadora(this.carro.getMontadora().toUpperCase());

		System.out.println(this.carro.getModelo().toUpperCase());
		carro.setModelo(this.carro.getModelo().toUpperCase());

		System.out.println(this.carro.getStrTipo().toUpperCase());
		carro.setStrTipo(this.carro.getStrTipo().toUpperCase());

		System.out.println(this.carro.getCor().toUpperCase());
		carro.setCor(this.carro.getCor().toUpperCase());

		System.out.println(this.carro.getMotor().toUpperCase());
		carro.setMotor(this.carro.getMotor().toUpperCase());

		System.out.println(this.carro.getCambio().toUpperCase());
		carro.setCambio(this.carro.getCambio().toUpperCase());

		System.out.println(this.carro.getPreco());
		carro.setPreco(this.carro.getPreco());

		CarroDAO dao = new CarroDAO();

		db = dao.salvar(carro);

		if (db == true) {
			addMessage("Carro " + this.carro.getModelo()
					+ " cadastrado com sucesso!");
		} else {
			addMessage("Erro: Carro " + this.carro.getModelo()
					+ " n�o foi cadastrado!");
		}

		this.carro = new Carro();

		return "carro.xhtml";
	}

	public List<Carro> getListarCarros() throws Exception {
		listCarros.clear();
		CarroDAO dao = new CarroDAO();
		listCarros = dao.listar();
		return listCarros;
	}

	public void deletarCarro(Carro carro) throws Exception {
		boolean db = false;
		CarroDAO dao = new CarroDAO();

		db = dao.deletar(carro);

		if (db == true && carro.getStrTipo() != null) {
			addMessage("Carro " + carro.getStrTipo() + " deletado com sucesso!");
		} else {
			addMessage("Erro: Carro " + this.carro.getStrTipo()
					+ " n�o foi deletado!");
		}
	}

}

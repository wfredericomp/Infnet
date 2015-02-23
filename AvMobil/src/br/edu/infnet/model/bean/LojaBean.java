package br.edu.infnet.model.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.edu.infnet.model.Loja;
import br.edu.infnet.model.DAO.LojaDAO;

@ManagedBean
@ViewScoped
public class LojaBean {
	
	static ArrayList<Loja> listLojas = new ArrayList<Loja>();
	private Loja loja = new Loja();

	public Loja getLoja() {
		return loja;
	}

	public void addMessage(String msn) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
				msn, null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public String gravaLoja() throws Exception {
		boolean db;
		System.out.println(this.loja.getNome().toUpperCase());
		loja.setNome(this.loja.getNome().toUpperCase());

		System.out.println(this.loja.getEndereco().toUpperCase());
		loja.setEndereco(this.loja.getEndereco().toUpperCase());
		LojaDAO dao = new LojaDAO();

		db = dao.salvar(loja);

		if (db == true) {
			addMessage("Loja " + this.loja.getNome()
					+ " cadastrada com sucesso!");
		} else {
			addMessage("Erro: Loja " + this.loja.getNome()
					+ " não foi cadastrado!");
		}

		this.loja = new Loja();

		return "loja.xhtml";
	}

	public List<Loja> getlistarLojas() throws Exception {
		listLojas.clear();
		LojaDAO dao = new LojaDAO();
		listLojas = dao.listar();
		return listLojas;
	}

	public void deletarLoja(Loja loja) throws Exception {
		boolean db = false;
		LojaDAO dao = new LojaDAO();

		db = dao.deletar(loja);
		
		if (db == true && loja.getNome() != null) {
			addMessage("Loja " + loja.getNome() + " deletada com sucesso!");
		} else {
			addMessage("Erro: Loja " + this.loja.getNome()
					+ " não foi deletada!");
		}
	}
	
	

}

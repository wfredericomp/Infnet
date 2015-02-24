package br.edu.infnet.model.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.edu.infnet.model.Motocicleta;
import br.edu.infnet.model.DAO.MotocicletaDAO;
import br.edu.infnet.model.colecoes.TipoMotocicleta;

@ManagedBean
@ViewScoped
public class MotocicletaBean {
	static ArrayList<Motocicleta> listmotos = new ArrayList<Motocicleta>();
	private Motocicleta moto = new Motocicleta();

	public Motocicleta getMoto() {
		return moto;
	}

	Motocicleta pojo = new Motocicleta();

	public void addMessage(String msn) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
				msn, null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public List<String> getTipoMotos() {
		ArrayList<String> listTiposMotos = new ArrayList<String>();

		if (listTiposMotos.size() < 22) {
			for (TipoMotocicleta tipo : TipoMotocicleta.values()) {
				listTiposMotos.add(tipo.toString());
			}
		}

		return listTiposMotos;
	}

	public String gravaMotos() throws Exception {
		boolean db;
		System.out.println(this.moto.getChassi().toUpperCase());
		moto.setChassi(this.moto.getChassi().toUpperCase());

		System.out.println(this.moto.getMontadora().toUpperCase());
		moto.setMontadora(this.moto.getMontadora().toUpperCase());

		System.out.println(this.moto.getModelo().toUpperCase());
		moto.setModelo(this.moto.getModelo().toUpperCase());

		System.out.println(this.moto.getStrTipo().toUpperCase());
		moto.setStrTipo(this.moto.getStrTipo().toUpperCase());

		System.out.println(this.moto.getCor().toUpperCase());
		moto.setCor(this.moto.getCor().toUpperCase());

		System.out.println(this.moto.getCilindrada());
		moto.setCilindrada(this.moto.getCilindrada());

		System.out.println(this.moto.getCapacidadeTanque());
		moto.setCapacidadeTanque(this.moto.getCapacidadeTanque());

		System.out.println(this.moto.getPreco());
		moto.setPreco(this.moto.getPreco());

		MotocicletaDAO dao = new MotocicletaDAO();

		db = dao.salvar(moto);
		String motodr = this.moto.getModelo();
		if (db == true) {
			this.moto = new Motocicleta();
			addMessage("Moto " + motodr + " cadastrado com sucesso!");
		} else {
			addMessage("Erro: Moto "
					+ this.moto.getModelo()
					+ " não foi cadastrado devido ao chassi já existir no banco!");
		}

		return "moto.xhtml";
	}

	public List<Motocicleta> getListarEstoquedeMotos() throws Exception {
		listmotos.clear();
		MotocicletaDAO dao = new MotocicletaDAO();

		if (pojo.getChassi() == null) {
			listmotos = dao.listar();
		}
		if (pojo.getChassi() != null) {
			listmotos.clear();
			listmotos.add(pojo);
		}

		this.moto = new Motocicleta();
		return listmotos;
	}

	public List<Motocicleta> listarPorChassi() throws Exception {
		listmotos.clear();
		MotocicletaDAO dao = new MotocicletaDAO();
		if (moto.getChassi() == null) {
			listmotos = dao.listar();
		}
		if (moto.getChassi() != null) {
			String auxChassi = moto.getChassi();
			if (!moto.getChassi().isEmpty()) {
				pojo = dao.listarPorChassi(moto.getChassi());
				if (pojo.getChassi() == null) {
					System.out.println("Aqui");
					this.moto = new Motocicleta();
					addMessage("Chassi digitado " + auxChassi
							+ " não foi encontrado!");
					moto.setChassi("");
				}
			}
			if (moto.getChassi().isEmpty()) {
				listmotos = dao.listar();
			}
			if (pojo.getChassi() == null) {
			}
			if (pojo.getChassi() != null) {
				listmotos.add(pojo);
			}
		}
		this.moto = new Motocicleta();
		return listmotos;
	}

	public void deletarCarro(Motocicleta moto) throws Exception {
		boolean db = false;
		MotocicletaDAO dao = new MotocicletaDAO();

		db = dao.deletar(moto);

		if (db == true && moto.getStrTipo() != null) {
			this.moto = new Motocicleta();
			addMessage("Moto " + moto.getStrTipo() + " deletado com sucesso!");
			this.moto = new Motocicleta();
			listmotos.clear();
			listmotos = dao.listar();
		} else {
			addMessage("Erro: Moto " + this.moto.getStrTipo()
					+ " não foi deletado!");
		}
	};
}

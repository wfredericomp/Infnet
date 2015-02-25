package br.edu.infnet.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import br.edu.infnet.database.Conexao;
import br.edu.infnet.model.Motocicleta;

public class MotocicletaDAO {

	public boolean salvar(Motocicleta moto) throws Exception {

		boolean db = false;
		try {
			Connection con = Conexao.getConexao();
			String sql = "insert into moto(chassi, montadora, modelo, tipo, cor, cilindrada, capacidade_tanque, preco) values(?, ?, ?, ?, ?, ?, ?, ?)";

			PreparedStatement comando = con.prepareStatement(sql);

			comando.setString(1, moto.getChassi());
			comando.setString(2, moto.getMontadora());
			comando.setString(3, moto.getModelo());
			comando.setString(4, moto.getStrTipo());
			comando.setString(5, moto.getCor());
			comando.setInt(6, moto.getCilindrada());
			comando.setInt(7, moto.getCapacidadeTanque());
			comando.setFloat(8, moto.getPreco());

			comando.executeUpdate();
			db = true;

		} catch (Exception e) {
			db = false;
			System.out.println(e.getMessage());
		}
		return db;
	}

	public ArrayList<Motocicleta> listar() throws Exception {
		ArrayList<Motocicleta> listMoto = new ArrayList<Motocicleta>();
		try {
			String sql = "select *from moto";
			Statement st = Conexao.getConexao().createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				Motocicleta moto = new Motocicleta();
				moto.setId(rs.getInt("id"));
				moto.setChassi(rs.getString("chassi"));
				moto.setMontadora(rs.getString("montadora"));
				moto.setModelo(rs.getString("modelo"));
				moto.setStrTipo(rs.getString("tipo"));
				moto.setCor(rs.getString("cor"));
				moto.setCilindrada(rs.getInt("cilindrada"));
				moto.setCapacidadeTanque(rs.getInt("capacidade_tanque"));
				moto.setPreco(rs.getFloat("preco"));

				listMoto.add(moto);
			}
			Conexao.closeConexao();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return listMoto;
	}

	public Motocicleta listarPorChassi(String chassi) throws Exception {
		Motocicleta moto = new Motocicleta();
		try {
			Statement st = Conexao.getConexao().createStatement();
			ResultSet rs = st
					.executeQuery("SELECT * FROM moto WHERE chassi = '"
							+ chassi + "'");

			while (rs.next()) {
				moto.setId(rs.getInt("id"));
				moto.setChassi(rs.getString("chassi"));
				moto.setMontadora(rs.getString("montadora"));
				moto.setModelo(rs.getString("modelo"));
				moto.setStrTipo(rs.getString("tipo"));
				moto.setCor(rs.getString("cor"));
				moto.setCilindrada(rs.getInt("cilindrada"));
				moto.setCapacidadeTanque(rs.getInt("capacidade_tanque"));
				moto.setPreco(rs.getFloat("preco"));
			}
			System.out.println("passou banco");
			Conexao.closeConexao();

		} catch (Exception e) {
			System.out.println("Erro: Não foi encontrado o carro!");
		}
		return moto;
	}

	public boolean deletar(Motocicleta moto) throws Exception {
		boolean db = false;
		try {
			Connection con = Conexao.getConexao();
			String sql = "delete from moto where id = ?";

			PreparedStatement comando = con.prepareStatement(sql);

			comando.setInt(1, moto.getId());

			comando.executeUpdate();
			db = true;

		} catch (Exception e) {
			db = false;
			System.out.println(e.getMessage());
		}
		return db;
	}
}

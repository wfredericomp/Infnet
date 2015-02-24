package br.edu.infnet.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import br.edu.infnet.database.Conexao;
import br.edu.infnet.model.Carro;

public class CarroDAO {
	public boolean salvar(Carro carro) throws Exception {

		boolean db = false;
		try {
			Connection con = Conexao.getConexao();
			String sql = "insert into carro(chassi, montadora, modelo, tipo, cor, motor, cambio, preco) values(?, ?, ?, ?, ?, ?, ?, ?)";

			PreparedStatement comando = con.prepareStatement(sql);

			comando.setString(1, carro.getChassi());
			comando.setString(2, carro.getMontadora());
			comando.setString(3, carro.getModelo());
			comando.setString(4, carro.getStrTipo());
			comando.setString(5, carro.getCor());
			comando.setString(6, carro.getMotor());
			comando.setString(7, carro.getCambio());
			comando.setFloat(8, carro.getPreco());

			comando.executeUpdate();
			db = true;

		} catch (Exception e) {
			db = false;
			System.out.println(e.getMessage());
		}
		return db;
	}

	public ArrayList<Carro> listar() throws Exception {
		ArrayList<Carro> listCarro = new ArrayList<Carro>();
		try {
			String sql = "select *from carro";
			Statement st = Conexao.getConexao().createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				Carro carro = new Carro();
				carro.setId(rs.getInt("id"));
				carro.setChassi(rs.getString("chassi"));
				carro.setMontadora(rs.getString("montadora"));
				carro.setModelo(rs.getString("modelo"));
				carro.setStrTipo(rs.getString("tipo"));
				carro.setCor(rs.getString("cor"));
				carro.setMotor(rs.getString("motor"));
				carro.setCambio(rs.getString("cambio"));
				carro.setPreco(rs.getFloat("preco"));

				listCarro.add(carro);
			}
			Conexao.closeConexao();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return listCarro;
	}

	public Carro listarPorChassi(String chassi) throws Exception {
		Carro carro = new Carro();
		try {
			Statement st = Conexao.getConexao().createStatement();
			ResultSet rs = st
					.executeQuery("SELECT * FROM carro WHERE chassi = '"
							+ chassi + "'");

			while (rs.next()) {
				carro.setId(rs.getInt("id"));
				carro.setChassi(rs.getString("chassi"));
				carro.setMontadora(rs.getString("montadora"));
				carro.setModelo(rs.getString("modelo"));
				carro.setStrTipo(rs.getString("tipo"));
				carro.setCor(rs.getString("cor"));
				carro.setMotor(rs.getString("motor"));
				carro.setCambio(rs.getString("cambio"));
				carro.setPreco(rs.getFloat("preco"));
			}
			System.out.println("passou banco");
			Conexao.closeConexao();

		} catch (Exception e) {
			System.out.println("Erro: Não foi encontrado o carro!");
		}
		return carro;
	}

	public boolean deletar(Carro carro) throws Exception {
		boolean db = false;
		try {
			Connection con = Conexao.getConexao();
			String sql = "delete from carro where id = ?";

			PreparedStatement comando = con.prepareStatement(sql);

			comando.setInt(1, carro.getId());

			comando.executeUpdate();
			db = true;

		} catch (Exception e) {
			db = false;
			System.out.println(e.getMessage());
		}
		return db;
	}
}

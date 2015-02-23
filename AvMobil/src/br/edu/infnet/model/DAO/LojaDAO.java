package br.edu.infnet.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import br.edu.infnet.database.Conexao;
import br.edu.infnet.model.Loja;

public class LojaDAO {

	public boolean salvar(Loja loja) throws Exception {

		boolean db = false;
		try {
			Connection con = Conexao.getConexao();
			String sql = "insert into loja(nome, endereco) values(?, ?)";

			PreparedStatement comando = con.prepareStatement(sql);

			comando.setString(1, loja.getNome());
			comando.setString(2, loja.getEndereco());

			comando.executeUpdate();
			db = true;

		} catch (Exception e) {
			db = false;
			System.out.println(e.getMessage());
		}
		return db;
	}

	public ArrayList<Loja> listar() throws Exception {
		ArrayList<Loja> listLoja = new ArrayList<Loja>();
		try {
			String sql = "select *from loja";
			Statement st = Conexao.getConexao().createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				Loja loja = new Loja();
				loja.setId(rs.getInt("id"));
				loja.setNome(rs.getString("nome"));
				loja.setEndereco(rs.getString("endereco"));

				listLoja.add(loja);
			}
			Conexao.closeConexao();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return listLoja;
	}

	public boolean deletar(Loja loja) throws Exception {
		boolean db = false;
		try {
			Connection con = Conexao.getConexao();
			String sql = "delete from loja where id = ?";

			PreparedStatement comando = con.prepareStatement(sql);

			comando.setInt(1, loja.getId());

			comando.executeUpdate();
			db = true;

		} catch (Exception e) {
			db = false;
			System.out.println(e.getMessage());
		}
		return db;
	}

}

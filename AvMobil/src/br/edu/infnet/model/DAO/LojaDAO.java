package br.edu.infnet.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

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

}

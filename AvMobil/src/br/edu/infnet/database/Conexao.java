package br.edu.infnet.database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	public Conexao() {
		
	}
	
	public static java.sql.Connection getConexao() {
		
		Connection connection = null;
		
		try {
			
			//Cria conexão com o banco de dados.
			
			String driver = "com.mysql.jdbc.Driver";
			Class.forName(driver);
			
			connection = DriverManager.getConnection(Database.url, Database.username, Database.password);			
			return connection;
					
		} catch (ClassNotFoundException e) { //Erro driver conexão.
			
			System.out.println("O driver de conexão não pode ser localizado.");
			return null;
			
		} catch (SQLException e) { //Erro de conexão com o banco.
			
			System.out.println("Não foi possível conectar ao banco de dados.");
			return null;
		}
		
	}
	
	
	//Método para fechar conexão com o banco.
	public static boolean closeConexao() {
		
		try {
			Conexao.getConexao().close();
			return true;
			
		} catch (SQLException e) {
            return false;
		}
	}
	
	//Método para reiniciar conexão com o banco.
	public static java.sql.Connection restartConexao() {
		closeConexao();
		return Conexao.getConexao();
	}
	
	


}

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
			
			//Cria conex�o com o banco de dados.
			
			String driver = "com.mysql.jdbc.Driver";
			Class.forName(driver);
			
			connection = DriverManager.getConnection(Database.url, Database.username, Database.password);			
			return connection;
					
		} catch (ClassNotFoundException e) { //Erro driver conex�o.
			
			System.out.println("O driver de conex�o n�o pode ser localizado.");
			return null;
			
		} catch (SQLException e) { //Erro de conex�o com o banco.
			
			System.out.println("N�o foi poss�vel conectar ao banco de dados.");
			return null;
		}
		
	}
	
	
	//M�todo para fechar conex�o com o banco.
	public static boolean closeConexao() {
		
		try {
			Conexao.getConexao().close();
			return true;
			
		} catch (SQLException e) {
            return false;
		}
	}
	
	//M�todo para reiniciar conex�o com o banco.
	public static java.sql.Connection restartConexao() {
		closeConexao();
		return Conexao.getConexao();
	}
	
	


}

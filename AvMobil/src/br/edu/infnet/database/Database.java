package br.edu.infnet.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Database {

	try {
	
		//vasco
		
	String driver = "com.mysql.jdbc.Driver";
	Class.forName(driver);
	
	String server = "localhost";
	String database = "avmobildb";
	String user = "root";		
	String pwd = "admin";
	
	String url = "jdbc:mysql://" + server + "/" + database;

	} catch (SQLException e) { 
		
		//Não conseguindo se conectar ao banco 
		
		System.out.println("Nao foi possivel conectar ao Banco de Dados."); return null; 

	}
}

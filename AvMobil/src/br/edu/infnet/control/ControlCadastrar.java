package br.edu.infnet.control;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import br.edu.infnet.database.Conexao;

public class ControlCadastrar {
	
	public static void cadastroVeiculo() {
	
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Informe os dados do veículo:");
		
		System.out.println("Chassi:");
		String chassi = sc.toString();
		
/*		System.out.println("Montadora:");
		String montadora = sc.toString();
		
		System.out.println("Modelo:");
		String modelo = sc.toString(); 
		
		System.out.println("Tipo:");
		String tipo = sc.toString();
		
		System.out.println("Cor:");
		String cor = sc.toString();
		
		System.out.println("Motor:");
		String motor = sc.toString();
		
		System.out.println("Câmbio:");
		String cambio = sc.toString();
		
		System.out.println("Preço:");
		Float preco = sc.nextFloat();
*/		
		sc.close();
		
		try {
			
	    	String sql = "INSERT INTO carro (chassi)" /*, montadora, modelo, tipo, cor, motor, cambio, preco)" */ + 
	    				 "VALUES (?)"; //, ?, ?, ?, ?, ?, ?, ? )";
	    	
	    	PreparedStatement preparedStatement = Conexao.getConexao().prepareStatement(sql);
			
	    	preparedStatement.setString(1, chassi);
/*	    	preparedStatement.setString(2, montadora);
	    	preparedStatement.setString(3, modelo);
	    	preparedStatement.setString(4, tipo);
	    	preparedStatement.setString(5, cor);
	    	preparedStatement.setString(6, motor);
	    	preparedStatement.setString(7, cambio);
	    	preparedStatement.setFloat(8, preco);
*/	    	
	    	preparedStatement.executeUpdate();    	
	    	
		} catch (SQLException e) {
			System.out.println("Erro, operação abortada");
		}
		
	}
}




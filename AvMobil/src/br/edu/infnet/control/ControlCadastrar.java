package br.edu.infnet.control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import br.edu.infnet.database.Conexao;

public class ControlCadastrar {
	
	private static Scanner sc;

	public static void cadastroVeiculo() {
	
		sc = new Scanner(System.in);
		String chassi;
		String montadora;
		String modelo;
		String tipo;
		String cor;
		String motor;
		String cambio;
		float preco;
		
		System.out.println("Informe os dados do veículo:");
		
		System.out.println("Chassi:");
		chassi = sc.next();
		
		System.out.println("Montadora:");
		montadora = sc.nextLine();
		
		System.out.println("Modelo:");
		modelo = sc.nextLine();
		
		System.out.println("Tipo:");
		tipo = sc.nextLine();
		
		System.out.println("Cor:");
		cor = sc.nextLine();
		
		System.out.println("Motor:");
		motor = sc.nextLine();
		
		System.out.println("Câmbio:");
		cambio = sc.nextLine();
		
		System.out.println("Preço:");
		preco = sc.nextFloat();
		
		try {
			
			Connection con = Conexao.getConexao();
			
	    	String sql = "INSERT INTO carro (chassi, montadora, modelo, tipo, cor, motor, cambio, preco )" +
	    	"VALUES (?,?,?,?,?,?,?,?)"; 
	    	    	
	    	PreparedStatement comando = con.prepareStatement(sql);
			
	    	comando.setString(1, chassi.toUpperCase());
	    	comando.setString(2, montadora.toUpperCase());
	    	comando.setString(3, modelo.toUpperCase());
	    	comando.setString(4, tipo.toUpperCase());
	    	comando.setString(5, cor.toUpperCase());
	    	comando.setString(6, motor.toUpperCase());
	    	comando.setString(7, cambio.toUpperCase());
	    	comando.setFloat(8, preco);
	    	comando.executeUpdate();    	
	    	
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
}




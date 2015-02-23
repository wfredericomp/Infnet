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
		System.out.println("Informe os dados do veículo:");
		
		System.out.println("Chassi:");
		chassi = sc.next();
		sc.close();
					
		try {
			
			Connection con = Conexao.getConexao();
			
	    	String sql = "INSERT INTO carro (chassi) VALUES (?)"; 
	    	    	
	    	PreparedStatement comando = con.prepareStatement(sql);
			
	    	comando.setString(1, chassi);
	    	comando.executeUpdate();    	
	    	
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
}




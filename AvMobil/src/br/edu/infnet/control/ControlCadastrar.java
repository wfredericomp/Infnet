package br.edu.infnet.control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import br.edu.infnet.database.Conexao;

public class ControlCadastrar {
	
	public static void cadastroVeiculo() {
	
		Scanner sc = new Scanner(System.in);
		int chassi = 0;
		System.out.println("Informe os dados do veículo:");
		
		System.out.println("Chassi:");
		chassi = sc.nextInt();
		sc.close();
					
		try {
			
			Connection con = Conexao.getConexao();
			
	    	String sql = "INSERT INTO carro (chassi) VALUES (?)"; 
	    	    	
	    	PreparedStatement comando = con.prepareStatement(sql);
			
	    	comando.setInt(1, chassi);
	    	comando.executeUpdate();    	
	    	
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
}




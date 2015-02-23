package br.edu.infnet.control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import br.edu.infnet.database.Conexao;

public class ControlCadastrar {
	
	public static Scanner sc = new Scanner(System.in);
	
	public static void cadCarro() {
	
		System.out.println("Informe os dados do veículo: \n");

		System.out.println("Chassi:");
		String chassi = sc.nextLine().toUpperCase();
		
		System.out.println("Montadora:");
		String montadora = sc.nextLine().toUpperCase();
		
		System.out.println("Modelo:");
		String modelo = sc.nextLine().toUpperCase();
		
		System.out.println("Tipo:");
		String tipo = sc.nextLine().toUpperCase();
		
		System.out.println("Cor:");
		String cor = sc.nextLine().toUpperCase();
		
		System.out.println("Motor:");
		String motor = sc.nextLine().toUpperCase();
		
		System.out.println("Câmbio:");
		String cambio = sc.nextLine().toUpperCase();
		
		System.out.println("Valor:");
		float preco = sc.nextFloat();
			
		try {
			
			Connection con = Conexao.getConexao();
			
	    	String sql = "INSERT INTO carro (chassi, montadora, modelo, tipo, cor, motor, cambio, preco )" +
	    	"VALUES (?,?,?,?,?,?,?,?)"; 
	    	    	
	    	PreparedStatement comando = con.prepareStatement(sql);
			
	    	comando.setString(1, chassi);
	    	comando.setString(2, montadora);
	    	comando.setString(3, modelo);
	    	comando.setString(4, tipo);
	    	comando.setString(5, cor);
	    	comando.setString(6, motor);
	    	comando.setString(7, cambio);
	    	comando.setFloat(8, preco);
	    	comando.executeUpdate();
	    	
	    	System.out.println("Veículo Registrado com sucesso!");
	    	
		} catch (SQLException e) {
			System.out.println("Processo abortado: " + e);
		}
		
		System.out.println("Deseja incluir outro carro?");
		System.out.println("1 - SIM");
		System.out.println("2 - NÃO");
		
		int opcao = sc.nextInt();
		
		if (opcao == 1) {
			cadCarro();
		}
		
		if (opcao == 2) {
			ControlPrincipal.menuPrincipal();
		}
		
		if (opcao != 1 && opcao != 2) {
			System.out.println("Opção inválida!");
			return;			
		}
		
	}
}





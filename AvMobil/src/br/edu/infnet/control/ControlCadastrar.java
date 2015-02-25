package br.edu.infnet.control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import br.edu.infnet.database.Conexao;
import br.edu.infnet.model.colecoes.*;

public class ControlCadastrar {
	
	public static Scanner sc = new Scanner(System.in);
	
	public static void cadastrarCarro() {
	
		System.out.println("Informe os dados do ve�culo: \n");

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Chassi:");
		String chassi = sc.nextLine().toUpperCase();
		
		System.out.println("Montadora:");
		String montadora = sc.nextLine().toUpperCase();
		
		System.out.println("Modelo:");
		String modelo = sc.nextLine().toUpperCase();
		
		System.out.println("Tipo:");
		
		int i = 1;
		for(TipoCarro car : TipoCarro.values()) {
			System.out.println(i + " - " + car);
			i++;
		}
		
		ArrayList<String> tCarro = TipoCarro.getNomes();
		String tipo = tCarro.get(sc.nextInt()-1);
		
		sc = new Scanner(System.in);
		
		System.out.println("Cor:");
		String cor = sc.nextLine().toUpperCase();
		
		System.out.println("Motor:");
		String motor = sc.nextLine().toUpperCase();
		
		System.out.println("C�mbio:");
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
	    	
	    	System.out.println("Ve�culo Registrado com sucesso!");
	    	
		} catch (SQLException e) {
			System.out.println("Processo abortado: " + e);
		}
		
		System.out.println("Deseja incluir outro carro?");
		System.out.println("1 - SIM");
		System.out.println("2 - N�O");
		
		int opcao = sc.nextInt();
		
		if (opcao == 1) {
			cadastrarCarro();
		}
		
			if (opcao == 2) {
				ControlPrincipal.menuPrincipal();
			}
		
				if (opcao != 1 && opcao != 2) {
					System.out.println("Op��o inv�lida!");
					return;			
				}
	}

	public static void cadastrarMoto() {
		
		System.out.println("Informe os dados do ve�culo: \n");

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
		
		System.out.println("Cilindrada:");
		int cilindrada = sc.nextInt();
		
		System.out.println("C�mbio:");
		int capacidadeTanque = sc.nextInt();
		
		System.out.println("Valor:");
		float preco = sc.nextFloat();
			
		try {
			
			Connection con = Conexao.getConexao();
			
	    	String sql = "INSERT INTO moto (chassi, montadora, modelo, tipo, cor, cilindrada, capacidade_tanque, preco )" +
	    	"VALUES (?,?,?,?,?,?,?,?)"; 
	    	    	
	    	PreparedStatement comando = con.prepareStatement(sql);
			
	    	comando.setString(1, chassi);
	    	comando.setString(2, montadora);
	    	comando.setString(3, modelo);
	    	comando.setString(4, tipo);
	    	comando.setString(5, cor);
	    	comando.setInt(6, cilindrada);
	    	comando.setInt(7, capacidadeTanque);
	    	comando.setFloat(8, preco);
	    	comando.executeUpdate();
	    	
	    	System.out.println("Ve�culo Registrado com sucesso!");
	    	
		} catch (SQLException e) {
			System.out.println("Processo abortado: " + e);
		}
		
		System.out.println("Deseja incluir outro ve�culo?");
		System.out.println("1 - SIM");
		System.out.println("2 - N�O");
		
		int opcao = sc.nextInt();
		
		if (opcao == 1) {
			cadastrarMoto();
		}
		
			if (opcao == 2) {
				ControlPrincipal.menuPrincipal();
			}
		
				if (opcao != 1 && opcao != 2) {
					System.out.println("Op��o inv�lida!");
					return;			
				}
	}

}





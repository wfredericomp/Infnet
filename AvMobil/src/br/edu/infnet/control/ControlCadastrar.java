package br.edu.infnet.control;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import br.edu.infnet.database.Conexao;
import br.edu.infnet.model.colecoes.TipoCarro;

public class ControlCadastrar {
	
	public void cadastroVeiculo() {
	
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Informe os dados do veículo:");
		
		System.out.println("Chassi:");
		String chassi = sc.next();
		
		System.out.println("Montadora:");
		String montadora = sc.next();
		
		System.out.println("Modelo:");
		String modelo = sc.next(); 
		
		System.out.println("Tipo:");
		String tipo = sc.next();
		
		System.out.println("Cor:");
		String cor = sc.next() ;
		
		System.out.println("Motor:");
		String motor = sc.next();
		
		System.out.println("Câmbio:");
		String cambio = sc.next();
		
		System.out.println("Preço:");
		Float preco = sc.nextFloat();
		
		try {
			
			Statement st = Conexao.getConexao().createStatement();
	    	//st.executeQuery("INSERT INTO carro () VALUES (?, ?, ? );
			
		} catch (SQLException e) {
			System.out.println("Erro, operação abortada");
		}
		
	}
}




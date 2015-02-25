package br.edu.infnet.control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import br.edu.infnet.database.Conexao;
import br.edu.infnet.model.*;
import br.edu.infnet.model.colecoes.*;

public class ControlCadastrar {
	
	public static Scanner sc = new Scanner(System.in);
	
	public static void cadastrarCarro() {
		
		ArrayList<Carro> carroLista = new ArrayList<Carro>();
		
		//Recebe os valores do usuário e atribui ao objeto;
		
		System.out.println("Informe os dados do veículo: \n");
		Scanner sc = new Scanner(System.in);
		
		int opcao;
		
		//Solicita todas as inclusões dos veículos;
		do {
			Carro carro = new Carro();
			sc = new Scanner(System.in);
		
			System.out.println("Chassi:");
			carro.setChassi(sc.nextLine().toUpperCase()); 
		
			System.out.println("Montadora:");
			carro.setMontadora(sc.nextLine().toUpperCase());
		
			System.out.println("Modelo:");
			carro.setModelo(sc.nextLine().toUpperCase());
		
			System.out.println("Tipo:");
		
				int i = 1;
					for(TipoCarro car : TipoCarro.values()) {
						System.out.println(i + " - " + car);
						i++;
					}
					
			ArrayList<String> tCarro = TipoCarro.getNomes();
			String tipo = tCarro.get(sc.nextInt()-1);
			carro.setTipo(TipoCarro.valueOf(tipo));
		
				sc = new Scanner(System.in);
		
			System.out.println("Cor:");
			carro.setCor(sc.nextLine().toUpperCase());
		
			System.out.println("Motor:");
			carro.setMotor(sc.nextLine().toUpperCase());
		
			System.out.println("Câmbio:");
			carro.setCambio(sc.nextLine().toUpperCase());
		
			System.out.println("Valor:");
			carro.setPreco(sc.nextFloat());
		
			carroLista.add(carro);
			
			System.out.println("Deseja incluir outro carro?");
			System.out.println("1 - SIM");
			System.out.println("2 - NÃO");
			opcao = sc.nextInt();
			
		} while (opcao == 1);
		
		
		//Abre a conexão com o banco de dados, executa a query e verifica as exceções;
		try {
			
			Connection con = Conexao.getConexao();
			
	    	String sql = "INSERT INTO carro (chassi, montadora, modelo, tipo, cor, motor, cambio, preco )" +
	    	"VALUES (?,?,?,?,?,?,?,?)"; 
	    	    	
	    	PreparedStatement comando = con.prepareStatement(sql);
	    	
	    	for(int j=0; j<carroLista.size();j++) {
	    		comando.setString(1, carroLista.get(j).getChassi());
	    		comando.setString(2, carroLista.get(j).getMontadora());
	    		comando.setString(3, carroLista.get(j).getModelo());
	    		
	    		ArrayList<String> tCarro = TipoCarro.getNomes();
	    		String tipo = tCarro.get(j);
	    		
	    		comando.setString(4, tipo);
	    		comando.setString(5, carroLista.get(j).getCor());
	    		comando.setString(6, carroLista.get(j).getMotor());
	    		comando.setString(7, carroLista.get(j).getCambio());
	    		comando.setFloat(8, carroLista.get(j).getPreco());
	    		comando.executeUpdate();
	    	}
	    	
	    	System.out.println("Veículo(s) Registrado(s) com sucesso!");
	    	
		} catch (SQLException e) {
			System.out.println("Processo abortado: " + e);
		}
	}
	
public static void cadastrarMoto() {
		
		ArrayList<Motocicleta> motoLista = new ArrayList<Motocicleta>();
		
		//Recebe os valores do usuário e atribui ao objeto;
		System.out.println("Informe os dados do veículo: \n");
		Scanner sc = new Scanner(System.in);
		
		int opcao;
		
		//Solicita todas as inclusões de veículos;
		do {
			Motocicleta moto = new Motocicleta();
			sc = new Scanner(System.in);
		
			System.out.println("Chassi:");
			moto.setChassi(sc.nextLine().toUpperCase()); 
		
			System.out.println("Montadora:");
			moto.setMontadora(sc.nextLine().toUpperCase());
		
			System.out.println("Modelo:");
			moto.setModelo(sc.nextLine().toUpperCase());
		
			System.out.println("Tipo:");
		
				int i = 1;
					for(TipoMotocicleta car : TipoMotocicleta.values()) {
						System.out.println(i + " - " + car);
						i++;
					}
					
			ArrayList<String> tmoto = TipoMotocicleta.getNomes();
			String tipo = tmoto.get(sc.nextInt()-1);
			moto.setTipo(TipoMotocicleta.valueOf(tipo));
		
				sc = new Scanner(System.in);
		
			System.out.println("Cor:");
			moto.setCor(sc.nextLine().toUpperCase());
		
			System.out.println("Motor:");
			moto.setCilindrada(sc.nextInt());
		
			System.out.println("Câmbio:");
			moto.setCapacidadeTanque(sc.nextInt());
		
			System.out.println("Valor:");
			moto.setPreco(sc.nextFloat());
		
			motoLista.add(moto);
			
			System.out.println("Deseja incluir outro moto?");
			System.out.println("1 - SIM");
			System.out.println("2 - NÃO");
			opcao = sc.nextInt();
			
		} while (opcao == 1);
		
		
		//Abre a conexão com o banco de dados, executa a query e verifica as exceções;
		try {
			
			Connection con = Conexao.getConexao();
			
	    	String sql = "INSERT INTO moto (chassi, montadora, modelo, tipo, cor, motor, cambio, preco )" +
	    	"VALUES (?,?,?,?,?,?,?,?)"; 
	    	    	
	    	PreparedStatement comando = con.prepareStatement(sql);
	    	
	    	for(int j=0; j<motoLista.size();j++) {
	    		comando.setString(1, motoLista.get(j).getChassi());
	    		comando.setString(2, motoLista.get(j).getMontadora());
	    		comando.setString(3, motoLista.get(j).getModelo());
	    		
	    		ArrayList<String> tmoto = TipoMotocicleta.getNomes();
	    		String tipo = tmoto.get(j);
	    		
	    		comando.setString(4, tipo);
	    		comando.setString(5, motoLista.get(j).getCor());
	    		comando.setInt(6, motoLista.get(j).getCilindrada());
	    		comando.setInt(7, motoLista.get(j).getCapacidadeTanque());
	    		comando.setFloat(8, motoLista.get(j).getPreco());
	    		comando.executeUpdate();
	    	}
	    	
	    	System.out.println("Veículo(s) Registrado(s) com sucesso!");
	    	
		} catch (SQLException e) {
			System.out.println("Processo abortado: " + e);
		}
	}

	
}





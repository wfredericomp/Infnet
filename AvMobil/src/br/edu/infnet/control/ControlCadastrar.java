package br.edu.infnet.control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.edu.infnet.console.Teclado;
import br.edu.infnet.database.Conexao;

public class ControlCadastrar {
	
	public static void cadastroVeiculo() {
		
		String texto = null;
		
		System.out.println("Informe os dados do veículo:");
		
		System.out.println("Chassi:");
		String chassi = Teclado.lerTexto(texto);
		
		System.out.println("Montadora:");
		String montadora = Teclado.lerTexto(texto);
		
		System.out.println("Modelo:");
		String modelo = Teclado.lerTexto(texto);
		
		System.out.println("Tipo:");
		String tipo = Teclado.lerTexto(texto);
		
		System.out.println("Cor:");
		String cor = Teclado.lerTexto(texto);
		
		System.out.println("Motor:");
		String motor = Teclado.lerTexto(texto);
		
		System.out.println("Câmbio:");
		String cambio = Teclado.lerTexto(texto);
		
		System.out.println("Preço:");
		float preco = Teclado.lerFloat(texto);
		
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




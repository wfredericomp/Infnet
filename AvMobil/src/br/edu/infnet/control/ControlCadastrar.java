package br.edu.infnet.control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.edu.infnet.database.Conexao;

public class ControlCadastrar {
	
	public static void cadastroVeiculo() {
			
		System.out.println("Informe os dados do veículo: \n");

		String chassi = Teclado.lerTexto("Chassi:");
		String montadora = Teclado.lerTexto("Montadora: ");
		String modelo = Teclado.lerTexto("Modelo: ");
		String tipo = Teclado.lerTexto("Tipo: ");
		String cor = Teclado.lerTexto("Cor: ");
		String motor = Teclado.lerTexto("Motor: ");
		String cambio = Teclado.lerTexto("Câmbio: ");
		Float preco = Teclado.lerFloat("Preço: ");
	
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




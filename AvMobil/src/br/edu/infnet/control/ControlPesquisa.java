package br.edu.infnet.control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Scanner;

import br.edu.infnet.database.Conexao;
import br.edu.infnet.model.Carro;

public class ControlPesquisa {

	public static Scanner sc = new Scanner(System.in);
	static NumberFormat formatoMoeda = NumberFormat.getCurrencyInstance(); 
	
	public ControlPesquisa() {
		
	}
	
	public static void pesquisaChassi() {
		
		ArrayList<Carro> carroLista = new ArrayList<Carro>();

		System.out.println("Informe o Chassi: ");
		String chassi = sc.next().toString();

		try {     
			Connection con = Conexao.getConexao();
			String sql = "SELECT * FROM carro WHERE chassi = '" + chassi + "'"; 
	    	PreparedStatement comando = con.prepareStatement(sql);
			ResultSet srs = comando.executeQuery();
	    
		    	while (srs.next()) {
		    		
		    		Carro carro = new Carro();
		    		
		    		carro.setChassi(srs.getString("chassi"));
	                carro.setMontadora(srs.getString("montadora"));
	                carro.setModelo(srs.getString("modelo"));
	                //carro.setTipo(srs.getString("tipo"));
	                carro.setCor(srs.getString("cor"));
	                carro.setMotor(srs.getString("motor"));
	                carro.setCambio(srs.getString("cambio"));
	                carro.setPreco(srs.getFloat("preco"));
	                       
	                carroLista.add(carro);        
		    	}
		    		             
	                for(int i=0; i<carroLista.size();i++) {

	                	System.out.println((i+1) + " - Modelo: " + (carroLista.get(i)).getModelo());
	                	System.out.println("    Montadora: " + (carroLista.get(i)).getMontadora());
	                	System.out.println("    Tipo: " + (carroLista.get(i)).getTipo());
	                	System.out.println("    Cor: " + (carroLista.get(i)).getCor());
	                	System.out.println("    Câmbio: " + (carroLista.get(i)).getCambio());
	                	System.out.println("    Motor: " + (carroLista.get(i)).getMotor());
	                	System.out.println("    Preço: " + formatoMoeda.format((carroLista.get(i)).getPreco()));

	                	System.out.println("-------------------------------------------------");	
	                }
	                
		   			Conexao.closeConexao();
	       
			} catch (SQLException e) {
	            	return;
	       		}
	}	
}	
	


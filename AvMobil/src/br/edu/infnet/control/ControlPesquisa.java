package br.edu.infnet.control;

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
	
	public static void pesqChassi() {
		
		ArrayList<Carro> carroLista = new ArrayList<Carro>();
		
		System.out.println("Informe o Chassi: ");
		String chassi = sc.next().toString();
		
		try {     
	    	   Statement st = Conexao.getConexao().createStatement();
	    	   ResultSet srs = st.executeQuery("SELECT * FROM carro WHERE 'chassi' = " + chassi);
	    	   
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
		   			Conexao.closeConexao();
	       
			} catch (SQLException e) {
	            	return;
	       		}
		
        for(int i=0; i<carroLista.size();i++) {

        	System.out.println((i+1) + " - Modelo: " + (carroLista.get(i)).getModelo().toUpperCase());
        	System.out.println("    Montadora: " + (carroLista.get(i)).getMontadora().toUpperCase());
        	System.out.println("    Tipo: " + (carroLista.get(i)).getTipo());
        	System.out.println("    Cor: " + (carroLista.get(i)).getCor().toUpperCase());
        	System.out.println("    Câmbio: " + (carroLista.get(i)).getCambio().toUpperCase());
        	System.out.println("    Motor: " + (carroLista.get(i)).getMotor().toUpperCase());
        	System.out.println("    Preço: " + formatoMoeda.format((carroLista.get(i)).getPreco()));

        	System.out.println("-------------------------------------------------");	
		
        }
	}	
}	
	


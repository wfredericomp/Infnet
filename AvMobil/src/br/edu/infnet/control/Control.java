package br.edu.infnet.control;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.NumberFormat;
import java.util.ArrayList;

import br.edu.infnet.database.Conexao;
import br.edu.infnet.model.Carro;

public class Control {
		
	public static void listaCarros() {	
		System.out.println("Conectando com BD.\n");
		
		ArrayList<Carro> carrosLista = new ArrayList<Carro>();
		NumberFormat formatoMoeda = NumberFormat.getCurrencyInstance();   
	   
		           
		try {     
    	   Statement st = Conexao.getConexao().createStatement();
    	   ResultSet srs = st.executeQuery("SELECT * FROM carro");
    	   
    	while (srs.next()) {
                Carro carro = new Carro();
                carro.setChassi(srs.getString("chassi"));
                carro.setMontadora(srs.getString("montadora"));
                carro.setModelo(srs.getString("modelo"));
                carro.setTipo(srs.getString("tipo"));
                carro.setCor(srs.getString("cor"));
                carro.setMotor(srs.getString("motor"));
                carro.setCambio(srs.getString("cambio"));
                carro.setPreco(srs.getFloat("preco"));
                       
                carrosLista.add(carro);        
        }
	   			Conexao.closeConexao();
       
		} catch (SQLException e) {
            	return;
       		}
             
   		System.out.println("\n Estes são nossos carros disponíveis: \n");
   		   		
            for(int i=0; i<carrosLista.size();i++) {

            	System.out.println((i+1) + " - Modelo: " + (carrosLista.get(i)).getModelo().toUpperCase());
            	System.out.println("    Montadora: " + (carrosLista.get(i)).getMontadora().toUpperCase());
            	System.out.println("    Tipo: " + (carrosLista.get(i)).getTipo().toUpperCase());
            	System.out.println("    Cor: " + (carrosLista.get(i)).getCor().toUpperCase());
            	System.out.println("    Câmbio: " + (carrosLista.get(i)).getCambio().toUpperCase());
            	System.out.println("    Motor: " + (carrosLista.get(i)).getMotor().toUpperCase());
            	System.out.println("    Preço: " + formatoMoeda.format((carrosLista.get(i)).getPreco()));

            	System.out.println("-------------------------------------------------");
            	System.out.println("cls");
            }
        		
	}	
		
		
		
	}
	
	
	
	
	
	
	



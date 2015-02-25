package br.edu.infnet.control;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.NumberFormat;
import java.util.ArrayList;

import br.edu.infnet.database.Conexao;
import br.edu.infnet.model.*;

public class ControlListar {

	static NumberFormat formatoMoeda = NumberFormat.getCurrencyInstance(); 		
	
	public static void listaCarros() {	
		
		//Recupera os atributos do objeto do banco de dados;
		System.out.println("Conectando com BD.\n");
		ArrayList<Carro> carroLista = new ArrayList<Carro>();
		  
		           
		try {     
    	   Statement st = Conexao.getConexao().createStatement();
    	   ResultSet srs = st.executeQuery("SELECT * FROM carro");
    	   
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
             
		
		//Imprime lista de carros encontrados;
   		System.out.println("\n Estes são nossos carros disponíveis: \n");
   		   		
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
            
            
    public static void listaMotocicletas() {	
    	
    		//Recupera os veículos cadastrados no banco;
    		System.out.println("Conectando com BD.\n");
       		
       		ArrayList<Motocicleta> motoLista = new ArrayList<Motocicleta>();  
        		           
       		try {     
           	   Statement st = Conexao.getConexao().createStatement();
   
           	   ResultSet srs = st.executeQuery("SELECT * FROM carro");
            	   
           	while (srs.next()) {
                  Motocicleta moto = new Motocicleta();
                  moto.setChassi(srs.getString("chassi"));
                  moto.setMontadora(srs.getString("montadora"));
                  moto.setModelo(srs.getString("modelo"));
                  moto.setStrTipo( srs.getString("tipo"));
                  moto.setCor(srs.getString("cor"));
                  moto.setCilindrada(srs.getInt("cilindradas"));
                  moto.setCapacidadeTanque(srs.getInt("capacidade_tanque"));
                  moto.setPreco(srs.getFloat("preco"));
                               
                  motoLista.add(moto);        
               }
        	   			Conexao.closeConexao();
               
       		} catch (SQLException e) {
                   	return;
       			}
                
       		
       			//Imprime veículos recuperados do banco de dados;
           		System.out.println("\n Estes são nossos veículos disponíveis: \n");
           		   		
                for(int i=0; i<motoLista.size();i++) {

                 	System.out.println((i+1) + " - Modelo: " + (motoLista.get(i)).getModelo().toUpperCase());
                   	System.out.println("    Montadora: " + (motoLista.get(i)).getMontadora().toUpperCase());
                   	System.out.println("    Tipo: " + (motoLista.get(i)).getTipo());
                   	System.out.println("    Cor: " + (motoLista.get(i)).getCor().toUpperCase());
                   	System.out.println("    Cilindrada: " + (motoLista.get(i)).getCilindrada());
                   	System.out.println("    Capacidade Tanque: " + (motoLista.get(i)).getCapacidadeTanque());
                   	System.out.println("    Preço: " + formatoMoeda.format((motoLista.get(i)).getPreco()));

                   	System.out.println("-------------------------------------------------");
                    }  		
        	}	
}


		

	
	
	
	
	



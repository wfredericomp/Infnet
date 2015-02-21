package br.edu.infnet.console;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Statement;

import br.edu.infnet.model.*;
import br.edu.infnet.database.*;

public class Console {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	   ArrayList<Carro> carrosLista = new ArrayList<Carro>();
		           
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
       } catch (SQLException e) {
            	return;
       	 }
 
  		System.out.println("#######################################################");
   		System.out.println("#######          BEM VINDO A AV MOBIL          ########");
   		System.out.println("#######################################################");
       
   		System.out.println("Estes são nossos carros disponíveis:");
   		
   		
            for(int i=0; i<carrosLista.size();i++) {
            	System.out.println(i + " - Nome: " + (carrosLista.get(i)).getModelo());
            }
        		
	}
}



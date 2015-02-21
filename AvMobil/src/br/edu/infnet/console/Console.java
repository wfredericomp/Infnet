package br.edu.infnet.console;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.edu.infnet.model.Carro;

public class Console {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	    ArrayList<Carro> carrosLista = new ArrayList<Carro>();

		try {

			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/avmobildb";
            Connection conn = DriverManager.getConnection(url, "root", "admin");
            Statement st = conn.createStatement();
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
 
            System.out.println(carrosLista.size());

        } catch (Exception e) {
            System.err.println("Advertência!");
            System.err.println(e.getMessage());
        }		
	}
}



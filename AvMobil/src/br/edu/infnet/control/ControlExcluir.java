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
import br.edu.infnet.model.*;

public class ControlExcluir {
	
	static NumberFormat formatoMoeda = NumberFormat.getCurrencyInstance(); 	
	public static Scanner sc = new Scanner(System.in);
		
	public ControlExcluir() {
		
	}
	
		public static void excluirCArro() {
			
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
			    		
			    		if (carroLista.size() > 0) {
			    	
			    			for(int i=0; i<carroLista.size();i++) {
			    				System.out.println("Foi encontrado o seguinte veículo: ");
			    				System.out.println((i+1) + " - Modelo: " + (carroLista.get(i)).getModelo());
			    				System.out.println("    Montadora: " + (carroLista.get(i)).getMontadora());
			    				System.out.println("    Tipo: " + (carroLista.get(i)).getTipo());
			    				System.out.println("    Cor: " + (carroLista.get(i)).getCor());
			    				System.out.println("    Câmbio: " + (carroLista.get(i)).getCambio());
			    				System.out.println("    Motor: " + (carroLista.get(i)).getMotor());
			    				System.out.println("    Preço: " + formatoMoeda.format((carroLista.get(i)).getPreco()));
			    				System.out.println("-------------------------------------------------");	
			    			}
			    			
			    				System.out.println("Deseja Excluir este veículo?");
			    					System.out.println("1 - SIM");
			    					System.out.println("2 - NÃO");
			    						
			    						int opcao = sc.nextInt();
			    					
			    							if (opcao ==1) {
			    								try { 
			    									sql = "DELETE FROM carro WHERE chassi = '" + chassi + "'"; 
			    									Statement st = con.createStatement();
			    									st.executeUpdate(sql);
			    									
			    									System.out.println("Veículo excluído com sucesso!");
			    									
			    								} catch (SQLException e) {
			    									System.out.println("Erro ao tentar excluir veículo:" + e);
			    								}
			    							}
			    								if (opcao == 2) {
			    									System.out.println("Retonando ao menu principal:");
			    									ControlPrincipal.menuPrincipal();
			    								}
			    									if (opcao != 1 && opcao != 2) {
			    										System.out.println("Opção Inválida, retornando ao menu principal.");
			    									}
			    		}
			    		
			    			else {
			    				System.out.println("Nenhum veículo encontrado: ");
			    			}
			    		
			   			Conexao.closeConexao();
		       
				} catch (SQLException e) {
		            	return;
		       		}
		}	
}
	
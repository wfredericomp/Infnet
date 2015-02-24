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
import br.edu.infnet.model.Motocicleta;

public class ControlEditar {

	static NumberFormat formatoMoeda = NumberFormat.getCurrencyInstance(); 	
	public static Scanner sc = new Scanner(System.in);
		
	public ControlEditar() {
		
	}
	
		public static void editarCarro() {
			
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
			    			
			    				System.out.println("Deseja Editarr este veículo?");
			    					System.out.println("1 - SIM");
			    					System.out.println("2 - NÃO");
			    						
			    						int opcao = sc.nextInt();
			    					
			    							if (opcao ==1) {
			    								System.out.println("Editando o veículo com chassi " + chassi + ":");
			    								
			    								System.out.println("Montadora:");
			    								String montadora = sc.nextLine().toUpperCase();
			    								
			    								System.out.println("Modelo:");
			    								String modelo = sc.nextLine().toUpperCase();
			    								
			    								System.out.println("Tipo:");
			    								String tipo = sc.nextLine().toUpperCase();
			    								
			    								System.out.println("Cor:");
			    								String cor = sc.nextLine().toUpperCase();
			    								
			    								System.out.println("Motor:");
			    								String motor = sc.nextLine().toUpperCase();
			    								
			    								System.out.println("Câmbio:");
			    								String cambio = sc.nextLine().toUpperCase();
			    								
			    								System.out.println("Valor:");
			    								float preco = sc.nextFloat();
			    								
			    								try { 
				    								
				    								sql = "UPDATE carro" + 
				    									  " set montadora='" + montadora + "'" +
				    									  ", modelo='" + modelo + "'" +
				    									  ", tipo='" + tipo + "'" +
				    									  ", cor='" + cor + "'" +
				    									  ", motor='" + motor + "'" +
				    									  ", cambio='" + cambio + "'" +
				    									  ", preco=" + preco +
				    									  " WHERE chassi='" + chassi +"'";    								
				    								
			    									Statement st = con.createStatement();
			    									st.executeUpdate(sql);
			    									
			    									System.out.println("Veículo atualizado com sucesso!");
			    									
			    									for(int i=0; i<carroLista.size();i++) {
			    					    				System.out.println("Veículo atualizado com os seguintes dados: ");
			    					    				System.out.println((i+1) + " - Modelo: " + modelo);
			    					    				System.out.println("    Montadora: " + montadora);
			    					    				System.out.println("    Tipo: " + tipo);
			    					    				System.out.println("    Cor: " + cor);
			    					    				System.out.println("    Câmbio: " + cambio);
			    					    				System.out.println("    Motor: " + motor);
			    					    				System.out.println("    Preço: " + formatoMoeda.format(preco));
			    					    				System.out.println("-------------------------------------------------");	
			    					    			}
			    									
			    									
			    								} catch (SQLException e) {
			    									System.out.println("Erro ao tentar editar veículo:" + e);
			    									ControlPrincipal.menuPrincipal();
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

		public static void editarMoto() {
			
			ArrayList<Motocicleta> motoLista = new ArrayList<Motocicleta>();

			System.out.println("Informe o Chassi: ");
			String chassi = sc.next().toString();

			try {     
				Connection con = Conexao.getConexao();
				String sql = "SELECT * FROM carro WHERE chassi = '" + chassi + "'"; 
		    	PreparedStatement comando = con.prepareStatement(sql);
				ResultSet srs = comando.executeQuery();
		    
			    	while (srs.next()) {
			    		
			    		Motocicleta moto = new Motocicleta();
			    		
			    		moto.setChassi(srs.getString("chassi"));
		                moto.setMontadora(srs.getString("montadora"));
		                moto.setModelo(srs.getString("modelo"));
		                //moto.setTipo(srs.getString("tipo"));
		                moto.setCor(srs.getString("cor"));
		                moto.setCilindrada(srs.getInt("motor"));
		                moto.setCapacidadeTanque(srs.getInt("cambio"));
		                moto.setPreco(srs.getFloat("preco"));
		                       
		                motoLista.add(moto);        
			    	}
			    		
			    		if (motoLista.size() > 0) {
			    	
			    			for(int i=0; i<motoLista.size();i++) {
			    				System.out.println("Foi encontrado o seguinte veículo: ");
			    				System.out.println((i+1) + " - Modelo: " + (motoLista.get(i)).getModelo());
			    				System.out.println("    Montadora: " + (motoLista.get(i)).getMontadora());
			    				System.out.println("    Tipo: " + (motoLista.get(i)).getTipo());
			    				System.out.println("    Cor: " + (motoLista.get(i)).getCor());
			    				System.out.println("    Cilindrada: " + (motoLista.get(i)).getCilindrada());
			    				System.out.println("    Capacidade Tanque: " + (motoLista.get(i)).getCapacidadeTanque());
			    				System.out.println("    Preço: " + formatoMoeda.format((motoLista.get(i)).getPreco()));
			    				System.out.println("-------------------------------------------------");	
			    			}
			    			
			    				System.out.println("Deseja Editarr este veículo?");
			    					System.out.println("1 - SIM");
			    					System.out.println("2 - NÃO");
			    						
			    						int opcao = sc.nextInt();
			    					
			    							if (opcao ==1) {
			    								System.out.println("Editando o veículo com chassi " + chassi + ":");
			    								
			    								System.out.println("Montadora:");
			    								String montadora = sc.nextLine().toUpperCase();
			    								
			    								System.out.println("Modelo:");
			    								String modelo = sc.nextLine().toUpperCase();
			    								
			    								System.out.println("Tipo:");
			    								String tipo = sc.nextLine().toUpperCase();
			    								
			    								System.out.println("Cor:");
			    								String cor = sc.nextLine().toUpperCase();
			    								
			    								System.out.println("Cilindrada:");
			    								int cilindrada = sc.nextInt();
			    								
			    								System.out.println("Capacidade Tanque:");
			    								int capacidadeTanque = sc.nextInt();
			    								
			    								System.out.println("Valor:");
			    								float preco = sc.nextFloat();
			    								
			    								try { 
				    								
				    								sql = "UPDATE moto" + 
				    									  " set montadora='" + montadora + "'" +
				    									  ", modelo='" + modelo + "'" +
				    									  ", tipo='" + tipo + "'" +
				    									  ", cor='" + cor + "'" +
				    									  ", cilindrada='" + cilindrada + "'" +
				    									  ", capacidade_tanque='" + capacidadeTanque + "'" +
				    									  ", preco=" + preco +
				    									  " WHERE chassi='" + chassi +"'";    								
				    								
			    									Statement st = con.createStatement();
			    									st.executeUpdate(sql);
			    									
			    									System.out.println("Veículo atualizado com sucesso!");
			    									
			    									for(int i=0; i<motoLista.size();i++) {
			    					    				System.out.println("Veículo atualizado com os seguintes dados: ");
			    					    				System.out.println((i+1) + " - Modelo: " + modelo);
			    					    				System.out.println("    Montadora: " + montadora);
			    					    				System.out.println("    Tipo: " + tipo);
			    					    				System.out.println("    Cor: " + cor);
			    					    				System.out.println("    Capacidade Tanque: " + cilindrada);
			    					    				System.out.println("    Capacidade Tanque: " + capacidadeTanque);
			    					    				System.out.println("    Preço: " + formatoMoeda.format(preco));
			    					    				System.out.println("-------------------------------------------------");	
			    					    			}
			    									
			    									
			    								} catch (SQLException e) {
			    									System.out.println("Erro ao tentar editar veículo:" + e);
			    									ControlPrincipal.menuPrincipal();
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
	
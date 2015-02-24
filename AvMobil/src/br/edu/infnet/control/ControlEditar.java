package br.edu.infnet.control;

import java.sql.Connection;
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

			carroLista = ControlPesquisa.pesquisaChassiCarro();
			String chassi = carroLista.get(0).getChassi();
				
				if (chassi == null) {
					System.out.println("Ve�culo n�o encontrado.");
				}
			    			
			    				System.out.println("Deseja Editar este ve�culo?");
			    					System.out.println("1 - SIM");
			    					System.out.println("2 - N�O");
			    						
			    						int opcao = sc.nextInt();
			    					
			    							if (opcao ==1) {
			    								System.out.println("Editando o ve�culo com chassi " + chassi + ":");
			    								
			    								Carro carro = new Carro();
			    								
			    								carro.setChassi(chassi);
			    								
			    								System.out.println("Montadora:");
			    								carro.setMontadora(sc.nextLine().toUpperCase());
			    								
			    								System.out.println("Modelo:");
			    								carro.setModelo(sc.nextLine().toUpperCase());
			    								
			    								System.out.println("Tipo:");
			    								carro.setStrTipo(sc.nextLine().toUpperCase());
			    								
			    								System.out.println("Cor:");
			    								carro.setCor(sc.nextLine().toUpperCase());
			    								
			    								System.out.println("Motor:");
			    								carro.setMotor(sc.nextLine().toUpperCase());
			    								
			    								System.out.println("C�mbio:");
			    								carro.setCambio(sc.nextLine().toUpperCase());
			    								
			    								System.out.println("Valor:");
			    								carro.setPreco(sc.nextFloat());
			    								
			    								carroLista.clear();
			    								carroLista.add(carro);
			    								
			    								System.out.println("Confirma a grava��o dos seguintes dados?");
			    								
			    								 for(int i=0; i<carroLista.size();i++) {

			    					                	System.out.println((i+1) + " - Modelo: " + (carroLista.get(i)).getModelo());
			    					                	System.out.println("    Montadora: " + (carroLista.get(i)).getMontadora());
			    					                	System.out.println("    Tipo: " + (carroLista.get(i)).getTipo());
			    					                	System.out.println("    Cor: " + (carroLista.get(i)).getCor());
			    					                	System.out.println("    Motor: " + (carroLista.get(i)).getMotor());
			    					                	System.out.println("    C�mbio: " + (carroLista.get(i)).getCambio());
			    					                	System.out.println("    Pre�o: " + formatoMoeda.format((carroLista.get(i)).getPreco()));

			    					                	System.out.println("-------------------------------------------------");	
			    					                }
			    								
			    								 System.out.println("1 - SIM");
			    								 System.out.println("2 - N�O");
			    								 
			    								 opcao = sc.nextInt();
			    								 
			    								 if (opcao == 1) {
			    								 
			    									 try { 
				    								
			    										 String sql = "UPDATE carro" + 
			    												 " set montadora='" + carroLista.get(0).getMontadora() + "'" +
			    												 ", modelo='" + carroLista.get(0).getModelo() + "'" +
			    												 ", tipo='" + carroLista.get(0).getTipo() + "'" +
			    												 ", cor='" + carroLista.get(0).getCor() + "'" +
			    												 ", motor='" + carroLista.get(0).getMotor() + "'" +
			    												 ", cambio='" + carroLista.get(0).getCambio() + "'" +
			    												 ", preco=" + carroLista.get(0).getPreco() +
			    												 " WHERE chassi='" + chassi +"'";
				    								
			    										 		Connection con = Conexao.getConexao();
			    										 		Statement st = con.createStatement();
			    										 		st.executeUpdate(sql);
			    										 		Conexao.closeConexao();
			    									
			    										 			System.out.println("Ve�culo atualizado com sucesso!");
			    									
			    										 				for(int i=0; i<carroLista.size();i++) {
			    										 					System.out.println("Ve�culo atualizado com os seguintes dados: ");
			    										 					System.out.println((i+1) + " - Modelo: " + carroLista.get(0).getModelo());
			    										 					System.out.println("    Montadora: " + carroLista.get(0).getMontadora());
			    										 					System.out.println("    Tipo: " + carroLista.get(0).getTipo());
			    										 					System.out.println("    Cor: " + carroLista.get(0).getCor());
			    										 					System.out.println("    C�mbio: " + carroLista.get(0).getCambio());
			    										 					System.out.println("    Motor: " + carroLista.get(0).getMotor());
			    										 					System.out.println("    Pre�o: " + formatoMoeda.format(carroLista.get(0).getPreco()));
			    										 					System.out.println("-------------------------------------------------");	
			    										 				}
			    										
			    									 } catch (SQLException e) {
			    										 System.out.println("Erro ao tentar editar ve�culo:" + e);
			    										 ControlPrincipal.menuPrincipal();
			    									 }
			    								 }
			    								 
			    								if (opcao == 2) {
			    									System.out.println("Retonando ao menu principal:");
			    									ControlPrincipal.menuPrincipal();
			    								}
			    								if (opcao != 1 && opcao != 2) {
			    										System.out.println("Op��o Inv�lida, retornando ao menu principal.");
			    									}
			    							}
		}

		public static void editarMoto() {
			
			ArrayList<Motocicleta> motoLista = new ArrayList<Motocicleta>();
			motoLista = ControlPesquisa.pesquisaChassiMoto();
			String chassi = motoLista.get(0).getChassi();
			
			if (chassi == null) {
				System.out.println("Ve�culo n�o encontrado.");
						    			
			    				System.out.println("Deseja Editarr este ve�culo?");
			    					System.out.println("1 - SIM");
			    					System.out.println("2 - N�O");
			    						
			    						int opcao = sc.nextInt();
			    					
			    							if (opcao ==1) {
			    								
			    								//Motocicleta moto = new Motocicleta();
			    								
			    								System.out.println("Editando o ve�culo com chassi " + chassi + ":");
			    								
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
				    								
			    										String sql = "UPDATE moto" + 
			    												" set montadora='" + montadora + "'" +
			    												", modelo='" + modelo + "'" +
			    												", tipo='" + tipo + "'" +
			    												", cor='" + cor + "'" +
			    												", cilindrada='" + cilindrada + "'" +
			    												", capacidade_tanque='" + capacidadeTanque + "'" +
			    												", preco=" + preco +
			    												" WHERE chassi='" + chassi +"'";    								
				    								
			    										Connection con = Conexao.getConexao();
			    										Statement st = con.createStatement();
			    										st.executeUpdate(sql);
			    										Conexao.closeConexao();
			    									
			    										System.out.println("Ve�culo atualizado com sucesso!");
			    									
			    										for(int i=0; i<motoLista.size();i++) {
			    											System.out.println("Ve�culo atualizado com os seguintes dados: ");
			    											System.out.println((i+1) + " - Modelo: " + modelo);
			    											System.out.println("    Montadora: " + montadora);
			    											System.out.println("    Tipo: " + tipo);
			    											System.out.println("    Cor: " + cor);
			    											System.out.println("    Capacidade Tanque: " + cilindrada);
			    											System.out.println("    Capacidade Tanque: " + capacidadeTanque);
			    											System.out.println("    Pre�o: " + formatoMoeda.format(preco));
			    											System.out.println("-------------------------------------------------");	
			    										}
			    									
			    									
			    									} catch (SQLException e) {
			    										System.out.println("Erro ao tentar editar ve�culo:" + e);
			    										ControlPrincipal.menuPrincipal();
			    									}
			    							}
			    	
			    							if (opcao == 2) {
			    								System.out.println("Retonando ao menu principal:");
			    								ControlPrincipal.menuPrincipal();
			    							}
			    								if (opcao != 1 && opcao != 2) {
			    									System.out.println("Op��o Inv�lida, retornando ao menu principal.");
			    								}
			}
			    		
			else {
				System.out.println("Nenhum ve�culo encontrado: ");
			}
		} 
}
	
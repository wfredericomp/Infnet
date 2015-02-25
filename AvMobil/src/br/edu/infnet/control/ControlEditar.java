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
					System.out.println("Veículo não encontrado.");
				}
			    			
			    				System.out.println("Deseja Editar este veículo?");
			    					System.out.println("1 - SIM");
			    					System.out.println("2 - NÃO");
			    						
			    						int opcao = sc.nextInt();
			    					
			    							if (opcao ==1) {
			    								System.out.println("Editando o veículo com chassi " + chassi + ":");
			    								
			    								Carro carro = new Carro();
			    								
			    								carro.setChassi(chassi);
			    								
			    								Scanner sc = new Scanner(System.in);
			    																
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
			    								
			    								System.out.println("Câmbio:");
			    								carro.setCambio(sc.nextLine().toUpperCase());
			    								
			    								System.out.println("Valor:");
			    								carro.setPreco(sc.nextFloat());
			    								
			    								carroLista.clear();
			    								carroLista.add(carro);
			    								
			    								System.out.println("Confirma a gravação dos seguintes dados?");
			    								
			    								 for(int i=0; i<carroLista.size();i++) {

			    					                	System.out.println((i+1) + " - Montadora: " + (carroLista.get(i)).getMontadora());
			    					                	System.out.println("    Modelo: " + (carroLista.get(i)).getModelo());
			    					                	System.out.println("    Tipo: " + (carroLista.get(i)).getTipo());
			    					                	System.out.println("    Cor: " + (carroLista.get(i)).getCor());
			    					                	System.out.println("    Motor: " + (carroLista.get(i)).getMotor());
			    					                	System.out.println("    Câmbio: " + (carroLista.get(i)).getCambio());
			    					                	System.out.println("    Preço: " + formatoMoeda.format((carroLista.get(i)).getPreco()));

			    					                	System.out.println("-------------------------------------------------");	
			    					                }
			    								
			    								 System.out.println("1 - SIM");
			    								 System.out.println("2 - NÃO");
			    								 
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
			    												    									
			    										 				for(int i=0; i<carroLista.size();i++) {
			    										 					System.out.println("Veículo atualizado com os seguintes dados: ");
			    										 					System.out.println((i+1) + " - Modelo: " + carroLista.get(0).getModelo());
			    										 					System.out.println("    Montadora: " + carroLista.get(0).getMontadora());
			    										 					System.out.println("    Tipo: " + carroLista.get(0).getTipo());
			    										 					System.out.println("    Cor: " + carroLista.get(0).getCor());
			    										 					System.out.println("    Câmbio: " + carroLista.get(0).getCambio());
			    										 					System.out.println("    Motor: " + carroLista.get(0).getMotor());
			    										 					System.out.println("    Preço: " + formatoMoeda.format(carroLista.get(0).getPreco()));
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
		}

		public static void editarMoto() {
			
			ArrayList<Motocicleta> motoLista = new ArrayList<Motocicleta>();
			motoLista = ControlPesquisa.pesquisaChassiMoto();
			String chassi = motoLista.get(0).getChassi();
			
			if (chassi == null) {
				System.out.println("Veículo não encontrado.");
						    			
			    				System.out.println("Deseja Editarr este veículo?");
			    					System.out.println("1 - SIM");
			    					System.out.println("2 - NÃO");
			    						
			    						int opcao = sc.nextInt();
			    					
			    							if (opcao ==1) {
			    								
			    								Motocicleta moto = new Motocicleta();
			    								
			    								Scanner sc = new Scanner(System.in);
			    								
			    								System.out.println("Editando o veículo com chassi " + chassi + ":");
			    								
			    								System.out.println("Montadora:");
			    								moto.setMontadora(sc.nextLine().toUpperCase());
			    								
			    								System.out.println("Modelo:");
			    								moto.setModelo(sc.nextLine().toUpperCase());
			    								
			    								System.out.println("Tipo:");
			    								//moto.setTipo(sc.nextLine().toUpperCase());
			    								
			    								System.out.println("Cor:");
			    								moto.setCor(sc.nextLine().toUpperCase());
			    								
			    								System.out.println("Cilindrada:");
			    								moto.setCilindrada(sc.nextInt());
			    								
			    								System.out.println("Capacidade Tanque:");
			    								moto.setCapacidadeTanque(sc.nextInt());
			    								
			    								System.out.println("Valor:");
			    								moto.setPreco(sc.nextFloat());
			    								
			    								motoLista.clear();
			    								motoLista.add(moto);
			    									try { 
				    								
			    										String sql = "UPDATE moto" + 
			    												" set montadora='" + moto.getMontadora() + "'" +
			    												", modelo='" + moto.getModelo() + "'" +
			    												", tipo='" + moto.getTipo() + "'" +
			    												", cor='" + moto.getCor() + "'" +
			    												", cilindrada='" + moto.getCilindrada() + "'" +
			    												", capacidade_tanque='" + moto.getCapacidadeTanque() + "'" +
			    												", preco=" + moto.getPreco() +
			    												" WHERE chassi='" + chassi + "'";    								
				    								
			    										Connection con = Conexao.getConexao();
			    										Statement st = con.createStatement();
			    										st.executeUpdate(sql);
			    										Conexao.closeConexao();
			    									
			    										System.out.println("Veículo atualizado com sucesso!");
			    									
			    										for(int i=0; i<motoLista.size();i++) {
			    											System.out.println("Veículo atualizado com os seguintes dados: ");
			    											System.out.println((i+1) + " - Montadora: " + moto.getMontadora());
			    											System.out.println("    Modelo: " + moto.getModelo());
			    											System.out.println("    Tipo: " + moto.getTipo());
			    											System.out.println("    Cor: " + moto.getCor());
			    											System.out.println("    Capacidade Tanque: " + moto.getCilindrada());
			    											System.out.println("    Capacidade Tanque: " + moto.getCapacidadeTanque());
			    											System.out.println("    Preço: " + formatoMoeda.format(moto.getPreco()));
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
		} 
}
	
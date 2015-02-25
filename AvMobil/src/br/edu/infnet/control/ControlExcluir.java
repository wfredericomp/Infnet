package br.edu.infnet.control;

import java.sql.Connection;
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
	
		public static void excluirCarro() {
			
			
			//Pesquisa parâmetro chassi informado pelo usuário
			ArrayList<Carro> carroLista = new ArrayList<Carro>();
			carroLista = ControlPesquisa.pesquisaChassiCarro();
			String chassi = carroLista.get(0).getChassi();
			
			if (chassi == null) {
				System.out.println("Nenhum veículo localizado.");
			}
			
			System.out.println("Deseja Excluir este veículo?");
			System.out.println("1 - SIM");
			System.out.println("2 - NÃO");
			    						
			int opcao = sc.nextInt();
			    	
				if (opcao ==1) {
					
					//Abre conexão com o banco e excluir o veículo;
					try { 
							Connection con = Conexao.getConexao();
			    			String sql = "DELETE FROM carro WHERE chassi = '" + chassi + "'"; 
			    			Statement st = con.createStatement();
			    			st.executeUpdate(sql);
			    			Conexao.closeConexao();
			    								
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
			    		
		public static void excluirMoto() {
			
			
			//Pesquisa parâmetro chassi informado pelo usuário;
			ArrayList<Motocicleta> motoLista = new ArrayList<Motocicleta>();
			motoLista = ControlPesquisa.pesquisaChassiMoto();
			String chassi = motoLista.get(0).getChassi();
			
			if (chassi == null) {
				System.out.println("Veículo não encontrado.");
			}
			
			System.out.println("Deseja Excluir este veículo?");
			System.out.println("1 - SIM");
			System.out.println("2 - NÃO");
			    						
			int opcao = sc.nextInt();
			    					
			if (opcao ==1) {
				
				//Abre conexão com o banco de dados e exclui veículo;
				try { 
					String sql = "DELETE FROM moto WHERE chassi = '" + chassi + "'";
					Connection con = Conexao.getConexao();
					Statement st = con.createStatement();
					st.executeUpdate(sql);
					Conexao.closeConexao();
					
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
}

	
package br.edu.infnet.control;

import java.util.Scanner;


public class ControlPrincipal {
	
	private static Scanner sc = new Scanner(System.in);
	private static int opcao = 0;
	
	public ControlPrincipal() {
	
	}
	
	public static void menuPrincipal() {

		System.out.println("#######################################################");
		System.out.println("#######          BEM VINDO A AV MOBIL          ########");
		System.out.println("#######################################################");

		System.out.println("\nSelecione uma opção:\n");
		
		System.out.println("1 - Listar Veículo.");
		System.out.println("2 - Pesquisar Chassi.");
		System.out.println("3 - Cadastrar Veículo.");
		System.out.println("4 - Editar Veículo.");
		System.out.println("5 - Excluir Veículo.");
		System.out.println("6 - Sair.");
	   
		opcao = sc.nextInt();
		
		switch (opcao) {
	
			case 1:
				ControlLista.listaCarros();
				break;
	
			case 2:
				System.out.println("Pesquisar Chassi em construção");
				System.out.println("Selecione uma opção");
				System.out.println("1 - Pesquisar por Carros");
				System.out.println("2 - Pesquisar por Motos");
				System.out.println("3 - Voltar ao menu Principal:");
				
				opcao = sc.nextInt();
				
					if (opcao == 1) {
						ControlPesquisa.pesquisaChassiCarro();
					}
				
					if (opcao == 2) {
						ControlPesquisa.pesquisaChassiMoto();
					}
				
					if (opcao == 3) {
						menuPrincipal();
					}
					
					if ( opcao != 1 && opcao != 2 && opcao != 3) {
						System.out.println("Opção inválida, retornando ao menu principal.");
						menuPrincipal();
					}
				
					break;
				
			case 3:
				//System.out.println("Cadastrar em construção");
				ControlCadastrar.cadCarro();
				break;
				
			case 4:
				System.out.println("Editar em construção:");
				voltarMenuPrincipal();
				break;
				
			case 5:
				System.out.println("Exclusão em construção");
				voltarMenuPrincipal();
				break;
				
			case 6:
				System.out.println("Saindo ...");
				break;
		}
	}

	
	private static void voltarMenuPrincipal() {

		System.out.println("Deseja voltar ao menu principal?");
		System.out.println("1 - SIM");
		System.out.println("2 - NÃO");
		
		opcao = sc.nextInt();

			if(opcao == 1) {
				menuPrincipal();
			}
			
			else {
				return;
			}	
	}
}
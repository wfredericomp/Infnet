package br.edu.infnet.control;

import java.util.Scanner;

public class ControlPrincipal {

	
	public ControlPrincipal() {
	
	}
	
	public static void menuPrincipal() {
	
		Scanner sc = new Scanner(System.in);
		int opcao = 0;

		System.out.println("#######################################################");
		System.out.println("#######          BEM VINDO A AV MOBIL          ########");
		System.out.println("#######################################################");

		System.out.println("\nSelecione uma op��o:\n");
		
		System.out.println("1 - Listar Ve�culo.");
		System.out.println("2 - Cadastrar Ve�culo.");
		System.out.println("3 - Editar Ve�culo.");
		System.out.println("4 - Excluir Ve�culo.");
	   
		opcao = sc.nextInt();
		
		switch (opcao) {
	
			case 1:
				ControlLista.listaCarros();
				break;
	
			case 2:
				//System.out.println("Cadastro em constru��o");
				ControlCadastrar.cadastroVeiculo();
		
				System.out.println("Deseja cadastrar outro ve�culo? S/N");
				opcao = sc.nextInt();
		
					if(opcao == 1) {
						ControlCadastrar.cadastroVeiculo();
					}
		
					else {
						menuPrincipal();
					}
				break;
	
			case 3:
				System.out.println("Edi��o em constru��o");
				
				System.out.println("Deseja voltar ao menu principal?");
				System.out.println("1 - SIM");
				System.out.println("2 - N�O");
				
				opcao = sc.nextInt();
		
					if(opcao == 1) {
						menuPrincipal();
					}
					
					else {
						break;
					}
			case 4:
				System.out.println("Exclus�o em constru��o");
				
				System.out.println("Deseja voltar ao menu principal?");
				System.out.println("1 - SIM");
				System.out.println("2 - N�O");
				
				opcao = sc.nextInt();
		
					if(opcao == 1) {
						menuPrincipal();
					}
					
					else {
						break;
					}	
		}
	}
}
	


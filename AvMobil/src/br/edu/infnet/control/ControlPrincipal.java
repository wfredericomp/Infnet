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

		System.out.println("\nSelecione uma opção:\n");
		
		System.out.println("1 - Listar Veículo.");
		System.out.println("2 - Cadastrar Veículo.");
		System.out.println("3 - Editar Veículo.");
		System.out.println("4 - Excluir Veículo.");
	   
		opcao = sc.nextInt();
	
		switch (opcao) {
	
			case 1:
				ControlLista.listaCarros();
				break;
	
			case 2:
				//System.out.println("Cadastro em construção");
				ControlCadastrar.cadastroVeiculo();
		
				System.out.println("Deseja cadastrar outro veículo? S/N");
				String respCadastro = sc.next();
		
					if(respCadastro == "S" || respCadastro == "s") {
						ControlCadastrar.cadastroVeiculo();
					}
		
					else {
						ControlPrincipal.menuPrincipal();
					}
				break;
	
			case 3:
				System.out.println("Edição em construção");
				break;	
	
			case 4:
				System.out.println("Exclusão em construção");
				break;	
		}
	}
}
	


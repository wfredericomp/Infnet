package br.edu.infnet.console;

import br.edu.infnet.control.*;
import java.util.Scanner;

public class Console {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int opcao = 0;
		Scanner sc = new Scanner(System.in);
	
		System.out.println("#######################################################");
   		System.out.println("#######          BEM VINDO A AV MOBIL          ########");
   		System.out.println("#######################################################");
 
   		System.out.println("\nSelecione uma opção:\n");
   		
		System.out.println("1 - Listar Veículo.");
		System.out.println("2 - Cadastrar Veículo.");
		System.out.println("3 - Editar Veículo.");
		System.out.println("4 - Excluir Veículo.");
		   
		opcao = sc.nextInt();
		sc.close();
		
		
				
		switch (opcao) {
		
		case 1:
			ControlLista.listaCarros();
			break;
		
		case 2:
			//System.out.println("Cadastro em construção");
			ControlCadastrar.cadastroVeiculo();
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



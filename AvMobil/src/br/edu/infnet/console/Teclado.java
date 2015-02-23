package br.edu.infnet.console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Teclado {
	
	//Objeto que representa teclado.

	private static BufferedReader teclado = new BufferedReader( new InputStreamReader(System.in));
	
	public static String lerTexto(String texto){
		
		try{
			//mostra o texto			
			System.out.println(texto);
			
			//Lê a linha
			
			return teclado.readLine();
			
		} catch (IOException e) {
			return null;
		}
		
	}
	
	public static int lerInt(String texto){
		// Chama o método lerString e corverte o resultado para double.
		
		return Integer.parseInt(lerTexto(texto));
	}	
	
	public static double lerDouble(String texto){
		//Chama o métodolerString e converte o resultado para double.
		return Double.parseDouble(lerTexto(texto));		
	}
	
	public static float lerFloat(String texto){
		//Chama o métodolerString e converte o resultado para float.
		return Float.parseFloat(lerTexto(texto));		
	}
}
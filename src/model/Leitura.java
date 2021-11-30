package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Leitura {

	public String entDados(String entrada) throws IOException {		

		InputStreamReader teclado = new InputStreamReader(System.in);
		BufferedReader memoria = new BufferedReader(teclado);
	
		entrada = "";

		try{
			entrada = memoria.readLine();
		}
		catch(IOException e){
			System.out.println("Erro de entrada");
		}

		return entrada;
	}

}

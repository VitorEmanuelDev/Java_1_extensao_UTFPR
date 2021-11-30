package model;

public class VeicExistException extends Exception{	
	public VeicExistException() {	
		System.out.println("Já existe um veículo com esta placa");	
	}
}

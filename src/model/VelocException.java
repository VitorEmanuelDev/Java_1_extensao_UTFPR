package model;

public class VelocException extends Exception{
	public VelocException() {
		System.out.println("A velocidade máxima está fora dos limites brasileiros");
	}
}

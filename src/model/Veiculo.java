package model;

public abstract class Veiculo implements Calcular{

	private String placa;
	private String marca;
	private String modelo;
	private String cor;
	protected float velocMax;
	private int qtdRodas;
	private Motor motor;

	public Veiculo(){
		placa = "";
		marca = "";
		modelo = "";
		cor = "";
		velocMax = 0;
		qtdRodas = 0;
		motor = new Motor();
	}

	public String getPlaca() {
		return placa;
	}

	public final void setPlaca(String placa) {		
		this.placa = placa;
	}

	public String getMarca() {
		return marca;
	}

	public final void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public final void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getCor() {
		return cor;
	}

	public final void setCor(String cor) {
		this.cor = cor;
	}

	public float getVelocMax() {
		return velocMax;
	}

	public final void setVelocMax(float velocMax) { 
		this.velocMax = velocMax;
	}

	public int getQtdRodas() {
		return qtdRodas;
	}

	public final void setQtdRodas(int qtdRodas) {
		this.qtdRodas = qtdRodas;
	}

	public Motor getMotor() {
		return this.motor;
	}

	public final void setMotor(Motor motor) {
		this.motor = motor;
	}

	public abstract float calcVel(float velocMax);


}

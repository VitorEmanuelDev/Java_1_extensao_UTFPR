package model;

import java.util.List;

public final class Passeio extends Veiculo{

	public int qtdPassageiros;

	public Passeio() {
		qtdPassageiros = 0;
	}

	public int getQtdPassageiros() {
		return qtdPassageiros;
	}

	public final void setQtdPassageiros(int qtdPassageiros) {
		this.qtdPassageiros = qtdPassageiros;
	}


	@Override
	public float calcVel(float velocMax) {
		return velocMax * 1000;
	}

	@Override
	public <Passeio> int calcular(List<Passeio> veiculoPasseio) {
		int cor = 0;
		int marca = 0;
		int modelo = 0;
		int placa = 0;
		
		for(int i = 0; i < veiculoPasseio.size(); i++) {
			if(veiculoPasseio.get(i) != null ) {
				cor += ((Veiculo) veiculoPasseio.get(i)).getCor().length();
				marca += ((Veiculo) veiculoPasseio.get(i)).getMarca().length();
				modelo += ((Veiculo) veiculoPasseio.get(i)).getModelo().length();
				placa += ((Veiculo) veiculoPasseio.get(i)).getPlaca().length();
			}
		}
		return cor + marca + modelo + placa;
	}

	
}

package model;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public final class Carga extends Veiculo{

	public int cargaMax;
	public int  tara;

	public Carga() {
		cargaMax = 0;
		tara = 0;
	}

	public int getCargaMax() {
		return cargaMax;
	}

	public final void setCargaMax(int cargaMax) {
		this.cargaMax = cargaMax;
	}

	public int getTara() {
		return tara;
	}

	public final void setTara(int tera) {
		this.tara = tera;
	}

	@Override
	public float calcVel(float velocMax) {
		return velocMax * 100000;
	}

	@Override
	public <Carga> int calcular(List<Carga> veiculoCarga) {

		int rodas = 0;
		int velocidade = 0;
		int potencia = 0;
		int pistoes = 0;

		for(int i = 0; i < veiculoCarga.size(); i++) {
			if(veiculoCarga.get(i) != null) {
				rodas = ((Veiculo) veiculoCarga.get(i)).getQtdRodas();
				velocidade = (int) ((Veiculo) veiculoCarga.get(i)).getVelocMax();
				potencia = ((Veiculo) veiculoCarga.get(i)).getMotor().getPotencia();
				pistoes = ((Veiculo) veiculoCarga.get(i)).getMotor().getQtdPist();
			}
		}

		return rodas + velocidade + potencia + pistoes;

	}


}

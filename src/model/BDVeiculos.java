package model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BDVeiculos {
	
	public static List<Passeio> veiculoPasseio = new ArrayList<Passeio>();
	public static List<Carga> veiculoCarga = new ArrayList<Carga>();
	
	public BDVeiculos() {}

	public static List<Passeio> getVeiculoPasseio() {
		return veiculoPasseio;
	}

	public static void setVeiculoPasseio(List<Passeio> veiculoPasseio) {
		BDVeiculos.veiculoPasseio = veiculoPasseio;
	}

	public static List<Carga> getVeiculoCarga() {
		return veiculoCarga;
	}

	public static void setVeiculoCarga(List<Carga> veiculoCarga) {
		BDVeiculos.veiculoCarga = veiculoCarga;
	}
	
	public static void excluirVeiculosCargaPlaca(String placa) throws IOException {
		excluirPlacaCarga(veiculoCarga, placa);
	}

	public static void excluirVeiculosPasseioPlaca(String placa) throws IOException {
		excluirPlacaPasseio(veiculoPasseio, placa);
	}

	public static Carga imprimirVeiculosCargaPlaca(String placa) throws IOException {
		Carga cargaDados = imprimirPlacaCarga(veiculoCarga, placa);
		return cargaDados;
	}

	public static Passeio imprimirVeiculosPasseioPlaca(String placa) throws IOException {
		Passeio passeioDados = imprimirPlacaPasseio(veiculoPasseio, placa);
		return passeioDados;
	}

	public static List<Carga> imprimirVeiculosCarga() {
		return veiculoCarga;
	}

	public static List<Passeio> imprimirVeiculosPasseio() {
		return veiculoPasseio;
	}


	public static void cadastrarVeiculoPasseio(String placa,  String qtdPassageirosStr, String marca, String modelo, String cor, String qtdRodasStr, String velocMaxStr, String qtdPistoesStr, String potenciaStr) throws IOException, VeicExistException, VelocException {
		boolean placaExiste = cadastroPasseio(placa, qtdPassageirosStr, marca, modelo, cor, qtdRodasStr, velocMaxStr, qtdPistoesStr, potenciaStr);
		if(placaExiste == false) {		
			Veiculo novoVeiculoPasseio = new Passeio();
			veiculoPasseio.add((Passeio) novoVeiculoPasseio);
			int soma = novoVeiculoPasseio.calcular(veiculoPasseio);
			System.out.println("Soma dos atributos int " + soma);
		}
	}

	public static void cadastrarVeiculoCarga(String placa, String taraStr, String cargaMaxStr, String marca, String modelo, String cor, String qtdRodasStr, String velocMaxStr, String qtdPistoesStr, String potenciaStr) throws IOException, VeicExistException, VelocException {
		boolean placaExiste = cadastroCarga(placa, taraStr, cargaMaxStr, marca, modelo, cor, qtdRodasStr, velocMaxStr, qtdPistoesStr, potenciaStr);
		if(placaExiste == false) {		
			Veiculo novoVeiculoCarga = new Carga();
			veiculoCarga.add((Carga) novoVeiculoCarga);
			int soma = novoVeiculoCarga.calcular(veiculoCarga);
			System.out.println("Soma dos atributos int " + soma);
		}
	}

	@SuppressWarnings("resource")
	private static boolean cadastroCarga(String placa, String taraStr, String cargaMaxStr, String marca, String modelo, String cor, String qtdRodasStr, String velocMaxStr, String qtdPistoesStr, String potenciaStr) throws IOException, VeicExistException, VelocException {
		Carga novoVeiculoCarga;

		boolean placaExiste = false;
		for(int i = 0; i < veiculoCarga.size(); i++) {
			if(veiculoCarga.get(i) != null && veiculoCarga.get(i).getPlaca().equals(placa)) {
				placaExiste = true;
				throw new VeicExistException();
			}
		}

		if(placaExiste == false)
			novoVeiculoCarga = new Carga();			
		else
			return true;
		
		int tara = Integer.parseInt(taraStr);
		novoVeiculoCarga.setTara(tara);
		int cargaMax = Integer.parseInt(cargaMaxStr);
		novoVeiculoCarga.setCargaMax(cargaMax);
		novoVeiculoCarga.setCor(cor);
		novoVeiculoCarga.setMarca(marca);
		novoVeiculoCarga.setModelo(modelo);
		novoVeiculoCarga.setMotor(new Motor());
		int potencia = Integer.parseInt(potenciaStr);
		novoVeiculoCarga.getMotor().setPotencia(potencia);
		int qtdPistoes = Integer.parseInt(qtdPistoesStr);
		novoVeiculoCarga.getMotor().setQtdPist(qtdPistoes);
		int qtdRodas = Integer.parseInt(qtdRodasStr);
		novoVeiculoCarga.setQtdRodas(qtdRodas);
		float velocMax = Float.parseFloat(velocMaxStr);
		if(velocMax < 80 || velocMax > 110) {	
			if (velocMax < 80)
				velocMax = 90;
			if (velocMax > 100)
				velocMax = 100;	
			throw  new VelocException();
		}
		novoVeiculoCarga.setVelocMax(velocMax);

		veiculoCarga.add(novoVeiculoCarga);
		int soma = novoVeiculoCarga.calcular(veiculoCarga);
		
		return false;
	}

	private static boolean cadastroPasseio(String placa, String qtdPassageirosStr, String marca, String modelo, String cor, String qtdRodasStr, String velocMaxStr, String qtdPistoesStr, String potenciaStr) throws IOException, VeicExistException, VelocException {

		Passeio novoVeiculoPasseio;

		boolean placaExiste = false;
		for(int i = 0; i < veiculoPasseio.size(); i++) {
			if(veiculoPasseio.get(i) != null && veiculoPasseio.get(i).getPlaca().equals(placa)) {
				placaExiste = true;
				throw new VeicExistException();
			}
		}

		if(placaExiste == false)		
			novoVeiculoPasseio = new Passeio();
		else
			return true;
		
		novoVeiculoPasseio.setPlaca(placa);
		int qtdPassageiros = Integer.parseInt(qtdPassageirosStr);
		novoVeiculoPasseio.setQtdPassageiros(qtdPassageiros);
		novoVeiculoPasseio.setMarca(marca);
		novoVeiculoPasseio.setModelo(modelo);
		novoVeiculoPasseio.setCor(cor);
		int qtdRodas = Integer.parseInt(qtdRodasStr);
		novoVeiculoPasseio.setQtdRodas(qtdRodas);
		float velocMax = Float.parseFloat(velocMaxStr);
		if(velocMax < 80 || velocMax > 110) {	
			if (velocMax < 80)
				velocMax = 90;
			if (velocMax > 100)
				velocMax = 100;	
			throw new VelocException();
		}
		novoVeiculoPasseio.setVelocMax(velocMax);
		novoVeiculoPasseio.setMotor(new Motor());
		int qtdPistoes = Integer.parseInt(qtdPistoesStr);
		novoVeiculoPasseio.getMotor().setQtdPist(qtdPistoes);
		int potencia = Integer.parseInt(potenciaStr);
		novoVeiculoPasseio.getMotor().setPotencia(potencia);

		veiculoPasseio.add(novoVeiculoPasseio);
		int soma = novoVeiculoPasseio.calcular(veiculoPasseio);

		return false;
	}
	
	private static Passeio imprimirPlacaPasseio(List<Passeio> veiculoPasseio, String placa) {
		boolean existe = false;
		Passeio passeioDados = new Passeio();
		for(int z = 0; z < veiculoPasseio.size(); z++) {
			if(veiculoPasseio.get(z) != null && veiculoPasseio.get(z).getPlaca().contains(placa)) {
				existe = true;
				passeioDados.setQtdPassageiros(veiculoPasseio.get(z).getQtdPassageiros());
				passeioDados.setMarca(veiculoPasseio.get(z).getMarca());
				passeioDados.setModelo(veiculoPasseio.get(z).getModelo());
				passeioDados.setCor(veiculoPasseio.get(z).getCor());
				passeioDados.setQtdRodas(veiculoPasseio.get(z).getQtdRodas());
				passeioDados.setVelocMax(veiculoPasseio.get(z).getVelocMax());
				passeioDados.setMotor(new Motor());
				passeioDados.getMotor().setQtdPist(veiculoPasseio.get(z).getMotor().getQtdPist());
				passeioDados.getMotor().setPotencia(veiculoPasseio.get(z).getMotor().getPotencia());
			}
		}

		if(existe == false)
			System.out.println("Placa informada não consta no cadastro.");
		
		return passeioDados;
		
	}
	

	public static void excluirPlacaPasseio(List<Passeio> veiculoPasseio, String placa) {
		boolean existe = false;
		for(int z = 0; z < veiculoPasseio.size(); z++) {
			if(veiculoPasseio.get(z) != null && veiculoPasseio.get(z).getPlaca().contains(placa)) {
				existe = true;
				veiculoPasseio.remove(z);
				System.out.println("Veiculo de placa " + placa + " removido.");
			}
		}
		if(existe == false)
			System.out.println("Placa informada não consta no cadastro.");
	}
	

	private static Carga imprimirPlacaCarga(List<Carga> veiculoCarga, String placa) {

		boolean existe = false;
		Carga cargaDados = new Carga();
		for(int z = 0; z < veiculoCarga.size(); z++) {
			if(veiculoCarga.get(z) != null && veiculoCarga.get(z).getPlaca().contains(placa)) {
				existe = true;
				cargaDados.setCor(veiculoCarga.get(z).getCor());
				cargaDados.setMarca(veiculoCarga.get(z).getMarca());
				cargaDados.setModelo(veiculoCarga.get(z).getModelo());
				cargaDados.setMotor(new Motor());
				cargaDados.getMotor().setPotencia(veiculoCarga.get(z).getMotor().getPotencia());
				cargaDados.getMotor().setQtdPist(veiculoCarga.get(z).getMotor().getQtdPist());
				cargaDados.setPlaca(veiculoCarga.get(z).getPlaca());
				cargaDados.setQtdRodas(veiculoCarga.get(z).getQtdRodas());		
				cargaDados.setCargaMax(veiculoCarga.get(z).getCargaMax());
				cargaDados.setTara(veiculoCarga.get(z).getTara());
			}
		}

		if(existe == false)
			System.out.println("Placa informada não consta no cadastro.");
		
		return cargaDados;

	}

	private static void excluirPlacaCarga(List<Carga> veiculoCarga, String placa) {
		boolean existe = false;
		for(int z = 0; z < veiculoCarga.size(); z++) {
			if(veiculoCarga.get(z) != null && veiculoCarga.get(z).getPlaca().contains(placa)) {
				existe = true;
				veiculoCarga.remove(z);
				System.out.println("Veiculo de placa " + placa + " removido.");
			}
		}
		if(existe == false)
			System.out.println("Placa informada não consta no cadastro.");
	}

}

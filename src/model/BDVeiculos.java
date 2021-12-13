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

	public static void imprimirVeiculosCargaPlaca(String placa) throws IOException {
		imprimirPlacaCarga(veiculoCarga, placa);
	}

	public static void imprimirVeiculosPasseioPlaca(String placa) throws IOException {
		imprimirPlacaPasseio(veiculoPasseio, placa);
	}

	public static void imprimirVeiculosCarga() {
		imprimirCarga(veiculoCarga);
	}

	public static void imprimirVeiculosPasseio() {
		imprimirPasseio(veiculoPasseio);
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
	
	private static void imprimirPlacaPasseio(List<Passeio> veiculoPasseio, String placa) {
		boolean existe = false;
		for(int z = 0; z < veiculoPasseio.size(); z++) {
			if(veiculoPasseio.get(z) != null && veiculoPasseio.get(z).getPlaca().contains(placa)) {
				existe = true;
				System.out.println("Cor: " + veiculoPasseio.get(z).getCor());
				System.out.println("Marca: " + veiculoPasseio.get(z).getMarca());
				System.out.println("Modelo: " + veiculoPasseio.get(z).getModelo());
				System.out.println("Potencia: " +veiculoPasseio.get(z).getMotor().getPotencia());
				System.out.println("Pistoes: " + veiculoPasseio.get(z).getMotor().getQtdPist());
				System.out.println("Placa: " + veiculoPasseio.get(z).getPlaca());
				System.out.println("Rodas: " + veiculoPasseio.get(z).getQtdRodas());		
				System.out.println("Velocidade (cm/h): " + veiculoPasseio.get(z).calcVel((veiculoPasseio.get(z).getVelocMax())));
				System.out.println("\n");
			}
		}

		if(existe == false)
			System.out.println("Placa informada não consta no cadastro.");

	}

	private static void imprimirPasseio(List<Passeio> veiculoPasseio) {
		for(int z = 0; z < veiculoPasseio.size(); z++) {
			System.out.println("Cor: " + veiculoPasseio.get(z).getCor());
			System.out.println("Marca: " + veiculoPasseio.get(z).getMarca());
			System.out.println("Modelo: " + veiculoPasseio.get(z).getModelo());
			System.out.println("Potencia: " + veiculoPasseio.get(z).getMotor().getPotencia());
			System.out.println("Pistoes: " + veiculoPasseio.get(z).getMotor().getQtdPist());
			System.out.println("Placa: " + veiculoPasseio.get(z).getPlaca());
			System.out.println("Rodas: " + veiculoPasseio.get(z).getQtdRodas());
			System.out.println("Velocidade (cm/h): " + veiculoPasseio.get(z).calcVel((veiculoPasseio.get(z).getVelocMax())));
			System.out.println("\n");
		}
	}

	private static void excluirPlacaPasseio(List<Passeio> veiculoPasseio, String placa) {
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
	

	private static void imprimirPlacaCarga(List<Carga> veiculoCarga, String placa) {

		boolean existe = false;
		for(int z = 0; z < veiculoCarga.size(); z++) {
			if(veiculoCarga.get(z) != null && veiculoCarga.get(z).getPlaca().contains(placa)) {
				existe = true;
				System.out.println("Cor: " + veiculoCarga.get(z).getCor());
				System.out.println("Marca: " + veiculoCarga.get(z).getMarca());
				System.out.println("Modelo: " + veiculoCarga.get(z).getModelo());
				System.out.println("Potencia: " +veiculoCarga.get(z).getMotor().getPotencia());
				System.out.println("Pistoes: " + veiculoCarga.get(z).getMotor().getQtdPist());
				System.out.println("Placa: " + veiculoCarga.get(z).getPlaca());
				System.out.println("Rodas: " + veiculoCarga.get(z).getQtdRodas());		
				System.out.println("Velocidade (cm/h): " + veiculoCarga.get(z).calcVel((veiculoCarga.get(z).getVelocMax())));
				System.out.println("\n");
			}
		}

		if(existe == false)
			System.out.println("Placa informada não consta no cadastro.");

	}

	private static void imprimirCarga(List<Carga> veiculoCarga) {

		for(int z = 0; z < veiculoCarga.size(); z++) {
			System.out.println("Cor: " + veiculoCarga.get(z).getCor());
			System.out.println("Marca: " + veiculoCarga.get(z).getMarca());
			System.out.println("Modelo: " + veiculoCarga.get(z).getModelo());
			System.out.println("Potencia: " + veiculoCarga.get(z).getMotor().getPotencia());
			System.out.println("Pistoes: " + veiculoCarga.get(z).getMotor().getQtdPist());
			System.out.println("Placa: " + veiculoCarga.get(z).getPlaca());
			System.out.println("Rodas: " + veiculoCarga.get(z).getQtdRodas());
			System.out.println("Velocidade (cm/h): " + veiculoCarga.get(z).calcVel((veiculoCarga.get(z).getVelocMax())));
			System.out.println("\n");
		}

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

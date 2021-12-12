package model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BDVeiculos {
	
	public static List<Passeio> veiculoPasseio = new ArrayList<Passeio>();
	public static List<Carga> veiculoCarga = new ArrayList<Carga>();
	public static Leitura leitura = new Leitura();
	
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
	
	protected static void excluirVeiculosCargaPlaca() throws IOException {
		System.out.println("Qual a placa do veiculo que deseja remover?");	
		String placa = null;
		placa = leitura.entDados(placa);
		excluirPlacaCarga(veiculoCarga, placa);
	}

	protected static void excluirVeiculosPasseioPlaca() throws IOException {
		System.out.println("Qual a placa do veiculo que deseja remover?");	
		String placa = null;
		placa = leitura.entDados(placa);
		excluirPlacaPasseio(veiculoPasseio, placa);
	}

	protected static void imprimirVeiculosCargaPlaca() throws IOException {
		System.out.println("Qual placa esta procurando?");	
		String placa = null;
		placa = leitura.entDados(placa);
		imprimirPlacaCarga(veiculoCarga, placa);
	}

	protected static void imprimirVeiculosPasseioPlaca() throws IOException {
		System.out.println("Qual placa esta procurando?");
		String placa = null;
		placa = leitura.entDados(placa);
		imprimirPlacaPasseio(veiculoPasseio, placa);
	}

	protected static void imprimirVeiculosCarga() {
		System.out.println("Lista de veículos de carga\n");
		imprimirCarga(veiculoCarga);
	}

	protected static void imprimirVeiculosPasseio() {
		System.out.println("Lista de veículos de passeio\n");
		imprimirPasseio(veiculoPasseio);
	}


	public static void cadastrarVeiculoPasseio() throws IOException, VeicExistException, VelocException {
		boolean placaExiste = cadastroPasseio();
		if(placaExiste == false) {		
			Veiculo novoVeiculoPasseio = new Passeio();
			veiculoPasseio.add((Passeio) novoVeiculoPasseio);
			int soma = novoVeiculoPasseio.calcular(veiculoPasseio);
			System.out.println("Soma dos atributos int " + soma);
		}
	}

	public static void cadastrarVeiculoCarga() throws IOException, VeicExistException, VelocException {
		boolean placaExiste = cadastroCarga();
		if(placaExiste == false) {		
			Veiculo novoVeiculoCarga = new Carga();
			veiculoCarga.add((Carga) novoVeiculoCarga);
			int soma = novoVeiculoCarga.calcular(veiculoCarga);
			System.out.println("Soma dos atributos int " + soma);
		}
	}

	@SuppressWarnings("resource")
	private static boolean cadastroCarga() throws IOException, VeicExistException, VelocException {
		Carga novoVeiculoCarga;
		System.out.println("Qual a placa do veiculo?");
		String placa = null;
		placa = leitura.entDados(placa);

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

		System.out.println("Qual a cor do veiculo?");
		String cor = null;
		cor = leitura.entDados(cor);
		novoVeiculoCarga.setCor(cor);

		System.out.println("Qual a marca do veiculo?");
		String marca = null;
		marca = leitura.entDados(marca);
		novoVeiculoCarga.setMarca(marca);

		System.out.println("Qual o modelo do veiculo?");
		String modelo = null;
		modelo = leitura.entDados(modelo);
		novoVeiculoCarga.setModelo(modelo);

		novoVeiculoCarga.setMotor(new Motor());
		System.out.println("Qual a potencia do veiculo?");
		String potenciaStr = null;
		potenciaStr = leitura.entDados(potenciaStr);
		int potencia = Integer.parseInt(potenciaStr);
		novoVeiculoCarga.getMotor().setPotencia(potencia);

		System.out.println("Quantos pistoes o veiculo tem?");
		String qtdPistoesStr = null;
		qtdPistoesStr = leitura.entDados(qtdPistoesStr);
		int qtdPistoes = Integer.parseInt(qtdPistoesStr);
		novoVeiculoCarga.getMotor().setQtdPist(qtdPistoes);

		System.out.println("Qual a quantidade de rodas do veiculo?");
		String qtdRodasStr = null;
		qtdRodasStr = leitura.entDados(qtdRodasStr);
		int qtdRodas = Integer.parseInt(qtdRodasStr);
		novoVeiculoCarga.setQtdRodas(qtdRodas);

		System.out.println("Qual a velocidade maxima do veiculo?");
		String velocMaxStr = null;
		velocMaxStr = leitura.entDados(velocMaxStr);
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
		System.out.println("Soma dos atributos int " + soma);

		System.out.println("Deseja cadastrar outro veiculo?");
		System.out.println("1. Sim");
		System.out.println("2. Nao");
		String continuarStr = null;
		continuarStr = leitura.entDados(continuarStr);
		int continuar = Integer.parseInt(continuarStr);

		if(continuar == 1) {
			System.out.println("1. Passeio");
			System.out.println("2. Carga");
			String opcaoStr = null;
			opcaoStr = leitura.entDados(opcaoStr);
			int opcao = Integer.parseInt(opcaoStr);

			switch (opcao) {
			case 1:
				cadastrarVeiculoPasseio();
				break;
			case 2:
				cadastrarVeiculoCarga();
				break;
			default:
				System.out.print("\nOpção Invalida!");
				break;		
			}
		}
		return false;
	}

	private static boolean cadastroPasseio() throws IOException, VeicExistException, VelocException {

		Passeio novoVeiculoPasseio;
		System.out.println("Qual a placa do veiculo?");
		String placa = null;
		placa = leitura.entDados(placa);

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

		System.out.println("Qual a cor do veiculo?");
		String cor = null;
		cor = leitura.entDados(cor);
		novoVeiculoPasseio.setCor(cor);

		System.out.println("Qual a marca do veiculo?");
		String marca = null;
		marca = leitura.entDados(marca);
		novoVeiculoPasseio.setMarca(marca);

		System.out.println("Qual o modelo do veiculo?");
		String modelo = null;
		modelo = leitura.entDados(modelo);
		novoVeiculoPasseio.setModelo(modelo);

		novoVeiculoPasseio.setMotor(new Motor());
		System.out.println("Qual a potencia do veiculo?");
		String potenciaStr = null;
		potenciaStr = leitura.entDados(potenciaStr);
		int potencia = Integer.parseInt(potenciaStr);
		novoVeiculoPasseio.getMotor().setPotencia(potencia);

		System.out.println("Quantos pistoes o veiculo tem?");
		String qtdPistoesStr = null;
		qtdPistoesStr = leitura.entDados(qtdPistoesStr);
		int qtdPistoes = Integer.parseInt(qtdPistoesStr);
		novoVeiculoPasseio.getMotor().setQtdPist(qtdPistoes);

		System.out.println("Qual a quantidade de rodas do veiculo?");
		String qtdRodasStr = null;
		qtdRodasStr = leitura.entDados(qtdRodasStr);
		int qtdRodas = Integer.parseInt(qtdRodasStr);
		novoVeiculoPasseio.setQtdRodas(qtdRodas);

		System.out.println("Qual a velocidade maxima do veiculo?");
		String velocMaxStr = null;
		velocMaxStr = leitura.entDados(velocMaxStr);
		float velocMax = Float.parseFloat(velocMaxStr);
		if(velocMax < 80 || velocMax > 110) {	
			if (velocMax < 80)
				velocMax = 90;
			if (velocMax > 100)
				velocMax = 100;	
			throw new VelocException();
		}
		novoVeiculoPasseio.setVelocMax(velocMax);

		veiculoPasseio.add(novoVeiculoPasseio);
		int soma = novoVeiculoPasseio.calcular(veiculoPasseio);

		System.out.println("Soma dos atributos int " + soma);

		System.out.println("Deseja cadastrar outro veiculo?");
		System.out.println("1. Sim");
		System.out.println("2. Nao");
		String continuarStr = null;
		continuarStr = leitura.entDados(continuarStr);
		int continuar = Integer.parseInt(continuarStr);

		if(continuar == 1) {
			System.out.println("1. Passeio");
			System.out.println("2. Carga");
			String opcaoStr = null;
			opcaoStr = leitura.entDados(opcaoStr);
			int opcao = Integer.parseInt(opcaoStr);
			switch (opcao) {
			case 1:
				cadastrarVeiculoPasseio();
				break;
			case 2:
				cadastrarVeiculoCarga();
				break;
			default:
				System.out.print("\nOpção Invalida!");
				break;		
			}
		}
		return false;
	}
	
	public static void imprimirPlacaPasseio(List<Passeio> veiculoPasseio, String placa) {
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

	public static void imprimirPasseio(List<Passeio> veiculoPasseio) {
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
	

	public static void imprimirPlacaCarga(List<Carga> veiculoCarga, String placa) {

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

	public static void imprimirCarga(List<Carga> veiculoCarga) {

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

	public static void excluirPlacaCarga(List<Carga> veiculoCarga, String placa) {
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

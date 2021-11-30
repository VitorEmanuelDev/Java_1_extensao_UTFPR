package model;

import java.io.IOException;
import java.util.List;

public class Teste extends BDVeiculos{

	public static Leitura leitura = new Leitura();

	public static void menu() {
		System.out.print("Sistema de Gestao de veículos - Menu Inicial\n\n");
		System.out.print("1. Cadastrar Veiculo de Passeio\n");
		System.out.print("2. Cadastrar Veiculo de Carga\n");
		System.out.print("3. Imprimir Todos os Veiculos de Passeio\n");
		System.out.print("4. Imprimir Todos os Veiculos de Carga\n");
		System.out.print("5. Imprimir Veiculo de Passeio pela Placa\n");
		System.out.print("6. Imprimir Veiculo de Carga pela Placa\n");
		System.out.print("7. Excluir Veiculo de Passeio pela Placa\n");
		System.out.print("8. Excluir Veiculo de Carga pela Placa\n");
		System.out.print("9. Sair do Sistema\n");

	}

	public static void main(String [] args ) throws IOException, VeicExistException, VelocException {

		int opcao;

		do {
			menu();

			String opcaoStr = null;
			opcaoStr = leitura.entDados(opcaoStr);
			opcao = Integer.parseInt(opcaoStr);

			switch (opcao) {
			case 1:
				cadastrarVeiculoPasseio();
				break;

			case 2:
				cadastrarVeiculoCarga();
				break;

			case 3:
				imprimirVeiculosPasseio();
				break;
			case 4:
				imprimirVeiculosCarga();
				break;
			case 5:
				imprimirVeiculosPasseioPlaca();
				break;
			case 6:
				imprimirVeiculosCargaPlaca();
				break;
			case 7:
				excluirVeiculosPasseioPlaca();
				break;
			case 8:
				excluirVeiculosCargaPlaca();
				break;

			default:
				System.out.print("\nOpção Inválida!");
				break;

			case 9:
				System.out.print("\nDesligando...");

			}

		}while(opcao != 7);

	}

}

package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JTextField;

import model.BDVeiculos;
import model.Carga;
import model.Passeio;
import model.VeicExistException;
import model.Veiculo;
import model.VelocException;

public class BotaoCadastrarVeiculos implements ActionListener {

	BDVeiculos cadastrar;
	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField3;
	private JTextField textField4;
	private JTextField textField5;
	private JTextField textField6;
	private JTextField textField7;
	private JTextField textField8;
	private JTextField textField9;
	private JTextField textFieldExtra;
	private boolean tipo;

	public BotaoCadastrarVeiculos(boolean tipo, JTextField textField1, JTextField textField2, JTextField textField3, JTextField textField4, JTextField textField5, JTextField textField6, JTextField textField7, JTextField textField8, JTextField textField9, JTextField textFieldExtra) {
		this.textField1 = textField1;
		this.textField2 = textField2;
		this.textField3 = textField3;
		this.textField4 = textField4;
		this.textField5 = textField5;
		this.textField6 = textField6;
		this.textField7 = textField7;
		this.textField8 = textField8;
		this.textField9 = textField9;
		if(tipo == true)
			this.textFieldExtra = textFieldExtra;
		this.tipo = tipo;
		cadastrar = new BDVeiculos();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String qtdPassageirosStr = null;
		String taraStr = null;
		String cargaMaxStr = null;

		if(tipo == false) 
			qtdPassageirosStr = textField1.getText();

		String placa = textField2.getText();
		String marca = textField3.getText();
		String modelo = textField4.getText();
		String cor = textField5.getText();
		String qtdRodasStr = textField6.getText();
		String velocMaxStr = textField7.getText();
		String qtdPistoesStr = textField8.getText();
		String potenciaStr = textField9.getText();

		if(tipo == true) {
			taraStr = textField1.getText();
			cargaMaxStr = textField9.getText();
		}
		if(tipo == false) {
			try {
				BDVeiculos.cadastrarVeiculoPasseio(placa, qtdPassageirosStr ,marca, modelo, cor, qtdRodasStr, velocMaxStr, qtdPistoesStr, potenciaStr);
			} catch (IOException | VeicExistException | VelocException e1) {
				e1.printStackTrace();
			}
		}else {
			try {
				BDVeiculos.cadastrarVeiculoCarga(placa, taraStr, cargaMaxStr, marca, modelo, cor, qtdRodasStr, velocMaxStr, qtdPistoesStr, potenciaStr);
			} catch (IOException | VeicExistException | VelocException e1) {
				e1.printStackTrace();
			}
		}
	}
}

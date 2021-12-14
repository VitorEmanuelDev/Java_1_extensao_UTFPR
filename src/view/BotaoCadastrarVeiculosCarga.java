package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.BDVeiculos;
import model.VeicExistException;
import model.VelocException;

public class BotaoCadastrarVeiculosCarga implements ActionListener {

	BDVeiculos cadastrar;
	JTextField textField1;
	JTextField textField2;
	JTextField textField3;
	JTextField textField4;
	JTextField textField5;
	JTextField textField6;
	JTextField textField7;
	JTextField textField8;
	JTextField textField9;
	JTextField textFieldExtra;
	JFrame jan1;

	public BotaoCadastrarVeiculosCarga(JFrame jan1, JTextField textField1, JTextField textField2, JTextField textField3, JTextField textField4, JTextField textField5, JTextField textField6, JTextField textField7, JTextField textField8, JTextField textField9, JTextField textFieldExtra) {
		this.jan1 = jan1;
		this.textField1 = textField1;
		this.textField2 = textField2;
		this.textField3 = textField3;
		this.textField4 = textField4;
		this.textField5 = textField5;
		this.textField6 = textField6;
		this.textField7 = textField7;
		this.textField8 = textField8;
		this.textField9 = textField9;
		this.textFieldExtra = textFieldExtra;
		cadastrar = new BDVeiculos();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String placa = textField2.getText();
		String marca = textField3.getText();
		String modelo = textField4.getText();
		String cor = textField5.getText();
		String qtdRodasStr = textField6.getText();
		String velocMaxStr = textField7.getText();
		String qtdPistoesStr = textField8.getText();
		String potenciaStr = textField9.getText();
		String taraStr = textField1.getText();
		String cargaMaxStr = textField9.getText();

		try {
			BDVeiculos.cadastrarVeiculoCarga(placa, taraStr, cargaMaxStr, marca, modelo, cor, qtdRodasStr, velocMaxStr, qtdPistoesStr, potenciaStr);
			JOptionPane.showMessageDialog(jan1, "Veiculo de carga excluido!");
		} catch (IOException | VeicExistException | VelocException e1) {
			e1.printStackTrace();
		}
	}
}

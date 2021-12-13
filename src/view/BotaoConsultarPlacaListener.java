package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JTextField;

import model.BDVeiculos;
import model.VeicExistException;
import model.VelocException;

public class BotaoConsultarPlacaListener implements ActionListener {

	BDVeiculos cadastrar;
	boolean tipo;
	JTextField textField2;

	public BotaoConsultarPlacaListener(boolean tipo, JTextField textField2) {
		this.tipo = tipo;
		this.textField2 = textField2;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String placa = textField2.getText();
		
		if(tipo == false) {
			try {
				BDVeiculos.imprimirVeiculosPasseioPlaca(placa);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}else {
			try {
				BDVeiculos.imprimirVeiculosCargaPlaca(placa);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

}

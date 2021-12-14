package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.BDVeiculos;

public class BotaoExcluirPlacaPasseio implements ActionListener {

	BDVeiculos cadastrar;
	JTextField textField2;
	JFrame jan1;

	public BotaoExcluirPlacaPasseio(JFrame jan1, JTextField textField2) {
		this.jan1 = jan1;
		this.textField2 = textField2;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String placa = textField2.getText();

		try {
			BDVeiculos.excluirVeiculosPasseioPlaca(placa);
			JOptionPane.showMessageDialog(jan1, "Veiculo de passeio excluido!");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}

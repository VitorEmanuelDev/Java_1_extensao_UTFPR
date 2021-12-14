package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.BDVeiculos;
import model.Passeio;


public class BotaoConsultarPlacaPasseio implements ActionListener {

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
	private JFrame jan1;

	public BotaoConsultarPlacaPasseio(JFrame jan1, JTextField textField1, JTextField textField2, JTextField textField3, JTextField textField4, JTextField textField5, JTextField textField6, JTextField textField7, JTextField textField8, JTextField textField9) {
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
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String placa = textField2.getText();
		Passeio passeioDados = null;

		try {
			passeioDados = BDVeiculos.imprimirVeiculosPasseioPlaca(placa);
			if(passeioDados != null) {
				int qtdPassageiros = passeioDados.getQtdPassageiros();
				String qtdPassageirosStr = Integer.toString(qtdPassageiros);
				textField1.setText(qtdPassageirosStr);

				String marca = passeioDados.getMarca();
				textField3.setText(marca);
				String modelo = passeioDados.getModelo();
				textField4.setText(modelo);
				String cor = passeioDados.getCor();
				textField5.setText(cor);
				int rodas = passeioDados.getQtdRodas();
				String rodasStr = Integer.toString(rodas);
				textField6.setText(rodasStr);
				float velocidade = passeioDados.getVelocMax();
				String velocidadeMaxStr = Integer.toString((int) velocidade);
				textField7.setText(velocidadeMaxStr);
				int pistoes = passeioDados.getMotor().getQtdPist();
				String pistoesStr = Integer.toString(pistoes);
				textField8.setText(pistoesStr);
				int potencia = passeioDados.getMotor().getPotencia();
				String potenciaStr = Integer.toString(potencia);
				textField9.setText(potenciaStr);
			}else {
				textField1.setText("");
				textField3.setText("");
				textField4.setText("");
				textField5.setText("");
				textField6.setText("");
				textField7.setText("");
				textField8.setText("");
				textField9.setText("");
				JOptionPane.showMessageDialog(jan1, "Veiculo de passeio nao encontrado!");

			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}

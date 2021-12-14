package view;

import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class JanelaConsultarExcluirPlacaPasseio  implements ActionListener{
	private static JFrame jan1 = new JFrame();
	private static JButton btnConsultar = new JButton("Consultar");
	private static JButton btnExcluir = new JButton("Excluir");
	private static JButton btnSair = new JButton("Sair");
	private static JTextField textField1 = new JTextField(15);
	private static JTextField textField2 = new JTextField(15);
	private static JTextField textField3 = new JTextField(15);
	private static JTextField textField4 = new JTextField(15);
	private static JTextField textField5 = new JTextField(15);
	private static JTextField textField6 = new JTextField(15);
	private static JTextField textField7 = new JTextField(15);
	private static JTextField textField8 = new JTextField(15);
	private static JTextField textField9 = new JTextField(15);
	private static JLabel label1 = new JLabel();
	private static JLabel label2 = new JLabel();
	private static JLabel label3 = new JLabel();
	private static JLabel label4 = new JLabel();
	private static JLabel label5 = new JLabel();
	private static JLabel label6 = new JLabel();
	private static JLabel label7 = new JLabel();
	private static JLabel label8 = new JLabel();
	private static JLabel label9 = new JLabel();

	@Override
	public void actionPerformed(ActionEvent e) {
		janelaExcluirPlacaVeiculosPasseio();
	}

	public void janelaExcluirPlacaVeiculosPasseio() {
		int larg = 200, alt = 550;
		jan1.setSize(larg, alt); 
		jan1.setLayout(new FlowLayout());
		jan1.setTitle("Consultar/Excluir pela placa"); 
		jan1.add(label2);
		jan1.add(textField2);
		label2.setText("Informe a placa");
		label1.setText("Qtd. Passageiros");
		jan1.add(label1);
		jan1.add(textField1);
		label3.setText("Marca");
		jan1.add(label3);
		jan1.add(textField3);
		label4.setText("Modelo");
		jan1.add(label4);
		jan1.add(textField4);
		label5.setText("Cor");
		jan1.add(label5);
		jan1.add(textField5);
		label6.setText("Qtd. Rodas");
		jan1.add(label6);
		jan1.add(textField6);
		label7.setText("Velocidade Max");
		jan1.add(label7);
		jan1.add(textField7);
		label8.setText("Qtd Pistoes");
		jan1.add(label8);
		jan1.add(textField8);
		jan1.add(label9);
		jan1.add(textField9);
		label9.setText("Potencia");

		jan1.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		jan1.add(btnConsultar);
		jan1.add(btnExcluir);
		jan1.add(btnSair);

		btnConsultar.addActionListener(new BotaoConsultarPlacaPasseio(jan1, textField1, textField2, textField3, textField4, textField5, textField6, textField7, textField8, textField9));
		btnExcluir.addActionListener(new BotaoExcluirPlacaPasseio(jan1, textField2));
		btnSair.addActionListener(new BotaoSairListener(jan1));
		jan1.setVisible(true); 
	}
}

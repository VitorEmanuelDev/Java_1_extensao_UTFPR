package view;

import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class JanelaPasseioListener implements ActionListener {
	
	private static JFrame jan1 = new JFrame();
	private static JLabel rtCod1 = new JLabel();
	private static JLabel rtCod2 = new JLabel();
	private static JLabel rtCod3 = new JLabel();
	private static JLabel rtCod4 = new JLabel();
	private static JButton btnCadastrar = new JButton();
	private static JButton btnConsultarExcluirPlaca = new JButton();
	private static JButton btnConsultarExcluirTodos = new JButton();
	private static JButton btnSair = new JButton();
	
	@Override
	public void actionPerformed(ActionEvent e) {
		veiculosDePasseioMenu();
	}

	public void veiculosDePasseioMenu() {
		int larg = 300, alt = 150;
		jan1.setSize(larg, alt); 
		jan1.setTitle("Veiculos de Passeio"); 
		jan1.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		rtCod1.setText("Cadastrar");
		jan1.add(rtCod1);
		jan1.add(btnCadastrar);
		rtCod2.setText("Consultar/Excluir por placa");
		jan1.add(rtCod2);
		jan1.add(btnConsultarExcluirPlaca);
		rtCod3.setText("Consultar/Excluir todos");
		jan1.add(rtCod3);
		jan1.add(btnConsultarExcluirTodos);
		rtCod4.setText("Sair");
		jan1.add(rtCod4);
		jan1.add(btnSair);
		btnCadastrar.addActionListener(new BotaoCadastrarPasseio());
		btnConsultarExcluirPlaca.addActionListener(new JanelaConsultarExcluirPlacaPasseio());
		btnConsultarExcluirTodos.addActionListener(new BotaoConsultarExcluirTodosPasseio());
		btnSair.addActionListener(new BotaoSairListener(jan1));
		jan1.setLayout(new FlowLayout());
		jan1.setVisible(true); 
	}

}

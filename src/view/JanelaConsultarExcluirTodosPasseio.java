package view;

import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.BDVeiculos;

public class JanelaConsultarExcluirTodosPasseio implements ActionListener{

	BDVeiculos listaVeiculos = new BDVeiculos();
	JScrollPane jspane;
	JFrame jan1 = new JFrame();
	JButton btnImprimir = new JButton("Imprimir Todos");
	JButton btnExcluir = new JButton("Excluir Todos");
	JButton btnSair = new JButton("Sair");
	int tamanhoListaPasseio = BDVeiculos.getVeiculoPasseio().size();
	Object[][] dadosPasseio = new Object[tamanhoListaPasseio][8];

	@Override
	public void actionPerformed(ActionEvent e) {
		janelaConsultarExcluirTodosPasseio();
	}

	public void janelaConsultarExcluirTodosPasseio() {
		int larg = 510, alt = 220;
		jan1.setSize(larg, alt); 
		jan1.setLayout(new FlowLayout());
		jan1.setTitle("Imprimir/Excluir todos"); 
		String[] colunas = new String[] {
				"Placa", "Marca", "Modelo", "Cor", "Qtd. Rodas",
				"Veloc. Max.", "Qtd. Pist", "Potenc", "Qtd. Passag"
		};
		JTable tabela = new JTable(dadosPasseio, colunas);
		tabela.setDefaultEditor(Object.class, null);
		tabela.setShowGrid(false);
		tabela.setForeground(Color.BLACK);
		tabela.setFillsViewportHeight(true);
		tabela.setBackground(Color.WHITE);
		tabela.getTableHeader().setBackground(Color.WHITE);
		tabela.getTableHeader().setForeground(Color.BLACK);
		tabela.getAutoResizeMode();
		jan1.getContentPane().setBackground(Color.WHITE);
		jan1.setResizable(true);
		jan1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		jspane = new JScrollPane(tabela);
		jspane.setSize(180, 50);
		jspane.setBackground(Color.WHITE);
		jan1.add(jspane);  
		jan1.pack();
		jan1.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		jan1.add(btnImprimir);
		jan1.add(btnExcluir);
		jan1.add(btnSair);
		btnImprimir.addActionListener(popularTabela());
		btnExcluir.addActionListener(excluirTodos());
		btnSair.addActionListener(new BotaoSairListener(jan1));
		jan1.setVisible(true); 
		jspane.setVisible(true);
	}

	private ActionListener excluirTodos() {
		BDVeiculos.getVeiculoPasseio().clear();
		return null;
	}

	public ActionListener popularTabela(){

		for (int i = 0; i < BDVeiculos.getVeiculoPasseio().size(); i++) {
			dadosPasseio[i][0] = BDVeiculos.getVeiculoPasseio().get(i).getPlaca();
			dadosPasseio[i][1] = BDVeiculos.getVeiculoPasseio().get(i).getMarca();
			dadosPasseio[i][2] = BDVeiculos.getVeiculoPasseio().get(i).getModelo();
			dadosPasseio[i][3] = BDVeiculos.getVeiculoPasseio().get(i).getCor();
			dadosPasseio[i][4] = BDVeiculos.getVeiculoPasseio().get(i).getQtdRodas();
			dadosPasseio[i][5] = BDVeiculos.getVeiculoPasseio().get(i).getVelocMax();
			dadosPasseio[i][6] = BDVeiculos.getVeiculoPasseio().get(i).getMotor().getQtdPist();
			dadosPasseio[i][7] = BDVeiculos.getVeiculoPasseio().get(i).getMotor().getPotencia();
			dadosPasseio[i][8] = BDVeiculos.getVeiculoPasseio().get(i).getQtdPassageiros();
		}

		return null;	
	}
}
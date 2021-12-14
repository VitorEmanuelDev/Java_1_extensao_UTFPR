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

public class JanelaConsultarExcluirTodosCarga implements ActionListener{

	BDVeiculos listaVeiculos = new BDVeiculos();
	JScrollPane jspane;
	JFrame jan1 = new JFrame();
	JButton btnImprimir = new JButton("Imprimir Todos");
	JButton btnExcluir = new JButton("Excluir Todos");
	JButton btnSair = new JButton("Sair");

	int tamanhoListaCarga = BDVeiculos.getVeiculoCarga().size();
	Object[][] dadosCarga = new Object[tamanhoListaCarga][9];

	@Override
	public void actionPerformed(ActionEvent e) {
		janelaConsultarExcluirTodosCarga();
	}

	public void janelaConsultarExcluirTodosCarga() {
		int larg = 510, alt = 220;
		jan1.setSize(larg, alt); 
		jan1.setLayout(new FlowLayout());
		jan1.setTitle("Imprimir/Excluir todos"); 
		String[] colunas = new String[] {
				"Placa", "Marca", "Modelo", "Cor", "Qtd. Rodas",
				"Veloc. Max.", "Qtd. Pist", "Potenc", "Tara", "Carga Max"
		};
		JTable tabela = new JTable(dadosCarga, colunas);
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
		jspane.setSize(220, 50);
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
		BDVeiculos.getVeiculoCarga().clear();
		return null;
	}

	public ActionListener popularTabela(){

		for (int i = 0; i < BDVeiculos.getVeiculoCarga().size(); i++) {
			dadosCarga[i][0] = BDVeiculos.getVeiculoCarga().get(i).getPlaca();
			dadosCarga[i][1] = BDVeiculos.getVeiculoCarga().get(i).getMarca();
			dadosCarga[i][2] = BDVeiculos.getVeiculoCarga().get(i).getModelo();
			dadosCarga[i][3] = BDVeiculos.getVeiculoCarga().get(i).getCor();
			dadosCarga[i][4] = BDVeiculos.getVeiculoCarga().get(i).getQtdRodas();
			dadosCarga[i][5] = BDVeiculos.getVeiculoCarga().get(i).getVelocMax();
			dadosCarga[i][6] = BDVeiculos.getVeiculoCarga().get(i).getMotor().getQtdPist();
			dadosCarga[i][7] = BDVeiculos.getVeiculoCarga().get(i).getMotor().getPotencia();
			dadosCarga[i][8] = BDVeiculos.getVeiculoCarga().get(i).getTara();
			dadosCarga[i][9] = BDVeiculos.getVeiculoCarga().get(i).getCargaMax();
		}

		return null;	
	}
}
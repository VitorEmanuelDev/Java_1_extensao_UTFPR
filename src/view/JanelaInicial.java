package view;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;
public class JanelaInicial {
	
	private static JFrame jan1 = new JFrame();
	private static JLabel rtCod1 = new JLabel();
	private static JLabel rtCod2 = new JLabel();
	private static JButton btnPasseio = new JButton();
	private static JButton btnCarga = new JButton();
	
	public static void main(String args[]){
		criarJanelaInicial();
	}

	public static void criarJanelaInicial(){
		int larg = 300, alt = 150;
		jan1.setSize(larg, alt); 
		jan1.setTitle("Gestão de veículos"); 
		jan1.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		rtCod1.setText("Passeio");
		jan1.add(rtCod1);
		jan1.add(btnPasseio);
		rtCod2.setText("Carga");
		jan1.add(rtCod2);
		jan1.add(btnCarga);
		jan1.setLayout(new FlowLayout());
		jan1.setVisible(true); 
		btnPasseio.addActionListener(new JanelaPasseioListener());
		btnCarga.addActionListener(new JanelaCargaListener());
	}
}
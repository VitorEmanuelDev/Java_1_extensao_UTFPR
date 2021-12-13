package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class BotaoSairListener implements ActionListener {
	
	JFrame jan1;
	
	public BotaoSairListener(JFrame jan1) {
		this.jan1 = jan1;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		jan1.dispose();
	}

}

package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BotaoCadastrarListener implements ActionListener {

	JanelaCadastro janelaCadastro;
	boolean tipo;

	public BotaoCadastrarListener(boolean tipo) {
		this.tipo = tipo;
		janelaCadastro = new JanelaCadastro(tipo);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		janelaCadastro.janelaCadastrarVeiculos();
	}

}

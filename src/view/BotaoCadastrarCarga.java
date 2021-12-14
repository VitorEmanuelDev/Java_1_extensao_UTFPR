package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BotaoCadastrarCarga implements ActionListener {

	JanelaCadastroCarga janelaCadastroCarga;

	public BotaoCadastrarCarga() {
		janelaCadastroCarga = new JanelaCadastroCarga();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		janelaCadastroCarga.janelaCadastrarVeiculosCarga();
	}

}

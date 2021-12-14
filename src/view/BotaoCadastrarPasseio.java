package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BotaoCadastrarPasseio implements ActionListener {

	JanelaCadastroPasseio janelaCadastroPasseio;

	public BotaoCadastrarPasseio() {
		janelaCadastroPasseio = new JanelaCadastroPasseio();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		janelaCadastroPasseio.janelaCadastrarVeiculosPasseio();
	}

}

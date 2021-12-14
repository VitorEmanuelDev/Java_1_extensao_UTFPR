package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BotaoConsultarExcluirTodosPasseio implements ActionListener {
	
	JanelaConsultarExcluirTodosPasseio janelaConsultarExcluirTodosPasseio;

	public BotaoConsultarExcluirTodosPasseio() {
		janelaConsultarExcluirTodosPasseio = new JanelaConsultarExcluirTodosPasseio();		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		janelaConsultarExcluirTodosPasseio.janelaConsultarExcluirTodosPasseio();
	}

}

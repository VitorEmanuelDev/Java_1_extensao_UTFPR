package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BotaoConsultarExcluirTodosCarga implements ActionListener {
	
	JanelaConsultarExcluirTodosCarga janelaConsultarExcluirTodosCarga;

	public BotaoConsultarExcluirTodosCarga() {
		janelaConsultarExcluirTodosCarga = new JanelaConsultarExcluirTodosCarga();		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		janelaConsultarExcluirTodosCarga.janelaConsultarExcluirTodosCarga();
	}

}

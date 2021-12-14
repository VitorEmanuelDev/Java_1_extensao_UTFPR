package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class BotaoLimparDadosCarga implements ActionListener {
	
	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField3;
	private JTextField textField4;
	private JTextField textField5;
	private JTextField textField6;
	private JTextField textField7;
	private JTextField textField8;
	private JTextField textField9;
	private JTextField textFieldExtra;

	public BotaoLimparDadosCarga(JTextField textField1, JTextField textField2, JTextField textField3, JTextField textField4, JTextField textField5, JTextField textField6, JTextField textField7, JTextField textField8, JTextField textField9, JTextField textFieldExtra) {
		this.textField1 = textField1;
		this.textField2 = textField2;
		this.textField3 = textField3;
		this.textField4 = textField4;
		this.textField5 = textField5;
		this.textField6 = textField6;
		this.textField7 = textField7;
		this.textField8 = textField8;
		this.textField9 = textField9;
		this.textFieldExtra = textFieldExtra;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		textField1.setText("");
		textField2.setText("");
		textField3.setText("");
		textField4.setText("");
		textField5.setText("");
		textField6.setText("");
		textField7.setText("");
		textField8.setText("");
		textField9.setText("");
		textFieldExtra.setText("");
	}

}

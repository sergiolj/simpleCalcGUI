package calculadora.ui;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

public class CalculadoraTecladoNum extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	//METODO CONSTRUTOR 
	//o parametro passado na criação do painel indica a qual frame ele está associado (CalculadoraFrame frame)
	public CalculadoraTecladoNum(CalculadoraFrame frame) {
		setBackground(new Color(240, 240, 240));
		setLayout(null);
		
		JButton btn1 = new JButton("1");
		btn1.setBounds(10, 93, 50, 30);
		btn1.setName("1");
		acao(btn1, frame);
		add(btn1);
		
		JButton btn2 = new JButton("2");
		btn2.setBounds(70, 93, 50, 30);
		btn2.setName("2");
		acao(btn2,frame);
		add(btn2);
		
		JButton btn3 = new JButton("3");
		btn3.setBounds(130, 93, 50, 30);
		btn3.setName("3");
		acao(btn3,frame);
		add(btn3);
		
		JButton btn4 = new JButton("4");
		btn4.setBounds(10, 52, 50, 30);
		btn4.setName("4");
		acao(btn4,frame);
		add(btn4);
		
		JButton btn5 = new JButton("5");
		btn5.setBounds(70, 52, 50, 30);
		btn5.setName("5");
		acao(btn5,frame);
		add(btn5);
		
		JButton btn6 = new JButton("6");
		btn6.setBounds(130, 52, 50, 30);
		btn6.setName("6");
		acao(btn6,frame);
		add(btn6);
		
		JButton btn7 = new JButton("7");
		btn7.setBounds(10, 11, 50, 30);
		btn7.setName("7");
		acao(btn7,frame);
		add(btn7);
		
		JButton btn8 = new JButton("8");
		btn8.setBounds(70, 11, 50, 30);
		btn8.setName("8");
		acao(btn8,frame);
		add(btn8);
		
		JButton btn9 = new JButton("9");
		btn9.setBounds(130, 11, 50, 30);
		btn9.setName("9");
		acao(btn9,frame);
		add(btn9);
		
		JButton btn0 = new JButton("0");
		btn0.setBounds(10, 134, 50, 30);
		btn0.setName("0");
		acao(btn0,frame);
		add(btn0);
		
		JButton btnPonto = new JButton(".");
		btnPonto.setBounds(70, 134, 50, 30);
		btnPonto.setName("PONTO");
		modificador(btnPonto,frame);
		add(btnPonto);
		
		JButton btnSinal = new JButton("+/-");
		btnSinal.setBounds(130, 134, 50, 30);
		btnSinal.setName("INVERT");
		modificador(btnSinal,frame);
		add(btnSinal);

	}
	private void acao(JButton botao, CalculadoraFrame frame) {
		//funcão para que ao acionar o botão o display no Jframe seja atualizado com o valor do name
		botao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.atualizarDisplay(botao.getName());
			}
		});
	}
	private void modificador(JButton botao, CalculadoraFrame frame) {
		//funcão para que ao acionar o botão o display no Jframe seja atualizado com o valor do name
		botao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.modificador(botao.getName());
			}
		});
	}
		
}


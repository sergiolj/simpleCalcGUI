package calculadora.ui;

import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;

public class CalculadoraTecladoFunc extends JPanel{

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	//o parametro passado na criação do painel indica a qual frame ele está associado (CalculadoraFrame frame)
	public CalculadoraTecladoFunc(CalculadoraFrame frame) {
		setLayout(null);

		JButton btnSubtrair = new JButton("-");
		btnSubtrair.setFont(new Font("Arial Black", Font.BOLD, 10));
		btnSubtrair.setBounds(4, 85, 55, 30);
		btnSubtrair.setName("SUBTRAIR");
		operacao(btnSubtrair,frame);
		add(btnSubtrair);
		
		JButton btnDividir = new JButton("/");
		btnDividir.setFont(new Font("Arial Black", Font.BOLD, 10));
		btnDividir.setBounds(69, 85, 55, 30);
		btnDividir.setName("DIVIDIR");
		operacao(btnDividir,frame);
		add(btnDividir);
		
		JButton btnMultiplicar = new JButton("X");
		btnMultiplicar.setFont(new Font("Arial Black", Font.BOLD, 10));
		btnMultiplicar.setBounds(69, 118, 55, 30);
		btnMultiplicar.setName("MULTIPLICAR");
		operacao(btnMultiplicar,frame);
		add(btnMultiplicar);
		
		JButton btnSomar = new JButton("+");
		btnSomar.setFont(new Font("Arial Black", Font.BOLD, 10));
		btnSomar.setBounds(4, 118, 55, 62);
		btnSomar.setName("SOMAR");
		operacao(btnSomar,frame);
		add(btnSomar);
		
		JButton btnRaiz = new JButton("Sqrt");
		btnRaiz.setFont(new Font("Arial Black", Font.BOLD, 8));
		btnRaiz.setBounds(4, 51, 55, 30);
		btnRaiz.setName("RAIZ");
		operacao(btnRaiz,frame);
		add(btnRaiz);

		JButton btnPotencia = new JButton("x2");
		btnPotencia.setFont(new Font("Arial Black", Font.BOLD, 11));
		btnPotencia.setBounds(69, 50, 55, 30);
		btnPotencia.setName("POTENCIA");
		operacao(btnPotencia,frame);
		add(btnPotencia);
			
		JButton btnZerar = new JButton("C");
		btnZerar.setForeground(new Color(255, 0, 0));
		btnZerar.setFont(new Font("Arial Black", Font.BOLD, 16));
		btnZerar.setBounds(4, 6, 120, 41);
		btnZerar.setName("ZERAR");
		operacao(btnZerar,frame);
		add(btnZerar);

		JButton btnResultado = new JButton("=");
		btnResultado.setForeground(new Color(255, 0, 0));
		btnResultado.setFont(new Font("Arial Black", Font.BOLD, 12));
		btnResultado.setBounds(69, 150, 55, 30);
		btnResultado.setName("RESULTADO");
		resultado(btnResultado,frame);
		add(btnResultado);
	}
	private void operacao(JButton botao, CalculadoraFrame frame) {
		//funcão para que ao acionar o botão o display no Jframe seja atualizado com o valor do name
		botao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.operacao(botao.getName());
			}
		});
	}
	private void resultado(JButton botao, CalculadoraFrame frame) {
		//funcão para que ao acionar o botão o display no Jframe seja atualizado com o valor do name
		botao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.resultadoOperacao();
			}
		});
	}
}

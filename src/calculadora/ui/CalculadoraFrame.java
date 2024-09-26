package calculadora.ui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

public class CalculadoraFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lbDisplay=new JLabel("");
	//cria as variáveis globais para armazenar os operadores
	String op1=null, op2=null;
	String operacao=null;
	int n3;
	double n1,n2;
	double resultado=0;
	String display;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculadoraFrame frame = new CalculadoraFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CalculadoraFrame() {
		setResizable(false);
		//título da janela
		setTitle("Calculadora");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 364, 310);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//cria o objeto do tipo Label para servir como display da calculadora
		//JLabel lbDisplay = new JLabel("");
		lbDisplay.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lbDisplay.setHorizontalAlignment(SwingConstants.RIGHT);
		lbDisplay.setFont(new Font("Arial Unicode MS", Font.BOLD, 25));
		//define a posição e as dimensões do label
		lbDisplay.setBounds(22, 11, 225, 45);
		//adiciona o objeto ao JFrame
		contentPane.add(lbDisplay);
		
		//cria um objeto do tipo teclado de funções
		//o parametro this é necessário para a criacao desse objeto no JFrame
		CalculadoraTecladoFunc tecladoOperacoes=new CalculadoraTecladoFunc(this);
		//adiciona ao JFrame
		contentPane.add(tecladoOperacoes);
		
		//determina a posicao do objeto
		tecladoOperacoes.setLocation(210, 70);
		tecladoOperacoes.setSize(130, 180);
		
		//cria um objeto do tipo teclado numérico
		//o parametro this é necessário para a criacao desse objeto no JFrame
		CalculadoraTecladoNum tecladoNumerico=new CalculadoraTecladoNum(this);
		//adiciona ao JFrame
		contentPane.add(tecladoNumerico);
		
		//Determina a posição do objeto
		tecladoNumerico.setLocation(10, 85);
		tecladoNumerico.setSize(190, 175);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(257, 11, 78, 45);
		contentPane.add(btnExit);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(ABORT);
			}
		});
	}

	public JLabel getLbDisplay() {
		return lbDisplay;
	}

	public void setLbDisplay(JLabel display) {
		this.lbDisplay = display;
	}
	//metodo que permite modificar o valor do label Display
	//acionado através da subclasse
	public void atualizarDisplay(String digito) {
			if((operacao==null) && (op1==null)) {
					op1="";
					op1+=digito;
					lbDisplay.setText(op1);
				}else { if((operacao==null)&&(op1!=null)){
						op1+=digito;
						lbDisplay.setText(op1);
						}else { if ((operacao!=null)&&(op2==null)) {
								lbDisplay.setText("");
								op2="";
								op2+=digito;
								lbDisplay.setText(op2);
								}else {if((operacao!=null)&&(op2!=null)) {
										op2+=digito;
										lbDisplay.setText(op2);
									}
								}
						}
				}
			
}
	public void operacao(String nome) {
		switch (nome) {
			case "ZERAR":
				limparOperacao();
				lbDisplay.setText("");
				break;
			case "RAIZ":
				operacao="RAIZ";
				resultadoOperacao();
				break;
			case "POTENCIA":
				operacao="POTENCIA";
				resultadoOperacao();
				break;
			case "SOMAR":
				op1=lbDisplay.getText();
				operacao="SOMAR";
				break;
			case "SUBTRAIR":
				op1=lbDisplay.getText();
				operacao="SUBTRAIR";
				break;
			case "DIVIDIR":
				op1=lbDisplay.getText();
				operacao="DIVIDIR";
				break;
			case "MULTIPLICAR":
				op1=lbDisplay.getText();
				operacao="MULTIPLICAR";
				break;
				}		
			}
	
	public void resultadoOperacao() {
		switch (operacao) {
		case "SOMAR":
			n1=Double.parseDouble(op1);
			n2=Double.parseDouble(op2);
			resultado=n1+n2;
			display=Double.toString(resultado);
			lbDisplay.setText(display);
			limparOperacao();
			break;
			
		case "SUBTRAIR":
			n1=Double.parseDouble(op1);
			n2=Double.parseDouble(op2);
			resultado=n1-n2;
			display=Double.toString(resultado);
			lbDisplay.setText(display);
			limparOperacao();
			break;
			
		case "DIVIDIR":
			n1=Double.parseDouble(op1);
			n2=Double.parseDouble(op2);
			if(n2==0) {
				lbDisplay.setText("Erro div/0");
				limparOperacao();
				break;
			}else {
				resultado=n1/n2;
				display=Double.toString(resultado);
				lbDisplay.setText(display);
				limparOperacao();
				break;
			}
			
		case "MULTIPLICAR":
			n1=Double.parseDouble(op1);
			n2=Double.parseDouble(op2);
			resultado=n1*n2;
			display=Double.toString(resultado);
			lbDisplay.setText(display);
			limparOperacao();
			break;
			
		case "RAIZ":
			n1=Double.parseDouble(lbDisplay.getText());
			resultado=Math.sqrt(n1);
			display=Double.toString(resultado);
			lbDisplay.setText(display);
			limparOperacao();
			break;
			
		case "POTENCIA":
			n1=Double.parseDouble(op1);
			resultado=n1*n1;
			display=Double.toString(resultado);
			lbDisplay.setText(display);
			limparOperacao();
			break;
		}
	}
	public void limparOperacao() {
		operacao=null;
		op1=null;
		op2=null;
	}
	public void modificador(String funcao) {
		switch (funcao) {
		case "INVERT":
			n1=Double.parseDouble(lbDisplay.getText());
			resultado=n1*(-1);
			display=Double.toString(resultado);
			lbDisplay.setText(display);
			break;
		case "PONTO":
			break;
		}

	}
	}

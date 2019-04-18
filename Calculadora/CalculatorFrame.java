package Calculadora;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class CalculatorFrame extends JFrame
{	private String simbolos;
	private Visor visor;
	private Botao[] btn = new Botao[16]; 
	public CalculatorFrame()									
	{	this.setSize(406, 580);									//tamanho
		this.setLayout(null);									//nenhum layout
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//permite fechar a janela
		this.setLocationRelativeTo(null);						//posiciona no centro da tela
		this.setResizable(false);								//nao permite redimensionar
		this.setTitle("Calculator");							//titulo
		this.simbolos = "1470258.369=+-*/";						//simbolos dos botoes
		this.visor = new Visor();								//tela de visão
		this.visor.setLocation(1, 10);
		this.add(this.visor);
		this.Init();
		this.setVisible(true);
	}//construção da calculadora
	public void Init()
	{	for(int i = 0, k = 4; i < 4; i++)
		{	for(int j = 0; j < 4; j++)
			{	btn[i*k+j] = new Botao(this, String.valueOf(this.simbolos.charAt(i*k+j)));
				btn[i*k+j].setLocation(i*100, (j+1)*100);
				this.add(btn[i*k+j]);
			}
		}
		JButton reset = new JButton("RESET");
		reset.setSize(400, 50);
		reset.setLocation(0, 500);
		this.add(reset);
		reset.addActionListener(new ActionListener()
		{	@Override public void actionPerformed(ActionEvent arg0) 
			{getVisor().setText("0");}
		});
	}
	public String getSimbolos() {return simbolos;}
	public void setSimbolos(String simbolos) {this.simbolos = simbolos;}
	public Visor getVisor() {return visor;}
	public void setVisor(Visor visor) {this.visor = visor;}
}

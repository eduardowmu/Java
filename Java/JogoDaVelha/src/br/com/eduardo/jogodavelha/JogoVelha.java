package br.com.eduardo.jogodavelha;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.print.DocFlavor.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class JogoVelha extends JFrame
{	private boolean player1;
	private Botao[] btn = new Botao[9];
	private int valor = 0;
	private int i;
	private int j;
	private int k;
	public JogoVelha()
	{	this.player1 = true;
		this.setSize(305, 375);
		this.setTitle("Jogo da Velha:");
		this.setLayout(null);
		this.setLocationRelativeTo(null);
		java.net.URL image = this.getClass().getResource("velha.png");
		ImageIcon icon = new ImageIcon(image);
		//insere a imagem no titulo do frame.
		this.setIconImage(icon.getImage());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.init();
		this.setVisible(true);
	}
	public void init()
	{	for(i = 0, k = 3; i < 3; i++)
		{	for(j = 0; j < 3; j++)
			{	btn[i*k+j] = new Botao(this);
				btn[i*k+j].setLocation(i*100, j*100);
				btn[i*k+j].setBackground(Color.WHITE);
				this.add(btn[i*k+j]);
			}
		}
		JButton reset = new JButton("RESET");
		reset.setSize(300, 50);
		reset.setLocation(0, 300);
		this.add(reset);
		reset.addActionListener(new ActionListener()
		{	@Override public void actionPerformed(ActionEvent arg0) 
			{	for(i = 0; i < 9; i++) 
				{	btn[i].setEnabled(true);
					btn[i].setText("");
					btn[i].setPonto(0);
				}
			
				if(getTitle().contains("Win")) setTitle("Jogo da Velha");
			}
		});
	}
	public void CheckGame()
	{	if(btn[0].getPonto() + btn[1].getPonto() + btn[2].getPonto() == 3 ||
			btn[3].getPonto() + btn[4].getPonto() + btn[5].getPonto() == 3 ||
			btn[6].getPonto() + btn[7].getPonto() + btn[8].getPonto() == 3 ||//soma das colunas
			btn[0].getPonto() + btn[3].getPonto() + btn[6].getPonto() == 3 ||
			btn[1].getPonto() + btn[4].getPonto() + btn[7].getPonto() == 3 ||
			btn[2].getPonto() + btn[5].getPonto() + btn[8].getPonto() == 3 ||//soma das linhas
			btn[0].getPonto() + btn[4].getPonto() + btn[8].getPonto() == 3 ||
			btn[6].getPonto() + btn[4].getPonto() + btn[2].getPonto() == 3)	 //soma das diagonais
		{	this.setTitle("Player 1 Win!");
			for(i = 0; i < 9; i++) {btn[i].setEnabled(false);}
		}
 		
		else if(btn[0].getPonto() + btn[1].getPonto() + btn[2].getPonto() == 12 ||
			btn[3].getPonto() + btn[4].getPonto() + btn[5].getPonto() == 12 ||
			btn[6].getPonto() + btn[7].getPonto() + btn[8].getPonto() == 12 ||
			btn[0].getPonto() + btn[3].getPonto() + btn[6].getPonto() == 12 ||
			btn[1].getPonto() + btn[4].getPonto() + btn[7].getPonto() == 12 ||
			btn[2].getPonto() + btn[5].getPonto() + btn[8].getPonto() == 12 ||
			btn[0].getPonto() + btn[4].getPonto() + btn[8].getPonto() == 12 ||
			btn[6].getPonto() + btn[4].getPonto() + btn[2].getPonto() == 12)
		{	this.setTitle("Player 2 Win!");
			for(i = 0; i < 9; i++) {btn[i].setEnabled(false);}
		}
	}
	public boolean isPlayer1() {return player1;}
	public void setPlayer1(boolean player1) {this.player1 = player1;}
	public int getValor() {return valor;}
	public void setValor(int valor) {this.valor = valor;}
}
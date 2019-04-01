package br.com.eduardo.jogodavelha;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class Botao extends JButton
{	private JogoVelha jv;
	private int ponto;
	public Botao(JogoVelha jv)
	{	this.setText("");
		setFont(new Font("Arial", 255, 30));
		this.setSize(100, 100);
		this.setEnabled(true);
		this.addActionListener(new ActionListener() 
		{	@Override public void actionPerformed(ActionEvent arg0) 
			{	if(getText().equals(""))
				{	if(jv.isPlayer1())	
					{	setText("X");
						setPonto(1);
					}
					else
					{	setText("O");
						setPonto(4);
					}
					jv.setPlayer1(!jv.isPlayer1());
					jv.CheckGame();
				}
			}
		});
	}
	public int getPonto() {return ponto;}
	public void setPonto(int ponto) {this.ponto = ponto;}
}

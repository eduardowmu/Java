package getblock;

import java.awt.Font;

import javax.swing.JLabel;

public class Placar extends JLabel
{	private int pontuacao;
	public Placar()
	{	this.setSize(50, 50);
		this.setFont(new Font("Arial", 255, 30));
		this.pontuacao = 0;
		this.setText(String.valueOf(this.pontuacao));
		this.setVisible(true);
	}
	
	public int getPontuacao() {return pontuacao;}
	public void setPontuacao(int pontuacao) {this.pontuacao = pontuacao;}
}

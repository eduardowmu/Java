package getblock;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Boneco extends JLabel implements KeyListener
{	private int velocidade;
	private int maximo;
	
	public Boneco(int larg, int alt, int max)
	{	this.setOpaque(true);
		this.setSize(larg, alt);
		//this.setBackground(Color.blue);
		this.setIcon(new ImageIcon(new ImageIcon(
			"boneco2.png").getImage().getScaledInstance(
			getWidth(), getHeight(), Image.SCALE_FAST)));
		this.addKeyListener(this);
		this.maximo = max;
		this.setVelocidade(1);
	}
	
	public int getVelocidade() {return velocidade;}
	public void setVelocidade(int velocidade) {this.velocidade = velocidade;}
	
	@Override public void keyPressed(KeyEvent arg) 
	{	if(arg.getKeyCode()==39)//Direita
		{	this.setIcon(new ImageIcon(new ImageIcon(
				"boneco2.png").getImage().getScaledInstance(
				getWidth(), getHeight(), Image.SCALE_FAST)));
			setLocation(getX()+(5*getVelocidade()), getY());
			if(getX()>maximo){setLocation(maximo, getY());}
		}
		
		else if(arg.getKeyCode()==37)//Esquerda
		{	this.setIcon(new ImageIcon(new ImageIcon(
				"boneco.png").getImage().getScaledInstance(
				getWidth(), getHeight(), Image.SCALE_FAST)));
			setLocation(getX()-(5*getVelocidade()), getY());
			if(getX()<0) {setLocation(0, getY());}
		}
		
		else if(arg.getKeyCode()==27)//Esc
		{	if(JOptionPane.showConfirmDialog(null,"Deseja Sair?") == JOptionPane.YES_OPTION)
			{System.exit(0);}
		}
		
		else if(arg.getKeyCode()==32)//Espaço
		{	Random random = new Random();
			setVelocidade(random.nextInt(10)+1);
		}
	}

	@Override public void keyReleased(KeyEvent arg0) {}

	@Override public void keyTyped(KeyEvent arg0) {}
}
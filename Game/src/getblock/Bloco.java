package getblock;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Bloco extends JLabel
{	private int maximo;
	private int direcao;
	private int velocidade;
	private int angulo;
	private Boneco boneco;
	private Cenario cenario;
	private boolean ready;
	Random random = new Random();
	
	public Bloco(Boneco boneco, int maximo, Cenario cenario)
	{	setSize(30, 10);
		this.boneco = boneco;
		this.cenario = cenario;
		setIcon(new ImageIcon(new ImageIcon(
			"tijolo.png").getImage().getScaledInstance(
			getWidth(), getHeight(), Image.SCALE_FAST)));
		setVelocidade(1);
		setDirecao(0);
		this.maximo = maximo;
		this.maximo -=getWidth();
		this.setVisible(true);
	}
	
	public void start()
	{	new Thread(new Runnable() 
		{	@Override public void run() 
			{	int i = 0; //contador de tijolos a serem jogados
				int a = 0; //contador de acertos
				while(true)
				{	int x = getX(), y = getY();
					y+= 2 * velocidade;
					
					setLocation(x, y);
					
					if(isColidiu(boneco))
					{	cenario.getPlacar().setText(String.valueOf(
							Integer.parseInt(cenario.getPlacar().getText())+1));
						setLocation(random.nextInt(650), -10);
						a++;
						i++;
					}
					
					else if(getY() >= 700)
					{	setLocation(random.nextInt(650), -10);
						i++;
					}
					
					if(i == 10)
					{	int op = 0;
						Object[] options = {"Sim", "Não"};
						if(a < 10)
						{op = JOptionPane.showOptionDialog(null, 
							"Você pegou " + a + " de " + i + ". Desejas reiniciar?", "", 
							JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, 
							null, options, options[0]);
						}
					
						else op = JOptionPane.showOptionDialog(null, 
							"Parabéns! Você pegou tudo! Desejas reiniciar?", "", 
							JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, 
							null, options, options[0]);
						
						if(op == JOptionPane.YES_OPTION)
						{	try {new GameGetBloque().start();} 
							catch (InterruptedException e) {}
						}
						//cenario.restart.setVisible(true);
						break;
					}
					
					try {Thread.sleep(23);} 
					catch (InterruptedException e) 
					{e.printStackTrace();}
				}
			}
		}).start();
	}
	
	public boolean isColidiu(Boneco b)
	{	if(getY()+getHeight()>= b.getY() &&	getY()<=b.getY()+b.getHeight())
		{	if(b.getX()<= getX()+getWidth() && getX()+getWidth()<= b.getX()+b.getWidth())
			{return true;}
		
			return false;
		}
		return false;
	}
	
	public void setVelocidade(int velocidade) 
	{this.velocidade = velocidade;}
	
	public void setDirecao(int direcao) 
	{this.direcao = direcao;}
	
	public boolean isReady() {return ready;}
	public void setReady(boolean ready) {this.ready = ready;}
}
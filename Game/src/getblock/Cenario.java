package getblock;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Cenario extends JFrame
{	public Cenario() throws InterruptedException
	{	setSize(800, 700);
		setTitle("Pega Bloco");
		setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		restart = new JButton("Reiniciar");
		restart.setLocation(400, 350);
		restart.setVisible(false);
		restart.addActionListener(new ActionListener()
		{	@Override public void actionPerformed(ActionEvent arg0) 
			{init();}
		});
		this.add(restart);
		init();
		setVisible(true);
	}
	
	private Boneco boneco;
	private Bloco bloco;
	private JLabel fundo = new JLabel();
	private Placar placar = new Placar();
	private Random random = new Random();
	public JButton restart;
	
	private void init()
	{	boneco = new Boneco(40, 40,getWidth());
		boneco.setVelocidade(3);
		boneco.setLocation(getWidth()/2 - 70, getHeight() - (boneco.getHeight()+50));
		add(boneco);
		addKeyListener(boneco);
		
		placar.setLocation(30, 30);
		this.add(placar);
		bloco = new Bloco(boneco, getWidth(), this);
		bloco.setLocation(random.nextInt(650), 10);
		add(bloco);
		bloco.setVelocidade(3);
		bloco.start();
		
		fundo.setBounds(0, 0, getWidth(), getHeight());
		fundo.setIcon(new ImageIcon(new  ImageIcon("cena.png").
		getImage().getScaledInstance(getWidth(),
				getHeight(),Image.SCALE_FAST)));
		add(fundo);
	}

	public Placar getPlacar() {return placar;}
	public void setPlacar(Placar placar) {this.placar = placar;}
}
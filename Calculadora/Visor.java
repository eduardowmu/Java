package Calculadora;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Visor extends JLabel
{	public Visor()
	{	this.setText("0");
		this.setFont(new Font("Arial", 250, 30));
		this.setSize(398, 80);
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.setHorizontalAlignment(SwingConstants.RIGHT);
	}
	public boolean hasOp(String eq)
	{	String op = "+-/*";
		for(int i = 0; i < eq.length(); i++)
		{	for(int j = 0; j < op.length(); j++)
			{	if(eq.charAt(i) == op.charAt(j))
				{return true;}
			}
		}
		return false;
	}
}

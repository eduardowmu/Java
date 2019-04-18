package Calculadora;

import java.awt.Color;
import java.awt.Font;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

public class Botao extends JButton
{	private CalculatorFrame cf;
	private String valor;
	public Botao(CalculatorFrame cf, String valor) 
	{	super();
		this.cf = cf;
		this.valor = valor;
		this.setText(this.valor);
		this.setFont(new Font("Arial", 255, 30));
		this.setSize(100, 100);
		this.setBackground(Color.WHITE);
		this.setEnabled(true);
		this.addActionListener(new ActionListener()
		{	@Override public void actionPerformed(ActionEvent arg0) 
			{	if(cf.getVisor().getText().equals("0"))
				{	if(isNumber(valor)||valor.equals("."))
					{cf.getVisor().setText(valor);}
				}
			
				else if(!valor.equals("="))
				{cf.getVisor().setText(cf.getVisor().getText() + valor);}
			
				else if(valor.equals("="))  //se nem o primeiro e nem o ultimo caractere da equação for um sinal
				{	if(isNumber(String.valueOf(cf.getVisor().getText().charAt(cf.getVisor().getText().length() - 1))))
					{	Equacao eq = new Equacao(cf);
						cf.getVisor().setText(eq.resolveEq(eq.getNumeros(), eq.getOperacoes()));
					}
				}
			}
		});
	}
	public CalculatorFrame getCf() {return cf;}
	public void setCf(CalculatorFrame cf) {this.cf = cf;}
	public String getValor() {return valor;}
	public void setValor(String valor) {this.valor = valor;}
	public boolean isNumber(String valor)
	{	try {double numero = Double.parseDouble(valor);}
		catch(Exception e) {return false;}
		return true;
	}
}

package Calculadora;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class Equacao 
{	private CalculatorFrame cf;
	private String valor;
	private List<String> numeros;
	private List<String> operacoes;
	public Equacao(CalculatorFrame cf) 
	{	super();
		this.cf = cf;
		this.valor = cf.getVisor().getText();
		numeros = new ArrayList<>();
		operacoes = new ArrayList<>();
		String numero = "";
		//looping por toda a equa��o
		for(int i = 0; i < this.valor.length(); i++)
		{	if(i == 0 && this.valor.charAt(i) == '-') //se o primeiro digito da equa��o for um sinal negativo
			{numero += this.valor.charAt(i);}		  //add como um numero
			//se cada caractere do �ndice for diferente de opera��es matem�ticas
			else if(this.valor.charAt(i) != '+' && this.valor.charAt(i) != '-' &&
				this.valor.charAt(i) != '*' && this.valor.charAt(i) != '/')
			{	//armazena cada valor em uma String de numero
				numero += valor.charAt(i);
				//se o proximo indice j� for o tamanho total da equa��o
				if((i+1) == this.valor.length())
				{	numeros.add(numero);
					numero = "";
				}
			}
			//se for qualquer uma das opera��es
			else
			{	//insira cada numero gerado em uma lista de numeros
				numeros.add(numero);
				//insira a respectiva opra��o em uma lista de operacoes
				operacoes.add(String.valueOf(valor.charAt(i)));
				//deixa vazio a variavel numero para inserir novos numeros futuros
				numero = "";
			}
		}
	}
	//GETTERs e SETTERs
	public CalculatorFrame getCf() {return cf;}
	public void setCf(CalculatorFrame cf) {this.cf = cf;}
	public String getValor() {return valor;}
	public void setValor(String valor) {this.valor = valor;}
	public List<String> getNumeros() {return numeros;}
	public void setNumeros(List<String> numeros) {this.numeros = numeros;}
	public List<String> getOperacoes() {return operacoes;}
	public void setOperacoes(List<String> operacoes) {this.operacoes = operacoes;}
	
	//resolve a equa��o da calculadora de acordo com as prioridades de opera��es matem�ticas
	public String resolveEq(List<String> numeros, List<String> operacoes)
	{	int i = 0;//contador
		//para possibilitar o parseDouble no calculo do resultado
		String resultado = "0";
		while(!numeros.isEmpty() && !operacoes.isEmpty())
		{	//se n�o houver opera��es de produto ou divis�o
			if(!operacoes.contains("*") && !operacoes.contains("/"))
			{	if(operacoes.get(i).equals("+"))//se for opera��o de soma
				{	//calcula o resultado
					resultado = String.valueOf((Double.parseDouble(numeros.get(i)) + Double.parseDouble(numeros.get(i+1))));
					//retira da lista de numeros aqueles j� usados
					this.removeDasListas(numeros, operacoes, i, resultado);
					//para futuramente iniciar a contagem do zero
					i = -1;
				}//se for de subtra��o
				else //calcula o resultado
				{	resultado = String.valueOf((Double.parseDouble(numeros.get(i)) - Double.parseDouble(numeros.get(i+1))));
					//retira da lista de numeros aqueles j� usados
					this.removeDasListas(numeros, operacoes, i, resultado);
					//para futuramente iniciar a contagem do zero
					i = -1;
				}
			}
			else
			{	if(operacoes.get(i).equals("*"))
				{	resultado = String.valueOf((Double.parseDouble(numeros.get(i)) * Double.parseDouble(numeros.get(i+1))));
					//retira da lista de numeros aqueles j� usados
					this.removeDasListas(numeros, operacoes, i, resultado);
					//para futuramente iniciar a contagem do zero
					i = -1;
				}
				else if(operacoes.get(i).equals("/"))
				{	resultado = String.valueOf((Double.parseDouble(numeros.get(i)) / Double.parseDouble(numeros.get(i+1))));
					//retira da lista de numeros aqueles j� usados
					this.removeDasListas(numeros, operacoes, i, resultado);
					//para futuramente iniciar a contagem do zero
					i = -1;
				}
			}
			i++;
		}
		return resultado;
	}
	public static void removeDasListas(List<String> numeros, List<String> operacoes, int i, String resultado)
	{	numeros.remove(numeros.get(i));		//remove o primeiro numero da opera�ao realizada
		numeros.remove(numeros.get(i));		//remove o segundo numero
		operacoes.remove(operacoes.get(i));	//remove o sinal da opera��o
		//se ainda houver operacoes		
		if(!operacoes.isEmpty())			
		{numeros.add(i, resultado);}		//insere o resultado no lugar de toda a opera��o
	}
}

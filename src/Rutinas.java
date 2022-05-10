
import Lista.Nodo;

public class Rutinas 
{
	private String sets;
	private Pila<Ejercicios> pilaInicial;
	private Pila<Ejercicios> pilaSecundaria;
	private Cola<Ejercicios> colaInicial;
	
	Rutinas(String sets, Pila pilaInicial, Pila pilaSecundaria, Cola colaInicial)
	{
		this.sets = sets;
		this.pilaInicial = pilaInicial;
		this.pilaSecundaria = pilaSecundaria;
		this.colaInicial = colaInicial;
	}
	
	public void siguiente() 
	{
		Ejercicios ejercicioActual = (Ejercicios) this.pilaInicial.stackTop();
		this.pilaSecundaria.push(ejercicioActual);
	}
	
}
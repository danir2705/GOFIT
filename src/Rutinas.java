
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
	
	public boolean siguiente() 
	{
		boolean retorno = false;
		if(this.pilaInicial.size()==1) 
		{
			retorno = true;
		}
		else 
		{
			Ejercicios ejercicioActual = this.pilaInicial.stackTop();
			this.pilaSecundaria.push(ejercicioActual);
			this.pilaInicial.popEjercicio();
		}
		return retorno;
	}
	public boolean anterior() 
	{
		boolean retorno = false;
		if(this.pilaSecundaria.tamaño==0) 
		{
			System.out.println("Este es tu primer ejercicio, no te puedes devolver más!");
		}
		else 
		{
			Ejercicios ejercicioActual = this.pilaSecundaria.stackTop();
			this.colaInicial.enqueueEjercicio(ejercicioActual);
			this.pilaSecundaria.popEjercicio();
			this.pilaInicial.push(colaInicial.colaTop());
			this.colaInicial.dequeueEjercicio();
		}
		return retorno;
	}
	public void mostrarEjercicioActual()
	{
		this.pilaInicial.stackTop().mostrarEjercicio();
	}
	
}

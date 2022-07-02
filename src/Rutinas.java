package Datos;

public class Rutinas 
{
	private String nombreRutina;
	private String sets;
	private Pila<Ejercicios> pilaInicial;
	private Pila<Ejercicios> pilaSecundaria;
	private Cola<Ejercicios> colaInicial;
	
	public Rutinas(String nombreRutina,String sets, Pila pilaInicial, Pila pilaSecundaria, Cola colaInicial)
	{
		this.nombreRutina = nombreRutina;
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
		boolean retorno = true;
		if(this.pilaSecundaria.tamaño==0) 
		{
			retorno=false;
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
	public Ejercicios mostrarEjercicioActual()
	{
		return this.pilaInicial.stackTop();
	}
	
	public void resetRutina() 
	{
		while(this.pilaSecundaria.tamaño!=0) 
		{
			this.anterior();
		}
	}
	
}
package Datos;
abstract public class Lista
{
	protected Nodo cabeza;
	protected Nodo cola;
	int tamaño = 0;
	
	public int size() 
	{
		return this.tamaño;
	}
	
	public Object getCola() 
	{
		return this.cola.dato;
	}
	public Object getCabeza() 
	{
		return this.cabeza.dato;
	}
}
	
package Datos;
abstract public class Lista
{
	protected Nodo cabeza;
	protected Nodo cola;
	int tama�o = 0;
	
	public int size() 
	{
		return this.tama�o;
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
	
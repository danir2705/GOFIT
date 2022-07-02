package Datos;


public class Nodo<T> 
{
	public T dato;

	Nodo<T> siguiente;
	Nodo<T> anterior;
	
	Nodo(T dato)
	{
		this.dato=dato;
		this.siguiente = null;
		this.anterior = null;
	}
}

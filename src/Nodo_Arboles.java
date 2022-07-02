package Datos;

public class Nodo_Arboles<T> 
{
	int posicionNodo;
	int alturaNodo = 0;
	protected T dato;
	Nodo_Arboles<T> padre;
	Nodo_Arboles<T> nodo_Izq;
	Nodo_Arboles<T> nodo_Der;
	
	Nodo_Arboles(int posicionNodo,T dato)
	{
		this.dato = dato;
	}
	
	public static int alturaNodo(Nodo_Arboles nodo) 
	{
		int retorno = -1;
		if(nodo != null) 
		{
			retorno = nodo.alturaNodo;
		}
		return retorno;
	}
	
	public static int balanceNodo(Nodo_Arboles nodo) 
	{
		int retorno = 0;
		if(nodo!=null) 
		{
			retorno = nodo.alturaNodo(nodo.nodo_Izq) - nodo.alturaNodo(nodo.nodo_Der);
		}
		return retorno; 
	}
	
	public static void actualizarAltura(Nodo_Arboles nodo) 
	{
		int altMax = Math.max(alturaNodo(nodo.nodo_Izq), alturaNodo(nodo.nodo_Der));
		nodo.alturaNodo = altMax + 1;
	}
 
}

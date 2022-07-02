package Datos;
import java.io.*;

public class Lista_Arbol_AVL<T>
{
	private int ultima_Pos_Insertada = 0;
	private int alturaArbol;
	private Nodo_Arboles<T> nodoRaiz;
	
	
	public Nodo_Arboles getRaiz() 
	{
		return this.nodoRaiz;
	}
	public static Nodo_Arboles rotacionIzq(Nodo_Arboles nodo) 
	{
		Nodo_Arboles a = nodo.nodo_Der;
		Nodo_Arboles b = a.nodo_Izq;
		a.nodo_Izq = nodo;
		nodo.nodo_Der = b;
		Nodo_Arboles.actualizarAltura(nodo);
		Nodo_Arboles.actualizarAltura(a);
		return a;
	}
	
	public static Nodo_Arboles rotacionDer(Nodo_Arboles nodo) 
	{
		Nodo_Arboles a = nodo.nodo_Izq;
		Nodo_Arboles b = a.nodo_Der;
		a.nodo_Der = nodo;
		nodo.nodo_Izq = b;
		Nodo_Arboles.actualizarAltura(nodo);
		Nodo_Arboles.actualizarAltura(a);
		return a;
	}
	
	public Nodo_Arboles<T> rebalanceo(Nodo_Arboles nodo) 
	{
		int estadoBalance = Nodo_Arboles.balanceNodo(nodo);
		if(estadoBalance>1) 
		{
			if(Nodo_Arboles.balanceNodo(nodo.nodo_Izq)<0) 
			{
				nodo.nodo_Izq = rotacionIzq(nodo.nodo_Izq);
			}
			return rotacionDer(nodo);
		}
		if(estadoBalance<-1)
		{
			if(Nodo_Arboles.balanceNodo(nodo.nodo_Izq)>0) 
			{
				nodo.nodo_Der = rotacionDer(nodo.nodo_Der);
			}
			return rotacionIzq(nodo);
		}
		return nodo;
	}
	
	public Nodo_Arboles<T> insertar(int posNodo,T data, Nodo_Arboles<T> nodo) 
	{
		if(nodo == null) 
		{
			Nodo_Arboles<T> nodoInsertar = new Nodo_Arboles<>(posNodo,data);
			nodoInsertar.posicionNodo = posNodo;
			return nodoInsertar;
		}
		if(posNodo<nodo.posicionNodo) 
		{
			nodo.nodo_Izq = insertar(posNodo, data, nodo.nodo_Izq);
		}
		else if(posNodo>nodo.posicionNodo) 
		{
			nodo.nodo_Der = insertar(posNodo, data, nodo.nodo_Der);
		}
		else 
		{
			return nodo;
		}
		Nodo_Arboles.actualizarAltura(nodo);
		return rebalanceo(nodo);
	}
	
	
	public Lista_Arbol_AVL<T> insertar(int posNodo ,T data) 
	{
		nodoRaiz = insertar(posNodo,data,nodoRaiz);
		return this;
	}
	
	public void printInOrder(Nodo_Arboles<T> nodo) 
	{
		if(nodo != null) 
		{
			printInOrder(nodo.nodo_Izq);
			System.out.println(nodo.dato);
			printInOrder(nodo.nodo_Der);
		}
	}
	
	public void printArbol() 
	{
		printInOrder(nodoRaiz);
	}
	
	public T buscarNodo(int posNodo) 
	{
		Nodo_Arboles<T> actual = this.getRaiz();
		while(posNodo!= actual.posicionNodo) 
		{
			if (actual.posicionNodo<posNodo) 
			{
				actual = actual.nodo_Der;
			}
			else 
			{
				actual = actual.nodo_Izq;
			}
		}
		return actual.dato;
	}
	
	
	
	
	
	
}

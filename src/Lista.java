

import java.io.*;
abstract public class Lista
{
	class Nodo<T>
	{
		protected T dato;
		int posicion;
		Nodo<T> siguiente;
		Nodo<T> anterior;
		
		Nodo(T dato)
		{
			this.dato=dato;
			this.siguiente = null;
			this.anterior = null;
		}
	}
	
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


class ListaEnlazada<G> extends Lista
{
	public void addUsuario(String nombreUsuario, int edad, int peso, String genero, String clave) 
	{
		if(this.cabeza == null) 
		{
			Usuario usuarioNuevo = new Usuario(nombreUsuario, edad, peso, genero, clave);
			this.cabeza = new Nodo<Usuario>(usuarioNuevo);
			this.cabeza.posicion = 0;
			this.tamaño= 1;
			try 
			{
				FileWriter editorArchivo = new FileWriter("Usuarios.txt",true);
				editorArchivo.write(nombreUsuario+","+edad+","+peso+","+genero+","+clave+","+"\n");
				editorArchivo.close();
			}
			catch(IOException e) 
			{
				System.out.println("Porfa no");
			}
			
		}
		else 
		{
			Nodo<Usuario> actual = this.cabeza;
			while(actual.siguiente!= null) 
			{
				actual = actual.siguiente;
			}
			Usuario usuarioNuevo = new Usuario(nombreUsuario, edad, peso, genero, clave);
			Nodo<Usuario> nuevoNodo = new Nodo<Usuario>(usuarioNuevo);
			actual.siguiente= nuevoNodo;
			nuevoNodo.posicion = this.tamaño;
			this.tamaño+=1;
			try 
			{
				FileWriter editorArchivo = new FileWriter("Usuarios.txt", true);
				editorArchivo.write(nombreUsuario+","+edad+","+peso+","+genero+","+clave+","+"\n");
				editorArchivo.close();
			}
			catch(IOException e) 
			{
				System.out.println("Porfa no");
			}
		}
	}
	public void addUsuarioUnicamenteALista(String nombreUsuario, int edad, int peso, String genero, String clave) 
	{
		if(this.cabeza == null) 
		{
			Usuario usuarioNuevo = new Usuario(nombreUsuario, edad, peso, genero, clave);
			this.cabeza = new Nodo<Usuario>(usuarioNuevo);
			this.cabeza.posicion = 0;
			this.tamaño= 1;
		}
		else 
		{
			Nodo<Usuario> actual = this.cabeza;
			while(actual.siguiente!= null) 
			{
				actual = actual.siguiente;
			}
			Usuario usuarioNuevo = new Usuario(nombreUsuario, edad, peso, genero, clave);
			Nodo<Usuario> nuevoNodo = new Nodo<Usuario>(usuarioNuevo);
			actual.siguiente= nuevoNodo;
			nuevoNodo.posicion = this.tamaño;
			this.tamaño+=1;
		}
		
	}

	public Object getValueAtUsuario(String nombreUsuario) 
	{
		Nodo<Usuario> actual = this.cabeza;
		while(actual.dato.getNombreUsuario() != nombreUsuario ) 
		{
			actual=actual.siguiente;
		}
		return actual.dato.getPeso();	
	}
	
	public Usuario existeUsuario(String nombreUsuario) 
	{
		Usuario retorno = null;
		Nodo<Usuario> nodoActual = this.cabeza;
		while(nodoActual != null) 
		{
			if(nodoActual.dato.getNombreUsuario().equals(nombreUsuario))
			{
				retorno = nodoActual.dato;
				break;
			}
			else 
			{
				nodoActual = nodoActual.siguiente;
			}
		}
		
		return retorno;
	}
}


	
class Cola<G> extends Lista
{
	 public void enqueue(int dato)
	 {
		
		if(this.cabeza == null) 
		{
			this.cabeza = new Nodo(dato);
			this.cola= this.cabeza;
			this.cabeza.posicion = 0;
			this.tamaño= 1;
		}
		else 
		{
			Nodo actual = this.cabeza;
			while(actual.siguiente!= null) 
			{
				actual = actual.siguiente;	
			}
			Nodo nuevoNodo = new Nodo(dato);
			nuevoNodo.anterior = actual;
			actual.siguiente = nuevoNodo;
			this.cola = nuevoNodo;
			nuevoNodo.posicion = this.tamaño;
			this.tamaño+=1;
		}
	 }
	 public void dequeue() 
	 {
		 Nodo actual = this.cabeza; //Recuerde a�adir la excepci�n donde la lista est� vac�a
		 Nodo posicion = this.cabeza;
		 if(actual.siguiente == null) //Caso donde solo hay un dato
		 {
			 this.cabeza = null;
			 this.cola = null;
			 this.tamaño = 0;
		 }
		 else 
		 {
			 this.cabeza = actual.siguiente;
			 actual = null;
			 this.tamaño -=1;
		 }
		 
	 }
}

class Pila<G> extends Lista
{
	 public void push(Ejercicios ejercicio)
	 {
		
		if(this.cabeza == null) 
		{
			this.cabeza = new Nodo(ejercicio);
			this.cola= this.cabeza;
			this.cabeza.posicion = 0;
			this.tamaño= 1;
		}
		else 
		{
			Nodo actual = this.cabeza;
			while(actual.siguiente!= null) 
			{
				actual = actual.siguiente;	
			}
			Nodo nuevoNodo = new Nodo(ejercicio);
			nuevoNodo.anterior = actual;
			actual.siguiente= nuevoNodo;
			this.cola = nuevoNodo;
			nuevoNodo.posicion = this.tamaño;
			this.tamaño+=1;
		}
	 }
	 public void popEjercicio() 
	 {
		 Nodo actual = this.cola; //Recuerde a�adir la excepci�n donde la lista est� vac�a
		 if(actual.anterior == null) //Caso donde solo hay un dato
		 {
			 this.cabeza = null;
			 this.cola = null;
			 this.tamaño = 0;
		 }
		 else 
		 {
			 this.cola = actual.anterior;
			 actual = null;
			 this.tamaño -=1;
		 }
		 
	 }
	 public Object stackTop()
	 {
		 return this.getCabeza();
	 }
}
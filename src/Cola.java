package Datos;

public class Cola<G> extends Lista
{
	 public void enqueueEjercicio(Ejercicios ejercicio)
	 {
		
		if(this.cabeza == null) 
		{
			this.cabeza = new Nodo<Ejercicios>(ejercicio);
			this.cola= this.cabeza;
			
			this.tama�o= 1;
		}
		else 
		{
			Nodo actual = this.cabeza;
			while(actual.siguiente!= null) 
			{
				actual = actual.siguiente;	
			}
			Nodo<Ejercicios> nuevoNodo = new Nodo<Ejercicios>(ejercicio);
			nuevoNodo.anterior = actual;
			actual.siguiente = nuevoNodo;
			this.cola = nuevoNodo;
			
			this.tama�o+=1;
		}
	 }
	 public void dequeueEjercicio() 
	 {
		 Nodo<Ejercicios> actual = this.cabeza; //Recuerde a�adir la excepci�n donde la lista est� vac�a
		 Nodo<Ejercicios> posicion = this.cabeza;
		 if(actual.siguiente == null) //Caso donde solo hay un dato
		 {
			 this.cabeza = null;
			 this.cola = null;
			 this.tama�o = 0;
		 }
		 else 
		 {
			 this.cabeza = actual.siguiente;
			 actual.siguiente = null;
			 this.cabeza.anterior = null;
			 actual = null;
			 this.tama�o -=1;
		 }
		 
	 }
	 public Ejercicios colaTop() 
	 {
		 return (Ejercicios) this.cabeza.dato;
	 }
}
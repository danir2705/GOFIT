package Datos;

public class Pila<G> extends Lista
{
	 public void push(Ejercicios ejercicio)
	 {
		
		if(this.cabeza == null) 
		{
			this.cabeza = new Nodo<Ejercicios>(ejercicio);
			this.cola= this.cabeza;
			
			this.tama�o= 1;
		}
		else 
		{
			Nodo<Ejercicios> actual = this.cola;
			Nodo<Ejercicios> nuevoNodo = new Nodo<Ejercicios>(ejercicio);
			nuevoNodo.anterior = actual;
			actual.siguiente= nuevoNodo;
			this.cola = nuevoNodo;
			
			this.tama�o+=1;
		}
	 }
	 public void popEjercicio() 
	 {
		 Nodo<Ejercicios> actual = this.cola; //Recuerde a�adir la excepci�n donde la lista est� vac�a
		 if(actual.anterior == null) //Caso donde solo hay un dato
		 {
			 this.cabeza = null;
			 this.cola = null;
			 this.tama�o = 0;
		 }
		 else 
		 {
			 this.cola = actual.anterior;
			 actual.anterior = null;
			 this.cola.siguiente = null;
			 actual = null;
			 this.tama�o -=1;
		 }
		 
	 }
	 public Ejercicios stackTop()
	 {
		 return (Ejercicios) this.cola.dato;
	 }
}
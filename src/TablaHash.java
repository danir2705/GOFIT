package Datos;

public class TablaHash
{
	private ListaEnlazada[] tabla;
	
	public TablaHash(int n)
	{
		this.tabla = new ListaEnlazada[n];
	}
	
	
	
	public void agregarEjercicio(Ejercicios ejercicio) 
	{
		Nodo<Ejercicios> nodo = new Nodo<Ejercicios>(ejercicio);
		String nombreEjercicio = nodo.dato.getNombre();
		String codigoHash = "";
		
		for(int i = 1; i< nombreEjercicio.length(); i+=2) 
		{
			if(nombreEjercicio.charAt(i) == 32) 
			{
				codigoHash+= 0;
			}
			else if(nombreEjercicio.charAt(i) >64 && nombreEjercicio.charAt(i) <91) 
			{
				int pos = ((90-nombreEjercicio.charAt(i))+25)%11;
				codigoHash+= pos;
			}
			else 
			{
				int pos = (122-nombreEjercicio.charAt(i))%11;
				codigoHash+= pos;
			}
		}
		Long hash1 = Long.parseLong(codigoHash)%11;
		int retorno = hash1.intValue();
		
		if(this.tabla[retorno]==null) 
		{
			ListaEnlazada listaAgregar = new ListaEnlazada();
			this.tabla[retorno] = listaAgregar;
			if (this.tabla[retorno].cabeza == null) 
			{
				Nodo<?> nodoAgregar = nodo;
				this.tabla[retorno].cabeza = nodoAgregar;
				this.tabla[retorno].cola= nodoAgregar;
			}
			else 
			{
				Nodo<?> nodoAgregar = nodo;
				this.tabla[retorno].cola.siguiente= nodoAgregar;
				this.tabla[retorno].cola = nodoAgregar;
			}
		}
		else 
		{
			if (this.tabla[retorno].cabeza == null) 
			{
				Nodo<?> nodoAgregar = nodo;
				this.tabla[retorno].cabeza = nodoAgregar;
				this.tabla[retorno].cola= nodoAgregar;
			}
			else 
			{
				Nodo<?> nodoAgregar = nodo;
				this.tabla[retorno].cola.siguiente= nodoAgregar;
				this.tabla[retorno].cola = nodoAgregar;
			}
		}
	}
	
	public Nodo<Ejercicios> retorarEjercicio(String elemento) 
	{
		Nodo<Ejercicios> retorno = null;
		String codigoHash = "";
		for(int i = 1; i< elemento.length(); i+=2) 
		{
			if(elemento.charAt(i) == 32) 
			{
				codigoHash+= 0;
			}
			else if(elemento.charAt(i) >64 && elemento.charAt(i) <91) 
			{
				int pos = ((90-elemento.charAt(i))+25)%11;
				codigoHash+= pos;
			}
			else 
			{
				int pos = (122-elemento.charAt(i))%11;
				codigoHash+= pos;
			}
		}
		Long hash = Long.parseLong(codigoHash)%11;
		int pos = hash.intValue();
		
		if(this.tabla[pos]!=null) 
		{
			Nodo<Ejercicios> nodoActual = this.tabla[pos].cabeza;
			while(nodoActual != null) 
			{
				if(nodoActual.dato.getNombre().equals(elemento))
				{
					retorno = nodoActual;
					break;
				}
				else 
				{
					nodoActual = nodoActual.siguiente;
				}
			}
		}
		
		return retorno;
		
	}
}

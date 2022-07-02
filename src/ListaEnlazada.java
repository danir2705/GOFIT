package Datos;
import java.io.*;

public class ListaEnlazada<G> extends Lista
{
	
	public Object listaUsuarios(ListaEnlazada<ListaEnlazada> listaListas)
	{
		Object listaReturn = new ListaEnlazada<Usuario>();
		listaReturn = listaListas.cabeza.dato;
		
		return listaReturn;
	}
	public void addLista(ListaEnlazada<Usuario> lista) 
	{
		if(this.cabeza == null) 
		{
			Object nuevaLista = lista;
			this.cabeza = new Nodo<Object>(nuevaLista);
			
			this.tamaño= 1;
		}
		else 
		{
			Nodo<Object> actual = this.cabeza;
			while(actual.siguiente!= null) 
			{
				actual = actual.siguiente;
			}
			Object nuevaLista = lista;
			Nodo<Object> nuevoNodo = new Nodo<Object>(nuevaLista);
			actual.siguiente= nuevoNodo;
			
			this.tamaño+=1;
		}
		
	}
	public void addUsuario(String nombreUsuario, int edad, int peso, String genero, String clave) 
	{
		if(this.cabeza == null) 
		{
			Usuario usuarioNuevo = new Usuario(nombreUsuario, edad, peso, genero, clave);
			Nodo<Usuario> nodoUsuario = new Nodo<Usuario>(usuarioNuevo);
			this.cabeza = nodoUsuario;
			this.cola = nodoUsuario;
			
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
			Nodo<Usuario> actual = this.cola;
			Usuario usuarioNuevo = new Usuario(nombreUsuario, edad, peso, genero, clave);
			Nodo<Usuario> nuevoNodo = new Nodo<Usuario>(usuarioNuevo);
			actual.siguiente= nuevoNodo;
			nuevoNodo.anterior = actual;
			this.cola = nuevoNodo;
			
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
			Nodo<Usuario> nodoUsuario = new Nodo<Usuario>(usuarioNuevo);
			this.cabeza = nodoUsuario;
			this.cola = nodoUsuario;
			
			this.tamaño= 1;
		}
		else 
		{
			Nodo<Usuario> actual = this.cola;
			Usuario usuarioNuevo = new Usuario(nombreUsuario, edad, peso, genero, clave);
			Nodo<Usuario> nuevoNodo = new Nodo<Usuario>(usuarioNuevo);
			actual.siguiente= nuevoNodo;
			nuevoNodo.anterior = actual;
			this.cola = nuevoNodo;
			
			this.tamaño+=1;
		}
		
	}
	public void addRutinas(Rutinas rutina) 
	{
		if(this.cabeza == null) 
		{
			Rutinas rutinaNueva = rutina;
			this.cabeza = new Nodo<Rutinas>(rutinaNueva);
			
			this.tamaño= 1;
		}
		else 
		{
			Nodo<Rutinas> actual = this.cabeza;
			while(actual.siguiente!= null) 
			{
				actual = actual.siguiente;
			}
			Rutinas rutinaNuevo = rutina;
			Nodo<Rutinas> nuevoNodo = new Nodo<Rutinas>(rutina);
			actual.siguiente= nuevoNodo;
			
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
	
	public void editarTxt() 
	{
		Nodo<Usuario> actual = this.cabeza;
		File archivoViejo = new File("Usuarios.txt");
		archivoViejo.delete();
		try 
		{
			archivoViejo.createNewFile();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		while(actual!=null) 
		{
			try 
			{	
				FileWriter editorArchivo = new FileWriter("Usuarios.txt", true);
				editorArchivo.write(actual.dato.getNombreUsuario()+","+actual.dato.getEdad()+","+actual.dato.getPeso()+","+actual.dato.getGenero()+","+actual.dato.getContraseña()+","+"\n");
				editorArchivo.close();
				actual = actual.siguiente;
				
			}
			catch(IOException e) 
			{
				System.out.println("Porfa no");
			}
		}
	}
	public void eliminarUsuario(String nombreUsuario) 
	{
		Nodo<Usuario> actual = this.cabeza;
		while(!actual.dato.getNombreUsuario().equals(nombreUsuario) ) 
		{
			actual=actual.siguiente;
			
		}
		if(actual.equals(this.cabeza)) 
		{
			this.cabeza = actual.siguiente;
			this.cabeza.anterior = null;
			actual.siguiente = null;
			this.tamaño-=1;
		}
		else if(actual == this.cola) 
		{
			this.cola = actual.anterior;
			this.cola.siguiente = null;
			actual.anterior = null;
			this.tamaño-=1;
		}
		else 
		{
			actual.anterior.siguiente = actual.siguiente;
			actual.siguiente.anterior = actual.anterior;
			actual.anterior = null;
			actual.siguiente = null;
			this.tamaño-=1;
		}
		
	}
}












package Datos;

import java.util.*;
import java.io.*;

public class MetodosMain 
{
	
	public static boolean nombreNuevoUsuario(ListaEnlazada<Usuario> listaUsuarios, String nombreUsuario) //Completo
	{
		boolean retorno = true;
		if(listaUsuarios.existeUsuario(nombreUsuario)!= null) 
		{
			retorno = false;
		}
		return retorno;
	}
	public static boolean edadUsuario(String edad) //Completo
	{
		boolean retorno = true;
		int entrada = 0;
		try 
		{
			entrada= Integer.parseInt(edad);
		}
		catch(Exception e) 
		{
			retorno = false;
		}
		if((entrada> 100) || (entrada < 14)) 
		{
			retorno = false;
		}
		return retorno;
	}
	public static boolean pesoUsuario(String peso) //Completo
	{
		boolean retorno = true;
		int entrada = 0;
		try 
		{
			entrada = Integer.parseInt(peso);
		}
		catch(Exception e) 
		{
			retorno = false;
		}
		if((entrada > 200) || (entrada < 50)) 
		{
			retorno = false;
		}
		return retorno;
	}
	public static boolean generoUsuario(String genero) //Completo
	{
		boolean retorno = true;
		if((genero.equals("F")) || (genero.equals("M")))
		{
			//Acá no va nada ya que el valor ingresado si es "M" o "F".
		}
		else 
		{
			retorno = false;
		}
		return retorno;
	}
	
	public static boolean cambioUsuario(ListaEnlazada<Usuario> lista, Usuario usuario, String nuevoNombre) 
	{
		boolean retorno = true;
		Nodo<Usuario> recorrer = new Nodo<Usuario>(usuario);
		Nodo<Usuario> actual = lista.cabeza;
		if(nuevoNombre.equals(usuario.getNombreUsuario())) 
		{
			retorno = true;
		}
		else if(nuevoNombre.equals("")) 
		{
			retorno = false;
		}
		else 
		{
			while(actual != null) 
			{
				if(nuevoNombre.equals(actual.dato.getNombreUsuario())) 
				{
					retorno = false;
					break;
				}
				actual = actual.siguiente;
			}
		}
		return retorno;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

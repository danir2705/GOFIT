package Datos;

public class Usuario 
{	
	private String fotoPerfil;
	private String nombreUsuario;
	private int edad;
	private int peso;
	private String genero;
	private String clave;
	
	Usuario(String nombreUsuario, int edad, int peso, String genero, String clave)
	{
		this.edad = edad;
		this.peso = peso;
		this.genero = genero;
		this.nombreUsuario = nombreUsuario;
		this.clave = clave;
	}
	
	public int getEdad() 
	{
		return this.edad;
	}
	public int getPeso() 
	{
		return this.peso;
	}
	public String getGenero() 
	{
		return this.genero;
	}
	
	public String getNombreUsuario() 
	{
		return this.nombreUsuario;
	}
	public String getContraseña() 
	{
		return this.clave;
	}
	
	
}

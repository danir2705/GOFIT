
public class Usuario 
{
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
	public void mostrarDatos() 
	{
		System.out.println("Tu nommbre de usuario es: "+this.getNombreUsuario());
		System.out.println("Tu edad es: "+this.getEdad());
		System.out.println("Tu peso es: "+this.getPeso());
		System.out.println("Tu g�nero es: "+this.getGenero());
	}
	
}

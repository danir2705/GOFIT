package Datos;

public class Ejercicios 
{
	private String nombreEjercicio;
	private String descripcionEjercicio;
	private String dificultadEjercicio;
	private String repeticiones;
	private String fotoEjercicio;
	
	public Ejercicios(String nombreEjercicio, String descripcionEjercicio, String dificultadEjercicio, String repeticiones)
	{
		this.nombreEjercicio = nombreEjercicio;
		this.descripcionEjercicio = descripcionEjercicio;
		this.dificultadEjercicio = dificultadEjercicio;
		this.repeticiones = repeticiones;
	}
	
	public void mostrarEjercicio() 
	{
		System.out.println( "Nombre Ejercicio: "+ this.nombreEjercicio+"\n"+
							"Descripción Ejercicio: "+ this.descripcionEjercicio+"\n"+
							"Difucultad Ejercicio :"+ this.dificultadEjercicio+"\n"+
							"Repeticiones: "+this.repeticiones);
	}
	
	public String getNombre() 
	{
		return this.nombreEjercicio;
	}
	public String getDescripcion() 
	{
		return this.descripcionEjercicio;
	}
	public String getDificultad() 
	{
		return this.dificultadEjercicio;
	}
	public String getRepeticiones() 
	{
		return this.repeticiones;
	}
	public void setFotoEjercicio(String url) 
	{
		this.fotoEjercicio = url;
	}
	public String getFotoEjercicio() 
	{
		return this.fotoEjercicio;
	}

}

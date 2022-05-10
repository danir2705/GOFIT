
public class Ejercicios 
{
	private String nombreEjercicio;
	private String descripcionEjercicio;
	private String dificultadEjercicio;
	private String repeticiones;
	
	Ejercicios(String nombreEjercicio, String descripcionEjercicio, String dificultadEjercicio, String repeticiones)
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

}

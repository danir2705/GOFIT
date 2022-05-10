

import java.util.*;
import java.import java.util.*;
import java.io.*;

public class Main 
{
	static String primeraEntrada() //Completo
	{
		Scanner lectorEntrada = new Scanner(System.in);
		String stringEntrada = "Null";
		String retorno = "0";
		stringEntrada = lectorEntrada.nextLine();
		if(stringEntrada.equals("2") || stringEntrada.equals("1") ) 
		{
			if(stringEntrada.equals("1")) 
			{
				retorno = "1";
			}
			else 
			{
				retorno = "2";
			}
		}
		else
		{
			System.out.println("Porfavor ingresa una opción válida");
			retorno = primeraEntrada();
		}
		return retorno;
	}
	
	static String segundaEntrada() //Completo
	{
		Scanner lectorEntrada = new Scanner(System.in);
		String stringEntrada = "Null";
		String retorno = "0";
		stringEntrada = lectorEntrada.nextLine();
		if(stringEntrada.equals("2") || stringEntrada.equals("1") || stringEntrada.equals("3") ) 
		{
			if(stringEntrada.equals("1")) 
			{
				retorno = "1";
			}
			else if(stringEntrada.equals("2"))
			{
				retorno = "2";
			}
			else
			{
				retorno = "3";
			}
		}
		else
		{
			System.out.println("Porfavor ingresa una opción válida");
			retorno = segundaEntrada();
		}
		return retorno;
	}
	
	static String terceraEntrada() //Completo
	{
		Scanner lectorEntrada = new Scanner(System.in);
		String stringEntrada = "Null";
		String retorno = "0";
		stringEntrada = lectorEntrada.nextLine();
		if(stringEntrada.equals("2") || stringEntrada.equals("1") || stringEntrada.equals("3") || stringEntrada.equals("4") ) 
		{
			if(stringEntrada.equals("1")) 
			{
				retorno = "1";
			}
			else if(stringEntrada.equals("2"))
			{
				retorno = "2";
			}
			else if(stringEntrada.equals("2"))
			{
				retorno = "3";
			}
			else 
			{
				retorno = "4";
			}
		}
		else
		{
			System.out.println("Porfavor ingresa una opción válida");
			retorno = segundaEntrada();
		}
		return retorno;
	}
	
	static String nombreNuevoUsuario(ListaEnlazada<Usuario> listaUsuarios, Rutinas rutinaBicep) //Completo
	{
		String retorno = "Null";
		Scanner lectorEntrada = new Scanner(System.in);
		String stringEntrada = "Null";
		retorno = lectorEntrada.nextLine();
		if(listaUsuarios.existeUsuario(retorno)!= null) 
		{
			System.out.println("Este nombre de usuario ya existe. Porfavor ingresa un nuevo nombre");
			retorno = nombreNuevoUsuario(listaUsuarios, rutinaBicep);
		}
		return retorno;
	}
	static int edadUsuario() //Completo
	{
		int retorno = 0;
		Scanner lectorEntrada = new Scanner(System.in);
		try 
		{
			retorno = lectorEntrada.nextInt();
		}
		catch(Exception e) 
		{
			System.out.println("Porfavor ingresa un número entre 14 - 100");
			retorno = edadUsuario();
		}
		if((retorno > 100) || (retorno < 14)) 
		{
			System.out.println("Porfavor ingresa un número entre 14 - 100");
			retorno = edadUsuario();
		}
		return retorno;
	}
	static int pesoUsuario() //Completo
	{
		int retorno = 0;
		Scanner lectorEntrada = new Scanner(System.in);
		try 
		{
			retorno = lectorEntrada.nextInt();
		}
		catch(Exception e) 
		{
			System.out.println("Porfavor ingresa un número entre 50 Kg - 200 Kg");
			retorno = pesoUsuario();
		}
		if((retorno > 200) || (retorno < 50)) 
		{
			System.out.println("Porfavor ingresa un número entre 50 Kg - 100 Kg");
			retorno = pesoUsuario();
		}
		return retorno;
	}
	static String generoUsuario() //Completo
	{
		String retorno = "Null";
		Scanner lectorEntrada = new Scanner(System.in);
		retorno = lectorEntrada.nextLine();
		if((retorno.equals("F")) || (retorno.equals("M")))
		{
			//Acá no va nada ya que el valor ingresado si es "M" o "F".
		}
		else 
		{
			System.out.println("Porfavor ingresa M o F");
			retorno = generoUsuario();
		}
		return retorno;
	}
	static void registroUsuario(ListaEnlazada<Usuario> ListaUsuarios, Rutinas rutinaBicep) //Completo
	{
		Scanner lectorEntrada = new Scanner(System.in);
		String nombreNuevoUsuario = "Null";
		String contraseñaNuevoUsuario = "Null";
		int edadNuevoUsuario = 0;
		int pesoNuevoUsuario = 0;
		String generoNuevoUsuario = "Null";
		String segundaEntrada = "Null";
		System.out.println("Porfavor ingresa el nombre de usuario que te gustaría tener");
		nombreNuevoUsuario = nombreNuevoUsuario(ListaUsuarios, rutinaBicep);
		System.out.println("Porfavor ingresa tu contraseña");
		contraseñaNuevoUsuario = lectorEntrada.nextLine();
		System.out.println("Porfavor ingresa tu edad");
		edadNuevoUsuario = edadUsuario();
		System.out.println("Porfavor ingresa tu peso");
		pesoNuevoUsuario = pesoUsuario();
		System.out.println("Porfavor ingresa tu genero");
		generoNuevoUsuario = generoUsuario();
		System.out.println(generoNuevoUsuario);
		ListaUsuarios.addUsuario(nombreNuevoUsuario, edadNuevoUsuario, pesoNuevoUsuario, generoNuevoUsuario, contraseñaNuevoUsuario);
		System.out.println("Tu usuario ha sido creado de forma exitosa!\nQué deseas hacer ahora:\n1. Volver al menu inicial 2. Ingresar a tu cuenta 3. Salir");
		segundaEntrada = segundaEntrada();
		if(segundaEntrada.equals("1")) 
		{
			menuPrincipal(ListaUsuarios, rutinaBicep);
		}
		else if(segundaEntrada.equals("2"))
		{
			ingresoUsuario(ListaUsuarios, rutinaBicep);
		}
		else 
		{
			System.exit(0);
		}

	}
	static void menuPrincipal(ListaEnlazada<Usuario> listaUsuarios, Rutinas rutinaBicep) //Completo
	{
		String eleccion = "Null";
		
		System.out.println("Bienvenido a GOFIT "+ "\nIngresa 1 si quieres ingresar a tu perfíl o 2 si te quieres registrar");
		eleccion = primeraEntrada();
		if(eleccion.equals("2")) 
		{
			registroUsuario(listaUsuarios, rutinaBicep);
		}
		else 
		{
			ingresoUsuario(listaUsuarios, rutinaBicep);
		}

	}
	static void ingresoUsuario(ListaEnlazada<Usuario> listaUsuarios, Rutinas rutinaBicep) //Completo
	{
		Scanner lectorEntrada = new Scanner(System.in);
		Usuario usuarioActual = null;
		String nombreUsuario = "Null";
		String contraseñaUsuario = "Null";
		String segundaEntrada = "Null";
		String primeraEntrada = "Null";
		System.out.println("Porfavor ingresa tu nombre de usuario");
		nombreUsuario = lectorEntrada.nextLine();
		if(listaUsuarios.existeUsuario(nombreUsuario)!=null) 
		{
			usuarioActual = listaUsuarios.existeUsuario(nombreUsuario);
			System.out.println("Porfavor ingresa tu contraseña");
			contraseñaUsuario = lectorEntrada.nextLine();
			if(usuarioActual.getContraseña().equals(contraseñaUsuario)==false) 
			{
				System.out.println("Contraseña incorrecta. Presiona: 1. Si quieres volver a intentarlo 2. Si quieres volver al menú principal 3. Si quieres salir");
				segundaEntrada = segundaEntrada();
				if(segundaEntrada.equals("1")) 
				{
					ingresoUsuario(listaUsuarios, rutinaBicep);
				}
				else if(segundaEntrada.equals("2"))
				{
					menuPrincipal(listaUsuarios, rutinaBicep);
				}
				else 
				{
					System.exit(0);
				}
			}
			else 
			{
				System.out.println("Has ingresado de manera exitosa!");
				menuPerfil(listaUsuarios, usuarioActual, rutinaBicep);
			}
		}
		else 
		{
			System.out.println("Este nombre de usuario no existe.\nPresiona: 1. Si quieres intentarlo de nuevo 2. si quieres registrarte 3. Si quieres salir");
			segundaEntrada = segundaEntrada();
			if(segundaEntrada.equals("1")) 
			{
				ingresoUsuario(listaUsuarios, rutinaBicep);
			}
			else if(segundaEntrada.equals("2"))
			{
				registroUsuario(listaUsuarios, rutinaBicep);
			}
			else 
			{
				System.exit(0);
			}
		}
	}
	
	public static void menuPerfil(ListaEnlazada<Usuario> listaUsuarios, Usuario usuario, Rutinas rutinaBicep) //Completo
	{
		String primeraEntrada = "Null";
		String segundaEntrada = "Null";
		System.out.println("Qué deseas hacer?\n1.Mirar los datos de tu perfíl 2.Realizar ejercicio 3. Salir");
		segundaEntrada = segundaEntrada();
		if(segundaEntrada.equals("1")) 
		{
			usuario.mostrarDatos();
			System.out.println("Qué deseas hacer?\n1.Volver al menú anterior 2.Salir");
			primeraEntrada = primeraEntrada();
			if(primeraEntrada.equals("1")) 
			{
				menuPerfil(listaUsuarios, usuario, rutinaBicep);
			}
			else 
			{
				System.exit(0);
			}
			
		}
		else if(segundaEntrada.equals("2"))
		{
			realizarEjercicio(listaUsuarios, rutinaBicep);
		}
		else 
		{
			System.exit(0);
		}
	}
	
	public static void comenzarRutina(Rutinas rutina) 
	{
		String primeraEntrada = "Null";
		rutina.mostrarEjercicioActual();
		System.out.println("Presiona: 1. Para ir al siguiente ejercicio 2. Para ir al anterior ");
		primeraEntrada = primeraEntrada();
		if(primeraEntrada.equals("1")) 
		{
			if (rutina.siguiente()==true) 
			{
				System.out.println("Has acabado!");
				System.exit(0);
			}
			else 
			{
				comenzarRutina(rutina);
			}
		}
		else 
		{
			rutina.anterior();
			comenzarRutina(rutina);
		}
		
	}
	
	public static void realizarEjercicio(ListaEnlazada<Usuario> listaUsuarios, Rutinas rutinaBicep) 
	{
		System.out.println("Excelente! Qué quieres trabajar hoy?\n1.Brazo 2.Bicep 3.Pierna 4.Abdomen");
		String terceraEntrada = "Null";
		terceraEntrada = terceraEntrada();
		if(terceraEntrada.equals("1")) 
		{
			System.out.println("Todavía no tenemos rutinas para esa categoría :(\nEstamos trabajando arduamente para que puedas realizar nuevos ejercicios y rutinas :D");
		}
		else if(terceraEntrada.equals("2")) 
		{
			System.out.println("Genial! Este es tu primer ejercicio. Recuerda descansar 40 segundos entre ejercicios y 1:20 minutos entre series");
			comenzarRutina(rutinaBicep);
			
		}
		else if(terceraEntrada.equals("3")) 
		{
			System.out.println("Todavía no tenemos rutinas para esa categoría :(\nEstamos trabajando arduamente para que puedas realizar nuevos ejercicios y rutinas :D");
		}
		else
		{
			System.out.println("Todavía no tenemos rutinas para esa categoría D:\nEstamos trabajando arduamente para que puedas realizar nuevos ejercicios y rutinas :D");
		}
		
	}
	
	public static void main(String[]  args) 
	{
		ListaEnlazada<Usuario> Usuarios = new ListaEnlazada<Usuario>();
		ListaEnlazada<Rutinas> Rutinas = new ListaEnlazada<Rutinas>();
		Ejercicios bicepCurl = new Ejercicios("Bicep Curl","Lleva la mancuerna en posicion neurtral hasta tu hombro","2","8-12");
		Ejercicios bicepHammer = new Ejercicios("Hammer Curl","Con tu pulgar mirando hacia arriba, realiza una curl del bicep","3","8-12");
		Ejercicios flexionBicep = new Ejercicios("Flexiones Inversas","Realiza una flexión o lagartija con tus muñecas apuntando hacia afuera","8","6-8");
		Ejercicios bicepInverso = new Ejercicios("Curl Inverso","Con la palma de tu mano mirando hacia abajo, realiza un curl normal","6","8-10");
		Pila<Ejercicios> pilaBicepUno = new Pila<Ejercicios>();
		Pila<Ejercicios> pilaBicepDos = new Pila<Ejercicios>();
		Cola<Ejercicios> colaBicepUno = new Cola<Ejercicios>();
		pilaBicepUno.push(bicepCurl);
		pilaBicepUno.push(bicepHammer);
		pilaBicepUno.push(flexionBicep);
		pilaBicepUno.push(bicepInverso);
		Rutinas rutinaBicep = new Rutinas("4",pilaBicepUno,pilaBicepDos,colaBicepUno);
		
		try 
		{
			File archivoUsuarios = new File("Usuarios.txt");
			if(archivoUsuarios.createNewFile()) 
			{
				System.out.println("Archivo creado de forma exitosa");
			}
			else 
			{
				System.out.println("El archivo ya existe");
				try 
				{
					Scanner lectorArchivo = new Scanner(archivoUsuarios);
					while(lectorArchivo.hasNextLine()) 
					{
						String nombreUsuario = "";
						int edadUsuario = 0;
						int pesoUsuario = 0;
						String generoUsuario = "";
						String claveUsuario = "";
						String entrada = lectorArchivo.nextLine();
						String datoActual = "";
						int contador = 0;
						for(int i = 0;i<entrada.length();i++) 
						{
							if(entrada.charAt(i)!=',') 
							{
								datoActual+=entrada.charAt(i);
							}
							else 
							{
								switch(contador) 
								{
								case 0:
									nombreUsuario = datoActual;
									datoActual = "";
									contador+=1;
									break;
								case 1:
									edadUsuario = Integer.parseInt(datoActual);
									datoActual = "";
									contador+=1;
									break;
								case 2:
									pesoUsuario = Integer.parseInt(datoActual);
									datoActual = "";
									contador+=1;
									break;
								case 3:
									generoUsuario = datoActual;
									datoActual = "";
									contador+=1;
									break;
								case 4:
									claveUsuario = datoActual;
									datoActual = "";
									contador+=1;
									break;
								}
							}
						}
						Usuarios.addUsuarioUnicamenteALista(nombreUsuario, edadUsuario, pesoUsuario, generoUsuario, claveUsuario);
					}
				}
				
				catch(FileNotFoundException e) 
				{
					System.out.println("An error occurred.");
				}
			}
		}
		catch(IOException e) 
		{
			System.out.println("Porfa no");
		}
		menuPrincipal(Usuarios, rutinaBicep);
		
	}
}
io.*;

public class Main 
{
	static String primeraEntrada() //Completo
	{
		Scanner lectorEntrada = new Scanner(System.in);
		String stringEntrada = "Null";
		String retorno = "0";
		stringEntrada = lectorEntrada.nextLine();
		if(stringEntrada.equals("2") || stringEntrada.equals("1") ) 
		{
			if(stringEntrada.equals("1")) 
			{
				retorno = "1";
			}
			else 
			{
				retorno = "2";
			}
		}
		else
		{
			System.out.println("Porfavor ingresa una opción válida");
			retorno = primeraEntrada();
		}
		return retorno;
	}
	
	static String segundaEntrada() //Completo
	{
		Scanner lectorEntrada = new Scanner(System.in);
		String stringEntrada = "Null";
		String retorno = "0";
		stringEntrada = lectorEntrada.nextLine();
		if(stringEntrada.equals("2") || stringEntrada.equals("1") || stringEntrada.equals("3") ) 
		{
			if(stringEntrada.equals("1")) 
			{
				retorno = "1";
			}
			else if(stringEntrada.equals("2"))
			{
				retorno = "2";
			}
			else
			{
				retorno = "3";
			}
		}
		else
		{
			System.out.println("Porfavor ingresa una opción válida");
			retorno = segundaEntrada();
		}
		return retorno;
	}
	
	static String terceraEntrada() //Completo
	{
		Scanner lectorEntrada = new Scanner(System.in);
		String stringEntrada = "Null";
		String retorno = "0";
		stringEntrada = lectorEntrada.nextLine();
		if(stringEntrada.equals("2") || stringEntrada.equals("1") || stringEntrada.equals("3") || stringEntrada.equals("4") ) 
		{
			if(stringEntrada.equals("1")) 
			{
				retorno = "1";
			}
			else if(stringEntrada.equals("2"))
			{
				retorno = "2";
			}
			else if(stringEntrada.equals("2"))
			{
				retorno = "3";
			}
			else 
			{
				retorno = "4";
			}
		}
		else
		{
			System.out.println("Porfavor ingresa una opción válida");
			retorno = segundaEntrada();
		}
		return retorno;
	}
	
	static String nombreNuevoUsuario(ListaEnlazada<Usuario> listaUsuarios) //Completo
	{
		String retorno = "Null";
		Scanner lectorEntrada = new Scanner(System.in);
		String stringEntrada = "Null";
		retorno = lectorEntrada.nextLine();
		if(listaUsuarios.existeUsuario(retorno)!= null) 
		{
			System.out.println("Este nombre de usuario ya existe. Porfavor ingresa un nuevo nombre");
			retorno = nombreNuevoUsuario(listaUsuarios);
		}
		return retorno;
	}
	static int edadUsuario() //Completo
	{
		int retorno = 0;
		Scanner lectorEntrada = new Scanner(System.in);
		try 
		{
			retorno = lectorEntrada.nextInt();
		}
		catch(Exception e) 
		{
			System.out.println("Porfavor ingresa un n�mero entre 14 - 100");
			retorno = edadUsuario();
		}
		if((retorno > 100) || (retorno < 14)) 
		{
			System.out.println("Porfavor ingresa un n�mero entre 14 - 100");
			retorno = edadUsuario();
		}
		return retorno;
	}
	static int pesoUsuario() //Completo
	{
		int retorno = 0;
		Scanner lectorEntrada = new Scanner(System.in);
		try 
		{
			retorno = lectorEntrada.nextInt();
		}
		catch(Exception e) 
		{
			System.out.println("Porfavor ingresa un n�mero entre 50 Kg - 200 Kg");
			retorno = pesoUsuario();
		}
		if((retorno > 200) || (retorno < 50)) 
		{
			System.out.println("Porfavor ingresa un n�mero entre 50 Kg - 100 Kg");
			retorno = pesoUsuario();
		}
		return retorno;
	}
	static String generoUsuario() //Completo
	{
		String retorno = "Null";
		Scanner lectorEntrada = new Scanner(System.in);
		retorno = lectorEntrada.nextLine();
		if((retorno.equals("F")) || (retorno.equals("M")))
		{
			//Ac� no va nada ya que el valor ingresado si es "M" o "F".
		}
		else 
		{
			System.out.println("Porfavor ingresa M o F");
			retorno = generoUsuario();
		}
		return retorno;
	}
	static void registroUsuario(ListaEnlazada<Usuario> ListaUsuarios) //Completo
	{
		Scanner lectorEntrada = new Scanner(System.in);
		String nombreNuevoUsuario = "Null";
		String contraseñaNuevoUsuario = "Null";
		int edadNuevoUsuario = 0;
		int pesoNuevoUsuario = 0;
		String generoNuevoUsuario = "Null";
		String segundaEntrada = "Null";
		System.out.println("Porfavor ingresa el nombre de usuario que te gustar�a tener");
		nombreNuevoUsuario = nombreNuevoUsuario(ListaUsuarios);
		System.out.println("Porfavor ingresa tu contrase�a");
		contraseñaNuevoUsuario = lectorEntrada.nextLine();
		System.out.println("Porfavor ingresa tu edad");
		edadNuevoUsuario = edadUsuario();
		System.out.println("Porfavor ingresa tu peso");
		pesoNuevoUsuario = pesoUsuario();
		System.out.println("Porfavor ingresa tu genero");
		generoNuevoUsuario = generoUsuario();
		System.out.println(generoNuevoUsuario);
		ListaUsuarios.addUsuario(nombreNuevoUsuario, edadNuevoUsuario, pesoNuevoUsuario, generoNuevoUsuario, contraseñaNuevoUsuario);
		System.out.println("Tu usuario ha sido creado de forma exitosa!\nQu� deseas hacer ahora:\n1. Volver al menu inicial 2. Ingresar a tu cuenta 3. Salir");
		segundaEntrada = segundaEntrada();
		if(segundaEntrada.equals("1")) 
		{
			menuPrincipal(ListaUsuarios);
		}
		else if(segundaEntrada.equals("2"))
		{
			ingresoUsuario(ListaUsuarios);
		}
		else 
		{
			System.exit(0);
		}

	}
	static void menuPrincipal(ListaEnlazada<Usuario> listaUsuarios) //Completo
	{
		String eleccion = "Null";
		
		System.out.println("Bienvenido a GOFIT "+ "\nIngresa 1 si quieres ingresar a tu perf�l o 2 si te quieres registrar");
		eleccion = primeraEntrada();
		if(eleccion.equals("2")) 
		{
			registroUsuario(listaUsuarios);
		}
		else 
		{
			ingresoUsuario(listaUsuarios);
		}

	}
	static void ingresoUsuario(ListaEnlazada<Usuario> listaUsuarios) 
	{
		Scanner lectorEntrada = new Scanner(System.in);
		Usuario usuarioActual = null;
		String nombreUsuario = "Null";
		String contraseñaUsuario = "Null";
		String segundaEntrada = "Null";
		String primeraEntrada = "Null";
		System.out.println("Porfavor ingresa tu nombre de usuario");
		nombreUsuario = lectorEntrada.nextLine();
		if(listaUsuarios.existeUsuario(nombreUsuario)!=null) 
		{
			usuarioActual = listaUsuarios.existeUsuario(nombreUsuario);
			System.out.println("Porfavor ingresa tu contraseña");
			contraseñaUsuario = lectorEntrada.nextLine();
			if(usuarioActual.getContraseña().equals(contraseñaUsuario)==false) 
			{
				System.out.println("Contraseña incorrecta. Presiona: 1. Si quieres volver a intentarlo 2. Si quieres volver al men� principal 3. Si quieres salir");
				segundaEntrada = segundaEntrada();
				if(segundaEntrada.equals("1")) 
				{
					ingresoUsuario(listaUsuarios);
				}
				else if(segundaEntrada.equals("2"))
				{
					menuPrincipal(listaUsuarios);
				}
				else 
				{
					System.exit(0);
				}
			}
			else 
			{
				System.out.println("Has ingresado de manera exitosa!");
				menuPerfil(listaUsuarios, usuarioActual);
			}
		}
		else 
		{
			System.out.println("Este nombre de usuario no existe.\nPresiona: 1. Si quieres intentarlo de nuevo 2. si quieres registrarte 3. Si quieres salir");
			segundaEntrada = segundaEntrada();
			if(segundaEntrada.equals("1")) 
			{
				ingresoUsuario(listaUsuarios);
			}
			else if(segundaEntrada.equals("2"))
			{
				registroUsuario(listaUsuarios);
			}
			else 
			{
				System.exit(0);
			}
		}
	}
	
	public static void menuPerfil(ListaEnlazada<Usuario> listaUsuarios, Usuario usuario) 
	{
		String primeraEntrada = "Null";
		String segundaEntrada = "Null";
		System.out.println("Qué deseas hacer?\n1.Mirar los datos de tu perfíl 2.Realizar ejercicio 3. Salir");
		segundaEntrada = segundaEntrada();
		if(segundaEntrada.equals("1")) 
		{
			usuario.mostrarDatos();
			System.out.println("Qué deseas hacer?\n1.Volver al menú anterior 2.Salir");
			primeraEntrada = primeraEntrada();
			if(primeraEntrada.equals("1")) 
			{
				menuPerfil(listaUsuarios, usuario);
			}
			else 
			{
				System.exit(0);
			}
			
		}
		else if(segundaEntrada.equals("2"))
		{
			
		}
		else 
		{
			System.exit(0);
		}
	}
	
	public static void realizarEjercicio(ListaEnlazada<Usuario> listaUsuarios) 
	{
		System.out.println("Qué quieres trabajar hoy?\n1.Brazo 2.Bicep 3.Pierna 4.Abdomen");
		String terceraEntrada = "Null";
		terceraEntrada = terceraEntrada();
		if(terceraEntrada.equals("1")) 
		{
			
		}
		else if(terceraEntrada.equals("2")) 
		{
			
		}
		else if(terceraEntrada.equals("3")) 
		{
			
		}
		else
		{
			
		}
		
	}
	
	public static void main(String[]  args) 
	{
		ListaEnlazada<Usuario> Usuarios = new ListaEnlazada<Usuario>();
		Ejercicios bicepCurl = new Ejercicios("Bicep Curl","Lleva la mancuerna en posicion neurtral hasta tu hombro","2","8-12");
		Ejercicios bicepHammer = new Ejercicios("Hammer Curl","Con tu pulgar mirando hacia arriba, realiza una curl del bicep","3","8-12");
		Ejercicios flexionBicep = new Ejercicios("Flexiones Inversas","Realiza una flexi�n o lagartija con tus mu�ecas apuntando hacia afuera","8","6-8");
		Ejercicios bicepInverso = new Ejercicios("Curl Inverso","Con la palma de tu mano mirando hacia abajo, realiza un curl normal","6","8-10");
		Pila<Ejercicios> pilaBicepUno = new Pila<Ejercicios>();
		Pila<Ejercicios> pilaBicepDos = new Pila<Ejercicios>();
		Cola<Ejercicios> colaBicepUno = new Cola<Ejercicios>();
		pilaBicepUno.push(bicepCurl);
		pilaBicepUno.push(bicepHammer);
		pilaBicepUno.push(flexionBicep);
		pilaBicepUno.push(bicepInverso);
		Rutinas rutinaBicep = new Rutinas("4",pilaBicepUno,pilaBicepDos,colaBicepUno);
		
		try 
		{
			File archivoUsuarios = new File("Usuarios.txt");
			if(archivoUsuarios.createNewFile()) 
			{
				System.out.println("Archivo creado de forma exitosa");
			}
			else 
			{
				System.out.println("El archivo ya existe");
				try 
				{
					Scanner lectorArchivo = new Scanner(archivoUsuarios);
					while(lectorArchivo.hasNextLine()) 
					{
						String nombreUsuario = "";
						int edadUsuario = 0;
						int pesoUsuario = 0;
						String generoUsuario = "";
						String claveUsuario = "";
						String entrada = lectorArchivo.nextLine();
						String datoActual = "";
						int contador = 0;
						for(int i = 0;i<entrada.length();i++) 
						{
							if(entrada.charAt(i)!=',') 
							{
								datoActual+=entrada.charAt(i);
							}
							else 
							{
								switch(contador) 
								{
								case 0:
									nombreUsuario = datoActual;
									datoActual = "";
									contador+=1;
									break;
								case 1:
									edadUsuario = Integer.parseInt(datoActual);
									datoActual = "";
									contador+=1;
									break;
								case 2:
									pesoUsuario = Integer.parseInt(datoActual);
									datoActual = "";
									contador+=1;
									break;
								case 3:
									generoUsuario = datoActual;
									datoActual = "";
									contador+=1;
									break;
								case 4:
									claveUsuario = datoActual;
									datoActual = "";
									contador+=1;
									break;
								}
							}
						}
						Usuarios.addUsuarioUnicamenteALista(nombreUsuario, edadUsuario, pesoUsuario, generoUsuario, claveUsuario);
					}
				}
				
				catch(FileNotFoundException e) 
				{
					System.out.println("An error occurred.");
				}
			}
		}
		catch(IOException e) 
		{
			System.out.println("Porfa no");
		}
		menuPrincipal(Usuarios);
		
	}
}

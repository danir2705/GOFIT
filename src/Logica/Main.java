package Logica;

//Importacion paquetes
import Datos.*;
import IU.*;
//Importacion JavaFX
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.image.*;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.geometry.*;
import javafx.scene.text.*;

//Importacion Java
import java.util.*;
import java.io.*;


public class Main extends Application {
	static Lista_Arbol_AVL<Rutinas> ArbolRutinas = new Lista_Arbol_AVL<Rutinas>();
	static ListaEnlazada<Object> ListasEnlazadas = new ListaEnlazada<Object>();
	static ListaEnlazada<Usuario> ListaUsuarios = new ListaEnlazada<Usuario>();
	static ListaEnlazada<Rutinas> ListaRutinas = new ListaEnlazada<Rutinas>();
	static TablaHash TablaEjercicios = new TablaHash(11);

	@Override
	public void start(Stage primaryStage) throws Exception //Completo
	{
		//Lista enlazada de los usuairos
		
		// Escenario
		Stage Ventana_Principal;
		Ventana_Principal = primaryStage;
		Ventana_Principal.getIcons().add(new Image("https://pngimg.com/uploads/book/book_PNG2111.png"));
				
		//Escena 1
		Image img = new Image("C:\\Users\\USUARIO\\Desktop\\Universidad\\Otros\\Eclipse\\PE_Dos\\Imagenes\\city.png");
		ImageView iview1 = new ImageView(img);
		Label titulo = new Label("Bienvenido a GoFit");
		Label labelIngreso = new Label("Ingresa tu nombre de usuario\n \t     y contraseña");
		TextField nombreUsuario_TF = new TextField();
		TextField contraseñaUsuario_TF = new TextField();
		nombreUsuario_TF.setPromptText("Nombre de Usuario");
		contraseñaUsuario_TF.setPromptText("Contraseña");
		Button ingresar_B = new Button("Ingresar");
		Button crearUsuario_B = new Button("Crear Usuario");
		Button salir_B = new Button("Salir");
		HBox layout_principal = new HBox();
		VBox layout_escena1 = new VBox();
		layout_escena1.setPadding(new Insets(25));
		layout_principal.setPadding(new Insets(10));
		layout_escena1.setSpacing(30);
		layout_escena1.getChildren().addAll(titulo, labelIngreso, nombreUsuario_TF, contraseñaUsuario_TF, ingresar_B, crearUsuario_B, salir_B );
		layout_escena1.setAlignment(Pos.TOP_CENTER);
		layout_principal.getChildren().addAll(layout_escena1, iview1);
		Scene escena1 = new Scene(layout_principal, 600, 520);
		
		
		//Accion Botones
		ingresar_B.setOnAction(e->
		{
			Usuario usuarioActual = null;
			if(ListaUsuarios.existeUsuario(nombreUsuario_TF.getText())!=null) 
			{
				usuarioActual = ListaUsuarios.existeUsuario(nombreUsuario_TF.getText());
				if(usuarioActual.getContraseña().equals(contraseñaUsuario_TF.getText())==true) 
				{
					
					ventanaIngreso(escena1, Ventana_Principal, usuarioActual);
				}
				else 
				{
					Diseños.ventana_Emergente("Contraseña Incorrecta. Por favor intente de nuevo", "Contraseña Incorrecta");
					contraseñaUsuario_TF.clear();
				}
			}
			else 
			{
				Diseños.ventana_Emergente("Usuario no encontrado. Por favor intente de nuevo","Usuario inexistente");
				nombreUsuario_TF.clear();
				contraseñaUsuario_TF.clear();
			}
		});
		crearUsuario_B.setOnAction(e->
		{
			nombreUsuario_TF.clear();
			contraseñaUsuario_TF.clear();
			Crear_Usuario(escena1, Ventana_Principal);
		});
		salir_B.setOnAction(e->
		{
			Ventana_Principal.close();
		});
		//Show ventana
		Ventana_Principal.setScene(escena1);
		Ventana_Principal.setTitle("GoFit");
		Ventana_Principal.show();
	}
	public static void ventanaIngreso(Scene scene, Stage stage, Usuario nombreUsuario) 
	{
		VBox lay1V = new VBox();
		HBox lay1H = new HBox();
		VBox layPerfil = new VBox();
		VBox layEjercitarse = new VBox();
		VBox laySalir = new VBox();
		VBox layBuscar = new VBox();
		lay1V.setPadding(new Insets(10));
		lay1H.setPadding(new Insets(10));
		layPerfil.setPadding(new Insets(10));
		layEjercitarse.setPadding(new Insets(10));
		laySalir.setPadding(new Insets(10));
		layBuscar.setPadding(new Insets(10));
		Image perfil = new Image("C:\\Users\\USUARIO\\Desktop\\Universidad\\Otros\\Eclipse\\PE_Dos\\Imagenes\\perfil.png");
		Image bicep = new Image("C:\\Users\\USUARIO\\Desktop\\Universidad\\Otros\\Eclipse\\PE_Dos\\Imagenes\\bicep.png");
		Image salir = new Image("C:\\Users\\USUARIO\\Desktop\\Universidad\\Otros\\Eclipse\\PE_Dos\\Imagenes\\salir.png");
		Image buscar = new Image("C:\\Users\\USUARIO\\Desktop\\Universidad\\Otros\\Eclipse\\PE_Dos\\Imagenes\\lupa.png");
		ImageView ivPerfil = new ImageView(perfil);
		ImageView ivBicep = new ImageView(bicep);
		ImageView ivSalir = new ImageView(salir);
		ImageView ivBuscar = new ImageView(buscar);
		ivPerfil.setFitHeight(200);
		ivPerfil.setFitWidth(200);
		ivBicep.setFitHeight(200);
		ivBicep.setFitWidth(200);
		ivSalir.setFitHeight(200);
		ivSalir.setFitWidth(200);
		ivBuscar.setFitHeight(200);
		ivBuscar.setFitWidth(200);
		ivPerfil.setPreserveRatio(true);
		ivBicep.setPreserveRatio(true);
		ivSalir.setPreserveRatio(true);
		ivBuscar.setPreserveRatio(true);
		Label bienvenido_LB = new Label("Bienvenido!");
		Label perfil_LB = new Label("Perfil");
		Label ejercitarse_LB = new Label("Ejercitarse");
		Label salir_LB = new Label("Salir");
		Label buscar_LB = new Label("Buscar Ejercicio");
		bienvenido_LB.setPadding(new Insets(10));
		perfil_LB.setPadding(new Insets(10));
		ejercitarse_LB.setPadding(new Insets(10));
		salir_LB.setPadding(new Insets(10));
		buscar_LB.setPadding(new Insets(10));
		Button perfil_B = new Button();
		Button bicep_B = new Button();
		Button salir_B = new Button();
		Button buscar_B = new Button();
		perfil_B.setPrefSize(210, 210);
		bicep_B.setPrefSize(210, 210);
		salir_B.setPrefSize(210, 210);
		buscar_B.setPrefSize(210, 210);
		perfil_B.setGraphic(ivPerfil);
		bicep_B.setGraphic(ivBicep);
		salir_B.setGraphic(ivSalir);
		buscar_B.setGraphic(ivBuscar);
		layPerfil.getChildren().addAll(perfil_B, perfil_LB);
		layPerfil.setAlignment(Pos.CENTER);
		layEjercitarse.setAlignment(Pos.CENTER);
		laySalir.setAlignment(Pos.CENTER);
		layBuscar.setAlignment(Pos.CENTER);
		layBuscar.getChildren().addAll(buscar_B, buscar_LB);
		layEjercitarse.getChildren().addAll(bicep_B, ejercitarse_LB);
		laySalir.getChildren().addAll(salir_B, salir_LB);
		lay1H.getChildren().addAll(layPerfil, layEjercitarse, layBuscar);
		lay1V.getChildren().addAll(bienvenido_LB, lay1H, laySalir);
		lay1V.setAlignment(Pos.CENTER);
		//Escena y stage
		Scene escena2 = new Scene(lay1V, 800, 800);
		stage.setScene(escena2);
		//Accion botones
		perfil_B.setOnAction(e->
		{
			perfilUsuario(stage, scene, nombreUsuario);
		});
		salir_B.setOnAction(e->
		{
			stage.close();
		});
		bicep_B.setOnAction(e->
		{
			ejercitarse(scene,stage, nombreUsuario);
		});
		buscar_B.setOnAction(e->
		{
			buscarEjercicio(stage, escena2, nombreUsuario);
		});
	}
	
	public static void buscarEjercicio(Stage stage, Scene scene, Usuario nombreUsuario) 
	{
		VBox lay_V = new VBox();
		lay_V.setPadding(new Insets(10));
		lay_V.setSpacing(10);
		lay_V.setAlignment(Pos.TOP_CENTER);
		HBox lay_H = new HBox();
		lay_H.setSpacing(10);
		lay_H.setPadding(new Insets(10));
		lay_H.setAlignment(Pos.TOP_CENTER);
		Label textoInicial_LB = new Label("Ingresa el nombre del ejercicio que deseas buscar");
		textoInicial_LB.setPadding(new Insets(10));
		TextField buscar_TF = new TextField();
		buscar_TF.setMaxWidth(500);
		buscar_TF.setFocusTraversable(false);
		buscar_TF.setPromptText("Nombre del Ejercicio");
		Button buscar_B = new Button("Buscar");
		Button volver_B = new Button("Volver");
		lay_H.getChildren().addAll(buscar_B, volver_B);
		lay_V.getChildren().addAll(textoInicial_LB ,buscar_TF,lay_H);
		Scene escena = new Scene(lay_V, 700,700);
		stage.setScene(escena);
		
		buscar_B.setOnAction(e->
		{
			Nodo<Ejercicios> ejercicio = TablaEjercicios.retorarEjercicio(buscar_TF.getText());
			if(ejercicio != null) 
			{
				mostrarEjercicio(stage, scene, nombreUsuario, ejercicio.dato);
			}
			else 
			{
				Diseños.ventana_Emergente("Ejercicio no encontrado. Por favor, introducelo nuevamente con su nombre exacto", "Ejercicio no encontrado");
				buscar_TF.clear();
			}
		});
		
		volver_B.setOnAction(e->
		{
			ventanaIngreso(scene, stage, nombreUsuario);
		});
	}
	
	public static void mostrarEjercicio(Stage stage, Scene scene, Usuario nombreUsuario, Ejercicios ejercicio) 
	{
		Image fotoEjercicio = new Image(ejercicio.getFotoEjercicio());
		ImageView fotoEjercicio_Iv = new ImageView(fotoEjercicio);
		fotoEjercicio_Iv.setFitWidth(400);
		fotoEjercicio_Iv.setFitHeight(400);
		fotoEjercicio_Iv.setPreserveRatio(true);
		VBox lay1V = new VBox();
		lay1V.setPadding(new Insets(10));
		HBox lay1H = new HBox();
		lay1H.setPadding(new Insets(10));
		Text infoEjercicio_Txt = new Text();
		infoEjercicio_Txt.setText("Descripción: "+ejercicio.getDescripcion());
		Label tituloEjercicio_LB = new Label("Nombre: "+ejercicio.getNombre());
		Label dificultadEjercicio_LB = new Label("Dificultad: "+ejercicio.getDificultad());
		Label repeticionesEjercicio_LB = new Label("Repeticiones: "+ejercicio.getRepeticiones());
		Button volver_B = new Button("Volver");
		lay1H.getChildren().addAll(volver_B);
		lay1V.getChildren().addAll(fotoEjercicio_Iv ,tituloEjercicio_LB, infoEjercicio_Txt, dificultadEjercicio_LB, repeticionesEjercicio_LB, lay1H);
		Scene escena = new Scene(lay1V, 700, 700);
		stage.setScene(escena);
		
		volver_B.setOnAction(e->
		{
			buscarEjercicio(stage, scene, nombreUsuario);
		});
	}
	
	public static void perfilUsuario(Stage stage, Scene scene, Usuario nombreUsuario) 
	{
		//Layouts
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10));
		Image fotoPerfil = new Image("C:\\Users\\USUARIO\\Desktop\\Universidad\\Otros\\Eclipse\\PE_Dos\\Imagenes\\perfil.png");
		ImageView fp_Iv = new ImageView(fotoPerfil);
		fp_Iv.setFitHeight(200);
		fp_Iv.setFitWidth(200);
		Label nombre_Lb = new Label("Nombre:");
		nombre_Lb.setPadding(new Insets(10));
		TextField nombre_Tf = new TextField(nombreUsuario.getNombreUsuario());
		nombre_Tf.setEditable(false);
		nombre_Tf.setMouseTransparent(true);
		nombre_Tf.setFocusTraversable(false);
		nombre_Tf.setPadding(new Insets(10));
		Label edad_Lb = new Label("Edad:");
		edad_Lb.setPadding(new Insets(10));
		TextField edad_Tf = new TextField(String.valueOf(nombreUsuario.getEdad()));
		edad_Tf.setEditable(false);
		edad_Tf.setMouseTransparent(true);
		edad_Tf.setFocusTraversable(false);
		edad_Tf.setPadding(new Insets(10));
		Label peso_Lb = new Label("Peso:");
		peso_Lb.setPadding(new Insets(10));
		TextField peso_Tf = new TextField(String.valueOf(nombreUsuario.getPeso()));
		peso_Tf.setEditable(false);
		peso_Tf.setMouseTransparent(true);
		peso_Tf.setFocusTraversable(false);
		peso_Tf.setPadding(new Insets(10));
		Label genero_Lb = new Label("Genero:");
		genero_Lb.setPadding(new Insets(10));
		TextField genero_Tf = new TextField(nombreUsuario.getGenero());
		genero_Tf.setEditable(false);
		genero_Tf.setMouseTransparent(true);
		genero_Tf.setFocusTraversable(false);
		genero_Tf.setPadding(new Insets(10));
		Label vacio = new Label("");
		Button volver_B = new Button("Volver");
		Button editar_B = new Button ("Editar perfil");
		Button guardar_B = new Button("Guardar");
		Button eliminar_B = new Button("Borrar cuenta");
		
		grid.addColumn(0, fp_Iv, nombre_Lb, edad_Lb, peso_Lb, genero_Lb, volver_B);
		grid.addColumn(1, vacio, nombre_Tf, edad_Tf, peso_Tf, genero_Tf, editar_B);
		grid.addColumn(3,eliminar_B);
		Scene escenaPU = new Scene(grid, 700, 700);
		//Accion botones
		volver_B.setOnAction(e->
		{
			ventanaIngreso(scene,stage,nombreUsuario);
		});
		
		editar_B.setOnAction(e->
		{
			nombre_Tf.setEditable(true);
			nombre_Tf.setMouseTransparent(false);
			nombre_Tf.setFocusTraversable(true);
			nombre_Tf.setPromptText("Introduzca su nombre");
			
			edad_Tf.setEditable(true);
			edad_Tf.setMouseTransparent(false);
			edad_Tf.setFocusTraversable(true);
			edad_Tf.clear();
			edad_Tf.setPromptText("Introduca su edad");
			
			
			peso_Tf.setEditable(true);
			peso_Tf.setMouseTransparent(false);
			peso_Tf.setFocusTraversable(true);
			peso_Tf.clear();
			peso_Tf.setPromptText("Introduzca su peso");
			
			genero_Tf.setEditable(true);
			genero_Tf.setMouseTransparent(false);
			genero_Tf.setFocusTraversable(true);
			genero_Tf.clear();
			genero_Tf.setPromptText("Introduzca su genero");
			grid.add(guardar_B, 2, 5);
			
		});
		
		guardar_B.setOnAction(e->
		{
			ListaEnlazada<Usuario> copiaLista = ListaUsuarios;
			String nuevoNombre = nombreUsuario.getNombreUsuario();
			int pesoUsuario = nombreUsuario.getPeso();
			int edadUsuario = nombreUsuario.getEdad();
			String generoUsuario = nombreUsuario.getGenero();
			String contraUsuario = nombreUsuario.getContraseña();
			
			if((nombre_Tf.getText().equals(""))) 
			{
				Diseños.ventana_Emergente("Uno de los campos está vacío. Porfavor ingresa un valor correcto", "Nombre de Usuario");
				copiaLista = ListaUsuarios;
			}
			else if(MetodosMain.edadUsuario(edad_Tf.getText())==false) 
			{
				Diseños.ventana_Emergente("Porfavor ingresa un número entre 14 - 100", "Edad incorrecta");
				edad_Tf.clear();
			}
			else if(MetodosMain.cambioUsuario(ListaUsuarios, nombreUsuario, nombre_Tf.getText())==false) 
			{
				Diseños.ventana_Emergente("Este nombre de usuario ya existe. Porfavor ingresa un nuevo nombre", "Nombre de Usuario Incorrecto");
				nombre_Tf.setText(nombreUsuario.getNombreUsuario());
			}
			else if(MetodosMain.pesoUsuario(peso_Tf.getText())==false) 
			{
				Diseños.ventana_Emergente("Porfavor ingresa un número entre 50 Kg - 100 Kg", "Peso incorrecto");
				peso_Tf.clear();
			}
			else if(MetodosMain.generoUsuario(genero_Tf.getText())==false) 
			{
				Diseños.ventana_Emergente("Porfavor ingresa M o F", "Formato de genero incorrecto");
				genero_Tf.clear();
			}
			else 
			{
				nuevoNombre = nombre_Tf.getText();
				pesoUsuario = Integer.parseInt(peso_Tf.getText());
				edadUsuario = Integer.parseInt(edad_Tf.getText());
				generoUsuario = genero_Tf.getText();
				ListaUsuarios.eliminarUsuario(nombreUsuario.getNombreUsuario());
				ListaUsuarios.addUsuario(nuevoNombre, edadUsuario, pesoUsuario, generoUsuario, contraUsuario);
				ListaUsuarios.editarTxt();
				Diseños.ventana_Emergente("Usuario editado de forma existosa!", "Exito");
				perfilUsuario(stage, scene, ListaUsuarios.existeUsuario(nuevoNombre));
			}
		});
		
		eliminar_B.setOnAction(e->
		{
			ListaUsuarios.eliminarUsuario(nombreUsuario.getNombreUsuario());
			ListaUsuarios.editarTxt();
			Diseños.ventana_Emergente("Usuario eliminado", "Exito");
			stage.setScene(scene);
		});
		//Scene
		
		stage.setScene(escenaPU);
			
	}
	
	public static void ejercitarse(Scene scene, Stage stage, Usuario usuario) 
	{
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setPadding(new Insets(10));
		Image abdomen = new Image("C:\\Users\\USUARIO\\Desktop\\Universidad\\Otros\\Eclipse\\PE_Dos\\Imagenes\\abdomen.jpg");
		Image piernas = new Image("C:\\Users\\USUARIO\\Desktop\\Universidad\\Otros\\Eclipse\\PE_Dos\\Imagenes\\brasos.jpeg");
		Image brazos = new Image("C:\\Users\\USUARIO\\Desktop\\Universidad\\Otros\\Eclipse\\PE_Dos\\Imagenes\\piernas.jpg");
		ImageView ivAbdomen = new ImageView(abdomen);
		ImageView ivBrazos = new ImageView(brazos);
		ImageView ivPiernas = new ImageView(piernas);
		ivAbdomen.setFitHeight(200);
		ivAbdomen.setFitWidth(200);
		ivBrazos.setFitHeight(200);
		ivBrazos.setFitWidth(200);
		ivPiernas.setFitHeight(200);
		ivPiernas.setFitWidth(200);
		ivAbdomen.setPreserveRatio(true);
		ivBrazos.setPreserveRatio(true);
		ivPiernas.setPreserveRatio(true);
		Label bienvenido_LB = new Label("\t\tBienvenido!\n\tQué deseas hacer hoy?");
		Label abdomen_LB = new Label("\t\t\tAbdomen");
		Label brazos_LB = new Label("\t\t\tBrazos");
		Label piernas_LB = new Label("\t\t\tPiernas");
		bienvenido_LB.setPadding(new Insets(10));
		abdomen_LB.setPadding(new Insets(10));
		piernas_LB.setPadding(new Insets(10));
		brazos_LB.setPadding(new Insets(10));
		Button abdomen_B = new Button();
		Button piernas_B = new Button();
		Button brazos_B = new Button();
		abdomen_B.setPrefSize(210, 210);
		piernas_B.setPrefSize(210, 210);
		brazos_B.setPrefSize(210, 210);
		abdomen_B.setGraphic(ivAbdomen);
		brazos_B.setGraphic(ivBrazos);
		piernas_B.setGraphic(ivPiernas);
		grid.add(bienvenido_LB, 1, 0);
		grid.addRow(1, abdomen_B, piernas_B, brazos_B);
		grid.addRow(2, abdomen_LB, piernas_LB, brazos_LB);
		Scene escena = new Scene(grid, 700, 700);
		stage.setScene(escena);
		brazos_B.setOnAction(e->
		{
			rutinasBrazos(scene , stage, usuario);
		});
		
		}
	
	
	public static void rutinasBrazos(Scene scene, Stage stage, Usuario usuario)
	{
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10));
		grid.setHgap(10);
		grid.setVgap(10);
		Label escoge = new Label("Escoge una de las sigueintes rutinas");
		Image unoImg = new Image("https://raw.githubusercontent.com/danir2705/GOFIT/main/SegundaEntrega/Imagenes/1.png");
		ImageView ivUnoImg = new ImageView(unoImg);
		ivUnoImg.setFitHeight(200);
		ivUnoImg.setFitWidth(200);
		ivUnoImg.setPreserveRatio(true);
		Label rutina1_LB = new Label("Rutina 1");
		rutina1_LB.setPadding(new Insets(10));
		Button rutina1_B = new Button();
		rutina1_B.setPrefSize(210, 210);
		rutina1_B.setGraphic(ivUnoImg);
		grid.add(escoge, 1, 0);
		grid.addRow(1, rutina1_B);
		grid.addRow(2, rutina1_LB);
		
		//
		
		rutina1_B.setOnAction(e->
		{
			rutinaActual(ArbolRutinas.buscarNodo(1), stage, scene, usuario);
		});
		
		
		Scene escena1 = new Scene(grid, 700, 700);
		stage.setScene(escena1);
		
	}
	
	public static void rutinaActual(Rutinas rutina, Stage stage, Scene scene, Usuario usuario) 
	{
		Image fotoEjercicio = new Image(rutina.mostrarEjercicioActual().getFotoEjercicio());
		ImageView fotoEjercicio_Iv = new ImageView(fotoEjercicio);
		fotoEjercicio_Iv.setFitWidth(400);
		fotoEjercicio_Iv.setFitHeight(400);
		fotoEjercicio_Iv.setPreserveRatio(true);
		Ejercicios ejercicioActual = rutina.mostrarEjercicioActual();
		VBox lay1V = new VBox();
		lay1V.setPadding(new Insets(10));
		HBox lay1H = new HBox();
		lay1H.setPadding(new Insets(10));
		Text infoEjercicio_Txt = new Text();
		infoEjercicio_Txt.setText("Descripción: "+ejercicioActual.getDescripcion());
		Label tituloEjercicio_LB = new Label("Nombre: "+ejercicioActual.getNombre());
		Label dificultadEjercicio_LB = new Label("Dificultad: "+ejercicioActual.getDificultad());
		Label repeticionesEjercicio_LB = new Label("Repeticiones: "+ejercicioActual.getRepeticiones());
		Button siguiente_B = new Button("Siguiente");
		Button anterior_B = new Button("Anterior");
		lay1H.getChildren().addAll(siguiente_B, anterior_B);
		lay1V.getChildren().addAll(fotoEjercicio_Iv ,tituloEjercicio_LB, infoEjercicio_Txt, dificultadEjercicio_LB, repeticionesEjercicio_LB, lay1H);
		Scene escena = new Scene(lay1V, 700, 700);
		stage.setScene(escena);
		
		siguiente_B.setOnAction(e->
		{
			if(!rutina.siguiente()) 
			{
				rutinaActual(rutina, stage, scene,  usuario);
			}
			else 
			{
				Diseños.ventana_Emergente("Has terminado", "Terminaste");
				rutina.resetRutina();
				ventanaIngreso(scene, stage, usuario);
				
			}
		});
		
		anterior_B.setOnAction(e->
		{
			if(!rutina.anterior()) 
			{
				Diseños.ventana_Emergente("Este es tu primer ejercicio!", "Acabaste de comenzar");
			}
			else 
			{
				rutinaActual(rutina, stage, scene, usuario);
			}
		});
		
		
		
	}
	
	public static void Crear_Usuario(Scene scene, Stage stage) //Falta que el usuario no pueda poner espacios como nombre de usuario o contraseña
	{
		
		//Diseño
		VBox lay_escena2 = new VBox(20);
		lay_escena2.setPadding(new Insets(30));
		Label bienvenido = new Label("Bienvenido!");
		HBox guardar_salir = new HBox(10);
		Button guardar = new Button("Crear Usuario");
		Button salir = new Button("Volver sin crear usuario");
		guardar_salir.getChildren().addAll(guardar, salir);
		TextField nombre_TF = new TextField();
		TextField contraseña_TF = new TextField();
		TextField edad_TF = new TextField();
		TextField peso_TF = new TextField();
		TextField genero_TF = new TextField();
		nombre_TF.setPromptText("Introduzca su nombre");
		contraseña_TF.setPromptText("Introduzca su contraseña");
		edad_TF.setPromptText("Introduca su edad");
		peso_TF.setPromptText("Introduzca su peso");
		genero_TF.setPromptText("Introduzca su genero");
		lay_escena2.getChildren().addAll(bienvenido, nombre_TF, contraseña_TF, edad_TF, peso_TF, genero_TF, guardar_salir);
		lay_escena2.setAlignment(Pos.TOP_CENTER);		
		//Accion botones
		guardar.setOnAction(e->
		{
			if((nombre_TF.getText().equals(""))||(contraseña_TF.getText().equals(""))) 
			{
				Diseños.ventana_Emergente("Uno de los campos está vacío. Porfavor ingresa un valor correcto", "Nombre de Usuario o Contraseña");
			}
			else if(MetodosMain.edadUsuario(edad_TF.getText())==false) 
			{
				Diseños.ventana_Emergente("Porfavor ingresa un número entre 14 - 100", "Edad incorrecta");
				edad_TF.clear();
			}
			else if(MetodosMain.nombreNuevoUsuario(ListaUsuarios, nombre_TF.getText())==false) 
			{
				Diseños.ventana_Emergente("Este nombre de usuario ya existe. Porfavor ingresa un nuevo nombre", "Nombre de Usuario Incorrecto");
				nombre_TF.clear();
			}
			else if(MetodosMain.pesoUsuario(peso_TF.getText())==false) 
			{
				Diseños.ventana_Emergente("Porfavor ingresa un número entre 50 Kg - 100 Kg", "Peso incorrecto");
				peso_TF.clear();
			}
			else if(MetodosMain.generoUsuario(genero_TF.getText())==false) 
			{
				Diseños.ventana_Emergente("Porfavor ingresa M o F", "Formato de genero incorrecto");
				genero_TF.clear();
			}
			else 
			{
				String nombreUsuario = nombre_TF.getText();
				String claveUsuario = contraseña_TF.getText();
				int pesoUsuario = Integer.parseInt(peso_TF.getText());
				int edadUsuario = Integer.parseInt(edad_TF.getText());
				String generoUsuario = genero_TF.getText();
				ListaUsuarios.addUsuario(nombreUsuario, edadUsuario, pesoUsuario, generoUsuario, claveUsuario);
				Diseños.ventana_Emergente("Usuario creado de forma existosa!", "Exito");
				stage.setScene(scene);
			}
		});
		salir.setOnAction(e->
		{
			stage.setScene(scene);
		});
		//Escena y stage
		Scene escena2 = new Scene(lay_escena2, 700, 700);
		stage.setScene(escena2);
	}
	
	
	public static void main(String[] args) {
		
		Lista_Arbol_AVL<Integer> ArbolEjemplo = new Lista_Arbol_AVL<Integer>();
		for(int i = 1; i<13;i++) 
		{
			ArbolEjemplo.insertar(i, i);
		}
		
		
		
		
		Ejercicios bicepCurl = new Ejercicios("Bicep Curl","Lleva la mancuerna en posicion neutral hasta tu hombro.","2","8-12");
		bicepCurl.setFotoEjercicio("C:\\Users\\USUARIO\\Desktop\\Universidad\\Otros\\Eclipse\\PE_Dos\\Imagenes\\BicepCurl.gif");
		Ejercicios bicepHammer = new Ejercicios("Hammer Curl","Con tu pulgar mirando hacia arriba, realiza una curl del bicep.","3","8-12");
		bicepHammer.setFotoEjercicio("C:\\Users\\USUARIO\\Desktop\\Universidad\\Otros\\Eclipse\\PE_Dos\\Imagenes\\HammerCurl.gif");
		Ejercicios flexionBicep = new Ejercicios("Flexiones Inversas","Realiza una flexión o lagartija con los dedos de tus manos apuntando hacia tus zapatos.","8","6-8");
		flexionBicep.setFotoEjercicio("C:\\Users\\USUARIO\\Desktop\\Universidad\\Otros\\Eclipse\\PE_Dos\\Imagenes\\BicepPushUp.gif");
		Ejercicios bicepInverso = new Ejercicios("Curl Inverso","Con la palma de tu mano mirando hacia abajo, realiza un curl normal.","6","8-10");
		bicepInverso.setFotoEjercicio("C:\\Users\\USUARIO\\Desktop\\Universidad\\Otros\\Eclipse\\PE_Dos\\Imagenes\\CurlInverso.gif");
		Pila<Ejercicios> pilaBicepUno = new Pila<Ejercicios>();
		Pila<Ejercicios> pilaBicepDos = new Pila<Ejercicios>();
		Cola<Ejercicios> colaBicepUno = new Cola<Ejercicios>();
		pilaBicepUno.push(bicepCurl);
		pilaBicepUno.push(bicepHammer);
		pilaBicepUno.push(flexionBicep);
		pilaBicepUno.push(bicepInverso);
		Rutinas rutinaBicep = new Rutinas("Rutina 1","4",pilaBicepUno,pilaBicepDos,colaBicepUno);
		ArbolRutinas.insertar(1, rutinaBicep);
		ListaRutinas.addRutinas(rutinaBicep);
		ListasEnlazadas.addLista(ListaUsuarios);
		TablaEjercicios.agregarEjercicio(bicepCurl);
		TablaEjercicios.agregarEjercicio(bicepHammer);
		TablaEjercicios.agregarEjercicio(flexionBicep);
		TablaEjercicios.agregarEjercicio(bicepInverso);
		
		
		try 
		{
			File archivoUsuarios = new File("Usuarios.txt");
			if(archivoUsuarios.createNewFile()) 
			{
				System.out.println("Archivo creado de forma exitosa");
			}
			else 
			{
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
						ListaUsuarios.addUsuarioUnicamenteALista(nombreUsuario, edadUsuario, pesoUsuario, generoUsuario, claveUsuario);
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
		launch(args);
	}
}

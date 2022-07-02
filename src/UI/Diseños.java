package IU;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Diseños 
{
	public static void ventana_Emergente(String mensaje, String titulo) 
	{
		Stage emergente = new Stage();
		emergente.setTitle(titulo);
		emergente.getIcons().add(new Image("https://cdn.pixabay.com/photo/2012/04/01/19/21/exclamation-mark-24144_960_720.png"));
		emergente.initModality(Modality.APPLICATION_MODAL);
		//Nodes
		Label guardar = new Label(mensaje);
		Button Ok = new Button("Ok");		//Layout y scene
		VBox vbox = new VBox(30);
		vbox.getChildren().addAll(guardar, Ok);
		vbox.setAlignment(Pos.TOP_CENTER);
		Scene escena_ve = new Scene(vbox, 600, 100);
		emergente.setScene(escena_ve);
		Ok.setOnAction(e -> 
		{
			emergente.close();
		});
		emergente.showAndWait();
	}
	
	public static void ventana_Emergente_bool(String mensaje, String titulo) 
	{
		boolean retorno = true;
		int a = 0;
		Stage emergente = new Stage();
		emergente.setTitle(titulo);
		emergente.getIcons().add(new Image("https://cdn.pixabay.com/photo/2012/04/01/19/21/exclamation-mark-24144_960_720.png"));
		emergente.initModality(Modality.APPLICATION_MODAL);
		//Nodes
		Label guardar = new Label(mensaje);
		Button Si = new Button("Si");
		Button No = new Button("No");
		//Layout y scene
		VBox vbox = new VBox(30);
		vbox.getChildren().addAll(guardar, Si, No);
		vbox.setAlignment(Pos.TOP_CENTER);
		Scene escena_ve = new Scene(vbox, 600, 100);
		emergente.setScene(escena_ve);
		Si.setOnAction(e -> 
		{   
			emergente.close();
		});
		
		No.setOnAction(e->
		{
			
		});
		emergente.showAndWait();
		
	}
}

package application;

import java.io.IOException;
import java.time.LocalDate;

import controllers.DocenteController;
import controllers.EstudianteController;
import controllers.IniciarDocenteController;
import controllers.IniciarEstudianteController;
import controllers.InicioController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class Aplicacion extends Application{

	private Stage primaryStage;

	@Override
	public void start(Stage primaryStage) {

		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Alcanzando la nota");

		mostrarVentanaIniciar();

	}

	//Procedimientos que muestra las ventanas del proyecto
	
	public void mostrarVentanaIniciar() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class.getResource("../views/Inicio.fxml"));

			AnchorPane rootLayout = (AnchorPane)loader.load();

			InicioController inicioController= loader.getController();
			inicioController.setAplicacion(this);

			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			//primaryStage.setResizable(false);
			primaryStage.show();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void mostrarVentanaIniciarE() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class.getResource("../views/iniciarEstudiante.fxml"));

			AnchorPane rootLayout = (AnchorPane)loader.load();

			IniciarEstudianteController inicioEController= loader.getController();
			inicioEController.setAplicacion(this);

			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			//primaryStage.setResizable(false);
			primaryStage.show();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void mostrarVentanaIniciarD() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class.getResource("../views/inicioDocente.fxml"));

			AnchorPane rootLayout = (AnchorPane)loader.load();

			IniciarDocenteController inicioDController= loader.getController();
			inicioDController.setAplicacion(this);

			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			//primaryStage.setResizable(false);
			primaryStage.show();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void mostrarVentanaDocente() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class.getResource("../views/Docente.fxml"));

			AnchorPane rootLayout = (AnchorPane)loader.load();

			DocenteController docenteController= loader.getController();
			docenteController.setAplicacion(this);

			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			//primaryStage.setResizable(false);
			primaryStage.show();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void mostrarVentanaEstudiante() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class.getResource("../views/Estudiante.fxml"));

			AnchorPane rootLayout = (AnchorPane)loader.load();

			EstudianteController estudianteController= loader.getController();
			estudianteController.setAplicacion(this);

			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			//primaryStage.setResizable(false);
			primaryStage.show();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//procedimiento main 
	
	public static void main(String[] args) {
		launch(args);
	}
}
package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import application.Aplicacion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class InicioController {
	

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnSoyEstudiante;

    @FXML
    private Button btnSoyDocente;
    
    private Aplicacion aplicacion;

    @FXML
    void ingresarDocenteEvent(ActionEvent event) {
    	aplicacion.mostrarVentanaIniciarD();
    }

    @FXML
    void ingresarEstudianteEvent(ActionEvent event) {
    	aplicacion.mostrarVentanaIniciarE();
    }
    
	public void setAplicacion(Aplicacion aplicacion) {
		this.aplicacion = aplicacion;

	}
	

    

}

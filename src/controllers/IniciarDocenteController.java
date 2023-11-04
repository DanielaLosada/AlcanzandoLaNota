package controllers;

import application.Aplicacion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class IniciarDocenteController {
	
	private Aplicacion aplicacion;
	

    @FXML
    private Button btnCrearPrueba;

    @FXML
    void crearPruebaEvent(ActionEvent event) {
    	aplicacion.mostrarVentanaDocente();
    }
    
	public void setAplicacion(Aplicacion aplicacion) {
		this.aplicacion = aplicacion;

	}

}

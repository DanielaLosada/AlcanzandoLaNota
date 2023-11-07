package controllers;

import application.Aplicacion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class IniciarEstudianteController {
	
	private Aplicacion aplicacion;
	
	@FXML
    private Button btnIniciarPrueba;

    @FXML
    void iniciarPruebaEvent(ActionEvent event) {
    	aplicacion.mostrarVentanaEstudiante();
    }

	public void setAplicacion(Aplicacion aplicacion) {
		this.aplicacion = aplicacion;

	}

}

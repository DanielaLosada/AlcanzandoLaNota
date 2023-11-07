package controllers;

import java.net.URL;
import java.util.*;
import application.Aplicacion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class DocenteController {
	
	private Aplicacion aplicacion;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> comboBoxTipoP;

    @FXML
    private AnchorPane seleccionM;

    @FXML
    private TextField txtEnunciadoM;

    @FXML
    private Button btnCrearM;

    @FXML
    private TextField txtResA;

    @FXML
    private TextField txtResB;

    @FXML
    private TextField txtResC;

    @FXML
    private TextField txtResD;

    @FXML
    private ComboBox<String> comboBoxCorrecta;

    @FXML
    private ImageView guardarResM;

    @FXML
    private AnchorPane verdaderoF;

    @FXML
    private TextField txtEnunciadoVF;

    @FXML
    private ComboBox<String> comboBoxVF;

    @FXML
    private Button btnCrearVF;

    @FXML
    private AnchorPane preguntaA;

    @FXML
    private TextField txtEnunciadoA;

    @FXML
    private Button btnCrearA;

    @FXML
    private TextField txtRespuestaA;

    @FXML
    private AnchorPane vacio;
    
    ModelFactoryController modelFactoryController; 
    
    @FXML
    private Button btnCrear;
    
    @FXML
    private Button btnSalir;
    
    @FXML
    void salirEvent(ActionEvent event) {
    	aplicacion.mostrarVentanaIniciar();
    }

    @FXML
    void crearEvent(ActionEvent event) {
    	if(modelFactoryController.verificarExamen()==true){
    		mostrarMensaje("Notificacion examen", "Examen creado", "Se ha creado con éxito el examen", AlertType.INFORMATION);
    		vacio.toFront();
    		comboBoxTipoP.getItems().clear();
    	}else{
    		mostrarMensaje("Notificacion examen", "Creación incorrecta", "El éxamen debe tener mínimo 1 pregunta", AlertType.ERROR);
    	}
    }

    @FXML
    void crearPreguntaAEvent(ActionEvent event) {
    	String preguntaA= txtEnunciadoA.getText();
    	String posibleRA= txtRespuestaA.getText();
    	
    	if(preguntaA != null && posibleRA != null){
    		modelFactoryController.crearPreguntaA(preguntaA, posibleRA);
    		mostrarMensaje("Notificacion pregunta", "Pregunta creada", "Se ha creado con éxito la pregunta abierta", AlertType.INFORMATION);
    		txtEnunciadoA.setText("");
    		txtRespuestaA.setText("");
    	}else{
			mostrarMensaje("Notificacion pregunta", "Informacion invalida", "Informacion invalida", AlertType.ERROR);
		}
    }

    @FXML
    void crearPreguntaMEvent(ActionEvent event) {
    	String preguntaM = txtEnunciadoM.getText();
    	String resA = txtResA.getText();
    	String resB = txtResB.getText();
    	String resC = txtResC.getText();
    	String resD = txtResD.getText();
    	
    	ArrayList<String> respuestas = new ArrayList<>();
    	respuestas.add(resA);
    	respuestas.add(resB);
    	respuestas.add(resC);
    	respuestas.add(resD);
    	
    	String correcta = comboBoxCorrecta.getSelectionModel().getSelectedItem();
    	
    	if(preguntaM != null && respuestas != null && correcta != null){
    		modelFactoryController.crearPreguntaM(preguntaM, respuestas, correcta);
    		mostrarMensaje("Notificacion pregunta", "Pregunta creada", "Se ha creado con éxito la pregunta de selección multiple", AlertType.INFORMATION);
    		txtEnunciadoM.setText("");
    		txtResA.setText("");
        	txtResB.setText("");
        	txtResC.setText("");
        	txtResD.setText("");
        	comboBoxCorrecta.getItems().clear();
    	}else{
			mostrarMensaje("Notificacion pregunta", "Informacion invalida", "Informacion invalida", AlertType.ERROR);
		}
    }

    @FXML
    void crearPreguntaVFEvent(ActionEvent event) {
    	String preguntaVF = txtEnunciadoVF.getText();
    	String selectedState = comboBoxVF.getSelectionModel().getSelectedItem();
    	String respuesta = selectedState;
    	
    	if(preguntaVF != null && respuesta != null){
    		modelFactoryController.crearPreguntaVF(preguntaVF, respuesta);
    		mostrarMensaje("Notificacion pregunta", "Pregunta creada", "Se ha creado con éxito la pregunta de elección verdadero o falso", AlertType.INFORMATION);
    		txtEnunciadoVF.setText("");
    		comboBoxVF.getItems().clear();
    	}else{
			mostrarMensaje("Notificacion pregunta", "Informacion invalida", "Informacion invalida", AlertType.ERROR);
		}
    }

    @FXML
    void guardarMEvent(MouseEvent event) {
    	String resA = txtResA.getText();
    	String resB = txtResB.getText();
    	String resC = txtResC.getText();
    	String resD = txtResD.getText();
    	
    	if (resA != null && resB != null && resC != null && resD != null && !resA.isEmpty() && !resB.isEmpty() && !resC.isEmpty() && !resD.isEmpty()) {
    	    ObservableList<String> respuestas = FXCollections.observableArrayList();
    	    respuestas.add(resA);
    	    respuestas.add(resB);
    	    respuestas.add(resC);
    	    respuestas.add(resD);
    	    comboBoxCorrecta.setItems(respuestas);
    	    mostrarMensaje("Notificación respuesta", "Respuesta guardada", "Se han registrado con éxito las respuestas", AlertType.INFORMATION);
    	} else {
    	    mostrarMensaje("Notificación respuesta", "Información inválida", "Al menos un campo está vacío", AlertType.ERROR);
    	}
    }
    
    @FXML
    void initialize() {
    	modelFactoryController = ModelFactoryController.getInstance();
    	
		comboBoxTipoP.getItems().addAll("Selección multiple", "Verdadero o Falso", "Abierta");
		comboBoxTipoP.setOnAction(this::filtrarAnchors);
		comboBoxVF.getItems().addAll("Verdadero", "Falso");
	}
	

	public void setAplicacion(Aplicacion aplicacion) {
		this.aplicacion = aplicacion;
	}
	
	private void filtrarAnchors(ActionEvent event) {
		String selectedState = comboBoxTipoP.getSelectionModel().getSelectedItem();
		if (selectedState != null) {
			if (selectedState.equals("Selección multiple")) {
				seleccionM.toFront();
			}
		}
		if (selectedState.equals("Verdadero o Falso")) {
			verdaderoF.toFront();
		}
		if (selectedState.equals("Abierta")) {
			preguntaA.toFront();
		}
	}
	
	public void mostrarMensaje(String titulo, String header, String contenido, AlertType alertType) {
		Alert alert = new Alert(alertType);
		alert.setTitle(titulo);
		alert.setHeaderText(header);
		alert.setContentText(contenido);
		alert.showAndWait();
	}
}

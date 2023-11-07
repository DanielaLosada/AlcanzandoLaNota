package controllers;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import application.Aplicacion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import model.Examen;
import model.Pregunta;
import model.PreguntaAbierta;
import model.PreguntaSMultiple;
import model.PreguntaVF;

public class EstudianteController {

	private Aplicacion aplicacion;

	ModelFactoryController modelFactoryController;

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private AnchorPane abiertas;

	@FXML
	private ImageView siguiente;

	@FXML
	private Label enunciadoAbiertas;

	@FXML
	private TextField txtResAbierta;

	@FXML
	private AnchorPane VF;

	@FXML
	private Label enunciadoVF;

	@FXML
	private ComboBox<String> comboBoxResVF;

	@FXML
	private AnchorPane multiple;

	@FXML
	private Label enunciadoM;

	@FXML
	private RadioButton radB1;

	@FXML
	private RadioButton radB2;

	@FXML
	private RadioButton radB3;

	@FXML
	private RadioButton radB4;

	@FXML
	private Button btnEnviar;

	private ArrayList<String> respuestasF = new ArrayList<>();
	private ArrayList<String> respuestasA = new ArrayList<>();
	private ArrayList<String> preguntasA = new ArrayList<>();
	private ArrayList<String> preguntasF = new ArrayList<>();
	private int contadorRespuestasValidas = 0;

	@FXML
	void siguienteEvent(MouseEvent event) {
		siguiente.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
			filtrarPreguntas();
		});
	}

	@FXML
	void EnviarEvent(ActionEvent event) {
	    Examen examen = modelFactoryController.retornarExamen();
	    if (contadorRespuestasValidas == examen.getListaPreguntas().size()) {
	        mostrarResultado();
	    } else {
	        Alert alert = new Alert(Alert.AlertType.WARNING);
	        alert.setTitle("Advertencia");
	        alert.setHeaderText(null);
	        alert.setContentText("Por favor, complete todas las preguntas antes de enviar.");
	        alert.showAndWait();
	    }
	}

	public void filtrarPreguntas() {
		Examen examen = modelFactoryController.retornarExamen();
		final int[] preguntaActual = { 0 };
		siguiente.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
			if (preguntaActual[0] < examen.getListaPreguntas().size()) {
				Pregunta preguntaActualObj = examen.getListaPreguntas().get(preguntaActual[0]);
				if (preguntaActualObj instanceof PreguntaAbierta) {
					abiertas.toFront();
					multiple.toBack();
					VF.toBack();
					enunciadoAbiertas.setText(preguntaActualObj.getEnunciado());
					boolean verificar = responderPreguntaA();
					if (verificar) {
						preguntaActual[0]++;
						contadorRespuestasValidas++;
					}

				} else if (preguntaActualObj instanceof PreguntaSMultiple) {
					PreguntaSMultiple preguntaSMultiple = (PreguntaSMultiple) preguntaActualObj;
					multiple.toFront();
					enunciadoM.setText(preguntaSMultiple.getEnunciado());
					boolean verificar = responderPreguntaM(preguntaSMultiple.getRespuestas(),
							preguntaSMultiple.getCorrecta(), preguntaSMultiple.getEnunciado());
					if (verificar) {
						preguntaActual[0]++;
						contadorRespuestasValidas++;
					}
				} else if (preguntaActualObj instanceof PreguntaVF) {
					PreguntaVF preguntaVF = (PreguntaVF) preguntaActualObj;
					VF.toFront();
					enunciadoVF.setText(preguntaActualObj.getEnunciado());
					boolean verificar = responderPreguntaVF(preguntaVF);
					if (verificar) {
						preguntaActual[0]++;
						contadorRespuestasValidas++;
					}
				}
				txtResAbierta.setText("");
				comboBoxResVF.setValue(null);
				radB1.setSelected(false);
				radB2.setSelected(false);
				radB3.setSelected(false);
				radB4.setSelected(false);

				System.out.println(respuestasF);
				System.out.println(respuestasA);
			}else{
				mostrarNoti();
			}
		});
	}

	private boolean responderPreguntaVF(PreguntaVF preguntaVF) {
		String selectedState = comboBoxResVF.getSelectionModel().getSelectedItem();
		if (selectedState != null) {
			if (selectedState.equals(preguntaVF.getRespuesta())) {
				respuestasA.add(selectedState);
				preguntasA.add(preguntaVF.getEnunciado());
			} else {
				respuestasF.add(selectedState);
				preguntasF.add(preguntaVF.getEnunciado());
			}
			return true;
		}
//		}else{
//			mostrarNoti();
//		}
		return false;
	}

	private boolean responderPreguntaM(ArrayList<String> respuestas, String correcta, String enunciado) {
		ToggleGroup grupoOpciones = new ToggleGroup();

		if (respuestas.size() <= 4) {
			radB1.setText(respuestas.get(0));
			radB2.setText(respuestas.get(1));
			radB3.setText(respuestas.get(2));
			radB4.setText(respuestas.get(3));

			radB1.setToggleGroup(grupoOpciones);
			radB2.setToggleGroup(grupoOpciones);
			radB3.setToggleGroup(grupoOpciones);
			radB4.setToggleGroup(grupoOpciones);
		}

		if (grupoOpciones.getSelectedToggle() != null) {
			RadioButton radioButtonSeleccionado = (RadioButton) grupoOpciones.getSelectedToggle();
			String textoDelRadioButton = radioButtonSeleccionado.getText();
			if (textoDelRadioButton.equals(correcta)) {
				respuestasA.add(textoDelRadioButton);
				preguntasA.add(enunciado);
				
			} else {
				respuestasF.add(textoDelRadioButton);
				preguntasF.add(enunciado);
			}
			return true;
		}
//		}else{
//			mostrarNoti();
//		}

		return false;
	}

	private boolean responderPreguntaA() {
		if (txtResAbierta.getText().equals("")) {
			return false;
		}
		return true;
	}

	public void setAplicacion(Aplicacion aplicacion) {
		this.aplicacion = aplicacion;
	}

	@FXML
	void initialize() {
		modelFactoryController = ModelFactoryController.getInstance();
		filtrarPreguntas();
		comboBoxResVF.getItems().addAll("Verdadero", "Falso");
	}
	
	private void mostrarResultado() {
		Examen examen = modelFactoryController.retornarExamen();
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Resultado de la Prueba");
		alert.setHeaderText(null);
		alert.setContentText(
				"Respuestas correctas: " + respuestasA.size() + " de " + examen.getListaPreguntas().size()+"\n"+
				"Su nota es: "+calificar());

		ButtonType retroalimentacionButton = new ButtonType("Retroalimentación", ButtonData.OK_DONE);
		alert.getButtonTypes().add(retroalimentacionButton);

		Optional<ButtonType> result = alert.showAndWait();

		if (result.isPresent() && result.get() == retroalimentacionButton) {

			Alert retroalimentacionAlert = new Alert(Alert.AlertType.INFORMATION);
			retroalimentacionAlert.setTitle("Retroalimentación");
			retroalimentacionAlert.setHeaderText(null);
			retroalimentacionAlert.setContentText(hacerRetroalimentacion());
			retroalimentacionAlert.showAndWait();
			System.exit(0);
		}else{
			System.exit(0);
		}
	}
	
	private void mostrarNoti() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Envio");
        alert.setHeaderText(null);
        alert.setContentText("Ha finalizado el examen, puede hacer el debido envio para recibir su calificación");
        alert.showAndWait();
    }
	
	private String hacerRetroalimentacion() {
	    StringBuilder correctas = new StringBuilder("Sus aciertos han sido:\n");
	    StringBuilder incorrectas = new StringBuilder("Sus errores han sido:\n");

	    for (int i = 0; i < preguntasA.size(); i++) {
	        correctas.append(preguntasA.get(i)).append("\n");
	        correctas.append(respuestasA.get(i)).append("\n");
	    }

	    for (int i = 0; i < preguntasF.size(); i++) {
	        incorrectas.append(preguntasF.get(i)).append("\n");
	        incorrectas.append(respuestasF.get(i)).append("\n");
	    }

	    return correctas.toString() +"\n"+ incorrectas.toString();
	}
	
	
	private double calificar() {
		Examen examen = modelFactoryController.retornarExamen();
		int preguntas = examen.getListaPreguntas().size();
		int aciertos = respuestasA.size();

		double notaPorcentaje = ((double) aciertos / preguntas) * 100.0;

		double puntajeMaximo = 100.0;
		double puntajeMinimo = 0.0;

		double notaEscala = 1.0 + (notaPorcentaje - puntajeMinimo) / (puntajeMaximo - puntajeMinimo) * 4.0;

		if (notaEscala < 1.0) {
			return 1.0;
		} else if (notaEscala > 5.0) {
			return 5.0;
		} else {
			return Math.round(notaEscala * 100.0) / 100.0;
		}
	}

}

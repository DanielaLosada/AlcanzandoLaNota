package controllers;
import java.util.ArrayList;

import javafx.scene.control.Alert;
import javafx.stage.Stage;
import model.Examen;
import model.Pregunta;
import model.PreguntaAbierta;
import model.PreguntaSMultiple;
import model.PreguntaVF;

public class ModelFactoryController {
	
	Examen examen;
	

	//------------------------------  Singleton ------------------------------------------------
	// Clase estatica oculta. Tan solo se instanciara el singleton una vez
	private static class SingletonHolder {
		// El constructor de Singleton puede ser llamado desde aquï¿½ al ser protected
		private final static ModelFactoryController eINSTANCE = new ModelFactoryController();
	}

	// Mï¿½todo para obtener la instancia de nuestra clase
	public static ModelFactoryController getInstance() {
		return SingletonHolder.eINSTANCE;
	}

	public ModelFactoryController() {
		//1. inicializar datos y luego guardarlo en archivos
				//iniciarSalvarDatosPrueba();

				//2. Cargar los datos de los archivos
				//cargarDatosDesdeArchivos();
		
				//3. Guardar y Cargar el recurso serializable binario
				//guardarResourceBinario();
				//cargarResourceBinario();

				//4. Guardar y Cargar el recurso serializable XML
//
//				try {
//					guardarResourceXML();
//					guardarResourceBinario();
//				} catch (Exception e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//		
				// Siempre se debe verificar si la raiz del recurso es null
				if (examen == null) {
					System.out.println("es null el examen");
					inicializarDatos();
				}
	}
	
    
    public void inicializarDatos() {
    	examen= new Examen();
//    	ArrayList<Pregunta> preguntas= new ArrayList<>();
//    	PreguntaVF pregunta1= new PreguntaVF("¿La tierra es plana?", "Falso");
//    	ArrayList<String> respuestasSM= new ArrayList<>();
//    	respuestasSM.add("Manzana");
//    	respuestasSM.add("Banano");
//    	respuestasSM.add("Pera");
//    	respuestasSM.add("Naranja");
//    	PreguntaSMultiple pregunta2 = new PreguntaSMultiple("Fruta de color rojo", "Manzana");
//    	pregunta2.setRespuestas(respuestasSM);
//    	
//    	ArrayList<String> respuestasSM2= new ArrayList<>();
//    	respuestasSM2.add("Gato");
//    	respuestasSM2.add("Lobo");
//    	respuestasSM2.add("Perro");
//    	respuestasSM2.add("Loro");
//    	PreguntaSMultiple pregunta3 = new PreguntaSMultiple("Animal amigo del hombre", "Perro");
//    	pregunta3.setRespuestas(respuestasSM2);
//    	PreguntaAbierta pregunta4 = new PreguntaAbierta("Que es el sol", "Una estrella que da luz");
//    	
//    	PreguntaVF pregunta5= new PreguntaVF("¿El cielo es verde?", "Falso");
//    	
//    	PreguntaAbierta pregunta6 = new PreguntaAbierta("Explique el concepto de agua", "Sustancia vital para el ser humano");
//    	
//    	preguntas.add(pregunta3);
//    	preguntas.add(pregunta1);
//    	preguntas.add(pregunta2);
//    	preguntas.add(pregunta4);
//    	preguntas.add(pregunta5);
//    	preguntas.add(pregunta6);    	
//    	
//    	
//    	examen.setListaPreguntas(preguntas);
//		return examen;
	}

	public void crearPreguntaA(String preguntaA, String posibleRA) {
		examen.crearPreguntaA(preguntaA, posibleRA);
	}

	public void crearPreguntaM(String preguntaM, ArrayList<String> respuestas, String correcta) {
		examen.crearPreguntaM(preguntaM, respuestas, correcta);
	}

	public void crearPreguntaVF(String preguntaVF, String respuesta) {
		examen.crearPreguntaVF(preguntaVF, respuesta);
	}

	public boolean verificarExamen() {
		if(examen.verificar()==true){
			retornarExamen();
			return true;
		}
		return false;
	}
	
	public Examen retornarExamen(){
		return examen;
	}
	
	
}

package controllers;
import java.util.ArrayList;

import model.Examen;

public class ModelFactoryController {
	
	Examen examen;
	

	//------------------------------  Singleton ------------------------------------------------
	// Clase estatica oculta. Tan solo se instanciara el singleton una vez
	private static class SingletonHolder {
		// El constructor de Singleton puede ser llamado desde aqu� al ser protected
		private final static ModelFactoryController eINSTANCE = new ModelFactoryController();
	}

	// M�todo para obtener la instancia de nuestra clase
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
	
    
    private void inicializarDatos() {
    	examen= new Examen();
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
		System.out.println(examen.getListaPreguntas());
		return examen.verificar();
	}
	
	
}

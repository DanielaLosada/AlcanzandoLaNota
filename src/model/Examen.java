package model;

import java.util.*;

public class Examen {
	
	private ArrayList<Pregunta> listaPreguntas;

	public Examen() {
		super();
		this.listaPreguntas = new ArrayList <Pregunta>();
	}

	public ArrayList<Pregunta> getListaPreguntas() {
		return listaPreguntas;
	}

	public void setListaPreguntas(ArrayList<Pregunta> listaPreguntas) {
		this.listaPreguntas = listaPreguntas;
	}

	public void crearPreguntaA(String preguntaA, String posibleRA) {
		PreguntaAbierta preguntaAbierta = new PreguntaAbierta();
		preguntaAbierta.setEnunciado(preguntaA);
		preguntaAbierta.setPosibleRespuesta(posibleRA);
		listaPreguntas.add(preguntaAbierta);
		System.out.println(listaPreguntas);
	}

	public void crearPreguntaM(String preguntaM, ArrayList<String> respuestas, String correcta) {
		PreguntaSMultiple preguntaMultiple = new PreguntaSMultiple();
		preguntaMultiple.setEnunciado(preguntaM);
		preguntaMultiple.setRespuestas(respuestas);
		preguntaMultiple.setCorrecta(correcta);
		listaPreguntas.add(preguntaMultiple);
		System.out.println(listaPreguntas);
	}

	public void crearPreguntaVF(String preguntaVF, String respuesta) {
		PreguntaVF preguntaVerF = new PreguntaVF();
		preguntaVerF.setEnunciado(preguntaVF);
		preguntaVerF.setRespuesta(respuesta);
		listaPreguntas.add(preguntaVerF);
		System.out.println(listaPreguntas);
	}

	public boolean verificar() {
		if (this.listaPreguntas == null || this.listaPreguntas.isEmpty()) {
	        return false;
	    }
	    return true;
	} 
	
	
	
	
	
	

}

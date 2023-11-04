package model;

import java.util.*;

public class PreguntaSMultiple extends Pregunta {
	
	private ArrayList<String> respuestas;
	private String correcta;

	public PreguntaSMultiple(String enunciado, String correcta) {
		super(enunciado);
		this.correcta = correcta;
		this.respuestas = new ArrayList<String>(4);
	}
	
	public PreguntaSMultiple(){
		super();
	}

	public ArrayList<String> getRespuestas() {
		return respuestas;
	}

	public void setRespuestas(ArrayList<String> respuestas) {
		this.respuestas = respuestas;
	}

	public String getCorrecta() {
		return correcta;
	}

	public void setCorrecta(String correcta) {
		this.correcta = correcta;
	} 

}

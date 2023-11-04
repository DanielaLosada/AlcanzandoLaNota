package model;

public class PreguntaVF extends Pregunta {
	
	private String respuesta;

	public PreguntaVF(String enunciado, String respuesta) {
		super(enunciado);
		this.respuesta = respuesta;
	}
	
	public PreguntaVF(){
		super();
	}

	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	} 

	
}

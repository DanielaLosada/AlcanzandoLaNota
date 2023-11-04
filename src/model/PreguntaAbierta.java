package model;

public class PreguntaAbierta extends Pregunta{
	
	private String posibleRespuesta;

	public PreguntaAbierta(String enunciado, String posibleRespuesta) {
		super(enunciado);
		this.posibleRespuesta = posibleRespuesta;
	}
	
	public PreguntaAbierta(){
		super();
	}
	
	public String getPosibleRespuesta() {
		return posibleRespuesta;
	}

	public void setPosibleRespuesta(String posibleRespuesta) {
		this.posibleRespuesta = posibleRespuesta;
	}
	
	
	
	
}

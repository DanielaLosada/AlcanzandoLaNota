package model;

public class Pregunta {
	
	private String enunciado;

	public Pregunta(String enunciado) {
		super();
		this.enunciado = enunciado;
	}
	
	public Pregunta(){
		super();
	}

	public String getEnunciado() {
		return enunciado;
	}

	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}
	
	
}

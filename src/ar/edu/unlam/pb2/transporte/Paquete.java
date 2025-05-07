package ar.edu.unlam.pb2.transporte;

public class Paquete {

	private Double largo;
	private Double ancho;
	private Double profundidad;
	private Double peso;
	
	public Paquete(Double largo, Double ancho, Double profundidad, Double peso) {
		this.largo = largo;
		this.ancho = ancho;
		this.profundidad = profundidad;	
		this.peso = peso;
	}
	
	public Double getVolumen() {
		return this.largo * this.ancho * this.profundidad;
	}

	public Double getPeso() {
		return this.peso;
	}
	
	public Double getLargo() {
		return this.largo;
	}
	
	public Double getAncho() {
		return this.ancho;
	}
	
	

}

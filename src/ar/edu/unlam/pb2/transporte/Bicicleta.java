package ar.edu.unlam.pb2.transporte;

import java.util.LinkedList;
import java.util.List;

public class Bicicleta {

	private List<Paquete> paquete = new LinkedList<Paquete>();
	private String destino;

	public Boolean agregar(Paquete paquete, String destino) {
		if (this.destino == null) {
			this.destino = destino;
		}
		Boolean resultado = false;
		if (paquete.getVolumen() <= 0.125 
				&& this.paquete.size() < 2 
				&& this.destino.equals(destino)
				&& paquete.getPeso() <= 15) {
			this.paquete.add(paquete);
			resultado = true;
		}
		return resultado;
	}

	public Integer getCantidadDePaquetes() {
		return this.paquete.size();
	}

}

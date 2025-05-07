package ar.edu.unlam.pb2.transporte;

import java.util.LinkedList;
import java.util.List;

public class Auto {

	private List<Paquete> paquete = new LinkedList<Paquete>();
	private List<String> destinos = new LinkedList<String>();
	private Double volumenTotal = 0.0;
	private Double pesoTotal = 0.0;

	public boolean agregar(Paquete paquete, String destino) {
		Boolean resultado = false;
		Boolean compatible = false;
		if ((!this.destinos.contains(destino) && this.destinos.size() < 3) 
			|| (this.destinos.contains(destino))) {
			compatible = true;
		}
		
		if (paquete.getVolumen() + this.volumenTotal <= 2.0 
				&& compatible
				&& paquete.getPeso() + this.pesoTotal <= 500) {
			this.paquete.add(paquete);
			this.volumenTotal += paquete.getVolumen();
			this.pesoTotal  += paquete.getPeso();
			if (!this.destinos.contains(destino)) {
				this.destinos.add(destino);
			}
			resultado = true;
		}

		return resultado;
	}

	public Integer getCantidadDePaquetes() {
		return this.paquete.size();
	}

}

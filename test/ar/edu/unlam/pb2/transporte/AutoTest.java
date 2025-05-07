package ar.edu.unlam.pb2.transporte;

import static org.junit.Assert.*;
import org.junit.Test;

public class AutoTest {

	@Test
	public void queSePuedaCargarUnPaquetePequenio() {
		Auto auto = new Auto();
		Paquete p1 = new Paquete(0.1, 0.1, 0.1, 1.0);
		assertTrue(auto.agregar(p1, "Ramos"));
	}

	@Test
	public void queNoSePuedaCargarVolumenExcedidio() {
		Auto auto = new Auto();
		Paquete p1 = new Paquete(1.0, 1.0, 2.1, 1.0);
		assertFalse(auto.agregar(p1, "Ramos"));
	}

	@Test
	public void queNoSePuedaCargarVolumenExcedidoEnVariosPaquetes() {
		Auto auto = new Auto();
		Paquete p1 = new Paquete(1.0, 1.0, 2.0, 1.0);
		Paquete p2 = new Paquete(0.01, 0.01, 0.01, 1.0);
		assertTrue(auto.agregar(p1, "Hurlingham"));
		assertFalse(auto.agregar(p2, "Hurlingham"));		
	}
	
	public void queNoSePuedaSuperarLaCantidadDePaquetes() {
		Auto auto = new Auto();
		Paquete paquete = new Paquete(0.1, 0.1, 0.1, 1.0);
		
		int cantidadTotalDePaquetesCargados = 0;
		for (int i = 0; i < 30; i++) { 
			if (auto.agregar(paquete, "Ituzaingó")) {
				cantidadTotalDePaquetesCargados++;
			}
		}
		
		Integer cantidadEsperada = auto.getCantidadDePaquetes();
		assertEquals("No debería superar el límite de volumen total", auto.getCantidadDePaquetes().intValue(), cantidadTotalDePaquetesCargados);
		assertTrue("El volumen total no debe superar 2.0", cantidadEsperada < 30);
	}

	@Test
	public void queNoSePuedaCargarMasDeTresDestinos() {
		Auto auto = new Auto();
		Integer cantidadEsperada = 3;
		Paquete p1 = new Paquete(0.1, 0.1, 0.1, 1.0);
		Paquete p2 = new Paquete(0.1, 0.1, 0.1, 1.0);
		Paquete p3 = new Paquete(0.1, 0.1, 0.1, 1.0);
		Paquete p4 = new Paquete(0.1, 0.1, 0.1, 1.0);
		assertTrue(auto.agregar(p1, "Ramos"));
		assertTrue(auto.agregar(p2, "San Justo"));
		assertTrue(auto.agregar(p3, "Haedo"));
		assertFalse(auto.agregar(p4, "El Palomar"));
		assertEquals(cantidadEsperada, auto.getCantidadDePaquetes());
	}

	@Test
	public void queNoSePuedaCargarMasDeTresDestinosDistintos() {
		Auto auto = new Auto();
		Paquete p1 = new Paquete(0.1, 0.1, 0.1, 1.0);
		Paquete p2 = new Paquete(0.1, 0.1, 0.1, 1.0);
		Paquete p3 = new Paquete(0.1, 0.1, 0.1, 1.0);
		Paquete p4 = new Paquete(0.1, 0.1, 0.1, 1.0);
		Paquete p5 = new Paquete(0.1, 0.1, 0.1, 1.0);
		Paquete p6 = new Paquete(0.1, 0.1, 0.1, 1.0);
		assertTrue(auto.agregar(p1, "Ramos"));
		assertTrue(auto.agregar(p2, "San Justo"));
		assertTrue(auto.agregar(p3, "Haedo"));
		assertFalse(auto.agregar(p4, "El Palomar"));
		assertTrue(auto.agregar(p5, "Haedo"));
		assertFalse(auto.agregar(p6, "Lujan"));
	}
	
	@Test
	public void queNoSePuedaCargarConPesoExcedidoEnVariosPaquetes() {
		Auto auto = new Auto();
		Paquete p1 = new Paquete(0.5, 0.5, 0.5, 500.0);
		Paquete p2 = new Paquete(0.5, 0.5, 0.5, 0.01);
		assertTrue(auto.agregar(p1, "Hurlingham"));	
		assertFalse(auto.agregar(p2, "Hurlingham"));		
	}
}

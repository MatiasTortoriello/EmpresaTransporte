package ar.edu.unlam.pb2.transporte;

import static org.junit.Assert.*;

import org.junit.Test;

public class BicicletaTest {

	@Test
	public void queSePuedaCargarUnPaquetePequenio() {
		Bicicleta bici = new Bicicleta();
		Paquete p1 = new Paquete(0.1, 0.1, 0.1, 1.0);
		assertTrue(bici.agregar(p1, "Ramos"));
	}

	@Test
	public void queNoSePuedaCargarVolumenExcedidio() {
		Bicicleta bici = new Bicicleta();
		Paquete p1 = new Paquete(0.51, 0.5, 0.5, 1.0);
		assertFalse(bici.agregar(p1, "Ramos"));
	}

	@Test
	public void queNoSePuedaSuperarLaCantidadDePaquetes() {
		Bicicleta bici = new Bicicleta();
		Integer valorEsperado = 2;
		Paquete p1 = new Paquete(0.1, 0.1, 0.1, 1.0);
		Paquete p2 = new Paquete(0.1, 0.1, 0.1, 1.0);
		Paquete p3 = new Paquete(0.1, 0.1, 0.1, 1.0);
		assertTrue(bici.agregar(p1, "Ramos"));
		assertTrue(bici.agregar(p2, "Ramos"));
		assertFalse(bici.agregar(p3, "Ramos"));
		assertEquals(valorEsperado, bici.getCantidadDePaquetes());
	}

	@Test
	public void queNoSePuedaCargarDestinosDistintos() {
		Bicicleta bici = new Bicicleta();
		Paquete p1 = new Paquete(0.1, 0.1, 0.1, 1.0);
		Paquete p2 = new Paquete(0.1, 0.1, 0.1, 1.0);
		assertTrue(bici.agregar(p1, "Ramos"));
		assertFalse(bici.agregar(p2, "San Justo"));
	}

	@Test
	public void queNoSePuedaCargarConPesoExcedido() {
		Bicicleta bici = new Bicicleta();
		Paquete p1 = new Paquete(0.5, 0.5, 0.5, 15.1);
		assertFalse(bici.agregar(p1, "Ramos"));
	}
}

package es.uva.inf.tds.pr4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import es.uva.inf.maps.CoordenadasGPS;
import es.uva.inf.tds.redmetro.Estacion;
import es.uva.inf.tds.redmetro.Linea;

/**
 * Clase de test TDD para la clase RedMetro
 * 
 * @author dardela
 *
 */
class RedMetroTDDTest {

	public static CoordenadasGPS c1;
	public static CoordenadasGPS c2;
	public static CoordenadasGPS c3;
	public static CoordenadasGPS c4;
	public static Estacion e1;
	public static Estacion e2;
	public static Linea l1;
	public static Linea l2;
	public static Linea l3;
	public static Linea l4;


	@Before
	public void setUp() {
		c1 = new CoordenadasGPS("040°42'46\"N", "074°00'21\"O");
		c2 = new CoordenadasGPS("040°42'46\"N", "074°00'20\"O");
		c3 = new CoordenadasGPS("040°42'46\"N", "074°00'19\"O");
		c4 = new CoordenadasGPS("040°42'46\"N", "074°00'18\"O");
		e1 = new Estacion("estacion1", c1, c2);
		e2 = new Estacion("estacion2", c3, c4);
		l1 = new Linea(1, "rojo", e1, e2);
		l2 = new Linea(2, "azul", e1, e2);
	}

	@Test
	public void testConstructorRedMetro() {
		RedMetro red = new RedMetro("red1", l1, l2);
		assertNotNull(red);
		assertEquals(red.getNombre(), "red1");
	}

	@Test
	public void testConstructorNoValidoMenosDe2Lineas() {
		assertThrows(IllegalArgumentException.class, () -> {
			@SuppressWarnings("unused")
			RedMetro red = new RedMetro("red1", l1);
		});
	}
	
	@Test
	public void testGetLineaNumero() {
		RedMetro red = new RedMetro("red1", l1, l2);
		assertEquals(red.getLineaNumero(1),l1);
	}
	
	@Test
	public void testGetLineaColor() {
		RedMetro red = new RedMetro("red1",l1,l2);
		assertEquals(red.getLineaColor("rojo"),l1);
	}
	
}

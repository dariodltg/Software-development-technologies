package es.uva.inf.tds.pr4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import es.uva.inf.maps.CoordenadasGPS;
import es.uva.inf.tds.redmetro.Estacion;
import es.uva.inf.tds.redmetro.Linea;

@Tag("BlackBox")
class RedMetroBlackBoxTest {
	
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
	
	@BeforeEach
	public void setUp() {
		c1 = new CoordenadasGPS("040°42'46\"N", "074°00'21\"O");
		c2 = new CoordenadasGPS("040°42'46\"N", "074°00'20\"O");
		c3 = new CoordenadasGPS("040°42'46\"N", "074°00'19\"O");
		c4 = new CoordenadasGPS("040°42'46\"N", "074°00'18\"O");
		e1 = new Estacion("estacion1", c1, c2);
		e2 = new Estacion("estacion2", c3, c4);
		l1 = new Linea(1, "rojo", e1, e2);
		l2 = new Linea(2, "azul", e1, e2);
		l3 = new Linea(3, "amarillo", e1, e2);
		l4 = new Linea(3, "azul", e1, e2);
	}
	
	@Test
	public void testConstructorNoValidoNumerosNoConsecutivos() {
		assertThrows(IllegalArgumentException.class, () -> {
			new RedMetro(l1,l3);
		});
	}
	
	@Test
	public void testConstructorNoValidoColoresRepetidos() {
		assertThrows(IllegalArgumentException.class, () -> {
			new RedMetro(l1,l3);
		});
	}
}

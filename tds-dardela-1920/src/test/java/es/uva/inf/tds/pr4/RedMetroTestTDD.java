package es.uva.inf.tds.pr4;

import static org.junit.jupiter.api.Assertions.*;

import org.json.JSONException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import es.uva.inf.maps.CoordenadasGPS;
import es.uva.inf.tds.redmetro.Estacion;
import es.uva.inf.tds.redmetro.Linea;

/**
 * Clase de test TDD para la clase RedMetro
 * 
 * @author dardela
 *
 */
@Tag("TDD")
class RedMetroTestTDD {

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
	public static String json;

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
		json = "[\r\n" + "		{\r\n" + "			\"numero\": 1,\r\n" + "			\"color\": \"rojo\",\r\n"
				+ "			\"estaciones\": [\r\n" + "				{\r\n"
				+ "					\"nombre\": \"estacion1\",\r\n" + "					\"coordenadasGPS\": [\r\n"
				+ "						{\r\n" + "							\"latitud\": \"040°42'46\\\"N\",\r\n"
				+ "							\"longitud\": \"074°00'21\\\"O\"\r\n" + "						},\r\n"
				+ "						{\r\n" + "							\"latitud\": \"040°42'46\\\"N\",\r\n"
				+ "							\"longitud\": \"074°00'20\\\"O\"\r\n" + "						}\r\n"
				+ "					]\r\n" + "				},\r\n" + "				{\r\n"
				+ "					\"nombre\": \"estacion2\",\r\n" + "					\"coordenadasGPS\": [\r\n"
				+ "						{\r\n" + "							\"latitud\": \"040°42'46\\\"N\",\r\n"
				+ "							\"longitud\": \"074°00'19\\\"O\"\r\n" + "						},\r\n"
				+ "						{\r\n" + "							\"latitud\": \"040°42'46\\\"N\",\r\n"
				+ "							\"longitud\": \"074°00'18\\\"O\"\r\n" + "						}\r\n"
				+ "					]\r\n" + "				}\r\n" + "			]\r\n" + "		},\r\n" + "		{\r\n"
				+ "			\"numero\": 2,\r\n" + "			\"color\": \"azul\",\r\n"
				+ "			\"estaciones\": [\r\n" + "				{\r\n"
				+ "					\"nombre\": \"estacion1\",\r\n" + "					\"coordenadasGPS\": [\r\n"
				+ "						{\r\n" + "							\"latitud\": \"040°42'46\\\"N\",\r\n"
				+ "							\"longitud\": \"074°00'21\\\"O\"\r\n" + "						},\r\n"
				+ "						{\r\n" + "							\"latitud\": \"040°42'46\\\"N\",\r\n"
				+ "							\"longitud\": \"074°00'20\\\"O\"\r\n" + "						}\r\n"
				+ "					]\r\n" + "				},\r\n" + "				{\r\n"
				+ "					\"nombre\": \"estacion2\",\r\n" + "					\"coordenadasGPS\": [\r\n"
				+ "						{\r\n" + "							\"latitud\": \"040°42'46\\\"N\",\r\n"
				+ "							\"longitud\": \"074°00'19\\\"O\"\r\n" + "						},\r\n"
				+ "						{\r\n" + "							\"latitud\": \"040°42'46\\\"N\",\r\n"
				+ "							\"longitud\": \"074°00'18\\\"O\"\r\n" + "						}\r\n"
				+ "					]\r\n" + "				}\r\n" + "			]\r\n" + "		}\r\n" + "	]";
	}

	@Test
	public void testConstructorRedMetro() {
		RedMetro red = new RedMetro(l1, l2);
		assertNotNull(l1);
		assertNotNull(l2);
		assertNotNull(red);
		fail("Not yet implemented");
	}

	@Test
	public void testConstructorNoValidoMenosDe2Lineas() {
		assertThrows(IllegalArgumentException.class, () -> {
			new RedMetro(l1);
		});
	}

	@Test
	public void testGetLineaNumero() {
		RedMetro red = new RedMetro(l1, l2);
		assertNotNull(l1);
		assertNotNull(l2);
		assertEquals(red.getLineaNumero(1), l1);
	}

	@Test
	public void testGetLineaColor() {
		RedMetro red = new RedMetro(l1, l2);
		assertNotNull(l1);
		assertNotNull(l2);
		assertEquals(red.getLineaColor("rojo"), l1);
	}

	@Test
	public void testAddLinea() {
		RedMetro red = new RedMetro(l1, l2);
		assertNotNull(l1);
		assertNotNull(l2);
		red.addLinea(l3);
		assertEquals(red.getLineaColor("amarillo"), l3);
	}

	@Test
	public void testAddLineaNoValidoColorRepetido() {
		RedMetro red = new RedMetro(l1, l2);
		assertThrows(IllegalArgumentException.class, () -> {
			red.addLinea(l4);
		});
	}

	@Test
	public void testRemoveLinea() {
		RedMetro red = new RedMetro(l1, l2);
		assertNotNull(l1);
		assertNotNull(l2);
		red.addLinea(l3);
		assertEquals(red.getLineaColor("amarillo"), l3);
		red.removeLinea(3);
		assertNull(red.getLineaColor("amarillo"));
	}

	@Test
	public void testRemoveLineaNumeroInexistente() {
		RedMetro red = new RedMetro(l1, l2);
		assertThrows(IllegalArgumentException.class, () -> {
			red.removeLinea(3);
		});
	}

	@Test
	public void testGetLineas() {
		RedMetro red = new RedMetro(l1, l2);
		Linea[] lineas = { l1, l2 };
		assertArrayEquals(red.getLineas(), lineas);
	}

	@Test
	public void testGetLineasEstacion() {
		RedMetro red = new RedMetro(l1, l2);
		Linea[] lineas = { l1, l2 };
		assertArrayEquals(red.getLineasEstacion("estacion1"), lineas);
	}

	@Test
	public void testGetLineasEstacionNombreInexistente() {
		RedMetro red = new RedMetro(l1, l2);
		assertThrows(IllegalArgumentException.class, () -> {
			red.getLineasEstacion("estacion3");
		});
	}

	@Test
	public void testGetEstacionesCorrespondencia() {
		RedMetro red = new RedMetro(l1, l2);
		Estacion[] estaciones = { e1, e2 };
		assertArrayEquals(red.getEstacionesCorrespondencia(1, 2), estaciones);
	}

	@Test
	public void testGetEstacionesCorrespondenciaNúmeroInexistente() {
		RedMetro red = new RedMetro(l1, l2);
		assertThrows(IllegalArgumentException.class, () -> {
			red.getEstacionesCorrespondencia(1, 3);
		});
	}

	@Test
	public void testGetLineasConexionSinTransbordo() {
		RedMetro red = new RedMetro(l1, l2);
		Linea[] lineas = { l1, l2 };
		assertArrayEquals(red.getLineasConexionSinTransbordo("estacion1", "estacion2"), lineas);
	}

	@Test
	public void testGetLineasConexionSinTransbordoNombreInexistente() {
		RedMetro red = new RedMetro(l1, l2);
		assertThrows(IllegalArgumentException.class, () -> {
			red.getLineasConexionSinTransbordo("estacion1", "estacion3");
		});
	}

	@Test
	public void testGetLineasConexionConTransbordo() {
		Estacion e3 = new Estacion("estacion3", c1, c2);
		Linea l5 = new Linea(1, "rojo", e1, e2);
		Linea l6 = new Linea(2, "azul", e2, e3);
		Linea[] lineas = { l5, l6 };
		RedMetro red = new RedMetro(l5, l6);
		assertArrayEquals(red.getLineasConexionConTransbordo("estacion1", "estacion3"), lineas);
	}

	@Test
	public void testGetLineasConexionConTransbordoNombreInexistente() {
		RedMetro red = new RedMetro(l1, l2);
		assertThrows(IllegalArgumentException.class, () -> {
			red.getLineasConexionConTransbordo("estacion1", "estacion3");
		});
	}

	@Test
	public void testGetEstacionesCercanas() {
		RedMetro red = new RedMetro(l1, l2);
		Estacion estaciones[] = { e1, e2 };
		assertArrayEquals(red.getEstacionesCercanas(c1, 10), estaciones);
	}

	@Test
	public void testGetJSON() {
		RedMetro red = new RedMetro(l1, l2);
		assertNotNull(red);
		try {
			JSONAssert.assertEquals(red.getJSON(), json, true);
		} catch (JSONException e) {
		}

	}

	@Test
	public void testConstructorFromJSON() {
		RedMetro red1=null;
		try {
			red1 = new RedMetro(json);
		} catch (JSONException e) {
		}
		RedMetro red2 = new RedMetro(l1, l2);
		assertNotNull(red1.getLineas());
		assertNotNull(red2.getLineas());
		assertEquals(red1.getLineas(), red2.getLineas());
	}
}

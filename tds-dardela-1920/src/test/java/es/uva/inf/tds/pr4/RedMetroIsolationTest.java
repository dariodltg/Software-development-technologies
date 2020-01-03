package es.uva.inf.tds.pr4;

import static org.junit.jupiter.api.Assertions.*;
import static org.easymock.EasyMock.*;

import org.easymock.Mock;
import org.json.JSONException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

import es.uva.inf.maps.CoordenadasGPS;
import es.uva.inf.tds.redmetro.Estacion;
import es.uva.inf.tds.redmetro.Linea;

/**
 * Clase de test en aislamiento para la clase RedMetro
 * 
 * @author dardela
 *
 */

@Tag("Isolation")
class RedMetroIsolationTest {

	public static String json;

	@Mock
	public CoordenadasGPS c1;
	public CoordenadasGPS c2;
	public CoordenadasGPS c3;
	public CoordenadasGPS c4;
	public CoordenadasGPS c5;
	public Estacion e1;
	public Estacion e2;
	public Linea l1;
	public Linea l2;
	public Linea l3;
	public Linea l4;
	public Linea l5;

	@BeforeEach
	public void setUp() {
		c1 = createMock(CoordenadasGPS.class);
		expect(c1.getLatitudGMS()).andReturn("040°42'46\"N").anyTimes();
		expect(c1.getLongitudGMS()).andReturn("074°00'21\"O").anyTimes();
		c2 = createMock(CoordenadasGPS.class);
		expect(c2.getLatitudGMS()).andReturn("040°42'46\"N").anyTimes();
		expect(c2.getLongitudGMS()).andReturn("074°00'20\"O").anyTimes();
		c3 = createMock(CoordenadasGPS.class);
		expect(c3.getLatitudGMS()).andReturn("040°42'46\"N").anyTimes();
		expect(c3.getLongitudGMS()).andReturn("074°00'19\"O").anyTimes();
		c4 = createMock(CoordenadasGPS.class);
		expect(c4.getLatitudGMS()).andReturn("040°42'46\"N").anyTimes();
		expect(c4.getLongitudGMS()).andReturn("074°00'18\"O").anyTimes();
		c5 = createMock(CoordenadasGPS.class);
		expect(c5.getLatitudGMS()).andReturn("040°42'46\"N").anyTimes();
		expect(c5.getLongitudGMS()).andReturn("074°00'18\"O").anyTimes();
		expect(c5.getDistanciaA(c1)).andReturn(2.0).anyTimes();
		expect(c5.getDistanciaA(c2)).andReturn(2.0).anyTimes();
		expect(c5.getDistanciaA(c3)).andReturn(2.0).anyTimes();
		expect(c5.getDistanciaA(c4)).andReturn(2.0).anyTimes();
		expect(c1.getDistanciaA(c1)).andReturn(0.0).anyTimes();
		expect(c1.getDistanciaA(c2)).andReturn(2.0).anyTimes();
		expect(c1.getDistanciaA(c3)).andReturn(2.0).anyTimes();
		expect(c1.getDistanciaA(c4)).andReturn(2.0).anyTimes();
		e1 = createMock(Estacion.class);
		expect(e1.getNombre()).andReturn("estacion1").anyTimes();
		CoordenadasGPS[] coords1 = {c1,c2};
		expect(e1.getCoordenadasGPS()).andReturn(coords1).anyTimes();
		e2 = createMock(Estacion.class);
		expect(e2.getNombre()).andReturn("estacion2").anyTimes();
		CoordenadasGPS[] coords2 = {c3,c4};
		expect(e2.getCoordenadasGPS()).andReturn(coords2).anyTimes();
		l1 = createMock(Linea.class);
		expect(l1.getColor()).andReturn("rojo").anyTimes();
		expect(l1.getNumero()).andReturn(1).anyTimes();
		Estacion[] estaciones1 = {e1,e2};
		expect(l1.getEstaciones(true)).andReturn(estaciones1).anyTimes();
		expect(l1.contieneEstacion(e1)).andReturn(true).anyTimes();
		expect(l1.contieneEstacion(e2)).andReturn(true).anyTimes();
		l2 = createMock(Linea.class);
		expect(l2.getColor()).andReturn("azul").anyTimes();
		expect(l2.getNumero()).andReturn(2).anyTimes();
		Estacion[] estaciones2 = {e1,e2};
		expect(l2.getEstaciones(true)).andReturn(estaciones2).anyTimes();
		expect(l2.contieneEstacion(e1)).andReturn(true).anyTimes();
		expect(l2.contieneEstacion(e2)).andReturn(true).anyTimes();
		expect(l1.getCorrespondencias(l2)).andReturn(estaciones1);
		l3 = createMock(Linea.class);
		expect(l3.getColor()).andReturn("amarillo").anyTimes();
		expect(l3.getNumero()).andReturn(3).anyTimes();
		Estacion[] estaciones3 = {e1,e2};
		expect(l3.getEstaciones(true)).andReturn(estaciones3).anyTimes();
		expect(l3.contieneEstacion(e1)).andReturn(true).anyTimes();
		expect(l3.contieneEstacion(e2)).andReturn(true).anyTimes();
		l4 = createMock(Linea.class);
		expect(l4.getColor()).andReturn("azul").anyTimes();
		expect(l4.getNumero()).andReturn(3).anyTimes();
		Estacion[] estaciones4 = {e1,e2};
		expect(l4.getEstaciones(true)).andReturn(estaciones4).anyTimes();
		expect(l4.contieneEstacion(e1)).andReturn(true).anyTimes();
		expect(l4.contieneEstacion(e2)).andReturn(true).anyTimes();
		l5 = createMock(Linea.class);
		expect(l5.getColor()).andReturn("naranja").anyTimes();
		expect(l5.getNumero()).andReturn(4).anyTimes();
		Estacion[] estaciones5 = {e1,e2};
		expect(l5.getEstaciones(true)).andReturn(estaciones5).anyTimes();
		expect(l5.contieneEstacion(e1)).andReturn(true).anyTimes();
		expect(l5.contieneEstacion(e2)).andReturn(true).anyTimes();
		replay(c1);
		replay(c2);
		replay(c3);
		replay(c4);
		replay(c5);
		replay(e1);
		replay(e2);
		replay(l1);
		replay(l2);
		replay(l3);
		replay(l4);
		replay(l5);
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
	}

	@Test
	public void testConstructorNoValidoMenosDe2Lineas() {
		assertThrows(IllegalArgumentException.class, () -> {
			new RedMetro(l1);
		});
	}

	@Test
	public void testConstructorNoValidoNumerosNoConsecutivos() {
		assertThrows(IllegalArgumentException.class, () -> {
			new RedMetro(l1, l3);
		});
	}

	@Test
	public void testConstructorNoValidoColoresRepetidos() {
		assertThrows(IllegalArgumentException.class, () -> {
			new RedMetro(l1, l4);
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
	public void testAddLineaNoValidoNumeroNoConsecutivo() {
		RedMetro red = new RedMetro(l1, l2);
		assertThrows(IllegalArgumentException.class, () -> {
			red.addLinea(l5);
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
		RedMetro red = new RedMetro(l1, l2, l3);
		assertThrows(IllegalArgumentException.class, () -> {
			red.removeLinea(4);
		});
	}

	@Test
	public void testRemoveLinea2LineasRestantes() {
		RedMetro red = new RedMetro(l1, l2);
		assertThrows(IllegalArgumentException.class, () -> {
			red.removeLinea(2);
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
	public void testGetEstacionesCorrespondenciaPrimerNúmeroInexistente() {
		RedMetro red = new RedMetro(l1, l2);
		assertThrows(IllegalArgumentException.class, () -> {
			red.getEstacionesCorrespondencia(3, 1);
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
	public void testGetLineasConexionSinTransbordoPrimerNombreInexistente() {
		RedMetro red = new RedMetro(l1, l2);
		assertThrows(IllegalArgumentException.class, () -> {
			red.getLineasConexionSinTransbordo("estacion3", "estacion1");
		});
	}

	@Test
	public void testGetLineasConexionConTransbordo() {
		Estacion e3 = createMock(Estacion.class);
		expect(e3.getNombre()).andReturn("estacion3").anyTimes();
		CoordenadasGPS[] coords3 = new CoordenadasGPS[2];
		coords3[0] = c1;
		coords3[1] = c2;
		expect(e3.getCoordenadasGPS()).andReturn(coords3).anyTimes();
		Linea l6 = createMock(Linea.class);
		expect(l6.getColor()).andReturn("rojo").anyTimes();
		expect(l6.getNumero()).andReturn(1).anyTimes();
		Estacion[] estaciones6 = new Estacion[2];
		estaciones6[0] = e1;
		estaciones6[1] = e2;
		expect(l6.getEstaciones(true)).andReturn(estaciones6).anyTimes();
		expect(l6.contieneEstacion(e3)).andReturn(false).anyTimes();
		expect(l6.contieneEstacion(e1)).andReturn(true).anyTimes();
		expect(l6.contieneEstacion(e2)).andReturn(true).anyTimes();
		Linea l7 = createMock(Linea.class);
		expect(l7.getColor()).andReturn("azul").anyTimes();
		expect(l7.getNumero()).andReturn(2).anyTimes();
		Estacion[] estaciones7 = new Estacion[2];
		estaciones7[0] = e2;
		estaciones7[1] = e3;
		expect(l7.getEstaciones(true)).andReturn(estaciones7).anyTimes();
		expect(l7.contieneEstacion(e1)).andReturn(false).anyTimes();
		expect(l7.contieneEstacion(e2)).andReturn(true).anyTimes();
		expect(l7.contieneEstacion(e3)).andReturn(true).anyTimes();
		replay(e3);
		replay(l6);
		replay(l7);
		Linea[] lineas = { l6, l7 };
		RedMetro red = new RedMetro(l6, l7);
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
	public void testGetLineasConexionConTransbordoPrimerNombreInexistente() {
		RedMetro red = new RedMetro(l1, l2);
		assertThrows(IllegalArgumentException.class, () -> {
			red.getLineasConexionConTransbordo("estacion3", "estacion1");
		});
	}

	@Test
	public void testGetEstacionesCercanas() {
		RedMetro red = new RedMetro(l1, l2);
		Estacion estaciones[] = { e1, e2 };
		assertArrayEquals(red.getEstacionesCercanas(c1, 10.0), estaciones);
	}

	@Test
	public void testGetEstacionesCercanas0Estaciones() {
		RedMetro red = new RedMetro(l1, l2);
		Estacion estaciones[] = {};
		assertArrayEquals(red.getEstacionesCercanas(c5, 1.0), estaciones);
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

	/*
	 * Para testear el constructor a partir de JSON debería hacerse con las clases
	 * de las que depende implementadas, no se puede hacer con mocks.
	 * 
	 * @Test public void testConstructorFromJSON() { RedMetro red1 = null; try {
	 * red1 = new RedMetro(json); } catch (JSONException e) { } RedMetro red2 = new
	 * RedMetro(l1, l2); assertNotNull(red1.getLineas());
	 * assertNotNull(red2.getLineas()); assertEquals(red1.getLineas(),
	 * red2.getLineas()); }
	 */
}

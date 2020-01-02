package es.uva.inf.tds.pr4;

import static org.junit.jupiter.api.Assertions.*;
import static org.easymock.EasyMock.*;

import org.easymock.Mock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

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
		expect(c1.getLatitudGMS()).andReturn("040°42'46\"N");
		expect(c1.getLongitudGMS()).andReturn("074°00'21\"O");
		c2 = createMock(CoordenadasGPS.class);
		expect(c2.getLatitudGMS()).andReturn("040°42'46\"N");
		expect(c2.getLongitudGMS()).andReturn("074°00'20\"O");
		c3 = createMock(CoordenadasGPS.class);
		expect(c3.getLatitudGMS()).andReturn("040°42'46\"N");
		expect(c3.getLongitudGMS()).andReturn("074°00'19\"O");
		c4 = createMock(CoordenadasGPS.class);
		expect(c4.getLatitudGMS()).andReturn("040°42'46\"N");
		expect(c4.getLongitudGMS()).andReturn("074°00'18\"O");
		c5 = createMock(CoordenadasGPS.class);
		expect(c5.getLatitudGMS()).andReturn("040°42'46\"N");
		expect(c5.getLongitudGMS()).andReturn("074°00'18\"O");
		e1 = createMock(Estacion.class);
		expect(e1.getNombre()).andReturn("estacion1").anyTimes();
		CoordenadasGPS[] coords1 = new CoordenadasGPS[2];
		coords1[0] = c1;
		coords1[1] = c2;
		expect(e1.getCoordenadasGPS()).andReturn(coords1).anyTimes();
		e2 = createMock(Estacion.class);
		expect(e2.getNombre()).andReturn("estacion2").anyTimes();
		CoordenadasGPS[] coords2 = new CoordenadasGPS[2];
		coords2[0] = c3;
		coords2[1] = c4;
		expect(e2.getCoordenadasGPS()).andReturn(coords2).anyTimes();
		l1 = createMock(Linea.class);
		expect(l1.getColor()).andReturn("rojo").anyTimes();
		expect(l1.getNumero()).andReturn(1).anyTimes();
		Estacion[] estaciones1 = new Estacion[2];
		estaciones1[0] = e1;
		estaciones1[1] = e2;
		expect(l1.getEstaciones(true)).andReturn(estaciones1).anyTimes();
		expect(l1.contieneEstacion(e1)).andReturn(true).anyTimes();
		expect(l1.contieneEstacion(e2)).andReturn(true).anyTimes();
		l2 = createMock(Linea.class);
		expect(l2.getColor()).andReturn("azul").anyTimes();
		expect(l2.getNumero()).andReturn(2).anyTimes();
		Estacion[] estaciones2 = new Estacion[2];
		estaciones2[0] = e1;
		estaciones2[1] = e2;
		expect(l2.getEstaciones(true)).andReturn(estaciones2).anyTimes();
		expect(l2.contieneEstacion(e1)).andReturn(true).anyTimes();
		expect(l2.contieneEstacion(e2)).andReturn(true).anyTimes();
		expect(l1.getCorrespondencias(l2)).andReturn(estaciones1);
		l3 = createMock(Linea.class);
		expect(l3.getColor()).andReturn("amarillo").anyTimes();
		expect(l3.getNumero()).andReturn(3).anyTimes();
		Estacion[] estaciones3 = new Estacion[2];
		estaciones3[0] = e1;
		estaciones3[1] = e2;
		expect(l3.getEstaciones(true)).andReturn(estaciones3).anyTimes();
		expect(l3.contieneEstacion(e1)).andReturn(true).anyTimes();
		expect(l3.contieneEstacion(e2)).andReturn(true).anyTimes();
		l4 = createMock(Linea.class);
		expect(l4.getColor()).andReturn("azul").anyTimes();
		expect(l4.getNumero()).andReturn(3).anyTimes();
		Estacion[] estaciones4 = new Estacion[2];
		estaciones4[0] = e1;
		estaciones4[1] = e2;
		expect(l4.getEstaciones(true)).andReturn(estaciones4).anyTimes();
		expect(l4.contieneEstacion(e1)).andReturn(true).anyTimes();
		expect(l4.contieneEstacion(e2)).andReturn(true).anyTimes();
		l5 = createMock(Linea.class);
		expect(l5.getColor()).andReturn("naranja").anyTimes();
		expect(l5.getNumero()).andReturn(4).anyTimes();
		Estacion[] estaciones5 = new Estacion[2];
		estaciones5[0] = e1;
		estaciones5[1] = e2;
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
			new RedMetro(l1,l3);
		});
	}
	
	@Test
	public void testConstructorNoValidoColoresRepetidos() {
		assertThrows(IllegalArgumentException.class, () -> {
			new RedMetro(l1,l3);
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
		RedMetro red = new RedMetro(l1, l2);
		assertThrows(IllegalArgumentException.class, () -> {
			red.removeLinea(3);
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
}

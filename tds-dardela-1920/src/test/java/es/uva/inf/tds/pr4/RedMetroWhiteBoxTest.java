package es.uva.inf.tds.pr4;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.junit.jupiter.api.Assertions.*;

import org.easymock.Mock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.uva.inf.maps.CoordenadasGPS;
import es.uva.inf.tds.redmetro.Estacion;
import es.uva.inf.tds.redmetro.Linea;

/**
 * Clase de test en aislamiento de caja blanca para aumentar la cobertura para
 * la clase RedMetro
 * 
 * @author dardela
 *
 */
class RedMetroWhiteBoxTest {
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
	public void testReactivarLinea() {
		RedMetro red = new RedMetro(l1, l2, l3);
		assertEquals(red.getLineas().length, 3);
		red.removeLinea(1);
		assertEquals(red.getLineas().length, 2);
		red.reactivarLinea(1);
		assertEquals(red.getLineas().length, 3);
	}

	@Test
	public void testReactivarLineaNumeroInexistente() {
		RedMetro red = new RedMetro(l1, l2, l3);
		red.removeLinea(1);
		assertThrows(IllegalArgumentException.class, () -> {
			red.reactivarLinea(2);
		});
	}
	
	@Test
	public void testGetLineasTotales() {
		RedMetro red = new RedMetro(l1,l2,l3);
		assertArrayEquals(red.getLineas(),red.getLineasTotales());
	}
}

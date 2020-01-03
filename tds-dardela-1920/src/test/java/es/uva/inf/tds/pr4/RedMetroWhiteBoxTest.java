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
	public Estacion e1;
	public Estacion e2;
	public Linea l1;
	public Linea l2;
	public Linea l3;

	@BeforeEach
	public void setUp() {
		e1 = createMock(Estacion.class);
		expect(e1.getNombre()).andReturn("estacion1").anyTimes();	
		e2 = createMock(Estacion.class);
		expect(e2.getNombre()).andReturn("estacion2").anyTimes();
		l1 = createMock(Linea.class);
		expect(l1.getColor()).andReturn("rojo").anyTimes();
		expect(l1.getNumero()).andReturn(1).anyTimes();
		Estacion[] estaciones1 = { e1, e2 };
		expect(l1.getEstaciones(true)).andReturn(estaciones1).anyTimes();
		expect(l1.contieneEstacion(e1)).andReturn(true).anyTimes();
		expect(l1.contieneEstacion(e2)).andReturn(true).anyTimes();
		l2 = createMock(Linea.class);
		expect(l2.getColor()).andReturn("azul").anyTimes();
		expect(l2.getNumero()).andReturn(2).anyTimes();
		Estacion[] estaciones2 = { e1, e2 };
		expect(l2.getEstaciones(true)).andReturn(estaciones2).anyTimes();
		expect(l2.contieneEstacion(e1)).andReturn(true).anyTimes();
		expect(l2.contieneEstacion(e2)).andReturn(true).anyTimes();
		expect(l1.getCorrespondencias(l2)).andReturn(estaciones1);
		l3 = createMock(Linea.class);
		expect(l3.getColor()).andReturn("amarillo").anyTimes();
		expect(l3.getNumero()).andReturn(3).anyTimes();
		Estacion[] estaciones3 = { e1, e2 };
		expect(l3.getEstaciones(true)).andReturn(estaciones3).anyTimes();
		expect(l3.contieneEstacion(e1)).andReturn(true).anyTimes();
		expect(l3.contieneEstacion(e2)).andReturn(true).anyTimes();
		replay(e1);
		replay(e2);
		replay(l1);
		replay(l2);
		replay(l3);
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
		RedMetro red = new RedMetro(l1, l2, l3);
		assertArrayEquals(red.getLineas(), red.getLineasTotales());
	}
}

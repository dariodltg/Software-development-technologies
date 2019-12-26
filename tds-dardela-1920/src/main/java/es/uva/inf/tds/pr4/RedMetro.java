package es.uva.inf.tds.pr4;

import es.uva.inf.tds.redmetro.Estacion;
import es.uva.inf.tds.redmetro.Linea;

/**
 * Implementación de la clase que representa una red de líneas de metro.
 * Práctica 4 de Tecnologías para el Desarrollo de Software.
 * 
 * @author dardela
 *
 */
public class RedMetro {

	/**
	 * Constructor de una red de líneas de metro.
	 * 
	 * @param nombre
	 *            Nombre de la red.
	 * @param lineas
	 *            Conjunto de líneas de metro que tendrá la red.
	 * @throws IllegalArgumentException
	 *             Si la red no tiene al menos 2 líneas o si los números de las
	 *             líneas no son consecutivos o si hay líneas con colores repetidos.
	 */
	public RedMetro(String nombre, Linea... lineas) {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Devuelve el nombre de la red de líneas de metro.
	 * 
	 * @return El nombre de la red de líneas de metro.
	 */
	public String getNombre() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Devuelve una linea de metro de la red a partir de su número.
	 * 
	 * @param numero
	 *            Número de la línea.
	 * @return La línea cuyo número se pasa como parámetro o null si no hay ninguna
	 *         línea con ese número.
	 */
	public Linea getLineaNumero(int numero) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Devuelve una linea de metro de la red a partir de su color.
	 * 
	 * @param color
	 *            Color de la línea.
	 * @return La línea cuyo color se pasa como parámetro o null si no hay ninguna
	 *         línea con ese color.
	 */
	public Linea getLineaColor(String color) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Añade una línea a la red.
	 * 
	 * @param linea
	 *            Línea que se añadirá.
	 * 
	 * @throws IllegalArgumentException
	 *             si el número de la línea no es consecutivo o el color está
	 *             repetido.
	 */
	public void addLinea(Linea linea) {
		// TODO Auto-generated method stub

	}

	/**
	 * Elimina una línea de la red dado su número.
	 * 
	 * @param numero
	 *            Número de la línea que se quiere eliminar.
	 * @throws IllegalArgumentException
	 *             si el número no corresponde a ninguna línea o si al quitarlo
	 *             dejara a la red con menos de 2 líneas.
	 */
	public void removeLinea(int numero) {
		// TODO Auto-generated method stub

	}

	/**
	 * Devuelve un array con todas las líneas que forman la red.
	 * 
	 * @return Un array con todas las líneas que forman la red.
	 */
	public Linea[] getLineas() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Devuelve un array con las líneas que pasan por una estación concreta.
	 * 
	 * @param nombreEstacion
	 *            Nombre de la estación por las que pasan las líneas que se
	 *            devolverán.
	 * @return Un array con las líneas que pasan por la estación cuyo nombre se pasa
	 *         como parámetro.
	 * @throws IllegalArgumentException
	 *             si el nombre que se pasa como parámetro no coincide con el de
	 *             ninguna estación de la red.
	 */
	public Linea[] getLineasEstacion(String nombreEstacion) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Devuelve un array con las estaciones en las que coinciden las dos líneas que
	 * se pasan como parámetros.
	 * 
	 * @param l1
	 *            Una de las líneas.
	 * @param l2
	 *            Otra de las líneas.
	 * @return Un array con las estaciones en las que coinciden las dos líneas que
	 *         se pasan como parámetros. Si no coinciden en ninguna estación
	 *         devuelve un array vacío.
	 * @throws IllegalArgumentException
	 *             si alguno de los número pasados como parámetros no corresponde
	 *             con ninguna de las líneas de la red.
	 */
	public Estacion[] getEstacionesCorrespondencia(int numL1, int numL2) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Devuelve un array con las líneas que conectan dos estaciones (sin
	 * transbordo).
	 * 
	 * @param nombreEstacion1
	 *            Nombre de una de las estaciones.
	 * @param nombreEstacion2
	 *            Nombre de otra de las estaciones.
	 * @return Un array con las líneas que conectan las dos estaciones (sin
	 *         transbordo) cuyos nombres se pasan como parámetros. Si no están
	 *         conectadas por ninguna línea devuelve un array vacío.
	 * @throws IllegalArgumentException
	 *             Si alguno de los nombres pasados como parámetros no coincide con
	 *             ninguna estación de la red.
	 */
	public Linea[] getLineasConexionSinTransbordo(String nombreEstacion1, String nombreEstacion2) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Devuelve un array con las líneas que conectan dos estaciones (con
	 * transbordo).
	 * 
	 * @param nombreEstacion1
	 *            Nombre de una de las estaciones.
	 * @param nombreEstacion2
	 *            Nombre de otra de las estaciones.
	 * @return Un array con las líneas que conectan las dos estaciones (con
	 *         transbordo) cuyos nombres se pasan como parámetros. Si no están
	 *         conectadas por ninguna línea devuelve un array vacío.La primera línea
	 *         en el array contiene la estación de partida, la última línea en el
	 *         array contiene la estación de destino.
	 * @throws IllegalArgumentException
	 *             Si alguno de los nombres pasados como parámetros no coincide con
	 *             ninguna estación de la red.
	 */
	public Linea[] getLineasConexionConTransbordo(String nombreEstacion1, String nombreEstacion2) {
		// TODO Auto-generated method stub
		return null;
	}

}

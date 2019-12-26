package es.uva.inf.tds.pr4;

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
	 *             Si la red no tiene al menos dos líneas o si los números de las
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

}

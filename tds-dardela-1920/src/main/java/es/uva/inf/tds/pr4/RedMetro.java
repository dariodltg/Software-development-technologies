package es.uva.inf.tds.pr4;

import java.util.ArrayList;
import es.uva.inf.maps.CoordenadasGPS;
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

	private ArrayList<Linea> lineas;
	private ArrayList<Linea> fueraDeServicio;

	/**
	 * Constructor de una red de líneas de metro.
	 * 
	 * @param lineas
	 *            Conjunto de líneas de metro que tendrá la red.
	 * @throws IllegalArgumentException
	 *             Si la red no tiene al menos 2 líneas o si los números de las
	 *             líneas no son consecutivos o si hay líneas con colores repetidos.
	 */
	public RedMetro(Linea... lineas) {
		if (lineas.length < 2) {
			throw new IllegalArgumentException("La red debe tener al menos 2 líneas");
		}
		this.lineas = new ArrayList<>();
		fueraDeServicio = new ArrayList<>();
		for (Linea linea : lineas) {
			this.lineas.add(linea);
		}
		for (int i = 0; i < this.lineas.size(); i++) {
			if (this.lineas.get(i).getNumero() != i + 1) {
				throw new IllegalArgumentException("Los número de las líneas deben ser consecutivos.");
			}
		}
	}

	/**
	 * Constructor de una red de líneas de metro a partir de un String en formato
	 * json
	 * 
	 * @param red
	 *            String en formato json que representa la red.
	 */
	public RedMetro(String red) {
		// TODO Auto-generated constructor stub
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
		Linea lineaBuscada = null;
		for (int i = 0; i < getLineas().length; i++) {
			if (getLineas()[i].getNumero() == numero) {
				lineaBuscada = getLineas()[i];
			}
		}
		return lineaBuscada;
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
		Linea lineaBuscada = null;
		for (int i = 0; i < getLineas().length; i++) {
			if (getLineas()[i].getColor().equals(color)) {
				lineaBuscada = getLineas()[i];
			}
		}
		return lineaBuscada;
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
		for (int i = 0; i < getLineas().length; i++) {
			if (linea.getColor().equals(getLineas()[i].getColor())) {
				throw new IllegalArgumentException("El color no se puede repetir");
			}
		}
		if (linea.getNumero() != getLineas()[lineas.size() - 1].getNumero() + 1) {
			throw new IllegalArgumentException("Los número de las líneas deben ser consecutivos");
		}
		lineas.add(linea);
	}

	/**
	 * Retira una línea del servicio de la red dado su número.
	 * 
	 * @param numero
	 *            Número de la línea que se quiere retirar.
	 * @throws IllegalArgumentException
	 *             si el número no corresponde a ninguna línea o si al quitarlo
	 *             dejara a la red con menos de 2 líneas.
	 */
	public void removeLinea(int numero) {
		if (getLineas().length - fueraDeServicio.size() == 2) {
			throw new IllegalArgumentException("Debe haber al menos 2 líneas en servicio");
		}
		boolean encontrado = false;
		for (int i = 0; i < getLineas().length; i++) {
			if (getLineas()[i].getNumero() == numero) {
				encontrado = true;
				fueraDeServicio.add(getLineas()[i]);
				break;
			}
		}
		if (!encontrado) {
			throw new IllegalArgumentException("El número no corresponde a ninguna línea");
		}
	}

	/**
	 * Devuelve un array con todas las líneas que forman la red.
	 * 
	 * @return Un array con todas las líneas que forman la red.
	 */
	public Linea[] getLineas() {
		return lineas.toArray(new Linea[lineas.size()]);
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
		Estacion estacionBuscada = null;
		boolean encontrado = false;
		ArrayList<Linea> lineasEstacion = new ArrayList<>();
		for (int i = 0; i < getLineas().length; i++) {
			Estacion[] estaciones = getLineas()[i].getEstaciones(true);
			for (int j = 0; j < estaciones.length; j++) {
				if (estaciones[j].getNombre().equals(nombreEstacion)) {
					encontrado = true;
					estacionBuscada = estaciones[j];
					break;
				}
			}
			if (encontrado) {
				break;
			}
		}
		if(!encontrado) {
			throw new IllegalArgumentException("El nombre no corresponde con ninguna estación");
		}
		for (int i = 0; i < getLineas().length; i++) {
			if (getLineas()[i].contieneEstacion(estacionBuscada)) {
				lineasEstacion.add(getLineas()[i]);
			}
		}
		return lineasEstacion.toArray(new Linea[lineasEstacion.size()]);
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
	 *         devuelve un array de tamaño 0.
	 * @throws IllegalArgumentException
	 *             si alguno de los número pasados como parámetros no corresponde
	 *             con ninguna de las líneas de la red.
	 */
	public Estacion[] getEstacionesCorrespondencia(int numL1, int numL2) {
		Linea l1;
		Linea l2;
		try {
			l1 = getLineaNumero(numL1);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("El número 1 no corresponde a ninguna línea.");
		}
		try {
			l2 = getLineaNumero(numL2);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("El número 2 no corresponde a ninguna línea.");
		}
		return l1.getCorrespondencias(l2);
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
	 *         conectadas por ninguna línea devuelve un array de tamaño 0.
	 * @throws IllegalArgumentException
	 *             Si alguno de los nombres pasados como parámetros no coincide con
	 *             ninguna estación de la red.
	 */
	public Linea[] getLineasConexionSinTransbordo(String nombreEstacion1, String nombreEstacion2) {
		ArrayList<Linea> lineasConexionSinTransbordo = new ArrayList<>();
		Linea [] lineasEstacion1;
		Linea [] lineasEstacion2;
		try {
			lineasEstacion1=getLineasEstacion(nombreEstacion1);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("El nombre 1 no corresponde a ninguna estación.");
		}
		try {
			lineasEstacion2=getLineasEstacion(nombreEstacion2);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("El nombre 2 no corresponde a ninguna estación.");
		}
		if(lineasEstacion1.length<lineasEstacion2.length) {
			Linea [] aux=lineasEstacion1;
			lineasEstacion1=lineasEstacion2;
			lineasEstacion2=aux;
		}
		for(int i=0;i<lineasEstacion1.length;i++) {
			for(int j=0;j<lineasEstacion2.length;j++) {
				if(lineasEstacion1[i]==lineasEstacion2[j]) {
					lineasConexionSinTransbordo.add(lineasEstacion1[i]);
				}
			}
		}
		return lineasConexionSinTransbordo.toArray(new Linea[lineasConexionSinTransbordo.size()]);
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
	 *         transbordo) cuyos nombres se pasan como parámetros. La primera línea
	 *         en el array contiene la estación de partida, la última línea en el
	 *         array contiene la estación de destino. Si no están conectadas por
	 *         ninguna línea devuelve un array de tamaño 0.
	 * @throws IllegalArgumentException
	 *             Si alguno de los nombres pasados como parámetros no coincide con
	 *             ninguna estación de la red.
	 */
	public Linea[] getLineasConexionConTransbordo(String nombreEstacion1, String nombreEstacion2) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Devuelve un array con las estaciones de la red que se encuentran a una
	 * distancia máxima dada desde las coordenadas dadas.
	 * 
	 * @param coordenadaGPS
	 *            CoordenadasGPS que se toman como punto de referencia.
	 * @param distanciaMaxima
	 *            Distancia máxima (en kilómetros) para establecer la cercanía.
	 * @return Un array con las estaciones de la red que se encuentran a una
	 *         distancia máxima dada desde las coordenadas dadas. Si no hay
	 *         estaciones cercanas, devuelve un array de tamaño 0.
	 */
	public Estacion[] getEstacionesCercanas(CoordenadasGPS coordenadaGPS, int distanciaMaxima) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Devuelve un String en formato JSON que contiene información sobre todas las
	 * líneas de la red.
	 */
	public String getJSON() {
		// TODO Auto-generated method stub
		return null;
	}

}

package fes.aragon.problema1.utilerias.estaticas;

import java.util.Random;

import fes.aragon.problema1.except.IndiceFueraDeRango;
/**
 * Herramienta para crear Un Arreglo Sencillo de cualquier tipo
 * 
 * @author Equipo 9 Bueno Zaldivar Omar Alejandro y Edith Sol Martinez
 *
 * @param <E> Tipo del arreglo
 */
public class Arreglos<E> {
	private int indice = 0;
	private final Object[] l;

	/**
	 * Constructor donde se indica el numero de elementos que se desea en el arreglo
	 * 
	 * @param numeroElementos
	 */
	public Arreglos(int numeroElementos) {
		this.l = new Object[numeroElementos];
	}

	/**
	 * Metodo que inserta un valor al arreglo
	 * 
	 * @param x Valor a insertar
	 * @throws IndiceFueraDeRango Advertencia de rango
	 */
	public void insertar(E x) throws IndiceFueraDeRango {
		if (indice < l.length) {
			l[indice] = x;
			indice++;
		} else {
			throw new IndiceFueraDeRango("Idice fuera de rango");
		}
	}

	/**
	 * Devuelve la posicion de un elemento de un valor localizado en el arreglo
	 * 
	 * @param x Valor a encontrar
	 * @return Devuelve la posicion del elemento localizado
	 */
	public Integer localizar(E x) {
		for (int i = 0; i < l.length; i++) {
			if (l[i].equals(x)) {
				return i;
			}
		}
		return -1;

	}

	/**
	 * Funcion que devuelve el valor del arreglo pasando el indice
	 * 
	 * @param p indice del arreglo
	 * @return Valor localizado en el indice p del arreglo
	 * @throws IndiceFueraDeRango Advertencia de rango
	 */
	public E recuperar(Integer p) throws IndiceFueraDeRango {
		if (p < l.length) {
			@SuppressWarnings("unchecked")
			final E e = (E) l[p];
			return e;
		} else {
			throw new IndiceFueraDeRango("Fallo funcion recuperar Indice fuera de rango");
		}
	}
	

	/**
	 * Metodo para borrar el elemento pasando su indice
	 * 
	 * @param p Indice a eliminar
	 * @throws IndiceFueraDeRango Advertencia de rango
	 */
	public void suprimir(Integer p) throws IndiceFueraDeRango {
		if (p < l.length) {
			l[p] = null;
		} else {
			throw new IndiceFueraDeRango("Fallo funcion recuperar Indice fuera de rango");
		}
	}

	/**
	 * Metodo que devuelve el valor del siguiente indice al mandado
	 * 
	 * @param p Indice
	 * @return devuelve el valor siguiente
	 * @throws IndiceFueraDeRango Advertencia de rango
	 */
	public E siguiente(Integer p) throws IndiceFueraDeRango {
		if (p < l.length && p + 1 < l.length) {
			@SuppressWarnings("unchecked")
			final E e = (E) l[p + 1];
			return e;
		} else {
			throw new IndiceFueraDeRango("Fallo funcion siguiente Indice fuera de rango");
		}
	}

	/**
	 * Metodo que regresa el valor del indice anterior al mandado
	 * 
	 * @param p Indice mandado
	 * @return Devulve el valor anterior
	 * @throws IndiceFueraDeRango Advertencia de rango
	 */
	public E anterior(Integer p) throws IndiceFueraDeRango {
		if (p < l.length && p - 1 >= 0) {
			@SuppressWarnings("unchecked")
			final E e = (E) l[p - 1];
			return e;
		} else {
			throw new IndiceFueraDeRango("Fallo funcion anterior Indice fuera de rango");
		}
	}

	/**
	 * Metodo que limpia la lista mandadoa
	 * 
	 */
	public void limpiar() {
		for (int i = 0; i < l.length; i++) {
			l[i] = null;
		}
	}

	/**
	 * Devuelve el primer valor del arreglo
	 * 
	 * @return Primer valor de la lista
	 */
	public E primero() {
		@SuppressWarnings("unchecked")
		final E e = (E) l[0];
		return e;
	}

	/**
	 * Metodo que devuelve la longitud del arreglo
	 * 
	 * @return retorna la longitud del arreglo
	 */
	public Integer longitud() {
		return l.length;
	}

	/**
	 * Metodo que llena el arreglo con numero aleatorios
	 */
	public void llenar() {
		Random rd = new Random();
		for (int i = 0; i < l.length; i++) {
			l[i] = rd.nextInt(101);

		}
	}

	/**
	 * Metodo que duevuelve el valor mayor de un arreglo
	 * 
	 * @return El valor mayor del arreglo
	 */
	public Integer mayor() {
		Integer mayor = 0;
		for (int i = 0; i < l.length; i++) {
			if ((Integer) l[i] > mayor) {
				mayor = (Integer) l[i];
			}
		}
		return mayor;
	}

	/**
	 * Metodo que retorna el segundo numero mayor del arreglo
	 * 
	 * @return Segundo Numero mayor del arreglo
	 */
	public Integer SegundoMayor() {
		int mayor = mayor();
		int mayorDos = 0;
		for (int i = 0; i < l.length; i++) {
			if ((Integer) l[i] > mayorDos && (Integer) l[i] < mayor) {
				mayorDos = (Integer) l[i];
			}
		}
		return mayorDos;
	}

	/**
	 * Metodo que retorna el promedio de todos los valores del arreglo
	 * 
	 * @return Promedio de los datos del arreglo
	 */
	public double promedio() {
		double suma = 0;
		for (Object valor : l) {
			suma += (Integer) valor;
		}
		return suma / l.length;
	}

	/**
	 * Metodo que calcula e imprime los numero repetidos de un arreglo
	 */
	public void numerosRepetidos() {
		Integer repetidos[][] = new Integer[mayor() + 1][2];
		Integer aux;
		for (int i = 0; i < l.length; i++) {
			for (int j = 0; j < l.length - 1; j++) {
				if ((Integer) l[j] > (Integer) l[j + 1]) {
					aux = (Integer) l[j];
					l[j] = l[j + 1];
					l[j + 1] = aux;
				}
			}
		}
		int repetidas = 0;
		int k = 0;
		for (int i = 0; i < l.length; i++) {
			if (i != l.length - 1) {
				if (l[i].equals(l[i + 1])) {
					repetidas++;
					continue;
				}
			}
			repetidos[k][0] = (Integer) l[i];
			repetidos[k][1] = repetidas;
			k++;
			repetidas = 0;
		}
		for (int i = 0; i < repetidos.length; i++) {
			if (repetidos[i][0] == null) {
				continue;
			}
			System.out.println(repetidos[i][0] + " = " + repetidos[i][1]);
		}
	}

	/**
	 * Metodo que imprime los elementos de un arreglo
	 * 
	 */
	public void imprimir() {
		for (Object valor : l) {
			System.out.println(valor);
		}
	}
}

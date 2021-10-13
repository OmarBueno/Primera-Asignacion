package fes.aragon.utilerias.estaticas;

import java.util.Random;

import fes.aragon.except.IndiceFueraDeRango;

public class ArreglosBi<E> {
	private int indiceFila = 0;
	private int indiceColuma = 0;
	private int celdas = 0;
	private int datos = 0;
	private final Object[][] l;

	/**
	 * Constructor donde se indica el numero de elementos que se desea en el arreglo
	 * 
	 * @param numeroElementos
	 */
	public ArreglosBi(int filas, int columnas) {
		this.l = new Object[filas][columnas];
		celdas = filas * columnas;
	}

	public void insertar(E x) throws IndiceFueraDeRango {
		if (datos < celdas) {
			if (indiceColuma < l[0].length) {
				l[indiceFila][indiceColuma] = x;
				indiceColuma++;
				datos++;
			} else {
				indiceFila++;
				indiceColuma = 0;
				l[indiceFila][indiceColuma] = x;
				indiceColuma++;
				datos++;
			}
		} else {
			throw new IndiceFueraDeRango("Idice fuera de rango");
		}

	}

	public E recuperar(Integer fila, int columna) throws IndiceFueraDeRango {
		if (fila < l.length && columna < l[0].length) {
			@SuppressWarnings("unchecked")
			final E e = (E) l[fila][columna];
			return e;
		} else {
			throw new IndiceFueraDeRango("Fallo funcion recuperar Indice fuera de rango");
		}
	}

	/**
	 * Método para borrar el elemento pasando su indice
	 * 
	 * @param p Indice a eliminar
	 * @throws IndiceFueraDeRango error del indice fuera de rango
	 */
	public void suprimir(int fila, int columna) throws IndiceFueraDeRango {

		if (fila < l.length && columna < l[0].length) {
			l[fila][columna] = null;
		} else {
			throw new IndiceFueraDeRango("Fallo funcion suprimir Indice fuera de rango");
		}
	}

	/**
	 * Metodo que devuelve el valor del siguiente indice al mandado
	 * 
	 * @param p Indice
	 * @return devuelve el valor siguiente
	 * @throws IndiceFueraDeRango error del indice fuera de rango
	 */
	@SuppressWarnings("unchecked")
	public E siguiente(int fila, int columna) throws IndiceFueraDeRango {
		if (fila < l.length && columna < l[0].length) {
			if (columna + 1 == l[0].length && fila + 1 < l.length) {
				fila++;
				columna = 0;
				final E e = (E) l[fila][columna];
				return e;
			} else {
				final E e = (E) l[fila][columna + 1];
				return e;
			}
		} else {
			throw new IndiceFueraDeRango("Fallo funcion siguiente Indice fuera de rango");
		}
	}

	/**
	 * Metodo que limpia la lista mandada
	 * 
	 */
	public void limpiar() {
		for (int i = 0; i < l.length; i++) {
			for (int j = 0; j < l[i].length; j++) {
				l[i][j] = null;
			}
		}
	}

	/**
	 * Devuelve el primer valor del arreglo
	 * 
	 * @return Primer valor de la lista
	 */
	public E primero() {
		@SuppressWarnings("unchecked")
		final E e = (E) l[0][0];
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
	 * Metodo que rellena el arreglo con numeros aleatorios del 0 al 100
	 * 
	 * @throws IndiceFueraDeRango Fuera de rango
	 */
	@SuppressWarnings("unchecked")
	public void llenar() throws IndiceFueraDeRango {
		Random rd = new Random();
		for (int i = 0; i < celdas; i++) {
			insertar((E) (Integer) rd.nextInt(101));
		}
	}

	/**
	 * Metodo que imprime los elementos de un arreglo
	 * 
	 */
	public void imprimir() {
		for (int i = 0; i < l.length; i++) {
			for (int j = 0; j < l[i].length; j++) {
				System.out.print("[" + l[i][j] + "]" + "\t");
			}
			System.out.println("\n");
		}
	}

	/**
	 * Metodo que imprimer los elementos de una fila
	 * 
	 * @param fila Fila aa imprimir
	 */
	public void imprimirFila(int fila) {
		System.out.println("fila " + fila + " :");
		for (int i = 0; i < l[fila].length; i++) {
			System.out.println(l[fila][i]);
		}
	}

	/**
	 * Metodo que imprime los elementos de una Columna
	 * 
	 * @param columna Columna a imprimir
	 */
	public void imprimirColumna(int columna) {
		System.out.println("Columna " + columna + " :");
		for (int i = 0; i < l.length; i++) {
			System.out.println(l[i][columna]);
		}
	}

	/**
	 * Metodo que imprimer un elemento dando la fila y columna
	 * 
	 * @param fila    Fila del elemento
	 * @param columna Columna del elemento
	 */
	public void imprimir(int fila, int columna) {
		System.out.println(l[fila][columna]);
	}
}

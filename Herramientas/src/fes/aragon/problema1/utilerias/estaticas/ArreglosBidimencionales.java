package fes.aragon.problema1.utilerias.estaticas;

import java.util.Random;

import fes.aragon.except.IndiceFueraDeRango;
import fes.aragon.problema1.modelo.Datos;

/**
 * Herramienta para crear Un Arreglo Bidimensional de cualquier tipo
 * 
 * @author Equipo 9 Bueno Zaldivar Omar Alejandro y Sol Martinez Edith
 *
 * @param <E> Tipo del arreglo
 */
public class ArreglosBidimencionales<E> {
	private int indiceFila = 0;
	private int indiceColuma = 0;
	private int celdas = 0;
	private int datos = 0;
	private final Object[][] l;

	/**
	 * Inicializa el arreglo
	 * 
	 * @param filas    Filas del arreglo
	 * @param columnas Columnas del arreglo
	 */
	public ArreglosBidimencionales(int filas, int columnas) {
		this.l = new Object[filas][columnas];
		celdas = filas * columnas;
	}

	/**
	 * Inserta elementos en el arreglo
	 * 
	 * @param x Elemento a insertar
	 * @throws IndiceFueraDeRango Advertencia de tama�o
	 */
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

	/**
	 * Recupero el elemento en la fila y columna indicados
	 * 
	 * @param fila    Fila
	 * @param columna Columna
	 * @return Elemento
	 * @throws IndiceFueraDeRango Advertencia de rango
	 */
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
	 * Metodo para borrar el elemento pasando su indice
	 * @param fila Fila en donde se encuentra el elemento que se quiere suprimir
	 * @param columna posicion en la columna del elemento que se quiere suprimir
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
	 * @param fila Fila antes de la fila que se busca
	 * @param columna columna anterior a la que se busca
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
	 * Metodo que limpia la lista
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
	 * Retorna la longitud de la fila
	 * 
	 * @param fila Fila
	 * @return Longitud de Fila
	 */
	public Integer longitudFila(int fila) {
		return l[fila].length;
	}

	/**
	 * Retorna la longitud de la columna
	 * 
	 * @param columna Columna
	 * @return Longitud de la Columna
	 */
	public Integer longitudColumna(int columna) {
		return l.length;
	}

	/**
	 * Retorna el numero de elementos en el arreglo
	 * 
	 * @return Numero de Elementos del arreglo
	 */
	public Integer longitudTotal() {
		return datos;
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
	 * Metodo que rellena el arreglo con Objetos tipo Dato
	 * 
	 * @throws IndiceFueraDeRango Advertencia de rango
	 */
	@SuppressWarnings("unchecked")
	public void llenarDatos() throws IndiceFueraDeRango {
		Random rd = new Random();
		String datos[] = { "Violeta", "Omar", "Sol", "Martinez", "Alejandro"
				, "Bueno", "Zaldivar", "Kiry", "Golo",
				"Goyo", "Morita", "Gordita" };
		for (int i = 0; i < celdas; i++) {
			insertar((E) new Datos(datos[rd.nextInt(12)], rd.nextInt(101)));
		}
	}

	/**
	 * Devuelve los elementos de una columna
	 * 
	 * @param columna Columna
	 * @return Elementos de la Columna
	 * @throws IndiceFueraDeRango Advertencia de Rango
	 */
	@SuppressWarnings("unchecked")
	public Arreglos<E> datosColumna(int columna) throws IndiceFueraDeRango {
		Arreglos<Object> arr = new Arreglos<>(longitudColumna(columna));
		if (columna < l[columna].length) {
			for (int i = 0; i < l.length; i++) {
				arr.insertar(l[i][columna]);
			}
		}
		return (Arreglos<E>) arr;
	}

	/**
	 * Devuelve los elementos de una Fila
	 * 
	 * @param fila Numero de la fila
	 * @return Elementos de la Fila
	 * @throws IndiceFueraDeRango Advertencia de Rango
	 */
	@SuppressWarnings("unchecked")
	public Arreglos<E> datosFila(int fila) throws IndiceFueraDeRango {
		Arreglos<Object> arr = new Arreglos<>(longitudFila(fila));
		if (fila < l.length) {
			for (int i = 0; i < l[fila].length; i++) {
				arr.insertar(l[fila][i]);
			}
		}
		return (Arreglos<E>) arr;
	}

	/**
	 * Metodo que suma los numeros en las filas
	 * 
	 * @param filas Filas a sumar
	 * @return Filas sumadas
	 * @throws IndiceFueraDeRango Advertencia de Rango
	 */
	@SuppressWarnings("unchecked")
	public int[] sumarFila(int... filas) throws IndiceFueraDeRango {
		int suma = 0;
		int sumas[] = new int[filas.length];
		Arreglos<Object> aux = null;
		for (int i = 0; i < filas.length; i++) {
			if (filas[i] < l.length) {
				aux = (Arreglos<Object>) datosFila(filas[i]);
				for (int j = 0; j < aux.longitud(); j++) {
					suma += ((Datos) aux.recuperar(j)).getNumero();
				}
				System.out.println("Suma de la Fila " + filas[i] + ": " + suma);
				sumas[i] = suma;
				suma = 0;
			}
		}
		return sumas;
	}

	/**
	 * etodo que suma los numeros en las columnas
	 * 
	 * @param columnas Columnas a sumar
	 * @return Columnas sumadas
	 * @throws IndiceFueraDeRango Advertencia de Rango
	 */
	@SuppressWarnings("unchecked")
	public int[] sumarColumnas(int... columnas) throws IndiceFueraDeRango {
		int suma = 0;
		int sumas[] = new int[columnas.length];
		Arreglos<Object> aux = null;
		for (int i = 0; i < columnas.length; i++) {
			if (columnas[i] < l[i].length) {
				aux = (Arreglos<Object>) datosColumna(columnas[i]);
				for (int j = 0; j < aux.longitud(); j++) {
					suma += ((Datos) aux.recuperar(j)).getNumero();
				}
				System.out.println("Suma de la Columa " + columnas[i] + ": " + suma);
				sumas[i] = suma;
				suma = 0;
			}
		}
		return sumas;
	}

	/**
	 * Metodo que imprime los elementos del arreglo
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
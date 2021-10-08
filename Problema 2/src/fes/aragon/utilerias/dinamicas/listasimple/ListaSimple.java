package fes.aragon.utilerias.dinamicas.listasimple;

import fes.aragon.except.IndiceFueraDeRango;
import fes.aragon.utilerias.dinamicas.listadoble.ListaDoble;

/**
 * Clase que crea una lista simplemente enlazada
 * 
 * @author Omar Bueno FES Aragón UNAM
 *
 * @param <E> Tipo de datos a almacenar
 */
public class ListaSimple<E> {
	protected Nodo<E> cabeza, cola;
	protected int longitud = 0;

	/**
	 * Creación de la lista
	 */
	public ListaSimple() {
		cabeza = cola = null;
	}

	/**
	 * Método que agrega un dato al inicio de la lista
	 * 
	 * @param dato Primer dato de la lista
	 */
	public void agregarEnCabeza(E dato) {
		cabeza = new Nodo<E>(dato, cabeza);
		if (cola == null) {
			cola = cabeza;
		}
		longitud++;
	}

	/**
	 * Método que agrega un dato al final de la lista
	 * 
	 * @param dato ultimo dato de la lista
	 */
	public void agregarEnCola(E dato) {
		if (cabeza == null) {
			cabeza = cola = new Nodo<E>(dato);
		} else {
			cola.setSiguiente(new Nodo<E>(dato));
			cola = cola.getSiguiente();
		}
		longitud++;
	}

	/**
	 * Método que elimina el dato de la cabeza si solo hay un dato elimina la lista
	 */
	public void eliminarEnCabeza() {
		if (cabeza == null) {
			System.out.println("No existe elemento en cabeza");
		} else {
			if (cabeza.getSiguiente() != null) {
				cabeza = cabeza.getSiguiente();
				longitud--;
			} else {
				cabeza = null;
				longitud--;
			}
		}
	}

	/**
	 * Método que elimina el dato de la cola si solo hay un dato elimina la lista
	 */
	public void eliminarEnCola() {
		if (cola == null) {
			System.out.println("No existe elemento en cola");
		} else {
			if (cola != cabeza) {
				Nodo<E> tmp;
				for (tmp = cabeza; tmp.getSiguiente() != cola; tmp = tmp.getSiguiente())
					;
				tmp.setSiguiente(null);
				cola = tmp;
				longitud--;
			} else {
				cola = cabeza = null;
			}

		}
	}

	/**
	 * Meétodo que devuelve la longitud de la lista
	 * 
	 * @return longitud de la lista
	 */
	public int getLongitud() {
		return longitud;
	}

	/**
	 * Método que indica si la lista es vacia
	 * 
	 * @return True si es vacia False si no es vacia
	 */
	public boolean esVacia() {
		if (longitud == 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Método que devuelve el valor del nodo indicado
	 * 
	 * @param i Indice a obtener
	 * @return Valor del nodo
	 * @throws IndiceFueraDeRango No existe el indice indicado
	 */
	public E obtenerNodo(int i) throws IndiceFueraDeRango {
		int aux = 0;
		E e = null;
		if (i < longitud && i >= 0) {
			for (Nodo<E> tmp = cabeza; aux <= i; tmp = tmp.getSiguiente(), aux++) {
				e = (E) tmp.getDato();
			}
		} else {
			throw new IndiceFueraDeRango("Fallo funcion obtenerNodo Indice fuera de rango");
		}

		return e;
	}

	/**
	 * Método que devuelve el valor de la fila y columna indicados
	 * 
	 * @param i       fila
	 * @param columna columna
	 * @return Valor en la fila y columna indicados
	 * @throws IndiceFueraDeRango No existe la fila o columna indicada indicado
	 */
	@SuppressWarnings("unchecked")
	public E obtenerNodo(int i, int columna) throws IndiceFueraDeRango {
		int aux = 0;
		E e = null;
		if (i < longitud && i >= 0) {
			for (Nodo<E> tmp = cabeza; aux <= i; tmp = tmp.getSiguiente(), aux++) {
				e = (E) ((ListaDoble<Object>) tmp.getDato()).obtenerNodo(columna);
			}
		} else {
			throw new IndiceFueraDeRango("Fallo funcion obtenerNodo Indice fuera de rango");
		}

		return e;
	}

	/**
	 * Indica si un elemento esta en la lista
	 * 
	 * @param x Dato a buscar
	 * @return Retorna el indice si lo encuentra sino un -1
	 */
	public int estaEnLista(E x) {
		int aux = 0;
		for (Nodo<E> tmp = cabeza; tmp != null; tmp = tmp.getSiguiente(), aux++) {
			if (tmp.getDato().equals(x)) {
				break;
			}
		}
		if (aux < longitud) {
			return aux;
		} else {
			return -1;
		}

	}

	/**
	 * Elimina el dato en el indice indicado
	 * 
	 * @param i Indice a eliminar
	 * @return True si lo logra eliminar False si no lo logra eliminarlo
	 */
	public boolean eliminarEnIndice(int i) {
		if (i == 0) {
			eliminarEnCabeza();
			return true;
		} else if (i == longitud - 1) {
			eliminarEnCola();
			return true;
		} else if (i > 0 && i < longitud - 1) {
			int aux = 0;
			Nodo<E> tmp;
			for (tmp = cabeza; aux < i - 1; tmp = tmp.getSiguiente(), aux++)
				;
			tmp.setSiguiente(tmp.getSiguiente().getSiguiente());
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Elimina el dato en el la fila y columna indicados
	 * 
	 * @param i       fila
	 * @param columna columna
	 * @return True si lo logra eliminar False si no lo logra eliminarlo
	 */
	@SuppressWarnings("unchecked")
	public boolean eliminarEnIndice(int i, int columna) {
		if (i == 0) {
			eliminarEnCabeza();
			return true;
		} else if (i == longitud - 1) {
			eliminarEnCola();
			return true;
		} else if (i > 0 && i < longitud - 1) {
			int aux = 0;
			Nodo<E> tmp;
			for (tmp = cabeza; aux < i; tmp = tmp.getSiguiente(), aux++)
				;
			((ListaDoble<Object>) tmp.getDato()).eliminarEnIndice(columna);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Inserta un dato en el indice indicado
	 * 
	 * @param dato Dato a agregar
	 * @param i    indice a insertar
	 * @throws IndiceFueraDeRango No existe el rango
	 */
	public void insertarEnIndice(E dato, int i) throws IndiceFueraDeRango {
		if (i == 0) {
			agregarEnCabeza(dato);
		} else if (i > 0 && i < longitud) {
			Nodo<E> tmp;
			int aux = 0;
			for (tmp = cabeza; aux < i; tmp = tmp.getSiguiente(), aux++)
				;
			Nodo<E> tmp2 = new Nodo<E>(tmp.getDato(), tmp.getSiguiente());
			tmp.setDato(dato);
			tmp.setSiguiente(tmp2);
			if (i == getLongitud() - 1) {
				cola = tmp2;
			}
			longitud++;
		} else {
			throw new IndiceFueraDeRango("Fallo funcion insertarEnIndice Indice fuera de rango");
		}
	}

	/**
	 * Inserta un dato en la fila y columna indicados
	 * 
	 * @param dato    dato a insertar
	 * @param i       fila
	 * @param columna columna
	 * @throws IndiceFueraDeRango No existe la fila o columna indicada
	 */
	@SuppressWarnings("unchecked")
	public void insertarEnIndice(Object dato, int i, int columna) throws IndiceFueraDeRango {
		if (i == 0) {
			((ListaDoble<Object>) obtenerNodo(0)).insertarEnIndice(dato, columna);
		} else if (i > 0 && i < longitud) {
			Nodo<E> tmp;
			int aux = 0;
			for (tmp = cabeza; aux < i; tmp = tmp.getSiguiente(), aux++)
				;
			((ListaDoble<Object>) tmp.getDato()).insertarEnIndice(dato, columna);
		} else {
			throw new IndiceFueraDeRango("Fallo funcion insertarEnIndice Indice fuera de rango");
		}
	}

	/**
	 * Metodo que asgna un dato en el indice indicado
	 * 
	 * @param dato dato a asignarr
	 * @param i    indice
	 * @throws IndiceFueraDeRango No existe el inidce
	 */
	public void asignar(E dato, int i) throws IndiceFueraDeRango {
		int aux = 0;
		if (i < longitud && i >= 0) {
			for (Nodo<E> tmp = cabeza; aux <= i; tmp = tmp.getSiguiente(), aux++) {
				if (aux == i) {
					tmp.setDato(dato);
				}
			}
		} else {
			throw new IndiceFueraDeRango("Fallo funcion asignar Indice fuera de rango");
		}
	}

	/**
	 * Metodo que asgna un dato en la fila y columna indicada
	 * 
	 * @param dato    Dato a asignar
	 * @param i       fila
	 * @param columna columna
	 * @throws IndiceFueraDeRango No existe la fila o columna
	 */
	@SuppressWarnings("unchecked")
	public void asignar(Object dato, int i, int columna) throws IndiceFueraDeRango {
		if (i < longitud && i >= 0) {
			Nodo<E> tmp;
			int aux = 0;
			for (tmp = cabeza; aux < i; tmp = tmp.getSiguiente(), aux++)
				;
			((ListaDoble<Object>) tmp.getDato()).asignar(dato, columna);
		} else {
			throw new IndiceFueraDeRango("Fallo funcion asignar Indice fuera de rango");
		}
	}

	/**
	 * Cambia la primera incidencia de dato con el nuevo dato si el boolean es true
	 * cambiara todos los datos si es False solo la primera coincidencia
	 * 
	 * @param dato      Data a cambiar
	 * @param nuevoDato Dato que remplaza al dato anterior
	 * @param condicion True: todas las coincidencias False: solo la primera
	 *                  coincidencia
	 * @throws IndiceFueraDeRango No existe el indice
	 */

	@SuppressWarnings("unchecked")
	public void asignar(Object dato, Object nuevoDato, boolean condicion) throws IndiceFueraDeRango {
		if (condicion == false) {
			for (Nodo<E> tmp = cabeza; tmp != null; tmp = tmp.getSiguiente()) {
				((ListaDoble<Object>) tmp.getDato()).asignar(dato, nuevoDato, condicion);
			}
		} else {
			for (Nodo<E> tmp = cabeza; tmp != null; tmp = tmp.getSiguiente()) {
				((ListaDoble<Object>) tmp.getDato()).asignar(dato, nuevoDato, condicion);
			}
		}
	}

	/**
	 * Método que llena la lista simple con listas dobles
	 * 
	 * @param listas    Numero de listas deseadas
	 * @param elementos Numero de elementos de cada lista
	 */
	@SuppressWarnings("unchecked")
	public void rellenar(int listas, int elementos) {
		for (int i = 0; i < listas; i++) {
			ListaDoble<Object> listaAux = new ListaDoble<>();
			listaAux.rellenar(elementos);
			agregarEnCola((E) listaAux);
		}
	}

	/**
	 * Método que imprime todos los elementos de todas las listas
	 * 
	 * @throws IndiceFueraDeRango
	 */
	@SuppressWarnings("unchecked")
	public void imprimirElementos() throws IndiceFueraDeRango {
		if (cabeza == null) {
		} else {
			int aux = 0;
			for (Nodo<E> tmp = cabeza; tmp != null; tmp = tmp.getSiguiente(), aux++) {
				// System.out.println(((ListaDoble<Object>) tmp.getDato()).imprimirElementos());
				System.out.println("Lista " + aux + ":");
				((ListaDoble<Object>) obtenerNodo(aux)).imprimirElementos();
			}
		}
	}

	/**
	 * Imprime todos los elementos de la lista imdicada
	 * 
	 * @param indice Lista a imprimir
	 * @throws IndiceFueraDeRango Se indico una lista fuera del rango
	 */
	@SuppressWarnings("unchecked")
	public void imprimirElementos(int indice) throws IndiceFueraDeRango {
		if (cabeza == null) {
		} else if (indice >= longitud) {
			throw new IndiceFueraDeRango("Fallo funcion imprimirElementos Indice fuera de rango");
		} else {
			int aux = 0;
			for (Nodo<E> tmp = cabeza; aux < indice; tmp = tmp.getSiguiente(), aux++)
				;
			System.out.println("En El indice: " + aux);
			((ListaDoble<Object>) obtenerNodo(aux)).imprimirElementos();

		}
	}

	/**
	 * Método que imprime los elementos de la lista indicada desde su primer
	 * elemento hata la columna indicada
	 * 
	 * @param indice  Lista a imprimir
	 * @param columna Rango a imprimir
	 * @throws IndiceFueraDeRango Se indico una lista o un indice fuera del rango
	 */
	@SuppressWarnings("unchecked")
	public void imprimirElementos(int indice, int columna) throws IndiceFueraDeRango {
		if (cabeza == null) {
		} else if (indice >= longitud) {
			throw new IndiceFueraDeRango("Fallo funcion imprimirElementos Indice fuera de rango");
		} else {
			int aux = 0;
			for (Nodo<E> tmp = cabeza; aux < indice; tmp = tmp.getSiguiente(), aux++)
				;
			System.out.println("En El indice:" + aux);
			((ListaDoble<Object>) obtenerNodo(aux)).imprimirElementos(columna);

		}
	}

}

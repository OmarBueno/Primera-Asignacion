package fes.aragon.nodos;

/**
 * Clase que crea aun Nodo
 * 
 * @author Equipo 9 Bueno Zaldivar Omar Alejandro y Sol Martinez Edith
 *
 * @param <E> Tipo de nodo a crear
 */
public class NodoListaDoble<E> {
	private E dato;
	private NodoListaDoble<E> anterior, siguiente;

	public NodoListaDoble(E dato) {
		this(dato, null, null);
	}

	public NodoListaDoble(E dato, NodoListaDoble<E> anterior, NodoListaDoble<E> siguiente) {
		this.dato = dato;
		this.anterior = anterior;
		this.siguiente = siguiente;
	}

	public E getDato() {
		return dato;
	}

	public void setDato(E dato) {
		this.dato = dato;
	}

	public NodoListaDoble<E> getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(NodoListaDoble<E> siguiente) {
		this.siguiente = siguiente;
	}

	public NodoListaDoble<E> getAnterior() {
		return anterior;
	}

	public void setAnterior(NodoListaDoble<E> anterior) {
		this.anterior = anterior;
	}

}

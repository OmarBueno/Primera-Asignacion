package fes.aragon.nodos;

/**
 * Clase que crea aun Nodo
 * 
 * @author Equipo 9 Bueno Zaldivar Omar Alejandro y Sol Martinez Edith
 *
 * @param <E> Tipo de nodo a crear
 */
public class NodoListaSimple<E> {
	private E dato;
	private NodoListaSimple<E> siguiente;

	public NodoListaSimple(E dato) {
		this(dato, null);
	}

	public NodoListaSimple(E dato, NodoListaSimple<E> siguiente) {
		this.dato = dato;
		this.siguiente = siguiente;
	}

	public E getDato() {
		return dato;
	}

	public void setDato(E dato) {
		this.dato = dato;
	}

	public NodoListaSimple<E> getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(NodoListaSimple<E> siguiente) {
		this.siguiente = siguiente;
	}

}

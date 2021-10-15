package fes.aragon.problema2.utilerias.dinamicas.listadoble;

import java.util.Random;

import fes.aragon.problema2.except.IndiceFueraDeRango;

/**
 * Clase que crea una lista doblemente enlazada y permite realizar diversas
 * funciones a traves de sus metodos
 *
 * @author Equipo 9 Bueno Zaldivar Omar Alejandro y Edith Sol Martinez
 *
 * @param <E> Tipo de datos a almacenar
 */
public class ListaDoble<E> {

    protected Nodo<E> cabeza, cola;
    protected int longitud = 0;

    /**
     * Creacion de la lista
     */
    public ListaDoble() {
        cabeza = cola = null;
    }

    /**
     * Metodo que agrega un dato al inicio de la lista
     *
     * @param dato Primer dato de la lista
     */
    public void agregarEnCabeza(E dato) {
        cabeza = new Nodo<E>(dato, null, cabeza);
        if (cola == null) {
            cola = cabeza;
        } else {
            cabeza.getSiguiente().setAnterior(cabeza);
        }
        longitud++;
    }

    /**
     * Metodo que agrega un dato al final de la lista
     *
     * @param dato ultimo dato de la lista
     */
    public void agregarEnCola(E dato) {
        if (cabeza == null) {
            cabeza = cola = new Nodo<E>(dato);
        } else {
            cola.setSiguiente(new Nodo<E>(dato));
            cola.getSiguiente().setAnterior(cola);
            cola = cola.getSiguiente();
        }
        longitud++;
    }

    /**
     * Metodo que elimina el dato de la cabeza si solo hay un dato elimina la
     * lista
     */
    public void eliminarEnCabeza() {
        if (cabeza == null) {
            System.out.println("No existe elemento en cabeza");
        } else {
            if (cabeza.getSiguiente() != null) {
                cabeza = cabeza.getSiguiente();
                cabeza.setAnterior(null);
                longitud--;
            } else {
                cabeza = null;
                longitud--;
            }
        }
    }

    /**
     * Metodo que elimina el dato de la cola si solo hay un dato elimina la
     * lista
     */
    public void eliminarEnCola() {
        if (cola == null) {
            System.out.println("No existe elemento en cola");
        } else {
            if (cola != cabeza) {
                cola = cola.getAnterior();
                cola.setSiguiente(null);
                longitud--;
            } else {
                cola = cabeza = null;
                longitud--;
            }

        }
    }

    /**
     * Metodo que devuelve la longitud de la lista
     *
     * @return longitud de la lista
     */
    public int getLongitud() {
        return longitud;
    }

    /**
     * Metodo que indica si la lista es vacia
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
     * Metodo que devuelve el valor del nodo indicado
     *
     * @param i Indice a obtener
     * @return Valor del nodo
     * @throws IndiceFueraDeRango Advertencia de rango
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
            tmp.getSiguiente().setAnterior(tmp);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Inserta un dato en el indice indicado
     *
     * @param dato Dato a agregar
     * @param i indice a insertar
     * @throws IndiceFueraDeRango Advertencia de rango
     */
    public void insertarEnIndice(E dato, int i) throws IndiceFueraDeRango {
        if (i == 0) {
            agregarEnCabeza(dato);
        } else if (i > 0 && i < longitud) {
            int aux = 0;
            Nodo<E> tmp;
            for (tmp = cabeza; aux < i; tmp = tmp.getSiguiente(), aux++)
				;
            Nodo<E> tmp2 = new Nodo<E>(tmp.getDato(), tmp, tmp.getSiguiente());
            tmp.setDato(dato);
            tmp.setSiguiente(tmp2);
            longitud++;
        } else {
            throw new IndiceFueraDeRango("Fallo funcion insertarEnIndice Indice fuera de rango");
        }
    }

    /**
     * Metodo que asigna un dato en el indice indicado
     *
     * @param dato dato a asignar
     * @param i indice
     * @throws IndiceFueraDeRango Advertencia de rangoe
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
     * Cambia la primera incidencia de dato con el nuevo dato si el boolean es
     * true cambiara todos los datos si es False solo la primera coincidencia
     *
     * @param dato Data a cambiar
     * @param nuevoDato Dato que remplaza al dato anterior
     * @param condicion True: todas las coincidencias False: solo la primera
     * coincidencia
     * @throws IndiceFueraDeRango Advertencia de rango
     */
    public void asignar(E dato, E nuevoDato, boolean condicion) throws IndiceFueraDeRango {
        if (condicion == false) {
            for (Nodo<E> tmp = cabeza; tmp != null; tmp = tmp.getSiguiente()) {
                if (tmp.getDato().equals(dato)) {
                    tmp.setDato(nuevoDato);
                    break;
                }
            }
        } else {
            for (Nodo<E> tmp = cabeza; tmp != null; tmp = tmp.getSiguiente()) {
                if (tmp.getDato().equals(dato)) {
                    tmp.setDato(nuevoDato);
                }
            }
        }
    }

    /**
     * Metodo que rellena el arreglo con numero aleatorios del 0 al 100
     *
     * @param nodos cantidad de datos a agregar
     */
    @SuppressWarnings("unchecked")
    public void rellenar(int nodos) {
        Random rd = new Random();
        for (int i = 0; i < nodos; i++) {
            agregarEnCola((E) (Integer) rd.nextInt(101));
        }
    }

    /**
     * Metodo que regresa una cadena con los datos de cada nodo
     *
     * @return Datos de los nodos
     * @throws IndiceFueraDeRango Advertencia de rango
     */
    public String imprimir() throws IndiceFueraDeRango {
        String cad = "";
        if (cabeza == null) {
        } else {
            for (Nodo<E> tmp = cabeza; tmp != null; tmp = tmp.getSiguiente()) {
                cad += "["+tmp.getDato() + "]"+" ";
            }
        }
        return cad;
    }

    /**
     * Metodo que imprime los elementos
     */
    public void imprimirElementos() {
        if (cabeza == null) {

        } else {
            for (Nodo<E> tmp = cabeza; tmp != null; tmp = tmp.getSiguiente()) {
                System.out.println(tmp.getDato());
            }
        }
    }

    /**
     * Metodo que imprime los elementos de determinado indice
     *
     * @param indice Indice a imprimir
     * @throws IndiceFueraDeRango Advertencia de rango
     */
    public void imprimirElementos(int indice) throws IndiceFueraDeRango {
        if (cabeza == null) {
        } else if (indice >= longitud) {
            throw new IndiceFueraDeRango("Fallo funcion imprimirElementos Indice fuera de rango");
        } else {
            int aux = 0;
            for (Nodo<E> tmp = cabeza; aux < indice; tmp = tmp.getSiguiente(), aux++) {
                System.out.println("Columna " + aux + " : " + (Object) tmp.getDato());
            }
        }
    }

}

package fes.aragon.inicio;

import fes.aragon.except.IndiceFueraDeRango;
import fes.aragon.problema2.utilerias.dinamicas.listadoble.ListaDoble;
import fes.aragon.problema2.utilerias.dinamicas.listasimple.ListaSimple;

/**
 * Clase que crea listas simplemente enlazadas que guardas listas doblemente
 * enlazadas las cuales guardan objetos de tipo object, se imprimen los datos
 * por indice, por columnas o en su totalidad
 * 
 * @author Equipo 9 Bueno Zaldivar Omar Alejandro y Sol Martinez Edith
 *
 */
public class Inicio {
	public static void main(String[] args) throws IndiceFueraDeRango {
		ListaSimple<ListaDoble<Object>> lista = new ListaSimple<>();
		System.out.println("----Rellenando datos----");
		lista.rellenar(5, 5);
		System.out.println("------Impresion todos los elementos-----------");
		lista.imprimirElementos();
		System.out.println("-----Impresion por indice------");
		lista.imprimirElementos(1);
		System.out.println("----------Impresion indice hasta columna-------------");
		lista.imprimirElementos(1, 4);
		System.out.println("---------Obtener fila y columna especifico-----------");
		System.out.println(lista.obtenerNodo(1, 2));
	}
}

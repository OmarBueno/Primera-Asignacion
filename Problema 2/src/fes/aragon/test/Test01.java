package fes.aragon.test;

import fes.aragon.problema2.except.IndiceFueraDeRango;
import fes.aragon.problema2.utilerias.dinamicas.listadoble.ListaDoble;
import fes.aragon.problema2.utilerias.dinamicas.listasimple.ListaSimple;

public class Test01 {

	public static void main(String[] args) throws IndiceFueraDeRango {
		ListaSimple<ListaDoble<Object>> lista = new ListaSimple<>();
		// Se puede mejorar preguntando el numero de listas y el numero de elementos de
		// cada una
		// Pedir el tipo de dato
		lista.rellenar(5, 5);
		System.out.println("------Impresion todos los elementos-----------");
		lista.imprimirElementos();
		System.out.println("-----Impresion por indice------");
		lista.imprimirElementos(1);
		System.out.println("----------Impresion indice hasta columna-------------");
		lista.imprimirElementos(1, 4);
		System.out.println("---------Obtener fila y columna especifico-----------");
		System.out.println(lista.obtenerNodo(1, 2));
		System.out.println("----------Eliminando en fila y columna especifica-------------");
		lista.eliminarEnIndice(1, 2);
		lista.imprimirElementos(1);
		System.out.println("----------Insertando en indice y columna indicados----------------------");
		lista.insertarEnIndice("hola", 0,3);
		lista.imprimirElementos(0);
		System.out.println("--------Asignando en indice y columna indicado---------------");
		lista.asignar("Adios", 0,4);
		lista.imprimirElementos(0);
		System.out.println("---------Cambiando los datos de la lista-----------");
		lista.asignar(10, 0,true);
		lista.imprimirElementos();
	}

}

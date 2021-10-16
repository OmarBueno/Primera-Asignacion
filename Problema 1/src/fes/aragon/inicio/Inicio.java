package fes.aragon.inicio;

import fes.aragon.except.IndiceFueraDeRango;
import fes.aragon.problema1.utilerias.estaticas.ArreglosBidimencionales;

/**
 * Clase de inicio del problema 1, se rellenan los datos de un arreglo
 * bidimensional y se implementan los metodos para sumar las columnas, las filas
 * e imprimir sus datos
 * 
 * @author Equipo 9 Bueno Zaldivar Omar Alejandro y Sol Martinez Edith
 *
 */
public class Inicio {

	public static void main(String[] args) throws IndiceFueraDeRango {
		ArreglosBidimencionales<Object> arr = new ArreglosBidimencionales<>(20, 20);
		System.out.println("-----Rellenando los datos-------");
		arr.llenarDatos();
		System.out.println("----Imprimiendo Fila-----");
		arr.imprimirFila(0);
		System.out.println("----Imprimiendo Columna-----");
		arr.imprimirColumna(2);
		System.out.println("-----Imprimiendo todos los datos-------");
		arr.imprimir();
		System.out.println("----Sumando filas-----");
		arr.sumarFila(2, 1, 4);
		System.out.println("-----Sumando Columnas-----");
		arr.sumarColumnas(0, 2, 4);
	}

}

package fes.aragon.inicio;

import java.io.File;

import fes.aragon.except.IndiceFueraDeRango;
import fes.aragon.problema3.utilerias.dinamicas.listadoble.ListaDoble;
import fes.aragon.problema3.utilerias.dinamicas.listasimple.ListaSimple;

/**
 * Clase que lee un archivo y lo separa palabra por palabra, insertando cada una
 * de ellas en listas dobles contenidas en listas simples Se imprimen los datos
 * y se escribe lo guardado en otro archivp
 * 
 * @author Equipo 9 Bueno Zaldivar Omar Alejandro y Sol Martinez Edith
 *
 */
public class Inicio {
	public static void main(String[] args) throws IndiceFueraDeRango {
		System.out.println("-----Iniciando archivos-------");
		File ruta = new File(System.getProperty("user.dir") + "/Textos/Informacion");
		File rutaDos = new File(System.getProperty("user.dir") + "/Textos/Informacion Modificada");
		System.out.println("Archivo a leer: " + ruta.getAbsolutePath());
		ListaSimple<ListaDoble<Object>> lista = new ListaSimple<>();
		System.out.println("----llenando listas con palabras--------");
		lista.llenarArchivo(ruta);
		System.out.println("-----Impresion de las palabras--------");
		lista.imprimirElementos();
		System.out.println("-----Escribiendo en archivo--------");
		lista.EscribirEnArchivo(ruta, rutaDos);

	}
}

package fes.aragon.test;

import java.io.File;

import fes.aragon.except.IndiceFueraDeRango;
import fes.aragon.utilerias.dinamicas.listadoble.ListaDoble;
import fes.aragon.utilerias.dinamicas.listasimple.ListaSimple;

public class Test03 {

	public static void main(String[] args) throws IndiceFueraDeRango {
		File ruta = new File(System.getProperty("user.dir") + "/Textos/Informacion");
		File rutaDos = new File(System.getProperty("user.dir") + "/Textos/Informacion Modificada");
		ListaSimple<ListaDoble<Object>> lista = new ListaSimple<>();
		lista.llenarArchivo(ruta);
		lista.imprimirElementos();
		//Sobreescirobir el archiv?????
		lista.EscribirEnArchivo(ruta, rutaDos);

	}

}

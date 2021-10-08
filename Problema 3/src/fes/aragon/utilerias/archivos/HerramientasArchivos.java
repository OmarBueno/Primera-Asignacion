package fes.aragon.utilerias.archivos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import fes.aragon.except.IndiceFueraDeRango;
import fes.aragon.utilerias.dinamicas.listasimple.ListaSimple;

public class HerramientasArchivos {
	public static ListaSimple<Object> guardarEnListas(File archivo) {
		File ruta = archivo;
		FileReader fr = null;
		BufferedReader buff = null;
		ListaSimple<Object> cadenas = new ListaSimple<>();
		try {
			fr = new FileReader(ruta);
			buff = new BufferedReader(fr);
			String cad;
			while ((cad = buff.readLine()) != null) {
				cadenas.agregarEnCola(cad);
			}
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
				fr.close();
				buff.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return cadenas;
	}

	public static void EscribirArchivo(ListaSimple<Object> lista, File archivo) throws IndiceFueraDeRango {
		File ruta = archivo;
		FileWriter fw = null;
		PrintWriter pw = null;
		try {
			fw = new FileWriter(ruta);
			pw = new PrintWriter(fw);
			for (int i = 0; i < lista.getLongitud(); i++) {
				for (int j = 0; j < lista.getLongitud(i); j++) {
					pw.write((String) (lista.obtenerNodo(i,j)));
					pw.write(" ");
				}
				pw.write("\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fw.close();
				pw.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}

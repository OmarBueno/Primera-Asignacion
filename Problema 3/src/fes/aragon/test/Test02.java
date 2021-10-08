package fes.aragon.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import fes.aragon.except.IndiceFueraDeRango;
import fes.aragon.utilerias.dinamicas.listasimple.ListaSimple;

public class Test02 {

	public static void main(String[] args) {
		File ruta = new File(System.getProperty("user.dir") + "/Textos/Informacion");
		FileReader fr = null;
		BufferedReader buff = null;
		ListaSimple<String> cadenas = new ListaSimple<>();
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
	}

}

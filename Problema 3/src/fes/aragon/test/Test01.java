package fes.aragon.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import fes.aragon.except.IndiceFueraDeRango;
import fes.aragon.problema3.utilerias.dinamicas.listadoble.ListaDoble;
import fes.aragon.problema3.utilerias.dinamicas.listasimple.ListaSimple;

public class Test01 {

	public static void main(String[] args) {

		File ruta = new File(System.getProperty("user.dir") + "/Textos/Informacion");
		File rutaDos = new File(System.getProperty("user.dir") + "/Textos/Informacion Modificada");
		FileReader fr = null;
		FileWriter fw = null;
		BufferedReader buff = null;
		PrintWriter pw = null;
		ListaSimple<ListaDoble<String>> listaUno = new ListaSimple<>();
		try {
			fr = new FileReader(ruta);
			fw = new FileWriter(rutaDos);
			buff = new BufferedReader(fr);
			pw = new PrintWriter(fw);
			String cad;
			String cadA[] = null;
			String datos[] = null;
			int aux = 0;
			int numLineas = 0;
			while ((cad = buff.readLine()) != null) {
				numLineas++;
				ListaDoble<String> listaAux = new ListaDoble<>();
				listaUno.agregarEnCola(listaAux);
				datos = cad.split(" ");
				for (int i = 0; i < datos.length; i++) {
					listaUno.obtenerNodo(aux).agregarEnCola(datos[i]);
				}
				aux++;
			}
			if (listaUno.obtenerCola().esVacia()) {
				listaUno.eliminarEnCola();
			}
			listaUno.imprimirElementos();

			for (int i = 0; i < 20; i++) {
				Random rd = new Random();
				int numero = rd.nextInt(listaUno.getLongitud());
				System.out.println("Se elimino la palabra: " + listaUno.obtenerNodo(numero));
				listaUno.eliminarEnIndice(numero);
			}
			for (int i = 0; i < listaUno.getLongitud(); i++) {
				pw.write(listaUno.obtenerNodo(i) + " ");
			}

		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (IndiceFueraDeRango e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fr.close();
				fw.close();
				pw.close();
				buff.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}

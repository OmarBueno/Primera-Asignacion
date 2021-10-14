package fes.aragon.test;

import fes.aragon.problema1.except.IndiceFueraDeRango;
import fes.aragon.problema1.utilerias.estaticas.ArreglosBi;

public class Test02 {

	public static void main(String[] args) throws IndiceFueraDeRango {
		ArreglosBi<Object> arr = new ArreglosBi<>(5, 5);
		arr.llenarDatos();
		arr.imprimir();
		//arr.datosColumna(1).imprimir();
		System.out.println("---------");
		//arr.datosFila(4).imprimir();
		//System.out.println("--------");
		//System.out.println(arr.sumarFila(0,1,2,3));
		arr.sumarFila(2,1,4);
		arr.sumarColumnas(0,2,4);
	}

}

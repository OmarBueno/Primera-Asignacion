package fes.aragon.test;

import fes.aragon.except.IndiceFueraDeRango;
import fes.aragon.utilerias.estaticas.ArreglosBi;

public class Test01 {

	public static void main(String[] args) throws IndiceFueraDeRango {
		ArreglosBi<Integer> arr = new ArreglosBi<>(5, 5);
		arr.llenar();
		arr.imprimir();
		arr.suprimir(2, 2);
		System.out.println("Elemento recuperado: " + arr.recuperar(2, 2));
		System.out.println("Elemento siguiente: "+arr.siguiente(2, 2));
		arr.imprimirFila(4);
		arr.imprimirColumna(3);
		arr.limpiar();
		arr.imprimir(); 

	}

}

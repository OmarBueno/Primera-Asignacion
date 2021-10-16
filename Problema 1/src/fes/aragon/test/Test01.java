package fes.aragon.test;

import fes.aragon.except.IndiceFueraDeRango;
import fes.aragon.problema1.utilerias.estaticas.ArreglosBidimencionales;

public class Test01 {

	public static void main(String[] args) throws IndiceFueraDeRango {
		ArreglosBidimencionales<Integer> arr = new ArreglosBidimencionales<>(5, 5);
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

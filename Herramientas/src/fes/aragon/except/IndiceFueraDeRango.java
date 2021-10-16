package fes.aragon.except;
/**
 * Clase que detecta si el limite de indice fue excedido, si es asi lanza una 
 * adevertencia al usuario
 * 
 * @author Equipo 9 Bueno Zaldivar Omar Alejandro y Sol Martinez Edith
 *
 */
public class IndiceFueraDeRango extends Exception {
	private static final long serialVersionUID = 1L;

	public IndiceFueraDeRango(String msg) {
		super(msg);
	}
}

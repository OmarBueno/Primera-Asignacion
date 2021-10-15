package fes.aragon.problema1.modelo;

public class Datos {
	private String cadena;
	private Integer numero;

	public Datos(String cadena, Integer numero) {
		this.cadena=cadena;
		this.numero=numero;
	}

	public String getCadena() {
		return cadena;
	}

	public void setCadena(String cadena) {
		this.cadena = cadena;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	@Override
	public String toString() {
		return "Nombre= " + cadena + ", numero= " + numero;
	}
	
}

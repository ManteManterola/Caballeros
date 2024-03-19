package modelo;

public class Escudero {

	private Caballero caballero;
	private String nombre;
	private int nivel;

	public Caballero getCaballero() {
		return caballero;
	}

	public void setCaballero(Caballero caballero) {
		this.caballero = caballero;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	@Override
	public String toString() {
		return "Escudero [caballero=" + caballero + ", nombre=" + nombre + ", nivel=" + nivel + "]";
	}

}

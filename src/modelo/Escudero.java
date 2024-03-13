package modelo;

public class Escudero {

	private int id;
	private String nombre;
	private int nivel;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
		return "Escudero [id=" + id + ", nombre=" + nombre + ", nivel=" + nivel + "]";
	}

}

package modelo;

public class Caballero {

	private int id;
	private String nombre;
	private int fuerza;
	private int nivel;
	private Escudero escudero;
	private Caballo caballo;
	private Arma arma;
	private Escudo escudo;

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

	public int getFuerza() {
		return fuerza;
	}

	public void setFuerza(int fuerza) {
		this.fuerza = fuerza;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public Escudero getEscudero() {
		return escudero;
	}

	public void setEscudero(Escudero escudero) {
		this.escudero = escudero;
	}

	public Caballo getCaballo() {
		return caballo;
	}

	public void setCaballo(Caballo caballo) {
		this.caballo = caballo;
	}

	public Arma getArma() {
		return arma;
	}

	public void setArma(Arma arma) {
		this.arma = arma;
	}

	public Escudo getEscudo() {
		return escudo;
	}

	public void setEscudo(Escudo escudo) {
		this.escudo = escudo;
	}

	@Override
	public String toString() {
		return "Caballero [id=" + id + ", nombre=" + nombre + ", fuerza=" + fuerza + ", nivel=" + nivel + ", escudero="
				+ escudero + ", caballo=" + caballo + ", arma=" + arma + ", escudo=" + escudo + "]";
	}



}

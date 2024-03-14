package modelo;

import java.sql.*;

public class Arma extends Conector {

	private int id;
	private int daño;
	private String tipo;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDaño() {
		return daño;
	}

	public void setDaño(int daño) {
		this.daño = daño;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return id + " Daño:" + daño + " Tipo:" + tipo;
	}
	public void insertarArma() {
		String sql = "INSERT INTO arma (daño,tipo) VALUES (?,?)";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, this.daño);
			pst.setString(2, this.tipo);
			
			pst.execute();
			
		} catch (SQLException e) {
			System.out.println("Error insertarArma");
			e.printStackTrace();
		}
		
	}

}

package modelo;

import java.sql.*;
import java.util.*;

/**
 * Conexion a la base de datos para la clase Arma
 */
public class ArmaModelo extends Conector  {

	/**
	 * Inserta el arma en la BD
	 * @param a Arma a insertar
	 */
	public void insertarArma(Arma a) {
		String sql = "INSERT INTO arma (daño,tipo) VALUES (?,?)";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, a.getDaño());
			pst.setString(2, a.getTipo());
			
			pst.execute();
			
		} catch (SQLException e) {
			System.out.println("Error insertarArma");
			e.printStackTrace();
		}
		
	}
	
	
	/**
	 * @return ArrayList de todas las armas de la tabla Arma
	 */
	public ArrayList<Arma> getArmas() {
		String sql ="SELECT * FROM arma";
		ArrayList<Arma> armas = new ArrayList<>();

		try {
			ResultSet rs = con.createStatement().executeQuery(sql);
			while (rs.next()) {
				Arma a = new Arma();
				
				rellenarArma(a, rs);
				
				armas.add(a);
			}
		} catch (SQLException e) {
			System.out.println("Error VisualizarArma");
			e.printStackTrace();
		}
		return armas;
	}
	/**
	 * Busca un arma por su tipo
	 * @param tipo Tipo del arma
	 * @return Arma de la BD con el mismo tipo que el insertado por el user
	 */
	public Arma getArma(String tipo) {
		String sql ="SELECT * FROM arma WHERE tipo=?";
		Arma a = new Arma();

		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, tipo);
			
			ResultSet rs = pst.executeQuery();
			rs.next();
			
			rellenarArma(a, rs);
			
		} catch (SQLException e) {
			System.out.println("Error VisualizarArma");
			e.printStackTrace();
		}
		return a;
	}
	
	private void rellenarArma(Arma a, ResultSet rs) throws SQLException {
		a.setId(rs.getInt("id"));
		a.setDaño(rs.getInt("daño"));
		a.setTipo(rs.getString("tipo"));
	}
	
	/**
	 * Modifica un arma en la BD
	 * @param a los nuevos datos del arma
	 * @param id el ID del arma a modificar
	 */
	public void modificarArma(Arma a,int id) {
		String sql = "UPDATE arma SET daño=?, tipo=? WHERE id=?";
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			
			pst.setInt(1, a.getDaño());
			pst.setString(2, a.getTipo());
			pst.setInt(3, id);
			
			pst.execute();
			
		} catch (SQLException e) {
			System.out.println("Error modificarArma");
			e.printStackTrace();
			
		}
	}
	/**
	 * Borra un arma especifica de la BD
	 * @param a datos del Arma a borrar
	 */
	public void borrarArma(Arma a) {
		String sql = "DELETE FROM arma WHERE id=?";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, a.getId());
			
			pst.execute();
		} catch (SQLException e) {
			System.out.println("Error borrarArma");
			e.printStackTrace();
		}
	}
}

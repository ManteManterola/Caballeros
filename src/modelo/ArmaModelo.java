package modelo;

import java.sql.*;
import java.util.*;

public class ArmaModelo extends Conector  {

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
	public ArrayList<Arma> getArmas() {
		String sql ="SELECT * FROM arma";
		ArrayList<Arma> armas = new ArrayList<>();
		try {
			ResultSet rs = con.createStatement().executeQuery(sql);
			while (rs.next()) {
				Arma a = new Arma();
				
				a.setId(rs.getInt("id"));
				a.setDaño(rs.getInt("daño"));
				a.setTipo(rs.getString("tipo"));
				
				armas.add(a);
			}
		} catch (SQLException e) {
			System.out.println("Error VisualizarArma");
			e.printStackTrace();
		}
		return armas;
	}
	public void modificarArma(Arma a,int id) {
		String sql = "UPDATE armas SET daño=?, tipo=? WHERE id=?";
		
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

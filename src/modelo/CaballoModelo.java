package modelo;

import java.sql.*;
import java.util.ArrayList;

public class CaballoModelo extends Conector {
	private static CaballeroModelo cm = new CaballeroModelo();
	
	public ArrayList<Caballo> getCaballos(){
		
		ArrayList<Caballo> caballos = new ArrayList<>();
		String sql = "SELECT * FROM caballo";
		cm.Conectar();
		
		try {
			ResultSet rs = con.createStatement().executeQuery(sql);
			
			while(rs.next()) {
				Caballo c = new Caballo();
				c.setCaballero(cm.getCaballero(rs.getInt("id_caballero")));
				c.setNombre(rs.getString("nombre"));
				c.setResistencia(rs.getInt("resistencia"));
				c.setVelocidadMaxima(rs.getInt("velocidad_maxima"));
				
				caballos.add(c);
			}
		} catch (SQLException e) {
			System.out.println("Error getCaballos()");
			e.printStackTrace();
		}
		cm.cerrar();
		return caballos;
	}
	
	public void insertarCaballo(Caballo c) {
		String sql = "INSERT INTO caballo (nombre,velocidad_maxima,resistencia,id_caballero) VALUES (?,?,?,?)";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, c.getNombre());
			pst.setInt(2, c.getVelocidadMaxima());
			pst.setInt(3,c.getResistencia());
			pst.setInt(4, c.getCaballero().getId());
			
			pst.execute();
		} catch (SQLException e) {
			System.out.println("Error insertarCaballos()");
			e.printStackTrace();
		}
	}
	
	public void modificarCaballo(Caballo c,int id) {
		String sql = "UPDATE caballo SET nombre=?,velocidad_maxima=?,resistencia=? WHERE id_caballero=?";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, c.getNombre());
			pst.setInt(2, c.getVelocidadMaxima());
			pst.setInt(3,c.getResistencia());
			pst.setInt(4, id);
			
			pst.execute();
		} catch (SQLException e) {
			System.out.println("Error modificarCaballos()");
			e.printStackTrace();
		}
	}
	
	public void borrarCaballo(int id) {
		String sql = "DELETE FROM caballo WHERE id_caballero=?";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			
			pst.execute();
		} catch (SQLException e) {
			System.out.println("Error borrarCaballos()");
			e.printStackTrace();
		}
	}
}

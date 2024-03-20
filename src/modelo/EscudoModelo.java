package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EscudoModelo extends Conector{
	
	public void insertarEscudo(Escudo es) {
		String sql = "INSERT INTO escudo (defensa,tipo) VALUES (?,?)";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, es.getDefensa());
			pst.setString(2, es.getTipo());
			
			pst.execute();
			
		} catch (SQLException e) {
			System.out.println("Error insertarEscudo");
			e.printStackTrace();
		}
		
	}
	
	
	/**
	 * @return ArrayList de todas las armas de la tabla Arma
	 */
	public ArrayList<Escudo> getEscudos() {
		String sql ="SELECT * FROM escudo";
		ArrayList<Escudo> escudos = new ArrayList<>();

		try {
			Conectar();
			ResultSet rs = con.createStatement().executeQuery(sql);
			while (rs.next()) {
				Escudo es= new Escudo();
				
				rellenarEscudo(es, rs);
				
				escudos.add(es);
			}
			cerrar();
		} catch (SQLException e) {
			System.out.println("Error getEscudos");
			e.printStackTrace();
		}
		return escudos;
	}
	/**
	 * Busca un arma por su tipo
	 * @param tipo Tipo del arma
	 * @return Arma de la BD con el mismo tipo que el insertado por el user
	 */
	public Escudo getEscudo(String tipo) {
		String sql ="SELECT * FROM escudo WHERE tipo=?";
		Escudo es = new Escudo();

		try {
			Conectar();
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, tipo);
			
			ResultSet rs = pst.executeQuery();
			rs.next();
			
			rellenarEscudo(es, rs);
			cerrar();
		} catch (SQLException e) {
			System.out.println("Error getEscudo");
			e.printStackTrace();
		}
		return es;
	}
	
	private void rellenarEscudo(Escudo es, ResultSet rs) throws SQLException {
		es.setId(rs.getInt("id"));
		es.setDefensa(rs.getInt("defensa"));
		es.setTipo(rs.getString("tipo"));
	}
	
	/**
	 * Modifica un arma en la BD
	 * @param a los nuevos datos del arma
	 * @param id el ID del arma a modificar
	 */
	public void modificarEscudo(Escudo es,int id) {
		String sql = "UPDATE escudo SET defensa=?, tipo=? WHERE id=?";
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			
			pst.setInt(1, es.getDefensa());
			pst.setString(2, es.getTipo());
			pst.setInt(3, id);
			
			pst.execute();
			
		} catch (SQLException e) {
			System.out.println("Error modificarEscudo");
			e.printStackTrace();
			
		}
	}
	/**
	 * Borra un arma especifica de la BD
	 * @param a datos del Arma a borrar
	 */
	public void borrarEscudo(Escudo es) {
		String sql = "DELETE FROM escudo WHERE id=?";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, es.getId());
			
			pst.execute();
		} catch (SQLException e) {
			System.out.println("Error borrarEscudo");
			e.printStackTrace();
		}
	}


	public Escudo getEscudoConId(int id) {
		String sentenciaSelect ="SELECT * FROM escudo WHERE id=?";
		Escudo escudo = new Escudo();

		try {
			PreparedStatement pst = con.prepareStatement(sentenciaSelect);
			pst.setInt(1, id);
			
			ResultSet rs = pst.executeQuery();
			rs.next();
			
			rellenarEscudo(escudo, rs);
			
		} catch (SQLException e) {
			System.out.println("Error getEscudoConId");
			e.printStackTrace();
		}
		return escudo;
	}
}

package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CaballeroModelo extends Conector{
	
	ArmaModelo armaModelo = new ArmaModelo();
	EscudoModelo escudoModelo = new EscudoModelo();
	//Metodo para visualizar todos los caballeros, devuelve ArrayList caballeros
	public ArrayList<Caballero> getCaballeros() {
		
		String sentenciaSelect = "SELECT * FROM caballero";
		ArrayList<Caballero> caballeros = new ArrayList<Caballero>();
		
		try {
			armaModelo.Conectar();
			escudoModelo.Conectar();
			ResultSet rs = getCon().createStatement().executeQuery(sentenciaSelect);
			
			while (rs.next()) {
				Caballero caballero = new Caballero();
				caballero.setId(rs.getInt("id"));
				caballero.setNombre(rs.getString("nombre"));
				caballero.setFuerza(rs.getInt("fuerza"));
				caballero.setNivel(rs.getInt("nivel"));
				caballero.setArma(armaModelo.getArmaConId(rs.getInt("id_arma")));
				caballero.setEscudo(escudoModelo.getEscudoConId(rs.getInt("id_escudo")));
				
				caballeros.add(caballero);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return caballeros;
		
	}
	
	//Metodo para insertar un caballero, el caballero viene de Formulario.pedirDatosCaballero
	public void insertarCaballero(Caballero caballero) {
		String sentenciaInsert = "INSERT INTO caballero (nombre, fuerza, nivel, id_arma, id_escudo) VALUES (?, ?, ?, ?, ?)";
		
		try {
			armaModelo.Conectar();
			escudoModelo.Conectar();
			PreparedStatement pst = con.prepareStatement(sentenciaInsert);
			
			pst.setString(1, caballero.getNombre());
			pst.setInt(2, caballero.getFuerza());
			pst.setInt(3, caballero.getNivel());
			pst.setInt(4, caballero.getArma().getId());
			pst.setInt(5, caballero.getEscudo().getId());
			
			pst.execute();
		} catch (SQLException e) {
			System.out.println("Error insertarCaballero");
			e.printStackTrace();
		}
	}
	
	//Metodo que elimina un caballero de la base de datos la id viene de Formulario.pedirIdCaballero
	public void borrarCaballero(int id) {
		String sentenciaDelete = "DELETE FROM caballero WHERE id = ?";
		
		try {
			PreparedStatement pst = con.prepareStatement(sentenciaDelete);
			pst.setInt(1, id);
			
			pst.execute();
		} catch (SQLException e) {
			System.out.println("Error borrarCaballero");
			e.printStackTrace();
		}
		
	}
	
	//Metodo que modifica un caballero la id viene de Formulario.pedirId y el caballero de Formulario.pedirDatosCaballero
	public void modificarCaballero(Caballero caballero, int id) {
		String sentenciaUpdate = "UPDATE caballero SET nombre=?, fuerza=?, nivel=?, id_arma=?, id_escudo=? WHERE id=?";
		
		try {
			armaModelo.Conectar();
			escudoModelo.Conectar();
			PreparedStatement pst = con.prepareStatement(sentenciaUpdate);
			
			pst.setString(1, caballero.getNombre());
			pst.setInt(2, caballero.getFuerza());
			pst.setInt(3, caballero.getNivel());
			pst.setInt(4, caballero.getArma().getId());
			pst.setInt(5, caballero.getEscudo().getId());
			pst.setInt(6, id);
			
			pst.execute();
			
		} catch (SQLException e) {
			System.out.println("Error modificarCaballero");
			e.printStackTrace();
		}
	}
}

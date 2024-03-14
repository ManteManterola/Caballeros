package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CaballeroModelo extends Conector{

	public ArrayList<Caballero> getCaballeros() {
		ArmaModelo armaModelo = new ArmaModelo();
		String sentenciaSelect = "SELECT * FROM caballero";
		ArrayList<Caballero> caballeros = new ArrayList<Caballero>();
		
		try {
			armaModelo.Conectar();
			ResultSet rs = getCon().createStatement().executeQuery(sentenciaSelect);
			
			while (rs.next()) {
				Caballero caballero = new Caballero();
				caballero.setId(rs.getInt("id"));
				caballero.setNombre(rs.getString("nombre"));
				caballero.setFuerza(rs.getInt("fuerza"));
				caballero.setNivel(rs.getInt("nivel"));
				caballero.setArma(armaModelo.getArmaConId(rs.getInt("id_arma")));
				
				
				
				caballeros.add(caballero);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return caballeros;
		
	}
}

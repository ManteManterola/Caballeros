package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LuchaModelo extends Conector{

	private static CaballeroModelo caballeroModelo = new CaballeroModelo();
	public ArrayList<Lucha> getLuchas() {
		String sentenciaSelect = "SELECT * FROM lucha";
		ArrayList<Lucha> luchas = new ArrayList<Lucha>();
		
		try {
			ResultSet resultado = getCon().createStatement().executeQuery(sentenciaSelect);
			
			while (resultado.next()) {
				Lucha lucha = new Lucha();
				lucha.setId(resultado.getInt("id"));
				lucha.setFecha(resultado.getDate("fecha"));
				lucha.setLugar(resultado.getString("lugar"));
				lucha.setCaballero1(caballeroModelo.getCaballero(resultado.getInt("caballero1")));
				lucha.setCaballero2(caballeroModelo.getCaballero(resultado.getInt("caballero2")));
				lucha.setGanador(caballeroModelo.getCaballero(resultado.getInt("ganador")));
				
				luchas.add(lucha);
				
			}
		} catch (SQLException e) {
			System.out.println("Error en getLuchas");
			e.printStackTrace();
		}
		return luchas;
		
	}
}

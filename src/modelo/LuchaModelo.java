package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LuchaModelo extends Conector{

	private static CaballeroModelo caballeroModelo = new CaballeroModelo();
	
	
	public ArrayList<Lucha> getLuchas() {
		String sentenciaSelect = "SELECT * FROM lucha";
		ArrayList<Lucha> luchas = new ArrayList<Lucha>();
		
		try {
			Conectar();
			caballeroModelo.Conectar();
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
	
	public void insertarlucha(Lucha l) {
        String sql = "INSERT INTO lucha (caballero1,caballero2,fecha,ganador) VALUES (?,?,?,?)";
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            
            pst.setInt(1, l.getCaballero1().getId());
            pst.setInt(2, l.getCaballero2().getId());
            pst.setDate(3, new java.sql.Date(new java.util.Date().getTime()));
            pst.setInt(4, l.getGanador().getId());
            
            pst.execute();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

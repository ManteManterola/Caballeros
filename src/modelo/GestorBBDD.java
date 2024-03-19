package modelo;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GestorBBDD extends Conector{

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

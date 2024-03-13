package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conector {

		protected Connection con;
		
		private String host = "localhost";
		private String bbdd = "caballeros_mesa_cuadrada";
		private String usuario = "root";
		private String contrasenia = "";
		
		public void Conectar() {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				this.con = DriverManager.getConnection("jdbc:mysql://" + host + "/" + bbdd, usuario, contrasenia);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		public void cerrar() {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}

		public  Connection getCon() {
			return con;
		}

		public void setCon(Connection con) {
			this.con = con;
		}
		
}

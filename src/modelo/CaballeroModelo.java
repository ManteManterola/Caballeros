package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;


public class CaballeroModelo extends Conector{
	
	private ArmaModelo armaModelo = new ArmaModelo();
	private EscudoModelo escudoModelo = new EscudoModelo();
	private EscuderoModelo em = new EscuderoModelo();
	
	//Metodo para visualizar todos los caballeros, devuelve ArrayList caballeros
	public ArrayList<Caballero> getCaballeros() {
		
		String sentenciaSelect = "SELECT * FROM CABALLERO LEFT JOIN ESCUDERO ON CABALLERO.ID=ESCUDERO.ID_CABALLERO;";

public class CaballeroModelo extends Conector {

	ArmaModelo armaModelo = new ArmaModelo();
	EscudoModelo escudoModelo = new EscudoModelo();
	EscuderoModelo escuderoModelo = new EscuderoModelo();

	// Metodo para visualizar todos los caballeros, devuelve ArrayList caballeros
	public ArrayList<Caballero> getCaballeros() {

		String sentenciaSelect = "SELECT * FROM caballero";

		ArrayList<Caballero> caballeros = new ArrayList<Caballero>();

		try {
			Conectar();
			armaModelo.Conectar();
			escudoModelo.Conectar();
			ResultSet resultado = getCon().createStatement().executeQuery(sentenciaSelect);

			while (resultado.next()) {
				Caballero caballero = new Caballero();
				rellenarCaballero(caballero, resultado);

				caballeros.add(caballero);

			}
			armaModelo.cerrar();
			escudoModelo.cerrar();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return caballeros;

	}

	public Caballero getCaballero(String nombre) {

		
		String sentenciaSelect = "SELECT * FROM CABALLERO LEFT JOIN ESCUDERO ON CABALLERO.ID=ESCUDERO.ID_CABALLERO WHERE caballero.nombre =?";

		Caballero caballero = new Caballero();

		try {

			armaModelo.Conectar();
			escudoModelo.Conectar();
			

			PreparedStatement pst = con.prepareStatement(sentenciaSelect);
			pst.setString(1, nombre);
			ResultSet rs = pst.executeQuery();

			rs.next();

			rellenarCaballero(caballero, rs);


			armaModelo.cerrar();
			escudoModelo.cerrar();


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return caballero;
	}

public Caballero getCaballero(int id) {
		
		String sentenciaSelect = "SELECT * FROM CABALLERO LEFT JOIN ESCUDERO ON CABALLERO.ID=ESCUDERO.ID_CABALLERO WHERE ID =?";

		Caballero caballero = new Caballero();

		try {

			armaModelo.Conectar();
			escudoModelo.Conectar();

			PreparedStatement pst = con.prepareStatement(sentenciaSelect);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();

			rs.next();
				
			rellenarCaballero(caballero, rs);

			armaModelo.cerrar();
			escudoModelo.cerrar();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return caballero;
}
private void rellenarCaballero(Caballero caballero, ResultSet rs) throws SQLException {
	armaModelo.Conectar();
	escudoModelo.Conectar();
	em.Conectar();
	Escudero escudero = new Escudero();
	
	caballero.setId(rs.getInt("id"));
	caballero.setNombre(rs.getString("caballero.nombre"));
	caballero.setFuerza(rs.getInt("fuerza"));
	caballero.setNivel(rs.getInt("caballero.nivel"));
	caballero.setArma(armaModelo.getArmaConId(rs.getInt("id_arma")));
	caballero.setEscudo(escudoModelo.getEscudoConId(rs.getInt("id_escudo")));
	
	if(rs.getString("escudero.nombre") != null) {
		escudero.setCaballero(caballero);
		escudero.setNivel(rs.getInt("escudero.nivel"));
		escudero.setNombre(rs.getString("escudero.nombre"));
		caballero.setEscudero(escudero);
	}
	
	armaModelo.cerrar();
	escudoModelo.cerrar();
	em.cerrar();
}

	}


	// Metodo para insertar un caballero, el caballero viene de
	// Formulario.pedirDatosCaballero
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
			armaModelo.cerrar();
			escudoModelo.cerrar();
		} catch (SQLException e) {
			System.out.println("Error insertarCaballero");
			e.printStackTrace();
		}
	}

	// Metodo que elimina un caballero de la base de datos la id viene de
	// Formulario.pedirIdCaballero
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

	// Metodo que modifica un caballero la id viene de Formulario.pedirId y el
	// caballero de Formulario.pedirDatosCaballero
	public void modificarCaballero(Caballero caballero, int id) {
		String sentenciaUpdate = "UPDATE caballero SET nombre=?, fuerza=?, nivel=?, id_arma=?, id_escudo=? WHERE id=?";

		try {
			armaModelo.Conectar();
			escudoModelo.Conectar();
			Conectar();
			PreparedStatement pst = con.prepareStatement(sentenciaUpdate);

			pst.setString(1, caballero.getNombre());
			pst.setInt(2, caballero.getFuerza());
			pst.setInt(3, caballero.getNivel());
			pst.setInt(4, caballero.getArma().getId());
			pst.setInt(5, caballero.getEscudo().getId());
			pst.setInt(6, id);

			pst.execute();
			armaModelo.cerrar();
			escudoModelo.cerrar();
			cerrar();
		} catch (SQLException e) {
			System.out.println("Error modificarCaballero");
			e.printStackTrace();
		}
	}

	public ArrayList<Caballero> getCaballerosDisponibles() {
		ArrayList<Caballero> caballeros = new ArrayList<>();
		String sql = "SELECT * FROM caballo RIGHT JOIN caballero ON caballo.id_caballero = caballero.id WHERE id_caballero is NULL";
		armaModelo.Conectar();
		escudoModelo.Conectar();
		try {
			ResultSet resultado = con.createStatement().executeQuery(sql);

			while (resultado.next()) {
				Caballero caballero = new Caballero();

				rellenarCaballero(caballero, resultado);

				caballeros.add(caballero);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return caballeros;
	}
	public void evolucionarACaballero(Escudero escudero,Arma a, Escudo es) {
		String insert = "INSERT INTO caballero (nombre,fuerza,nivel,id_arma,id_escudo) VALUES (?,?,?,?,?)";
		String delete = "DELETE FROM escudero WHERE id_caballero=?";
		Random r = new Random();
		try {
			PreparedStatement insertpst = con.prepareStatement(insert);
			insertpst.setString(1, escudero.getNombre());
			insertpst.setInt(2, r.nextInt(10));
			insertpst.setInt(3, 1);
			insertpst.setInt(4, a.getId());
			insertpst.setInt(5, es.getId());
			
			insertpst.execute();
			
			PreparedStatement deletepst = con.prepareStatement(delete);
			deletepst.setInt(1, escudero.getCaballero().getId());
			deletepst.execute();

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

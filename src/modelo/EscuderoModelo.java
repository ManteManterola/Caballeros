package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class EscuderoModelo extends Conector {
	Scanner scan = new Scanner(System.in);
	private static CaballeroModelo caballeroModelo = new CaballeroModelo();

	// Llena una ArrayList escuderos con los datos de la base
	public ArrayList<Escudero> getEscuderos() {
		String sentenciaSelect = "SELECT * FROM escudero";
		ArrayList<Escudero> escuderos = new ArrayList<Escudero>();

		try {
			Conectar();
			caballeroModelo.Conectar();
			ResultSet resultado = getCon().createStatement().executeQuery(sentenciaSelect);

			while (resultado.next()) {
				Escudero escudero = new Escudero();

				escudero.setCaballero(caballeroModelo.getCaballero(resultado.getInt("id_caballero")));
				escudero.setNombre(resultado.getString("nombre"));
				escudero.setNivel(resultado.getInt("nivel"));

				escuderos.add(escudero);

			}
			caballeroModelo.cerrar();
		} catch (SQLException e) {
			System.out.println("Error en getEscuderos");
			e.printStackTrace();
		}
		return escuderos;

	}

	public void insertarEscudero(Escudero escudero) {
		String sentenciaInsert = "INSERT INTO escudero (id_caballero, nombre, nivel) VALUES(?, ?, ?)";

		try {
			Conectar();
			caballeroModelo.Conectar();
			PreparedStatement pst = con.prepareStatement(sentenciaInsert);

			pst.setInt(1, escudero.getCaballero().getId());
			pst.setString(2, escudero.getNombre());
			pst.setInt(3, escudero.getNivel());

			pst.execute();

		} catch (SQLException e) {
			System.out.println("Error en insertarCaballero");
			e.printStackTrace();
		}

	}

	// Elimina un escudero de la base de datos con la id que viene de
	// Formulario.pedirIdEscudero
	public void borrarEscudero(int id) {
		String sentenciaDelete = "DELETE FROM escudero WHERE id_caballero = ?";

		try {
			Conectar();
			PreparedStatement pst = con.prepareStatement(sentenciaDelete);
			pst.setInt(1, id);

			pst.execute();
		} catch (SQLException e) {
			System.out.println("Error en borrarEscudero");
			e.printStackTrace();
		}
	}

	public void modificarEscudero(Escudero escudero, int id) {
		String sentenciaUpdate = "UPDATE escudero SET nombre=?, nivel=? WHERE id_caballero=?";

		try {
			Conectar();
			PreparedStatement pst = con.prepareStatement(sentenciaUpdate);
			pst.setString(1, escudero.getNombre());
			pst.setInt(2, escudero.getNivel());
			pst.setInt(3, id);

			pst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void generarEscudero(Caballero ganador) {

		Random random = new Random();
    
		int numeroAleatorio = random.nextInt(5) + 1;
		if(ganador.getEscudero() == null && numeroAleatorio == 1) {

			System.out.println("Un nuevo escudero quiere unirse a " + ganador.getNombre() + "!!!");
			Escudero escudero = new Escudero();

			escudero.setCaballero(ganador);
			System.out.println("Introduce el nombre del nuevo escudero");
			escudero.setNombre(scan.nextLine());
			escudero.setNivel(1);

			String sentenciaInsert = "INSERT INTO escudero (id_caballero, nombre, nivel) VALUES(?, ?, ?)";

			try {
				Conectar();
				PreparedStatement pst = con.prepareStatement(sentenciaInsert);

				pst.setInt(1, ganador.getId());
				pst.setString(2, escudero.getNombre());
				pst.setInt(3, escudero.getNivel());

				pst.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public Escudero getEscudero(int id) {
		String sql = "SELECT * FROM escudero WHERE id_caballero=?";
		Escudero escudero = new Escudero();

		try {
			Conectar();
			caballeroModelo.Conectar();
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();

			if(rs.next()) {
			escudero.setCaballero(caballeroModelo.getCaballero(id));
			escudero.setNombre(rs.getString("nombre"));
			escudero.setNivel(rs.getInt("nivel"));
			}
			caballeroModelo.cerrar();
			cerrar();
			return escudero;
		} catch (SQLException e) {
			System.out.println("Error en getEscuderos");
			e.printStackTrace();
			return null;
		}

	}
}

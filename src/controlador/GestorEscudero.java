package controlador;

import java.util.Scanner;

import modelo.Escudero;
import modelo.EscuderoModelo;
import vista.Formulario;
import vista.Menu;
import vista.Visor;

public class GestorEscudero {

	private static Scanner scan = new Scanner(System.in);
	private static EscuderoModelo escuderoModelo = new EscuderoModelo();

	public static void run() {

		int opcion;
		do {
			Menu.mostrarMenuEscuderos();
			opcion = Integer.parseInt(scan.nextLine());

			switch (opcion) {
			case Menu.SALIR:
				break;

			case Menu.VISUALIZAR_ESCUDEROS: {
				Visor.mostrarArray(escuderoModelo.getEscuderos());
				break;
			}
			case Menu.INSERTAR_ESCUDEROS: {
				Escudero escudero = Formulario.pedirDatosEscudero();
				escuderoModelo.insertarEscudero(escudero);
				break;
			}
			case Menu.BORRAR_ESCUDEROS: {
				int id = Formulario.pedirIdEscudero();
				escuderoModelo.borrarEscudero(id);
				break;
			}
			case Menu.MODIFICAR_ESCUDEROS: {

				int id = Formulario.pedirIdEscudero();
				Escudero escudero = Formulario.pedirDatosEscuderoSinId();
				escuderoModelo.modificarEscudero(escudero, id);
				break;

			}
			default:
				System.out.println("Opcion no disponible");
				break;
			}
		} while (opcion != Menu.SALIR);

	}
}

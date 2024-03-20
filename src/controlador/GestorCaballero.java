package controlador;

import java.util.Scanner;

import modelo.Caballero;
import modelo.CaballeroModelo;
import vista.*;

public class GestorCaballero {
	private static Scanner scan = new Scanner(System.in);
	private static CaballeroModelo caballeroModelo = new CaballeroModelo();
	
	public static void run() {
	
		int opcion;
		do {
			Menu.mostrarMenuCaballeros();
			opcion = Integer.parseInt(scan.nextLine());
			
			switch (opcion) {
			
			case Menu.SALIR:
				break;
				
			case Menu.VISUALIZAR_CABALLEROS: {
				caballeroModelo.Conectar();
				
				Visor.mostrarArray(caballeroModelo.getCaballeros());
				caballeroModelo.cerrar();
				break;
			}
				
			case Menu.INSERTAR_CABALLEROS: {
				caballeroModelo.Conectar();
				
				Caballero caballero = Formulario.pedirDatosCaballero();
				caballeroModelo.insertarCaballero(caballero);
				
				caballeroModelo.cerrar();
				break;
			}
				
			case Menu.BORRAR_CABALLEROS: {
				caballeroModelo.Conectar();
				
				int id = Formulario.pedirIdCaballero();
				
				if(Formulario.confirmacionBorrarCaballero()) {
				caballeroModelo.borrarCaballero(id);
				}
				caballeroModelo.cerrar();
				break;
			}
				
			case Menu.MODIFICAR_CABALLEROS: {
				caballeroModelo.Conectar();
				
				Visor.mostrarArray(caballeroModelo.getCaballeros());
				int id = Formulario.pedirId();
				Caballero caballero = Formulario.pedirDatosCaballero();
				caballeroModelo.modificarCaballero(caballero, id);
				
				caballeroModelo.cerrar();
				break;
			}
				
				
				
			default:
				break;
			}
		} while (opcion != Menu.SALIR);
		
		
		
	}
}

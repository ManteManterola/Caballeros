package controlador;

import java.util.Scanner;

import modelo.CaballeroModelo;
import vista.*;

public class GestorCaballero {
	private static Scanner scan = new Scanner(System.in);
	private static CaballeroModelo cm = new CaballeroModelo();
	
	public static void run() {
	
		int opcion;
		do {
			Menu.mostrarMenuCaballeros();
			opcion = Integer.parseInt(scan.nextLine());
			
			switch (opcion) {
			
			case Menu.SALIR:
				break;
				
			case Menu.VISUALIZAR_CABALLEROS:
				cm.Conectar();
				Visor.mostrarArray(cm.getCaballeros());
				cm.cerrar();
				

			default:
				break;
			}
		} while (opcion != Menu.SALIR);
		
		
		
	}
}

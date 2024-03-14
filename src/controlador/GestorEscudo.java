package controlador;

import java.util.Scanner;

import vista.Menu;

public class GestorEscudo {
	private static Scanner scan = new Scanner(System.in);
	
	public static void run() {
			
			int select;
			do {
				Menu.mostrarMenuAdmin();
				select=Integer.parseInt(scan.nextLine());
				switch(select) {
				
				case Menu.VISUALIZAR_ESCUDOS:
					//visualizarEscudos()
					break;
					
				case Menu.INSERTAR_ESCUDOS:
					//INSERTAR_Escudos()
					break;
				case Menu.BORRAR_ESCUDOS:
					//BORRAR_Escudos()
					break;
				case Menu.MODIFICAR_ESCUDOS:
					//Menu.MODIFICAR_Escudos()
					break;
				case Menu.SALIR:
					
					break;
					
				default:
				}
			}while(select!=0);
		
	}
}

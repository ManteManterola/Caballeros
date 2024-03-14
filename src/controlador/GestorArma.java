package controlador;

import java.util.Scanner;

import modelo.*;
import vista.*;

public class GestorArma {
	
	private static Scanner scan = new Scanner(System.in);
	private static ArmaModelo am = new ArmaModelo();
	public static void run() {
		
		int select;
		do {
			Menu.mostrarMenuAdmin();
			select=Integer.parseInt(scan.nextLine());
			switch(select) {
			
			case Menu.VISUALIZAR_ARMAS:
				Visor.mostrarArray(am.getArmas());
				break;
				
			case Menu.INSERTAR_ARMAS:
				//INSERTAR_ARMAS()
				break;
			case Menu.BORRAR_ARMAS:
				//BORRAR_ARMAS()
				break;
			case Menu.MODIFICAR_ARMAS:
				//Menu.MODIFICAR_ARMA()
				break;
			case Menu.SALIR:
				
				break;
				
			default:
			}
		}while(select!=0);
	}
}

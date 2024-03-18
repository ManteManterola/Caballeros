package controlador;

import java.util.*;

import modelo.Conector;
import vista.Menu;

public class GestorCaballerosMesaCuadrada extends Conector{

	private static Scanner scan = new Scanner(System.in);
	
	public static void run() {
		
		int opcion;
		do {
			Menu.mostrarMenuPrincipal();
			opcion=Integer.parseInt(scan.nextLine());
			switch(opcion){
			
			case Menu.SALIR:
				break;
			
			case Menu.ADMIN://Admin
				gestorAdmin();
				break;
			
			case Menu.USUARIO://User
				gestorUser();
				break;
		
				
			default:
				System.out.println("Opcion no valida");
				break;
			}
		}while (opcion!=0);
	}

	private static void gestorAdmin() {
		int opcion;
		do {
			//Menu
			Menu.mostrarMenuAdmin();
			opcion=Integer.parseInt(scan.nextLine());
			switch(opcion) {
			
			case Menu.SALIR:
				break;
				
			case Menu.GESTIONAR_ARMAS:
				GestorArma.run();
				break;
				
			case Menu.GESTIONAR_CABALLEROS:
				GestorCaballero.run();
				break;
				
			case Menu.GESTIONAR_CABALLOS:
				GestorCaballo.run();
				break;
				
			case Menu.GESTIONAR_ESCUDEROS:
				GestorEscudero.run();
				break;
				
			case Menu.GESTIONAR_ESCUDOS:
				GestorEscudo.run();
				break;
				
			case Menu.GESTIONAR_LUCHAS_ADMIN:
				GestorLucha.run();
				break;
				
			default:
				System.out.println("Opcion no valida");
				break;
			}
		}while(opcion!=0);
	}
	private static void gestorUser() {
		int opcion;
		do {
			//Menu
			Menu.mostrarMenuUsuario();
			opcion=Integer.parseInt(scan.nextLine());
			switch(opcion) {
			
			case Menu.SALIR:
				break;
				
			case Menu.GESTIONAR_LUCHAS_USUARIO:
				GestorLucha.run();
				break;
				
			default:
				System.out.println("Opcion no valida");
				break;
			}
		}while(opcion!=0);
	}
}

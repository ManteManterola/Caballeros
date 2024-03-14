package controlador;

import java.util.*;

import modelo.Conector;

public class GestorCaballerosMesaCuadrada extends Conector{

	private static Scanner scan = new Scanner(System.in);
	
	public static void run() {
		
		int select;
		do {
//			System.out.println("--Menu--");
//			System.out.println("1-Admin");
//			System.out.println("2-User");
//			System.out.println("0-");
			select=Integer.parseInt(scan.nextLine());
			switch(select){
			
			case 1://Admin
				gestorAdmin();
				break;
			
			case 2://User
				gestorUser();
				break;
			case 0://Salir
				break;
				
			default:
				System.out.println("Opcion no valida");
				break;
			}
		}while (select!=0);
	}

	private static void gestorAdmin() {
		int select;
		do {
			//Menu
			select=Integer.parseInt(scan.nextLine());
			switch(select) {
			case 1://Caballero
				GestorCaballero.run();;
				break;
			case 2://Escudero
				GestorEscudero.run();
				break;
			case 3://Arma
				GestorArma.run();
				break;
			case 4://Escudo
				GestorEscudo.run();
				break;
			case 5://Lucha
				GestorLucha.run();
				break;
			case 0://salir
				break;
			default:
				break;
			}
		}while(select!=0);
	}
	private static void gestorUser() {
		int select;
		do {
			//Menu
			select=Integer.parseInt(scan.nextLine());
			switch(select) {
			case 1://Lucha
				GestorLucha.run();
				break;
			case 0://Salir
				break;
			default:
				break;
			}
		}while(select!=0);
	}
}

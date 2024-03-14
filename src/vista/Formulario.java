package vista;

import java.util.Scanner;

import modelo.*;

public class Formulario {
	private static Scanner scan = new Scanner(System.in);
	
	public static Arma pedirDatosArma() {
		Arma a = new Arma();
	
		a.setTipo(pedirNombre());
		
		System.out.println("Inserte el daño del arma");
		a.setDaño(Integer.parseInt(scan.nextLine()));
		
		return a;
	}
	public static String pedirNombre() {
		System.out.println("Inserte el tipo");
		return scan.nextLine();
	}
}


package vista;

import java.util.Scanner;

import modelo.*;

public class Formulario {
	private static Scanner scan = new Scanner(System.in);
	
	public static Arma pedirDatosArma() {
		Arma a = new Arma();
		
		System.out.println("Inserte el nombre del arma");
		a.setTipo(scan.nextLine());
		
		System.out.println("Inserte el daño del arma");
		a.setDaño(Integer.parseInt(scan.nextLine()));
		
		return a;
	}
}


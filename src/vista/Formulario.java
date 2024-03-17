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
		System.out.println("Inserte el nombre");
		return scan.nextLine();
	}
	
	public static Escudo pedirDatosEscudo() {
		Escudo es = new Escudo();
	
		es.setTipo(pedirNombre());
		
		System.out.println("Inserte la defensa del escudo");
		es.setDefensa(Integer.parseInt(scan.nextLine()));
		
		return es;
	}
	
	//Pide los datos de caballero y devuelve un caballero
	public static Caballero pedirDatosCaballero() {
		ArmaModelo armaModelo = new ArmaModelo();
		EscudoModelo escudoModelo = new EscudoModelo();
		Caballero caballero = new Caballero();
		
		armaModelo.Conectar();
		escudoModelo.Conectar();
		
		System.out.println("Inserta el nombre");
		caballero.setNombre(scan.nextLine());
		
		System.out.println("Inserta la fuerza");
		caballero.setFuerza(Integer.parseInt(scan.nextLine()));
		
		System.out.println("Inserta el nivel");
		caballero.setNivel(Integer.parseInt(scan.nextLine()));
		
		System.out.println("Inserta el id del arma");
		Visor.mostrarArray(armaModelo.getArmas());
		caballero.setArma(armaModelo.getArmaConId(Integer.parseInt(scan.nextLine())));
		
		System.out.println("Inserta el id del escudo");
		Visor.mostrarArray(escudoModelo.getEscudos());
		caballero.setEscudo(escudoModelo.getEscudoConId(Integer.parseInt(scan.nextLine())));
		
		
		return caballero;
		
	}
	
	public static int pedirIdCaballero() {
		int id;
		CaballeroModelo caballeroModelo = new CaballeroModelo();
		
		caballeroModelo.Conectar();
		Visor.mostrarArray(caballeroModelo.getCaballeros()); 
		System.out.println("Inserta el id del caballero");
		id = Integer.parseInt(scan.nextLine());
		
		return id;
	}
	
	public static int pedirId() {
		System.out.println("Que caballero deseas modificar? Introduce el id");
		int id = Integer.parseInt(scan.nextLine());
		return id;
	}
}


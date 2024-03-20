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

	// Pide los datos de caballero y devuelve un caballero
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

	
	//Metodo en el que se rellena un escudero por teclado y se devuelve el mismo
	public static Escudero pedirDatosEscudero() {
		CaballeroModelo caballeroModelo = new CaballeroModelo();
		Escudero escudero = new Escudero();
		
		System.out.println("Inserta la id de su caballero");
		Visor.mostrarArray(caballeroModelo.getCaballeros());
		escudero.setCaballero(caballeroModelo.getCaballero(Integer.parseInt(scan.nextLine())));
		
		System.out.println("Introduce el nombre del escudero");
		escudero.setNombre(scan.nextLine());
		
		System.out.println("Introduce el nivel del escudero");
		escudero.setNivel(Integer.parseInt(scan.nextLine()));
		
		return escudero;
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

	
	public static int pedirIdEscudero() {
		int id;
		EscuderoModelo escuderoModelo = new EscuderoModelo();
		
		escuderoModelo.Conectar();
		Visor.mostrarArray(escuderoModelo.getEscuderos()); 
		System.out.println("Inserta el id del caballero asignado al escudero");
		id = Integer.parseInt(scan.nextLine());
		
		return id;
	}

	public static int pedirId() {
		System.out.println("Que caballero deseas modificar? Introduce el id");
		int id = Integer.parseInt(scan.nextLine());
		return id;
	}

	
	public static Escudero pedirDatosEscuderoSinId() {
		Escudero escudero = new Escudero();
		
		System.out.println("Introduce el nombre del escudero");
		escudero.setNombre(scan.nextLine());
		
		System.out.println("Introduce el nivel del escudero");
		escudero.setNivel(Integer.parseInt(scan.nextLine()));
		
		return escudero;
	}



	public static Caballo pedirDatosCaballoInsert() {
		Caballo c = new Caballo();

		CaballeroModelo cm = new CaballeroModelo();
		cm.Conectar();

		pedirDatosCaballo(c);

		Visor.mostrarArray(cm.getCaballerosDisponibles());
		System.out.println("Seleccciona el nombre de un caballero");
		c.setCaballero(cm.getCaballero(scan.nextLine()));
		return c;
	}

	private static void pedirDatosCaballo(Caballo c) {
		System.out.println("Inserte el nombre del Caballo");
		c.setNombre(scan.nextLine());

		System.out.println("Inserte su resistencia");
		c.setResistencia(Integer.parseInt(scan.nextLine()));

		System.out.println("Inserte su velocidad maxima");
		c.setVelocidadMaxima(Integer.parseInt(scan.nextLine()));
	}

	public static Caballo pedirDatosCaballoMod() {
		Caballo c = new Caballo();

		CaballeroModelo cm = new CaballeroModelo();
		cm.Conectar();

		pedirDatosCaballo(c);
		return c;
	}
	public static Arma pedirDatosBuscaArma() {
		ArmaModelo am = new ArmaModelo();
		
		Visor.mostrarArray(am.getArmas());
		System.out.println("Seleccione un arma para equipar");
		Arma a = am.getArma(scan.nextLine());
		am.cerrar();
		return a;
	}

	public static Escudo pedirDatosBuscaEscudo() {
		EscudoModelo em = new EscudoModelo();
		
		Visor.mostrarArray(em.getEscudos());
		System.out.println("Seleccione un escudo para equipar");
		Escudo e = em.getEscudo(scan.nextLine());
		em.cerrar();
		return e;
	}
	public static boolean confirmacionBorrarCaballero() {
		System.out.println("¿Estas seguro de borrar caballero? Si se borra el caballero se borrara todos sus registros relacionados (S/N)");
		String resultado = scan.nextLine();
		if(resultado.equalsIgnoreCase("n")) {
			return false;
		}else if(resultado.equalsIgnoreCase("s")) {
			return true;
		}else {
			System.out.println("Opcion no valida, por seguridad no se borrara el caballero");
			return false;
		}
	}
}

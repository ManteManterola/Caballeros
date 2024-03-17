package vista;

import java.util.Scanner;

public class Menu {

	Scanner scan = new Scanner(System.in);

	// Constantes del menu principal
	public static final int SALIR = 0;
	public static final int ADMIN = 1;
	public static final int USUARIO = 2;

	// Constantes de los gestores
	public static final int GESTIONAR_ARMAS = 1;
	public static final int GESTIONAR_CABALLEROS = 2;
	public static final int GESTIONAR_CABALLOS = 3;
	public static final int GESTIONAR_ESCUDEROS = 4;
	public static final int GESTIONAR_ESCUDOS = 5;

	// Constantes del gestor armas
	public static final int VISUALIZAR_ARMAS = 1;
	public static final int INSERTAR_ARMAS = 2;
	public static final int BORRAR_ARMAS = 3;
	public static final int MODIFICAR_ARMAS = 4;

	// Constantes del gestor caballeros
	public static final int VISUALIZAR_CABALLEROS = 1;
	public static final int INSERTAR_CABALLEROS = 2;
	public static final int BORRAR_CABALLEROS = 3;
	public static final int MODIFICAR_CABALLEROS = 4;

	// Constantes del gestor caballos
	public static final int VISUALIZAR_CABALLOS = 1;
	public static final int INSERTAR_CABALLOS = 2;
	public static final int BORRAR_CABALLOS = 3;
	public static final int MODIFICAR_CABALLOS = 4;

	// Constantes del gestor escuderos
	public static final int VISUALIZAR_ESCUDEROS = 1;
	public static final int INSERTAR_ESCUDEROS = 2;
	public static final int BORRAR_ESCUDEROS = 3;
	public static final int MODIFICAR_ESCUDEROS = 4;

	// Constantes del gestor escudos
	public static final int VISUALIZAR_ESCUDOS = 1;
	public static final int INSERTAR_ESCUDOS = 2;
	public static final int BORRAR_ESCUDOS = 3;
	public static final int MODIFICAR_ESCUDOS = 4;
	
	//Constante luchar
	public static final int LUCHAR_ADMIN = 6;
	public static final int LUCHAR_USUARIO = 1;
	
	public static void mostrarMenuPrincipal() {
		System.out.println("----Menu Principal----");
		System.out.println(SALIR + ". Salir");
		System.out.println(ADMIN + ". Entrar como administrados");
		System.out.println(USUARIO + ". Entrar como usuario");
	}
	
	public static void mostrarMenuAdmin() {
		System.out.println("----Menu Administrador----");
		System.out.println(SALIR + ". Salir");
		System.out.println(GESTIONAR_ARMAS + ". Gestionar armas");
		System.out.println(GESTIONAR_CABALLEROS + ". Gestionar caballeros");
		System.out.println(GESTIONAR_CABALLOS + ". Gestionar caballos");
		System.out.println(GESTIONAR_ESCUDEROS + ". Gestionar escuderos");
		System.out.println(GESTIONAR_ESCUDOS + ". Gestionar escudos");
		System.out.println(LUCHAR_ADMIN + ". Luchar");
	}
	
	public static void mostrarMenuUsuario() {
		System.out.println("----Menu Usuario----");
		System.out.println(SALIR + ". Salir");
		System.out.println(LUCHAR_USUARIO + ". Luchar");
	}
	
	public static void mostrarMenuArmas() {
		System.out.println("----Menu Armas----");
		System.out.println(SALIR + ". Salir");
		System.out.println(VISUALIZAR_ARMAS + ". Visualizar todas las armas");
		System.out.println(INSERTAR_ARMAS + ". Insertar un arma");
		System.out.println(BORRAR_ARMAS + ". Eliminar un arma");
		System.out.println(MODIFICAR_ARMAS + ". Modificar un arma");
	}
	
	public static void mostrarMenuCaballeros() {
		System.out.println("----Menu Caballeros----");
		System.out.println(SALIR + ". Salir");
		System.out.println(VISUALIZAR_CABALLEROS + ". Visualizar todos los caballeros");
		System.out.println(INSERTAR_CABALLEROS + ". Insertar un caballero");
		System.out.println(BORRAR_CABALLEROS + ". Eliminar un caballero");
		System.out.println(MODIFICAR_CABALLEROS + ". Modificar un caballero");
	}
	
	public static void mostrarMenuCaballos() {
		System.out.println("----Menu Caballos----");
		System.out.println(SALIR + ". Salir");
		System.out.println(VISUALIZAR_CABALLOS + ". Visualizar todos los caballos");
		System.out.println(INSERTAR_CABALLOS + ". Insertar un caballo");
		System.out.println(BORRAR_CABALLOS + ". Eliminar un caballo");
		System.out.println(MODIFICAR_CABALLOS + ". Modificar un caballo");
	}
	
	public static void mostrarMenuEscuderos() {
		System.out.println("----Menu Escuderos----");
		System.out.println(SALIR + ". Salir");
		System.out.println(VISUALIZAR_ESCUDEROS + ". Visualizar todos los escuderos");
		System.out.println(INSERTAR_ESCUDEROS + ". Insertar un escudero");
		System.out.println(BORRAR_ESCUDEROS + ". Eliminar un escudero");
		System.out.println(MODIFICAR_ESCUDEROS + ". Modificar un escudero");
	}
	
	public static void mostrarMenuEscudos() {
		System.out.println("----Menu Escudos----");
		System.out.println(SALIR + ". Salir");
		System.out.println(VISUALIZAR_ESCUDOS + ". Visualizar todos los escudos");
		System.out.println(INSERTAR_ESCUDOS + ". Insertar un escudo");
		System.out.println(BORRAR_ESCUDOS + ". Eliminar un escudo");
		System.out.println(MODIFICAR_ESCUDOS + ". Modificar un escudo");
	}
}

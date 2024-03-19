package controlador;

import java.util.Scanner;

import modelo.CaballoModelo;
import vista.Formulario;
import vista.Menu;
import vista.Visor;

public class GestorCaballo {
	
	private static Scanner scan = new Scanner(System.in);
	private static CaballoModelo cm = new CaballoModelo(); 
	public static void run() {
			int select=0;
			do {
				Menu.mostrarMenuCaballos();
				select=Integer.parseInt(scan.nextLine());
				
				switch(select) {
				
					case Menu.VISUALIZAR_CABALLOS:
						cm.Conectar();
						Visor.mostrarArray(cm.getCaballos());
						cm.cerrar();
						break;
						
					case Menu.INSERTAR_CABALLOS:
						cm.Conectar();
						cm.insertarCaballo(Formulario.pedirDatosCaballoInsert());
						cm.cerrar();
						break;
						
					case Menu.BORRAR_CABALLOS:
						cm.Conectar();
						cm.borrarCaballo(Formulario.pedirIdCaballero());
						cm.cerrar();
						break;
					case Menu.MODIFICAR_CABALLOS:
						cm.Conectar();
						cm.modificarCaballo(Formulario.pedirDatosCaballoMod(),Formulario.pedirIdCaballero());
						cm.cerrar();
						break;
					
					
				}
			}while(select!=0);
		}
}

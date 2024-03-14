package controlador;

import java.util.Scanner;

import modelo.*;
import vista.*;

/**
 * @author Xabi
 */
public class GestorArma {
	
	private static Scanner scan = new Scanner(System.in);
	private static ArmaModelo am = new ArmaModelo();
	
	/**
	 * Funcion principal
	 */
	public static void run() {
		
		int select;
		do {
			Menu.mostrarMenuArmas();
			select=Integer.parseInt(scan.nextLine());
			switch(select) {
			
			case Menu.VISUALIZAR_ARMAS:
				am.Conectar();
				Visor.mostrarArray(am.getArmas());
				am.cerrar();
				break;
				
			case Menu.INSERTAR_ARMAS:
				am.Conectar();
				am.insertarArma(Formulario.pedirDatosArma());
				am.cerrar();
				break;
			case Menu.BORRAR_ARMAS:
				am.Conectar();
				am.borrarArma(am.getArma(Formulario.pedirNombre()));
				am.cerrar();
				break;
			case Menu.MODIFICAR_ARMAS:
				am.Conectar();
				
				//Busca un arma y la enseña al user
				Arma armaVieja = am.getArma(Formulario.pedirNombre());
				Visor.mostrarItem(armaVieja);
				
				//El user mete datos nuevos y se actualizar en la BD
				Arma armaNueva = Formulario.pedirDatosArma();	
				am.modificarArma(armaNueva,armaVieja.getId());
				
				am.cerrar();
				break;
			case Menu.SALIR:
				
				break;
				
			default:
			}
		}while(select!=0);
	}
}

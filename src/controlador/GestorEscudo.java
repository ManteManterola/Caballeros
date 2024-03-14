package controlador;

import java.util.Scanner;

import modelo.*;
import vista.*;

public class GestorEscudo {

	private static Scanner scan = new Scanner(System.in);
	private static EscudoModelo em = new EscudoModelo();
	
	public static void run() {

		int select;
		do {
			Menu.mostrarMenuEscudos();
			select=Integer.parseInt(scan.nextLine());
			switch(select) {
			
			case Menu.VISUALIZAR_ARMAS:
				em.Conectar();
				Visor.mostrarArray(em.getEscudos());
				em.cerrar();
				break;
				
			case Menu.INSERTAR_ARMAS:
				em.Conectar();
				em.insertarEscudo(Formulario.pedirDatosEscudo());
				em.cerrar();
				break;
			case Menu.BORRAR_ARMAS:
				em.Conectar();
				em.borrarEscudo(em.getEscudo(Formulario.pedirNombre()));
				em.cerrar();
				break;
			case Menu.MODIFICAR_ARMAS:
				em.Conectar();
				
				//Busca un arma y la enseña al user
				Escudo escudoViejo = em.getEscudo(Formulario.pedirNombre());
				Visor.mostrarItem(escudoViejo);
				
				//El user mete datos nuevos y se actualizar en la BD
				Escudo escudoNuevo = Formulario.pedirDatosEscudo();	
				em.modificarEscudo(escudoNuevo,escudoViejo.getId());
				
				em.cerrar();
				break;
			case Menu.SALIR:
				
				break;
				
			default:
			}
			
		}while(select!=0);
	}
}



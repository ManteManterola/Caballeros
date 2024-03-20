package controlador;

import java.util.*;

import modelo.*;
import vista.*;
public class GestorLucha {
	
	private static Scanner scan = new Scanner(System.in);
	private static CaballeroModelo cm = new CaballeroModelo();
	private static Lucha lucha = new Lucha();
	private static LuchaModelo luchaModelo = new LuchaModelo();
	private static ArmaModelo am = new ArmaModelo();
	private static EscuderoModelo escuderoModelo = new EscuderoModelo();

	public static void run() {
		int opcion;
		do {
			Menu.mostrarMenuLuchas();
			opcion = Integer.parseInt(scan.nextLine());
			
			switch (opcion) {
			case Menu.SALIR:		
				break;

			case Menu.LUCHAR:
				am.Conectar();
				cm.Conectar();
				luchar();
				am.cerrar();
				cm.cerrar();

				break;
				
			case Menu.VISUALIZAR_LUCHAS:
				Visor.mostrarArray(luchaModelo.getLuchas());
				break;
				
			default:
				System.out.println("Opcion no valida");
				break;
			}
		} while (opcion != Menu.SALIR);
		
		
	}
	private static void luchar() {
		
		ArrayList<Caballero> caballeros = cm.getCaballeros();
		Random r = new Random();
		
		//El visor da la bienvenida al User y mediante una funcion del formulario devuelve un caballero
		lucha.setCaballero1(Visor.bienvenidaLucha(caballeros));
		
		
		//Si el caballeroIA es el mismo que el del usuario seguira en el bucle
		do {
			
			lucha.setCaballero2(cm.getCaballero(r.nextInt(caballeros.size())+1));
			
		}while(lucha.getCaballero1().getId()==lucha.getCaballero2().getId());
		Visor.lucha(lucha);
		
		int statsCaballeroUsuario = rellenarStats(lucha.getCaballero1(),lucha.getCaballero2());
		int statsCaballeroIA = rellenarStats(lucha.getCaballero2(),lucha.getCaballero1());
		
		if(statsCaballeroUsuario>statsCaballeroIA) {
			lucha.setGanador(lucha.getCaballero1());
			//funcion(ucha)
		}else if(statsCaballeroUsuario>statsCaballeroIA){
			lucha.setGanador(lucha.getCaballero2());
		}
		
		
		Visor.ganador(lucha);
		escuderoModelo.generarEscudero(lucha.getGanador());
		LuchaModelo luchaModelo = new LuchaModelo();
		luchaModelo.Conectar();
		luchaModelo.insertarlucha(lucha);
		luchaModelo.cerrar();
		

		if(lucha.getGanador().getEscudero() != null && lucha.getGanador().getEscudero().getNivel()>=10) {
			
			cm.evolucionarACaballero(lucha.getGanador().getEscudero(),Formulario.pedirDatosBuscaArma() , Formulario.pedirDatosBuscaEscudo());
		}

		//Subir de nivel al caballero y escudero ganador
		subirNivel();

	}
	
	
	private static void subirNivel() {
		lucha.getGanador().setNivel(lucha.getGanador().getNivel()+1);
		if(lucha.getGanador().getEscudero() != null) {
			lucha.getGanador().getEscudero().setNivel(lucha.getGanador().getEscudero().getNivel()+1);
			escuderoModelo.modificarEscudero(lucha.getGanador().getEscudero(), lucha.getGanador().getId());
		}
		cm.modificarCaballero(lucha.getGanador(), lucha.getGanador().getId());
	}
	
	
	private static int rellenarStats(Caballero c, Caballero rival) {
		return c.getFuerza() + c.getNivel() + c.getArma().getDaño() - rival.getEscudo().getDefensa();
	}
}

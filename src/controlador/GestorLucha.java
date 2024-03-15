package controlador;

import java.util.Scanner;

import modelo.*;
import vista.*;
public class GestorLucha {
	
	private static Scanner scan = new Scanner(System.in);
	private static CaballeroModelo cm = new CaballeroModelo();
	private static Lucha lucha = new Lucha();
	
	public static void run() {
			
		//El visor da la bienvenida al User y mediante una funcion del formulario devuelve un caballero
		lucha.setCaballero1(Visor.bienvenidaLucha());
		
		//Si el caballeroIA es el mismo que el del usuario seguira en el bucle
		do {
			
			lucha.setCaballero2(cm.getCaballero((int)Math.floor(Math.random()*cm.getCaballeros().size()+1)));
			
		}while(lucha.getCaballero1().getId()==lucha.getCaballero2().getId());
		
		int statsCaballeroUsuario = rellenarStats(lucha.getCaballero1(),lucha.getCaballero2());
		int statsCaballeroIA = rellenarStats(lucha.getCaballero2(),lucha.getCaballero1());
		
		if(statsCaballeroUsuario>statsCaballeroIA) {
			lucha.setGanador(lucha.getCaballero1());
		}else if(statsCaballeroUsuario>statsCaballeroIA){
			lucha.setGanador(lucha.getCaballero2());
		}
		
		
	}
	private static int rellenarStats(Caballero c, Caballero rival) {
		return c.getFuerza() + c.getNivel() + c.getArma().getDaño() - rival.getEscudo().getDefensa();
	}
}

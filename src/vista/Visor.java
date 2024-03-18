package vista;

import java.util.*;
import modelo.*;
public class Visor {
  
	public static <T> void mostrarArray(ArrayList<T> lista) {
		for(T item : lista) {
			System.out.println(item+"\n");
		}
	}
	public static <T> void mostrarItem(T item) {
		System.out.println(item+"\n");
	}
	
	public static Caballero bienvenidaLucha() {
		CaballeroModelo cm = new CaballeroModelo();
		ArmaModelo am = new ArmaModelo();
		EscudoModelo em = new EscudoModelo();
		
		cm.Conectar();
		am.Conectar();
		em.Conectar();
		
		System.out.println("Bienvenid@ a la lucha, por favor inserte el nombre de un caballero");
		
		mostrarArray(cm.getCaballeros());
		Caballero c = cm.getCaballero(Formulario.pedirNombre());
		
		System.out.println("Selecciona un arma");
		mostrarArray(am.getArmas());
		c.setArma(am.getArma(Formulario.pedirNombre()));
		
		System.out.println("Selecciona un escudo");
		mostrarArray(em.getEscudos());
		c.setEscudo(em.getEscudo(Formulario.pedirNombre()));
		
		return c;
	}
	
	public static void lucha(Lucha l) {
		System.out.println("Va a luchar " + l.getCaballero1().getNombre() 
				+	" equipado con una " + l.getCaballero1().getArma().getTipo()
				+ " y con un " + l.getCaballero1().getEscudo().getTipo());
		
		System.out.println("Contra " + l.getCaballero2().getNombre() 
				+	" equipado con una " + l.getCaballero2().getArma().getTipo()
				+ " y con un " + l.getCaballero2().getEscudo().getTipo());
	}
	public static void ganador(Lucha l) {
		if(l.getGanador() != null){
			System.out.println("El ganador es:" + l.getGanador().getNombre());
		}
	}
}

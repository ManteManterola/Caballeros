package vista;

public class Visor {


	public static <T> void mostrarArray(ArrayList<T> lista) {
		for(T item : lista) {
			System.out.println(item);
		}
	}
}

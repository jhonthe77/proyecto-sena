package arreglo;

import java.util.ArrayList;

import clases.tiendas;

public class Arreglos2 {

	ArrayList<tiendas> tendero2;

	public Arreglos2() {

		tendero2 = new ArrayList<tiendas>();
	}

	public void adicionar(tiendas t) {

		tendero2.add(t);
	}

	public tiendas odtener(int posicion) {

		return tendero2.get(posicion);

	}

	public int tamaño() {
		return tendero2.size();
	}
	public void borrar() {
		tendero2.removeAll(tendero2);
		
	}
	
}
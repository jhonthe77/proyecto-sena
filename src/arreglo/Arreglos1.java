package arreglo;

import java.util.ArrayList;

import clases.tiendas;


public class Arreglos1 {

	
	ArrayList<tiendas> tendero;

	public Arreglos1() {

		tendero = new ArrayList<tiendas>();
	}

	public void adicionar(tiendas t) {

		tendero.add(t);
	}

	public tiendas odtener(int posicion) {

		return tendero.get(posicion);

	}
	
	public int tamaño() {
		return tendero.size();
	}
	
	public void borrar() {
		tendero.removeAll(tendero);
		
	}
	
	
}



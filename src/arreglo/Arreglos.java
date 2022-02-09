package arreglo;

import java.util.ArrayList;

import clases.tiendas;

public class Arreglos {

	
	ArrayList<tiendas> tendero1;

	public Arreglos() {

		tendero1 = new ArrayList<tiendas>();
	}

	public void adicionar(tiendas t) {

		tendero1.add(t);
	}

	public tiendas odtener(int posicion) {

		return tendero1.get(posicion);

	}
	
	public int tamaño() {
		return tendero1.size();
	}
	public void borrar() {
		tendero1.removeAll(tendero1);
		
	}
	
}


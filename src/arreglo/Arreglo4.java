package arreglo;

import java.util.ArrayList;

import clases.tiendas;

public class Arreglo4 {
	
	ArrayList<tiendas> tendero4;

	public void Arreglos4() {

		tendero4 = new ArrayList<tiendas>();
	}

	public void adicionar(tiendas t) {

		tendero4.add(t);
	}

	public tiendas odtener(int posicion) {

		return tendero4.get(posicion);

	}

	public int tamaño() {
		return tendero4.size();
	}
	public void borrar() {
		tendero4.removeAll(tendero4);
		
	}
}



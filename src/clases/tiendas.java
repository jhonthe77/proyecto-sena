package clases;

public class tiendas {
	public tiendas() {

	}

	private String nombre, producto;

	@SuppressWarnings("unused")
	private double precio, total;

	private int cantida;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public double getTotal() {
		return total;
	}

	public int getCantida() {
		return cantida;
	}

	public void setCantida(int cantida) {
		this.cantida = cantida;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public void setTotal(int cantida, double precio) {

		this.total = cantida * precio;
	}

	public void setTotal(double total) {

		this.total = total;
	}

	public tiendas(String nombre, String producto, double precio, int cantida, double total) {
		super();
		this.nombre = nombre;
		this.producto = producto;
		this.precio = precio;
		this.cantida = cantida;
		this.total = total;
	}
	
	

	public tiendas(String nombre,  int cantida ,double total) {
		super();
		this.nombre = nombre;
		this.total = total;
		this.cantida = cantida;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof tiendas) {
			tiendas tienda = (tiendas) obj;
			
			if(this.total==tienda.total) {
				return true;
			}else {
				return false;
			}
		}
		return false;
	}

}

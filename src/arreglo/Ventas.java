package arreglo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import clases.tiendas;

public class Ventas {
	private tiendas T;
	private ConetarBD conetar;
	private Connection con;
	private String sql;
	private Statement mistate;
	private ResultSet resul;

	public Ventas() {
		T = new tiendas();
		conetar = new ConetarBD();
		sql = "";
		con = conetar.getconetarBD();

	}

	public void vender(JLabel nombreT, JLabel producto, JTextField cantida, JLabel precio) {

		T.setNombre(nombreT.getText());
		T.setProducto(producto.getText());
		T.setCantida(Integer.parseInt(cantida.getText()));
		T.setPrecio(Double.parseDouble(precio.getText()));
		T.setTotal(Integer.parseInt(cantida.getText()), Double.parseDouble(precio.getText()));

		if (T.getNombre().equalsIgnoreCase("tienda 1")) {
			sql = "insert into tienda1 (nombreT,producto,cantida,precio,total) value(?,?,?,?,?)";

		} else if (T.getNombre().equalsIgnoreCase("tienda 2")) {
			sql = "insert into tienda2 (nombreT,producto,cantida,precio,total) value(?,?,?,?,?)";

		} else if (T.getNombre().equalsIgnoreCase("tienda 3")) {
			sql = "insert into tienda3 (nombreT,producto,cantida,precio,total) value(?,?,?,?,?)";
		}

		else {
			JOptionPane.showMessageDialog(null, "No conecto");
		}

		con = conetar.getconetarBD();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, T.getNombre());
			ps.setString(2, T.getProducto());
			ps.setInt(3, T.getCantida());
			ps.setDouble(4, T.getPrecio());
			ps.setDouble(5, T.getTotal());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void consulatar(JTable tabla, JLabel nombreT) {
		DefaultTableModel modelo = new DefaultTableModel();

		if (nombreT.getText().equalsIgnoreCase("tienda 1")) {
			sql = "SELECT * FROM tienda1";
		} else if (nombreT.getText().equalsIgnoreCase("tienda 2")) {
			sql = "SELECT * FROM tienda2";
		} else if (nombreT.getText().equalsIgnoreCase("tienda 3")) {
			sql = "SELECT * FROM tienda3";
		}
		modelo.addColumn("id");
		modelo.addColumn(T.getNombre());
		modelo.addColumn("PRODUCTO");
		modelo.addColumn("CANTIDA");
		modelo.addColumn("PRECIO");
		modelo.addColumn("TOTAL");
		tabla.setModel(modelo);

		String[] datos_usuario = new String[6];
		try {

			mistate = con.createStatement();
			resul = mistate.executeQuery(sql);

			while (resul.next()) {

				datos_usuario[0] = resul.getString(1);
				datos_usuario[1] = resul.getString(2);
				datos_usuario[2] = resul.getString(3);
				datos_usuario[3] = resul.getString(4);
				datos_usuario[4] = resul.getString(5);
				datos_usuario[5] = resul.getString(6);
				modelo.addRow(datos_usuario);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void sumar(JTable tabla, JTextField total, JTextField totalc, JTextField totalp) {

		double suma = 0;

		double fila = 0;
		int fila2 = 0;
		int suma2 = 0;
		double suma3 = 0;
		double fila3 = 0;
		for (int i = 0; i < tabla.getRowCount(); i++) {
			fila = Double.parseDouble(tabla.getValueAt(i, 5).toString());
			fila2 = Integer.parseInt(tabla.getValueAt(i, 3).toString());
			fila3 = Double.parseDouble(tabla.getValueAt(i, 4).toString());
			suma += fila;
			suma3 += fila3;
			suma2 += fila2;
		}
		// System.out.println("" + suma3 + " " + suma);
		double totalprom = suma / suma3;
		DecimalFormat formato1 = new DecimalFormat();

		formato1.setMaximumFractionDigits(0);
		total.setText("" + suma);
		totalc.setText("" + suma2);
		totalp.setText(formato1.format(totalprom));
		JOptionPane.showMessageDialog(null, "Dinero total: " + suma + "$");
	}

	public void calculototal(JTextField total, JLabel nombreT, JTextField cantida) {

		tiendas tienda1 = new tiendas(nombreT.getText(), Integer.parseInt(cantida.getText()),
				Double.parseDouble(total.getText()));
		ArrayList<tiendas> tienda = new ArrayList<tiendas>();

		if (total(tienda1)) {
			tienda.add(tienda1);

			for (tiendas T : tienda) {

				sql = "insert into total (nombreT,cantida,total) value(?,?,?)";
				try {

					PreparedStatement ps = con.prepareStatement(sql);

					ps.setString(1, T.getNombre());
					System.out.println();
					ps.setInt(2, T.getCantida());
					ps.setDouble(3, T.getTotal());

					ps.executeUpdate();

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}

	}

	public void consulta(JTable tabla) {

		DefaultTableModel modelo = new DefaultTableModel();
		modelo.addColumn("Id");
		modelo.addColumn("NombreT");
		modelo.addColumn("Cantida");
		modelo.addColumn("Total");

		tabla.setModel(modelo);
		String datos[] = new String[4];
		String sql = "SELECT * FROM  total";
		try {
			mistate = con.createStatement();
			resul = mistate.executeQuery(sql);

			while (resul.next()) {
				datos[0] = resul.getString(1);
				datos[1] = resul.getString(2);
				datos[2] = resul.getString(3);
				datos[3] = resul.getString(4);
				modelo.addRow(datos);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean total(tiendas t) {

		PreparedStatement ps = null;
		ResultSet rs = null;

		sql = "SELECT nombreT, cantida, total  FROM total WHERE nombreT = ?";

		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, t.getNombre());
			rs = ps.executeQuery();

			if (rs.next()) {

				if (t.getTotal() != rs.getDouble(3)) {
					return true;
				} else {
					System.out.println("aqui");
					return false;
				}

			} else {
				return true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("aqui2");
		return false;

	}

	public void sumar2(JTable tabla1, JTextField totalt, JTextField totalcp, JTextField totalpp) {

		double suma = 0;

		double fila = 0;
		int fila2 = 0;
		int suma2 = 0;

		for (int i = 0; i < tabla1.getRowCount(); i++) {
			fila = Double.parseDouble(tabla1.getValueAt(i, 3).toString());
			fila2 = Integer.parseInt(tabla1.getValueAt(i, 2).toString());

			suma += fila;

			suma2 += fila2;
		}
	DecimalFormat forma = new DecimalFormat();
		double totalprom = suma / suma2;
forma.setMaximumFractionDigits(0);
		totalt.setText(forma.format(suma));
		totalcp.setText(forma.format(suma2));
		totalpp.setText(forma.format(totalprom));
		JOptionPane.showMessageDialog(null, "Dinero total: " +forma.format(suma)+ "$");
	}

}

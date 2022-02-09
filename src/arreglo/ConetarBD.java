package arreglo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ConetarBD {
	Connection con=null;
	public Connection getconetarBD() {
		String url ="jdbc:mysql://127.0.0.1:3306/comidasr";
		String usuario="root";
		String pass="";
		
		try {
	
			con=DriverManager.getConnection(url, usuario, pass);
			JOptionPane.showMessageDialog(null, "Conexion exitosa");
			
		} catch (SQLException  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
	}

}

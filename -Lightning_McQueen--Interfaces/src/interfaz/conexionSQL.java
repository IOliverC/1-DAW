package interfaz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexionSQL {

	private static final String CONTROLADOR = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/login";
	private static final String USUARIO = "root";
	private static final String CLAVE = "";

	public Connection conexion() {
		Connection conectar = null;
		
		try {
			Class.forName(CONTROLADOR);
			conectar = DriverManager.getConnection(URL, USUARIO, CLAVE);
			

		} catch (ClassNotFoundException e) {
			System.out.println("Error al cargar el controlador");
			e.printStackTrace();

		} catch (SQLException e) {
			System.out.println("Error  de Conexión");
			e.printStackTrace();
		}
		
		return conectar;
	}

}
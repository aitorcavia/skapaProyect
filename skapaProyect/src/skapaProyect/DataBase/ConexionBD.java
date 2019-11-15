
package skapaProyect.DataBase;

import java.rmi.ConnectIOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;;

public class ConexionBD {

	public static void main(String[] args) {
		
		try {
			Class.forName("org.sqlite.JDBC");
			
			Connection conn = DriverManager.getConnection("jdbc:sqlite:data/BD.db");
			Statement stmt = conn.createStatement();
		
			//Recuperar datos, consultas
			ResultSet rs = stmt.executeQuery("SELECT Usuario, Contraseña FROM usuario");
			
			while (rs.next()) {
				String usuario = rs.getString("Usuario");
				String contrasenya = rs.getString("Contraseña");
				
				System.out.println(usuario);
				System.out.println(contrasenya);
			}
			
			stmt.close();
			conn.close();
			
		} catch (ClassNotFoundException e) {
			System.out.println("No se ja podido cargar el driver");
			e.printStackTrace();
		}catch (SQLException e) {
			System.out.println("No se ha podido conectar a BD");
			e.printStackTrace();
		}
		
		

	}

}

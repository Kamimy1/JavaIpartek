package com.AMBM.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB_Helper implements DAO_Constantes {

	public Connection contectar() {

		Connection con = null;

		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(CONEXION, USUARIO, CONTRASENA);

			System.out.println("CONEXION ESTABLECIDA");
		} catch (ClassNotFoundException e) {
			System.out.println("ERROR: DRIVER NO ENCONTRADO");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("ERROR: ERROR EN EL SQL: posblemente usuario, password, nombre de BD");
			e.printStackTrace();
		}

		return con;

	}

	public void desconectar(Connection con) {

		try {
			con.close();
			
			System.out.println("CONEXION CERRADA");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("ERROR: NO SE PUDO DESCONECTAR");
			e.printStackTrace();
		}

	}

}

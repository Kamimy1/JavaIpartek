package com.ambm.modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ambm.modelo.dto.Estadio;


public class DB_Helper implements DAO_Constantes {
	
	public Connection contectar() {

		Connection con = null;

		try {
			Class.forName(BD_DRIVER);
			con = DriverManager.getConnection(CADENA_CONEXION, USUARIO, PASS);

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

	public List<Estadio> obtenerTodosEstadios(Connection con) {
		// TODO Auto-generated method stub
		
		List<Estadio> estadiosList = new ArrayList<>();
		
		try {
			CallableStatement cSmt = con.prepareCall("call sp_mostrarTodosEstadios();");
			
			boolean timeSelect = cSmt.execute();
			
			if(timeSelect) {
				ResultSet rs = cSmt.getResultSet();
				
				while(rs.next()) {
					Estadio estadio = new Estadio();
					
					estadio.setId(rs.getInt(ESTADIOS_ID));
					estadio.setNombre(rs.getString(ESTADIOS_NOMBRE));
					estadio.setAforo(rs.getInt(ESTADIOS_AFORO));
					estadio.setFechaConstruccion(rs.getString(ESTADIOS_FECHA));
					estadio.setEquipo(rs.getString(ESTADIOS_EQUIPO));
					
					estadiosList.add(estadio);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		return estadiosList;
	}

}

package com.p02.modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.p02.modelo.dto.E_Animal;

public class DB_Helper implements DAO_Constantes{
	
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

	public List<E_Animal> obtenerTodosEAnimales(Connection con) {
		// TODO Auto-generated method stub
		List<E_Animal> listVAnimal = new ArrayList<E_Animal>();

		try {
			CallableStatement cStmt = con.prepareCall(SP_OBTENER_TODOS_ANIMALES_ESPECIE);

			boolean tieneSelect = cStmt.execute();

			if (tieneSelect) {
				ResultSet rs = cStmt.getResultSet();

				while (rs.next()) {
					E_Animal eAnimal = new E_Animal();

					eAnimal.setId(rs.getInt(E_ANIMALES_ID));
					eAnimal.setNombre(rs.getString(E_ANIMALES_NOMBRE));
					eAnimal.setPeso(rs.getInt(E_ANIMALES_PESO));
					eAnimal.setEdad(rs.getInt(E_ANIMALES_EDAD));
					eAnimal.setFk_especie(rs.getInt(E_ANIMALES_FK_ESPECIE));
					eAnimal.setEspecie(rs.getString(E_ANIMALES_ESPECIE));

					listVAnimal.add(eAnimal);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return new ArrayList<E_Animal>();
		}

		return listVAnimal;
	}

}

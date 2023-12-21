package com.ambm.modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ambm.modelo.dto.Producto;
import com.ambm.modelo.dto.V_Producto;

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

	public List<V_Producto> obtenerTodosProductos(Connection con) {
		// TODO Auto-generated method stub
		List<V_Producto> productsList = new ArrayList<>();

		try {
			CallableStatement cSmt = con.prepareCall("call sp_obtener_todos_productos_cta();");

			boolean timeSelect = cSmt.execute();

			if (timeSelect) {
				ResultSet rs = cSmt.getResultSet();

				while (rs.next()) {
					V_Producto prod = new V_Producto();

					prod.setId(rs.getInt(V_PRODUCTOS_ID));
					prod.setNombre(rs.getString(V_PRODUCTOS_NOMBRE));
					prod.setPrecio(rs.getDouble(V_PRODUCTOS_PRECIO));
					prod.setFk_categoria(rs.getInt(V_PRODUCTOS_FK_CATEGORIA));
					prod.setCategoria(rs.getString(V_CATEGORIAS_CATEGORIA));

					productsList.add(prod);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return productsList;
	}

}

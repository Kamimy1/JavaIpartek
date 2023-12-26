package com.ipartek.modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.modelo.dto.Categoria;
import com.ipartek.modelo.dto.Producto;
import com.ipartek.modelo.dto.V_Producto;

public class DB_Helper implements DAO_Constantes {

	public Connection conectar() {

		Connection con = null;

		try {
			Class.forName(BD_DRIVER);
			con = DriverManager.getConnection(CADENA_CONEXION, USUARIO, PASS);
			System.out.println("CONECTADO CORRECTAMENTE A LA BD");
		} catch (ClassNotFoundException e) {
			// entra si no se ha hecho el MAVEN
			System.out.println("ERROR: DRIVER NO ENCONTRADO");
			e.printStackTrace();
		} catch (SQLException e) {
			// Error al conectar a la BD
			System.out.println("ERROR: NO SE PUDO CONECTAR A LA BD");
			e.printStackTrace();
		}

		return con;
	}

	public void desconectar(Connection con) {
		try {
			con.close();
			System.out.println("DESCONECTADA LA BD");
		} catch (SQLException e) {
			// no se pudo desconectar
			System.out.println("ERROR: NO SE PUDO DESCONECTAR DE LA BD");
			e.printStackTrace();
		}
	}

	public List<V_Producto> obtenerTodosVProductos(Connection con) {
		List<V_Producto> listaVProducto = new ArrayList<V_Producto>();

		try {
			CallableStatement cStmt = con.prepareCall(SP_OBTENER_TODOS_PRODUCTOS_VISTA);

			boolean tieneSelect = cStmt.execute();

			if (tieneSelect) {
				ResultSet rs = cStmt.getResultSet();

				while (rs.next()) {
					V_Producto vProd = new V_Producto();

					vProd.setId(rs.getInt(V_PRODUCTOS_ID));
					vProd.setNombre(rs.getString(V_PRODUCTOS_NOMBRE));
					vProd.setPrecio(rs.getDouble(V_PRODUCTOS_PRECIO));
					vProd.setFk_categoria(rs.getInt(V_PRODUCTOS_FK_CATEGORIA));
					vProd.setCategoria(rs.getString(V_PRODUCTOS_CATEGORIA));

					listaVProducto.add(vProd);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return new ArrayList<V_Producto>();
		}

		return listaVProducto;
	}

	public void insertarProducto(Connection con, Producto prod) {

		try {
			// call sp_insertar_producto('Alien Vs Predator', 7.98, 1);
			CallableStatement cStmt = con.prepareCall(SP_INSERTAR_PRODUCTO);
			cStmt.setString(1, prod.getNombre());
			cStmt.setDouble(2, prod.getPrecio());
			cStmt.setInt(3, prod.getFk_categoria());

			cStmt.execute();
			System.out.println("Insertado correctamente");
		} catch (SQLException e) {
			System.out.println("ERROR: no se inserto el producto: " + prod);
			e.printStackTrace();
		}
	}

	public void borrarProducto(Connection con, int id) {

		try {
			CallableStatement cStmt = con.prepareCall(SP_BORRAR_PRODUCTO);
			cStmt.setInt(1, id);

			cStmt.execute();
			System.out.println("Borrado correctamente");
		} catch (SQLException e) {
			System.out.println("ERROR: no se borro el producto con id: " + id);
			e.printStackTrace();
		}
	}

	public boolean modificarProducto(Connection con, Producto prod) {
	    boolean modificado = false; 
	    
	    try {
	        CallableStatement cstmt = con.prepareCall(SP_MODIFICAR_PRODUCTO);
	        cstmt.setInt(1, prod.getId());
	        cstmt.setString(2, prod.getNombre());
	        cstmt.setDouble(3, prod.getPrecio());
	        cstmt.setInt(4, prod.getFk_categoria());

	        int filasAfectadas = cstmt.executeUpdate();
	        
	        if (filasAfectadas > 0) {
	            modificado = true;
	            System.out.println("PRODUCTO MODIFICADO");
	        } else {
	            System.out.println("El producto no se modificó");
	        }

	    } catch (SQLException e) {
	        System.out.println("ERROR AL MODIFICAR EL PRODUCTO " + prod);
	        e.printStackTrace();
	    }
	    
	    return modificado;
	}

	public V_Producto obtenerProductoPorId(Connection con, int idProducto) {
		// TODO Auto-generated method stub

		V_Producto producto = new V_Producto();

		System.out.println("ID a" + idProducto);

		try {
			CallableStatement cStmt = con.prepareCall(SP_OBTENER_PRODUCTO);
			cStmt.setInt(1, idProducto);

			boolean tieneSelect = cStmt.execute();

			if (tieneSelect) {
				ResultSet rs = cStmt.getResultSet();

				while (rs.next()) {

					producto.setId(rs.getInt(V_PRODUCTOS_ID));
					producto.setNombre(rs.getString(V_PRODUCTOS_NOMBRE));
					producto.setPrecio(rs.getDouble(V_PRODUCTOS_PRECIO));
					producto.setFk_categoria(rs.getInt(V_PRODUCTOS_FK_CATEGORIA));
					producto.setCategoria(rs.getString(V_PRODUCTOS_CATEGORIA));

				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("IDP" + producto.getId());

		return producto;
	}

	public List<Categoria> obtenerTodasCategorias(Connection con) {
		// TODO Auto-generated method stub
		
		List<Categoria> listaCategorias= new ArrayList<Categoria>();

		try {
			CallableStatement cStmt = con.prepareCall(SP_OBTENER_TODAS_CATEGORIA);

			boolean tieneSelect = cStmt.execute();

			if (tieneSelect) {
				ResultSet rs = cStmt.getResultSet();

				while (rs.next()) {
					Categoria cad = new Categoria();

					cad.setId(rs.getInt(CATEGORIAS_ID));
					cad.setCategoria(rs.getString(CATEGORIAS_CATEGORIA));


					listaCategorias.add(cad);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return new ArrayList<Categoria>();
		}

		return listaCategorias;

	}

}

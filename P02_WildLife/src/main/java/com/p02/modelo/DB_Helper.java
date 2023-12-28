package com.p02.modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.p02.modelo.dto.Animal;
import com.p02.modelo.dto.E_Animal;
import com.p02.modelo.dto.Especie;

public class DB_Helper implements DAO_Constantes {

	public Connection conectar() {

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
		List<E_Animal> listEAnimal = new ArrayList<E_Animal>();

		try {
			CallableStatement cStmt = con.prepareCall(SP_OBTENER_TODOS_ANIMALES_ESPECIE);

			boolean tieneSelect = cStmt.execute();

			if (tieneSelect) {
				ResultSet rs = cStmt.getResultSet();

				while (rs.next()) {
					E_Animal eAnimal = new E_Animal();

					eAnimal.setId(rs.getInt(E_ANIMALES_ID));
					eAnimal.setNombre(rs.getString(E_ANIMALES_NOMBRE));
					eAnimal.setPeso(rs.getDouble(E_ANIMALES_PESO));
					eAnimal.setEdad(rs.getInt(E_ANIMALES_EDAD));
					eAnimal.setFk_especie(rs.getInt(E_ANIMALES_FK_ESPECIE));
					eAnimal.setEspecie(rs.getString(E_ANIMALES_ESPECIE));

					listEAnimal.add(eAnimal);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return new ArrayList<E_Animal>();
		}

		return listEAnimal;
	}

	public List<Especie> obtenerTodasEspecies(Connection con) {
		List<Especie> listaEspecies = new ArrayList<Especie>();

		try {
			CallableStatement cStmt = con.prepareCall(SP_OBTENER_TODAS_ESPECIES);

			boolean tieneSelect = cStmt.execute();

			if (tieneSelect) {
				ResultSet rs = cStmt.getResultSet();

				while (rs.next()) {
					Especie esp = new Especie();

					esp.setId(rs.getInt(ESPECIES_ID));
					esp.setEspecie(rs.getString(ESPECIES_ESPECIE));

					listaEspecies.add(esp);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return new ArrayList<Especie>();
		}

		return listaEspecies;
	}

	public void insertarProducto(Connection con, Animal anim) {

		try {

			CallableStatement cStmt = con.prepareCall(SP_INSERTAR_ANIMAL);
			cStmt.setString(1, anim.getNombre());
			cStmt.setDouble(2, anim.getPeso());
			cStmt.setInt(3, anim.getEdad());
			cStmt.setInt(4, anim.getFk_especie());

			cStmt.execute();

			System.out.println("Insertado correctamente");
		} catch (SQLException e) {
			System.out.println("ERROR: no se inserto el producto: " + anim);
			e.printStackTrace();
		}

	}

	public void borrarAnimalPorId(Connection con, int id) {

		try {
			// call sp_borrar_producto_id(27);
			CallableStatement cStmt = con.prepareCall(SP_BORRAR_ANIMAL);
			cStmt.setInt(1, id);

			cStmt.execute();

			System.out.println("Se borro el producto: " + id);
		} catch (SQLException e) {
			System.out.println("ERROR: no se borro el producto: " + id);
			e.printStackTrace();
		}

	}

	public Animal obtenerAnimalId(Connection con, int id) {
		
		try {
			Animal anim = new Animal();
			
			CallableStatement cStmt= con.prepareCall(SP_OBTENER_ANIMAL_ID);
				cStmt.setInt(1, id);
			
			boolean tieneSelect= cStmt.execute();
			
			if (tieneSelect==true) {
				
				ResultSet rs= cStmt.getResultSet();
				
				while (rs.next()) {
					anim.setId(rs.getInt(ANIMALES_ID));
					anim.setNombre(rs.getString(ANIMALES_NOMBRE));
					anim.setPeso(rs.getDouble(ANIMALES_PESO));
					anim.setEdad(rs.getInt(ANIMALES_EDAD));
					anim.setFk_especie(rs.getInt(ANIMALES_FK_ESPECIE));	
				}
			}
		
			return anim;
		} catch (SQLException e) {
			System.out.println("NO SE PUDO OBTENER EL PRODUCTO CON ID: "+id);
			e.printStackTrace();
			return new Animal();
		}
		
	}

	public void modificarAnimal(Connection con, Animal anim) {
		
		try {
			CallableStatement cStmt = con.prepareCall(SP_MODIFICAR_ANINAL);
				cStmt.setInt(1, anim.getId());
				cStmt.setString(2, anim.getNombre());
				cStmt.setDouble(3, anim.getPeso());
				cStmt.setInt(4, anim.getEdad());
				cStmt.setInt(5, anim.getFk_especie());
				
			cStmt.execute();

			System.out.println("Insertado correctamente");
		} catch (SQLException e) {
			System.out.println("ERROR: no se inserto el producto: "+anim);
			e.printStackTrace();
		}	
		
	}

}

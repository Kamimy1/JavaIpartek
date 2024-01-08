package com.ipartek.modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.modelo.dto.Animal;
import com.ipartek.modelo.dto.Especie;
import com.ipartek.modelo.dto.V_Animal;

public class DB_Helper implements DAO_Constantes, DAO_Metodos {

	@Override
	public Connection conectar() {
		Connection con = null;

		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(CONEXION, USUARIO, PASS);
			System.out.println("BASE DE DATOS CONECTADA");
		} catch (ClassNotFoundException e) {
			System.out.println("NO SE ENCONTRO EL DRIVER");
		} catch (SQLException e) {
			System.out.println("ERROR AL CONECTAR A LA BD");
		}

		return con;
	}

	@Override
	public void desconectar(Connection con) {
		try {
			con.close();
			System.out.println("BASE DE DATOS DESCONECTADA");
		} catch (SQLException e) {
			System.out.println("NO SE PUDO DESCONECTAR");
		}
	}

	public void insertarAnimal(Connection con, Animal ani) {
		try {
			// call sp_insertar_animal('Lagun', 45.0, 9, 1);
			CallableStatement cStmt = con.prepareCall(SP_INSERTAR_ANIMAL);
			cStmt.setString(1, ani.getNombre());
			cStmt.setDouble(2, ani.getPeso());
			cStmt.setInt(3, ani.getEdad());
			cStmt.setInt(4, ani.getFk_especie());

			cStmt.execute();

			System.out.println("Instertado correctamente");

		} catch (SQLException e) {
			System.out.println("ERROR: no se inserto");
			e.printStackTrace();
		}
	}

	public List<Especie> seleccionarTodasEspecies(Connection con) {
		List<Especie> listaEspecies = new ArrayList<Especie>();

		try {
			CallableStatement cStmt = con.prepareCall(SP_OBTENER_TODAS_ESPECIES);
			boolean tieneSelect = cStmt.execute();

			if (tieneSelect == true) {

				ResultSet rs = cStmt.getResultSet();

				while (rs.next()) {
					Especie especie = new Especie();

					especie.setId(rs.getInt(ESPECIES_ID));
					especie.setEspecie(rs.getString(ESPECIES_ESPECIES));

					listaEspecies.add(especie);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();

			return new ArrayList<Especie>();

		}

		return listaEspecies;

	}

	public List<V_Animal> obtenerAnimalesVista(Connection con) {

		List<V_Animal> lista_animales = new ArrayList<V_Animal>(); // Crear nueva lista

		try {
			CallableStatement cStmt = con.prepareCall(SP_OBTENER_ANIMALES_VISTA); // Llamar sp
			boolean tiene_select = cStmt.execute();

			if (tiene_select) { // Comprobamos si el sp contiene un SELECT
				ResultSet rs = cStmt.getResultSet(); // Guardamos en rs la respuesta del sp

				while (rs.next()) { // Iteramos por los registros de rs
					V_Animal nuevo_animal = new V_Animal(); // Creamos un nuevo animal

					// Añadimos el nuevo animal los atributos
					nuevo_animal.setId(rs.getInt(V_ANIMALES_ID));
					nuevo_animal.setNombre(rs.getString(V_ANIMALES_NOMBRE));
					nuevo_animal.setPeso(rs.getDouble(V_ANIMALES_PESO));
					nuevo_animal.setEdad(rs.getInt(V_ANIMALES_EDAD));
					nuevo_animal.setFk_especie(rs.getInt(V_ANIMALES_FK_ESPECIE));
					nuevo_animal.setEspecie(rs.getString(V_ANIMALES_ESPECIE));

					lista_animales.add(nuevo_animal); // Añadimos el nuevo animal a la lista
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return new ArrayList<V_Animal>(); // Devolvemos lista vacía si hay error
		}

		return lista_animales; // Devolvemos la lista con animales si ha ido todo bien
	}

	public void borrarAnimalPorId(Connection con, int id) {
		try {
			//
			CallableStatement cStmt = con.prepareCall(SP_BORRAR_ANIMALES_POR_ID);
			cStmt.setInt(1, id);
			
			cStmt.execute();

			System.out.println("Borrado correctamente");

		} catch (SQLException e) {
			System.out.println("ERROR: no se borro");
			e.printStackTrace();
		}
		
	}

	public Animal obtenerAnimalPorId(Connection con, int id) {
		Animal nuevo_animal = new Animal();

		try {
			CallableStatement cStmt = con.prepareCall(SP_OBTENER_ANIMAL_POR_ID); 
			cStmt.setInt(1, id);
			
			boolean tiene_select = cStmt.execute();

			if (tiene_select) { 
				ResultSet rs = cStmt.getResultSet(); 
				
				while (rs.next()) { 
					nuevo_animal.setId(rs.getInt(V_ANIMALES_ID));
					nuevo_animal.setNombre(rs.getString(V_ANIMALES_NOMBRE));
					nuevo_animal.setPeso(rs.getDouble(V_ANIMALES_PESO));
					nuevo_animal.setEdad(rs.getInt(V_ANIMALES_EDAD));
					nuevo_animal.setFk_especie(rs.getInt(V_ANIMALES_FK_ESPECIE));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return new V_Animal(); 
		}

		return nuevo_animal;
	}

	public void modificarAnimal(Connection con, Animal ani) {
		try {
			//
			CallableStatement cStmt = con.prepareCall(SP_MODIFICAR_ANIMAL_POR_ID);
			cStmt.setInt(1, ani.getId());
			cStmt.setString(2, ani.getNombre());
			cStmt.setDouble(3, ani.getPeso());
			cStmt.setInt(4, ani.getEdad());
			cStmt.setInt(5, ani.getFk_especie());
			
			cStmt.execute();

			System.out.println("Modificado correctamente");

		} catch (SQLException e) {
			System.out.println("ERROR: no se modifico");
			e.printStackTrace();
		}
		
	}

}

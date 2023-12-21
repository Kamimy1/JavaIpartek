package com.ambm.modelo;

public interface DAO_Constantes {
	
	String BD_DRIVER = "com.mysql.jdbc.Driver";
	String BD = "bd_pipo";
	String CADENA_CONEXION = "jdbc:mysql://localhost:3306/" + BD;
	String USUARIO = "root";
	String PASS = "1234";
	
	String TABLA_CATEGORIAS = "categorias";
	String CATEGORIAS_ID = "id";
	String CATEGORIAS_CATEGORIA = "categoria";

	
	String TABLA_PRODUCTOS = "productos";
	String PRODUCTOS_ID = "id";
	String PRODUCTOS_NOMBRE = "nombre";
	String PRODUCTOS_PRECIO = "precio";
	String PRODUCTOS_FK_CATEGORIA = "fk_categoria";
	

	String V_PRODUCTOS_ID = "id";
	String V_PRODUCTOS_NOMBRE = "nombre";
	String V_PRODUCTOS_PRECIO = "precio";
	String V_PRODUCTOS_FK_CATEGORIA = "fk_categoria";
	String V_CATEGORIAS_CATEGORIA = "categoria";

}

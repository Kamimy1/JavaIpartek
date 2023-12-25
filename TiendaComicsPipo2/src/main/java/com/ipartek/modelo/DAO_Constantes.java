package com.ipartek.modelo;

public interface DAO_Constantes {

	// datos de la conexion
	String BD_DRIVER = "com.mysql.cj.jdbc.Driver";
	String BD = "bd_pipo";
	String CADENA_CONEXION = "jdbc:mysql://localhost:3306/" + BD;
	String USUARIO = "root";
	String PASS = "1234";

	// datos de las tablas
	String TABLA_CATEGORIAS = "categorias";
	String CATEGORIAS_ID = "id";
	String CATEGORIAS_CATEGORIA = "categoria";

	// haced lo mismo con la tabla de Productos
	String TABLA_PRODUCTOS = "productos";
	String PRODUCTOS_ID = "id";
	String PRODUCTOS_NOMBRE = "nombre";
	String PRODUCTOS_PRECIO = "precio";
	String PRODUCTOS_FK_CATEGORIA = "fk_categoria";

	// haced lo mismo con la vista de v_Productos
	String VISTA_PRODUCTOS = "v_productos";
	String V_PRODUCTOS_ID = "id";
	String V_PRODUCTOS_NOMBRE = "nombre";
	String V_PRODUCTOS_PRECIO = "precio";
	String V_PRODUCTOS_FK_CATEGORIA = "fk_categoria";
	String V_PRODUCTOS_CATEGORIA = "categoria";

	// atributos de la mochila
	String ATR_LISTA_VPROD = "atr_lista_vproductos";

	// paginas jsp
	String JSP_INICIO = "inicio.jsp";

	// Llamadas a los stored procedures de la BD
	String SP_OBTENER_TODOS_PRODUCTOS_VISTA = "call sp_obtener_todos_productos_vista();";
	String SP_INSERTAR_PRODUCTO="call sp_insertar_producto(?, ?, ?);";
}

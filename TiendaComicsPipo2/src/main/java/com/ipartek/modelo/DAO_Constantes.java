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
	String PRODUCTOS_FK_CATEGORIA = "FK_categoria";

	// haced lo mismo con la vista de v_Productos
	String VISTA_PRODUCTOS = "v_productos";
	String V_PRODUCTOS_ID = "id";
	String V_PRODUCTOS_NOMBRE = "nombre";
	String V_PRODUCTOS_PRECIO = "precio";
	String V_PRODUCTOS_FK_CATEGORIA = "FK_categoria";
	String V_PRODUCTOS_CATEGORIA = "categoria";

	// atributos de la mochila
	String ATR_LISTA_VPROD = "atr_lista_vproductos";
	String ATR_LISTA_CAT = "atr_lista_categorias";

	// paginas jsp
	String JSP_INICIO = "inicio.jsp";
	String JSP_MODIFICAR_PRODUCTO = "modificar.jsp";

	// Llamadas a los stored procedures de la BD
	String SP_OBTENER_TODOS_PRODUCTOS_VISTA = "call sp_obtener_todos_productos_vista();";
	String SP_INSERTAR_PRODUCTO="call sp_insertar_producto(?, ?, ?);";
	String SP_BORRAR_PRODUCTO="call sp_borrar_producto_id(?);";
	String SP_OBTENER_PRODUCTO="call sp_obtener_producto_por_id(?);";
	String SP_MODIFICAR_PRODUCTO="call sp_modificar_producto(?, ?, ?, ?);";
	String SP_OBTENER_TODAS_CATEGORIA = "call sp_obtener_todas_categorias();";
}

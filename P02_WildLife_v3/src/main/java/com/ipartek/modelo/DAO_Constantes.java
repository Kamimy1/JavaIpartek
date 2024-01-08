package com.ipartek.modelo;

public interface DAO_Constantes {

	// cadenas de conexion
	String BASE_DATOS = "bd_wild_life";
	String DRIVER = "com.mysql.jdbc.Driver";
	String CONEXION = "jdbc:mysql://localhost:3306/" + BASE_DATOS;
	String USUARIO = "root";
	String PASS = "1234";

	// archivos JSP
	String JSP_INDEX = "inicio.jsp";
	String JSP_FORM_MOD = "form_modificar.jsp";

	// cosntantes de tablas y vistas
	String TABLA_ESPECIES = "especies";
	String ESPECIES_ID = "id";
	String ESPECIES_ESPECIES = "especie";

	String TABLA_ANIMALES = "animales";
	String ANIMALES_ID = "id";
	String ANIMALES_NOMBRE = "nombre";
	String ANIMALES_PESO = "peso";
	String ANIMALES_EDAD = "edad";
	String ANIMALES_FK_ESPECIE = "FK_especie";

	String VISTA_ANIMALES = "v_animales";
	String V_ANIMALES_ID = "id";
	String V_ANIMALES_NOMBRE = "nombre";
	String V_ANIMALES_PESO = "peso";
	String V_ANIMALES_EDAD = "edad";
	String V_ANIMALES_FK_ESPECIE = "FK_especie";
	String V_ANIMALES_ESPECIE = "especie";

	// constantes de llamadas a Stored procedures
	String SP_INSERTAR_ANIMAL = "call sp_insertar_animal(?, ?, ?, ?);";
	String SP_OBTENER_TODAS_ESPECIES = "call sp_obtener_todas_especies();";
	String SP_OBTENER_ANIMALES_VISTA ="call sp_obtener_todos_animales_especie();";
	String SP_BORRAR_ANIMALES_POR_ID ="call sp_borrar_animal(?);";
	String SP_OBTENER_ANIMAL_POR_ID="call sp_obtener_animal_id(?);";
	String SP_MODIFICAR_ANIMAL_POR_ID="call sp_modificar_animal(?, ?, ?, ?, ?);";
	

	// constantes de Atributos de los formularios
	String ATR_LISTA_ESPECIES = "atr_lista_especies";
	String ATR_LISTA_V_ANIMALES = "atr_lista_v_animales";
	String  ATR_ANIMAL_MODIFICAR = "atr_animal_modificar";

}

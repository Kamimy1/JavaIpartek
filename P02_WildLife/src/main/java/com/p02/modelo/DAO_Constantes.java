package com.p02.modelo;

public interface DAO_Constantes {
	
	String BD_DRIVER = "com.mysql.jdbc.Driver";
	String BD = "bd_wild_life";
	String CADENA_CONEXION = "jdbc:mysql://localhost:3306/" + BD;
	String USUARIO = "root";
	String PASS = "1234";

	String TABLA_ANIMALES = "animales";
	String ANIMALES_ID = "id";
	String ANIMALES_NOMBRE = "nombre";
	String ANIMALES_PESO = "peso";
	String ANIMALES_EDAD = "edad";
	String ANIMALES_FK_ESPECIE = "FK_especie";

	String TABLA_ESPECIES = "especies";
	String ESPECIES_ID = "id";
	String ESPECIES_ESPECIE = "especie";
	
	String E_ANIMALES_ID = "id";
	String E_ANIMALES_NOMBRE = "nombre";
	String E_ANIMALES_PESO = "peso";
	String E_ANIMALES_EDAD = "edad";
	String E_ANIMALES_FK_ESPECIE = "FK_especie";
	String E_ANIMALES_ESPECIE = "especie";
	
	String JSP_INICIO = "inicio.jsp";
	String JSP_FORM_MODIFICAR = "modificar.jsp";
	
	String ATR_LISTA_EANIMALES = "atr_lista_eanimales";
	String ATR_LISTA_ESPECIES = "atr_lista_especies";
	String ATR_ANIMAL = "atr_animal";
	
	String SP_OBTENER_TODOS_ANIMALES_ESPECIE = "call sp_obtener_todos_animales_especie();";
	String SP_OBTENER_TODAS_ESPECIES = "call sp_obtener_todas_categorias();";
	String SP_INSERTAR_ANIMAL = "call sp_insertar_animal(?, ?, ?, ?);";
	String SP_BORRAR_ANIMAL = "call sp_borrar_animal(?);";
	String SP_OBTENER_ANIMAL_ID = "call sp_obtener_animal_id(?);";
	String SP_MODIFICAR_ANINAL = "call sp_modificar_animal(?, ?, ?, ?, ?)";


}
